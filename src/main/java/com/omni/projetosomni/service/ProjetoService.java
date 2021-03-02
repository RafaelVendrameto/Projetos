package com.omni.projetosomni.service;

import com.omni.projetosomni.dto.ProjetoDTO;
import com.omni.projetosomni.model.Projeto;
import com.omni.projetosomni.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> listarProjetos() {
        return projetoRepository.findAll();
    }


    public void cadastrarProjeto(ProjetoDTO projetoDTO) {
        Projeto projeto = projetoDTO.toProjeto();
        projetoRepository.save(projeto);
    }

    public void deletarProjeto(Integer id) {
        projetoRepository.deleteById(id);
    }


    public Projeto detalharProjeto(Integer id) {
        Optional<Projeto> projeto = projetoRepository.findById(id);
        if(projeto.isPresent()){
            return projeto.get();
        }
        return null;
    }
}
