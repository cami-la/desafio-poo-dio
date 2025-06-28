package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {

    private int cargaHoraria;

    public Curso() { }

    public Curso(String titulo, String descricao, int cargaHoraria) {
        super(titulo, descricao);
        setCargaHoraria(cargaHoraria);
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        if (cargaHoraria < 0) {
            throw new IllegalArgumentException("Carga horária não pode ser negativa");
        }
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return super.toString() + ", Curso{" +
                "cargaHoraria=" + cargaHoraria +
                '}';
    }
}
