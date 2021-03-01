package com.omni.projetosomni.controller;

import com.omni.projetosomni.model.Projeto;
import com.omni.projetosomni.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProjetoRepository projetoRepository;

    @GetMapping
    public String home(Model model){
        List<Projeto> projetos = projetoRepository.findAll();
        model.addAttribute("projetos", projetos);
        return "index";
    }
}
