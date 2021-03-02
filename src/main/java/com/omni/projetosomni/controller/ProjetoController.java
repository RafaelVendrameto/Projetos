package com.omni.projetosomni.controller;

import com.omni.projetosomni.dto.ProjetoDTO;
import com.omni.projetosomni.model.Projeto;
import com.omni.projetosomni.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public String home(Model model){
        List<Projeto> projetos = projetoService.listarProjetos();
        model.addAttribute("projetos", projetos);
        return "index";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(ProjetoDTO projetoDTO){
        return "cadastro";
    }

    @PostMapping("/novoProjeto")
    public String novoProjeto(@Valid ProjetoDTO projetoDTO, BindingResult result) {
        if (result.hasErrors()){
            return "cadastro";
        }
        projetoService.cadastrarProjeto(projetoDTO);
        return "redirect:index";
    }

}
