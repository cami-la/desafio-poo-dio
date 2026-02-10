package br.com.dio.desafio.dominio;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Classe Instrutor que herda de Pessoa
 * Demonstra HERANÇA: Instrutor é uma especialização de Pessoa
 * Demonstra POLIMORFISMO: Pessoa pode ser Dev ou Instrutor
 */
public class Instrutor extends Pessoa {
    private String especialidade;
    private Set<Mentoria> mentoriasMinistradas = new HashSet<>();

    public Instrutor() {
        super();
    }

    public Instrutor(String nome, String email, String especialidade) {
        super(nome, email);
        this.especialidade = especialidade;
    }

    /**
     * Ministra uma mentoria
     * Demonstra ENCAPSULAMENTO: lógica de negócio encapsulada
     */
    public void ministrarMentoria(Mentoria mentoria) {
        mentoria.setInstrutor(this);
        this.mentoriasMinistradas.add(mentoria);
        System.out.println("👨‍🏫 " + getNome() + " está ministrando: " + mentoria.getTitulo());
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Set<Mentoria> getMentoriasMinistradas() {
        return mentoriasMinistradas;
    }

    public void setMentoriasMinistradas(Set<Mentoria> mentoriasMinistradas) {
        this.mentoriasMinistradas = mentoriasMinistradas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Instrutor instrutor = (Instrutor) o;
        return Objects.equals(especialidade, instrutor.especialidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), especialidade);
    }

    @Override
    public String toString() {
        return "Instrutor{" +
                "nome='" + getNome() + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", mentoriasMinistradas=" + mentoriasMinistradas.size() +
                '}';
    }
}
