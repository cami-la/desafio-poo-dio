package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo {

    private LocalDate data;

    public Mentoria() { }

    public Mentoria(String titulo, String descricao, LocalDate data) {
        super(titulo, descricao);
        setData(data);
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("Data da mentoria não pode ser nula");
        }
        this.data = data;
    }

    @Override
    public String toString() {
        return super.toString() + ", Mentoria{" +
                "data=" + data +
                '}';
    }
}
