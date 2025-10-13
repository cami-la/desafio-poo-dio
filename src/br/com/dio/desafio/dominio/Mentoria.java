package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo {

    private LocalDate data;
    private Mentor mentor;

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    public Mentoria() {
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Mentoria \n---------------------------------\n")
                .append("Data: ").append(getData())
                .append("\nMentor: ").append(getMentor().getName())
                .append("\nTítulo: ").append(getTitulo())
                .append("\nDescriço: ").append(getDescricao())
                .append("\nXp: ").append(calcularXp());
        return builder.toString();
    }
}
