package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

// A classe Bootcamp representa um Bootcamp, com informações sobre seu nome, descrição, datas e conteúdos.
public class Bootcamp {

    // Atributos da classe Bootcamp
    private String nome; // Nome do Bootcamp
    private String descricao; // Descrição do Bootcamp
    private final LocalDate dataInicial = LocalDate.now(); // Data de início do Bootcamp, definida como a data atual.
    private final LocalDate dataFinal = dataInicial.plusDays(45); // Data final do Bootcamp, 45 dias após a data inicial.
    private Set<Dev> devsInscritos = new HashSet<>(); // Conjunto de desenvolvedores inscritos, armazenado em um HashSet para garantir que não haja duplicatas.
    private Set<Conteudo> conteudos = new LinkedHashSet<>(); // Conjunto de conteúdos do Bootcamp, armazenado em um LinkedHashSet para manter a ordem de inserção.

    // Métodos getters e setters para acessar e modificar os atributos privados.

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public void setDevsInscritos(Set<Dev> devsInscritos) {
        this.devsInscritos = devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    // Método equals para comparar dois objetos Bootcamp. Utiliza todos os atributos da classe para verificar se são iguais.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Se os objetos são o mesmo, retorna true.
        if (o == null || getClass() != o.getClass()) return false; // Verifica se o objeto é do tipo correto e não é nulo.
        Bootcamp bootcamp = (Bootcamp) o; // Faz o cast para Bootcamp.
        // Compara todos os atributos do Bootcamp
        return Objects.equals(nome, bootcamp.nome) &&
                Objects.equals(descricao, bootcamp.descricao) &&
                Objects.equals(dataInicial, bootcamp.dataInicial) &&
                Objects.equals(dataFinal, bootcamp.dataFinal) &&
                Objects.equals(devsInscritos, bootcamp.devsInscritos) &&
                Objects.equals(conteudos, bootcamp.conteudos);
    }

    // Método hashCode, que gera um código hash único baseado nos atributos da classe.
    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal, devsInscritos, conteudos);
    }
}