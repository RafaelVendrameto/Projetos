package com.omni.projetosomni.dto;

import com.omni.projetosomni.model.Departamento;
import com.omni.projetosomni.model.Projeto;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ProjetoDTO {
    @NotBlank @NotNull @Length(max = 25)
    private String nomeProjeto;
    private String departamento;
    private String regulatorio;
    private String analiseSituacaoAtual;
    private String descricaoSituacaoDesejada;
    private String descricaoSolucao;

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getRegulatorio() {
        return regulatorio;
    }

    public void setRegulatorio(String regulatorio) {
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

    public Projeto toProjeto() {
        Projeto projeto = new Projeto();
        projeto.setNomeProjeto(nomeProjeto);
        projeto.setDataSolicitacao(LocalDate.now());
        projeto.setDepartamento(Departamento.valueOf(departamento));
        projeto.setRegulatorio(Boolean.valueOf(regulatorio));
        projeto.setDescricaoSolucao(descricaoSolucao);
        projeto.setAnaliseSituacaoAtual(analiseSituacaoAtual);
        projeto.setDescricaoSituacaoDesejada(descricaoSituacaoDesejada);
        projeto.setDescricaoSolucao(descricaoSolucao);
        return projeto;
    }
}
