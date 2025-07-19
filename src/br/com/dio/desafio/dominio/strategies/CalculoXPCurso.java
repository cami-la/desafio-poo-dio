package br.com.dio.desafio.dominio.strategies;

import br.com.dio.desafio.dominio.interfaces.EstrategiaCalculoXP;

public class CalculoXPCurso implements EstrategiaCalculoXP {
    private static final double XP_PADRAO = 10d;
    private final int cargaHoraria;

    public CalculoXPCurso(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public double calcularXP() {
        return XP_PADRAO * cargaHoraria;
    }
}