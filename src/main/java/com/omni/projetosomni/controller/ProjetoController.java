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
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/projeto/{id}")
    public String detalharProjeto(@PathVariable("id") Integer id, Model model){
        Projeto projeto = projetoService.detalharProjeto(id);
        model.addAttribute("projeto", projeto);
        return "detalhes";
    }

    @GetMapping("/projeto")
    public String buscarProjeto(@RequestParam("nome") String nome, Model model){
        Projeto projeto = projetoService.buscarPorNome(nome);
        if(projeto != null){
            model.addAttribute("projeto", projeto);
            return "detalhes";
        }
        else {
            model.addAttribute("msg", "O Projeto " + nome + " não foi encontrado na nossa base de dados, tente novamente.");
            return "erroBusca";
        }
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

    @GetMapping("/alterar/{id}")
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

    @GetMapping("/excluir/{id}")
    public String respostaExcluir(@PathVariable("id") Integer id, Model model){
        Projeto projeto = projetoService.detalharProjeto(id);
        model.addAttribute("projeto", projeto);
        model.addAttribute("msg", "Você tem certeza que deseja excluir o projeto :");
        return "respostaExcluir";
    }

    @GetMapping("/excluirProjeto/{id}")
    public String excluir(@PathVariable("id") Integer id){
        projetoService.deletarProjeto(id);
        return "redirect:/";
    }


}
