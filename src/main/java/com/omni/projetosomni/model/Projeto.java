package com.omni.projetosomni.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeProjeto;
    private LocalDate dataSolicitacao;
    @Enumerated(EnumType.STRING)
    private Departamento departamento;
    private Boolean regulatorio;
    private String analisaSituacaoAtual;
    private String descricaoSituacaoDesejada;
    private String descricaoSolucao;

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

    public String getAnalisaSituacaoAtual() {
        return analisaSituacaoAtual;
    }

    public void setAnalisaSituacaoAtual(String analisaSituacaoAtual) {
        this.analisaSituacaoAtual = analisaSituacaoAtual;
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
}
