package br.com.dio.desafio.dominio;

import java.math.BigDecimal; 

public abstract class Conteudo {

    protected static final BigDecimal XP_PADRAO = new BigDecimal("10");

    private String titulo;
    private String descricao;

  
    public abstract BigDecimal calcularXp();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
