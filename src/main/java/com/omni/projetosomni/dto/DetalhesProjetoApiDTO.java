package com.omni.projetosomni.dto;

import com.omni.projetosomni.model.Departamento;
import com.omni.projetosomni.model.Projeto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DetalhesProjetoApiDTO {
    private Integer id;
    private String nomeProjeto;
    private LocalDate dataSolicitacao;
    private Departamento departamento;
    private Boolean regulatorio;
    private String analiseSituacaoAtual;
    private String descricaoSituacaoDesejada;
    private String descricaoSolucao;

    public DetalhesProjetoApiDTO(Projeto projeto) {
        this.id = projeto.getId();
        this.nomeProjeto = projeto.getNomeProjeto();
        this.dataSolicitacao = projeto.getDataSolicitacao();
        this.departamento = projeto.getDepartamento();
        this.regulatorio = projeto.getRegulatorio();
        this.analiseSituacaoAtual = projeto.getAnaliseSituacaoAtual();
        this.descricaoSituacaoDesejada = projeto.getDescricaoSituacaoDesejada();
        this.descricaoSolucao = projeto.getDescricaoSolucao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Boolean getRegulatorio() {
        return regulatorio;
    }

    public void setRegulatorio(Boolean regulatorio) {
        this.regulatorio = regulatorio;
    }

    public String getAnaliseSituacaoAtual() {
        return analiseSituacaoAtual;
    }

    public void setAnaliseSituacaoAtual(String analiseSituacaoAtual) {
        this.analiseSituacaoAtual = analiseSituacaoAtual;
    }

    public String getDescricaoSituacaoDesejada() {
        return descricaoSituacaoDesejada;
    }

    public void setDescricaoSituacaoDesejada(String descricaoSituacaoDesejada) {
        this.descricaoSituacaoDesejada = descricaoSituacaoDesejada;
    }

    public String getDescricaoSolucao() {
        return descricaoSolucao;
    }

    public void setDescricaoSolucao(String descricaoSolucao) {
        this.descricaoSolucao = descricaoSolucao;
    }

    public static List<DetalhesProjetoApiDTO> converter(List<Projeto> listarProjetos) {
        return listarProjetos.stream().map(DetalhesProjetoApiDTO::new).collect(Collectors.toList());
    }
}
