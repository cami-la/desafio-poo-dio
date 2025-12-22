package br.com.dio.desafio.dominio;

import java.util.Objects;

/**
 * Classe abstrata que representa a base para qualquer tipo de conteúdo educacional.
 * Aplica o pilar da ABSTRAÇÃO ao isolar atributos comuns.
 */
public abstract class Conteudo {

    // Constante acessível pelas subclasses para o cálculo de XP
    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;

    // Método abstrato: obriga as subclasses (Curso/Mentoria) a implementar sua própria lógica de XP (POLIMORFISMO)
    public abstract double calcularXp();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Implementação de Equals e HashCode para garantir que não existam conteúdos duplicados em coleções Set
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conteudo conteudo = (Conteudo) o;
        return Objects.equals(titulo, conteudo.titulo) && Objects.equals(descricao, conteudo.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, descricao);
    }

    // Facilita a impressão dos dados no console durante os testes na classe Main
    @Override
    public String toString() {
        return "Conteudo{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
