package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo{

    private LocalDate data;

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    //Construtores
    public Mentoria() {
    }

    public Mentoria(String titulo, String descricao, LocalDate data) {
        super(titulo, descricao); //se refere a classe mãe
        this.data = data;
    }

    //set e get
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Mentoria: "
        		+ getTitulo()
                + "\nDescricao: " + getDescricao()
                + "\nData: " + data;
    }
}
