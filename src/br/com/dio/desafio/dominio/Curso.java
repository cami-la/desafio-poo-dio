package br.com.dio.desafio.dominio;

import br.com.dio.desafio.dominio.strategies.CalculoXPCurso;

public class Curso extends Conteudo {
    private int cargaHoraria;

    public Curso() {
        this.estrategiaCalculoXP = new CalculoXPCurso(this.cargaHoraria);
    }

    public Curso(String titulo, String descricao, int cargaHoraria) {
        this.setTitulo(titulo);
        this.setDescricao(descricao);
        this.cargaHoraria = cargaHoraria;
        this.estrategiaCalculoXP = new CalculoXPCurso(cargaHoraria);
    }

    public int getCargaHoraria() { return cargaHoraria; }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
        this.estrategiaCalculoXP = new CalculoXPCurso(cargaHoraria);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}
