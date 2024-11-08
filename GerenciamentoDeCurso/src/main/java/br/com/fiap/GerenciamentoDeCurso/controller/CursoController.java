package br.com.fiap.GerenciamentoDeCurso.controller;

import br.com.fiap.GerenciamentoDeCurso.model.Curso;
import br.com.fiap.GerenciamentoDeCurso.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/form-curso")
    public String cadastrar(Model model){
    model.addAttribute("curso", new Curso());
        return "curso/cadastro";
    }

    @PostMapping("/save")
    public String salvarCurso(@ModelAttribute Curso curso, Model model) {
        cursoRepository.save(curso);
        model.addAttribute("msg", "Curso salvo com sucesso!");
        return "curso/cadastro";  // Redireciona para a mesma página ou para uma página de sucesso.
    }

    @GetMapping("/lista")
    public String listar(Model model){
        model.addAttribute("evento", cursoRepository.findAll());
        return "curso/lista";
    }
}
