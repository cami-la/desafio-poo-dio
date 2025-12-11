package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo{

    private LocalDate data;

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    public Mentoria() {
    }

    public Mentoria(String titulo, String descricao, Tutor professor, LocalDate date) {
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        this.setProfessor(professor);
        this.setData(date);
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", data=" + data + '\'' +
                ", professor=" + getProfessor().getName() +
                '}';
    }
}
