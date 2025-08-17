package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Set;

public class Projeto {
    private String nome;
    private String descricao;
    private Set<String> tecnologias = new LinkedHashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<String> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(Set<String> tecnologias) {
        this.tecnologias = tecnologias;
    }
}
