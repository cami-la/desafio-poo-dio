package br.com.dio.desafio.dominio;

public class Curso extends Conteudo{

    private int cargaHoraria;

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    //construtores
    public Curso() {
    }

    public Curso(String titulo, String descricao, int cargaHoraria) {
        super(titulo, descricao); //se refere a classe mãe
        this.cargaHoraria = cargaHoraria;
    }

    //get e set
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso: " + getTitulo()
                + "\nDescricao:" + getDescricao()
                + "\nCarga Horaria: " + cargaHoraria;
    }
}
