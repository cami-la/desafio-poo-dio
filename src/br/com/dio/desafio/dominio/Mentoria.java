package br.com.dio.desafio.dominio;

import java.time.LocalDate;

// A classe Mentoria herda da classe Conteudo e representa um tipo de conteúdo do sistema
public class Mentoria extends Conteudo {

    // Atributo específico da mentoria: data da mentoria
    private LocalDate data;

    // Método que calcula a experiência (XP) adquirida com a mentoria
    @Override
    public double calcularXp() {
        // O cálculo do XP baseia-se no XP padrão somado a um valor fixo de 20
        return XP_PADRAO + 20d;
    }

    // Construtor padrão da classe Mentoria
    public Mentoria() {
    }

    // Método getter para obter a data da mentoria
    public LocalDate getData() {
        return data;
    }

    // Método setter para definir a data da mentoria
    public void setData(LocalDate data) {
        this.data = data;
    }

    // Método toString sobrescrito para representar a Mentoria como uma string
    @Override
    public String toString() {
        // Retorna uma string com as informações da mentoria: título, descrição e data
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", data=" + data +
                '}';
    }
}