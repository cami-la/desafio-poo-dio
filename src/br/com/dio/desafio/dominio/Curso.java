package br.com.dio.desafio.dominio;

public class Curso extends Conteudo{

    private int cargaHoraria;
    private Professor Professor;

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }
    public void SetProfessor(Professor professor){
        this.Professor = professor;
    }
    public Curso() {}


    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "professor: " + this.Professor.toString() +
                " titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria + "Professor: " + this.Professor +
                '}';
    }
}
