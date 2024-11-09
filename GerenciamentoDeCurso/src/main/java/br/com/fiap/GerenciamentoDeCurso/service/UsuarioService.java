package br.com.fiap.GerenciamentoDeCurso.service;

import br.com.fiap.GerenciamentoDeCurso.model.Role;
import br.com.fiap.GerenciamentoDeCurso.model.Usuario;
import br.com.fiap.GerenciamentoDeCurso.repository.RoleRepository;
import br.com.fiap.GerenciamentoDeCurso.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;


    public void saveUser(String username, String password, List<String> roles) {
        Usuario user = new Usuario();
        user.setUsername(username);
        user.setPassword(password);
// Adicionar as roles selecionadas ao usuário
        HashSet<Role> userRoles = new HashSet<>();
        for (String roleName : roles) {
            Role role = roleRepository.findByName(roleName);
            if (role != null) {
                userRoles.add(role);
            }
        }
        user.setRoles(userRoles);
        usuarioRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Pesquisa o usuário pelo username
        Usuario usuario = usuarioRepository.findByUsername(username);
        //Valida se o usuário existe
        if (usuario == null)
            throw new UsernameNotFoundException("Usuário não encontrado");

        //Transformar as Roles do usuário em SimpleGrantedAuthority
        Set<SimpleGrantedAuthority> authorities = usuario.getRoles().stream()
                .map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toSet());

        //retornar um User
        return new User(username, usuario.getPassword(), authorities);
    }

}
