package br.com.dio.desafio.dominio.services;

import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.interfaces.CalculadoraXP;
import java.util.Set;

public class GerenciadorProgresso implements CalculadoraXP {
    private final Set<Conteudo> conteudosConcluidos;

    public GerenciadorProgresso(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public double calcular() {
        return conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public double calcularProgressoPercentual(Set<Conteudo> conteudosTotal) {
        if (conteudosTotal.isEmpty()) return 0.0;
        return (double) conteudosConcluidos.size() / conteudosTotal.size() * 100;
    }
}