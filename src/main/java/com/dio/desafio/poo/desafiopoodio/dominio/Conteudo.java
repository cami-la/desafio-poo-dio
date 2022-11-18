package com.dio.desafio.poo.desafiopoodio.dominio;

import lombok.Data;

@Data
public abstract class Conteudo {

    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;

    public abstract double calcularXp();
}
