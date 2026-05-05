package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Bootcamp {

    private String nome;
    private String descricao;
    private LocalDate dataInicial = LocalDate.now();
    private LocalDate dataFinal = dataInicial.plusDays(45);

    private Set<Conteudo> conteudos = new HashSet<>();
    private Set<Dev> devsInscritos = new HashSet<>();

    public Set<Conteudo> getConteudos() { return conteudos; }
    public Set<Dev> getDevsInscritos() { return devsInscritos; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}