package br.com.dio.desafio.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe {@link Conteudo} é uma classe abstrata, sua finalidade é
 * prover o reuso de código para as classes filhas
 * @author Edielson Assis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Conteudo {
    
    final protected static double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;

    public abstract double calcularXp();
}