package com.omni.projetosomni.controller;

import com.omni.projetosomni.dto.DetalhesProjetoApiDTO;
import com.omni.projetosomni.model.Projeto;
import com.omni.projetosomni.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoRestController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public Page<DetalhesProjetoApiDTO> listarProjetos(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable paginacao){
        return DetalhesProjetoApiDTO.converter(projetoService.listarProjetos(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesProjetoApiDTO> detalharProjetoPorId(@PathVariable("id") Integer id){
        Projeto projeto = projetoService.detalharProjeto(id);
        if (projeto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new DetalhesProjetoApiDTO(projeto));
    }
}
