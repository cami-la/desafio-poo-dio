package br.com.dio.desafio.dominio;

public class Tutor {
    private String name;
    private int idade;

    public Tutor(String name, int idade) {
        this.name = name;
        this.idade = idade;
    }

    public Tutor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
