package br.com.dio.desafio.dominio;

public enum NivelDificuldade {
    FACIL(1),
    MEDIO(2),
    DIFICIL(3);

    private final int multiplicadorXp;

    NivelDificuldade(int multiplicadorXp) {
        this.multiplicadorXp = multiplicadorXp;
    }

    public int getMultiplicadorXp() {
        return multiplicadorXp;
    }
}