package br.com.dio.desafio.dominio.strategies;

import br.com.dio.desafio.dominio.interfaces.EstrategiaCalculoXP;

public class CalculoXPMentoria implements EstrategiaCalculoXP {
    private static final double XP_PADRAO = 20d;

    @Override
    public double calcularXP() {
        return XP_PADRAO;
    }
}