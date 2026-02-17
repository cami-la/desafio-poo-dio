package br.com.dio.desafio.dominio;

public class Projeto extends Conteudo{
    private int dificuldade; // 1 a 5

    @Override
    public double calcularXp() {
        return XP_PADRAO * dificuldade * 5;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", dificuldade=" + dificuldade +
                '}';
    }
}
