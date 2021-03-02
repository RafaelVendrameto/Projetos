package com.omni.projetosomni.controller;

import com.omni.projetosomni.dto.ProjetoDTO;
import com.omni.projetosomni.model.Projeto;
import com.omni.projetosomni.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String listarProjetosHome(Model model){
        List<Projeto> projetos = projetoService.listarProjetos();
        model.addAttribute("projetos", projetos);
        return "index";
    }

    @GetMapping("/projeto{id}")
    public String detalharProjeto(@PathVariable("id") Integer id, Model model){
        Projeto projeto = projetoService.detalharProjeto(id);
        model.addAttribute("projeto", projeto);
        return "detalhes";
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
        return "redirect:/";
    }

    @GetMapping("/alterar{id}")
    public String alterar(@PathVariable("id") Integer id, Model model, ProjetoDTO projetoDTO){
        Projeto projeto = projetoService.detalharProjeto(id);
        model.addAttribute("projeto", projeto);
        return "alterar";
    }

    @PostMapping("/alterarProjeto/{id}")
    public String alterarProjeto(@PathVariable("id") Integer id, @Valid ProjetoDTO projetoDTO,
                                 Model model, BindingResult result) {
        if (result.hasErrors()){
            return "alterar";
        }
        projetoService.alterarProjeto(projetoDTO, id);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String excluir(@PathVariable("id") Integer id){
        projetoService.deletarProjeto(id);
        return "redirect:/";
    }


}
