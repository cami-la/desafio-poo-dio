package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Curso extends Conteudo{

    private int cargaHoraria;

    public Curso(String titulo, String descricao, Tutor professor, int cargaHoraria) {
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        this.setProfessor(professor);
        this.setCargaHoraria(cargaHoraria);
    }

    public Curso() {

    }

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria + '\'' +
                ", professor=" + getProfessor().getName() +
                '}';
    }
}
