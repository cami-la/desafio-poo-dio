package br.com.dio.desafio.dominio;

public class Desafio extends Conteudo {

    private int nivelDificuldade;

    @Override
    public double calcularXp() {
        return XP_PADRAO * nivelDificuldade;
    }

    public int getNivelDificuldade() {
        return nivelDificuldade;
    }

    public void setNivelDificuldade(int nivelDificuldade) {
        this.nivelDificuldade = nivelDificuldade;
    }

    @Override
    public String toString() {
        return "Desafio{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", nivelDificuldade=" + nivelDificuldade +
                '}';
    }
}