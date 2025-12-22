package br.com.dio.desafio.dominio;

import java.util.Objects;

public class Curso extends Conteudo {
    private int cargaHoraria;

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public int getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(int cargaHoraria) { this.cargaHoraria = cargaHoraria; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        Curso curso = (Curso) o;
        return cargaHoraria == curso.cargaHoraria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cargaHoraria);
    }

    @Override
    public String toString() {
        return "Curso{" + "titulo='" + getTitulo() + '\'' + ", cargaHoraria=" + cargaHoraria + '}';
    }
}
