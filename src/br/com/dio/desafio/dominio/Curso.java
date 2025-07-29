package br.com.dio.desafio.dominio;

public class Curso extends Conteudo{

    private int cargaHoraria;

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public Curso() {
    }
    public Curso((String titulo, String descricao, int cargaHoraria) { 
        super(titulo, descricao);
        this.cargaHoraria = cargaHoraria;
    }



    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        if (cargaHoraria < 0) {
             throw new IllegalArgumentException("A carga horária não pode ser negativa.");
        }
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return String.format("Curso{titulo='%s', descricao='%s', cargaHoraria=%d}",
            getTitulo(), getDescricao(), cargaHoraria);
    }
}
