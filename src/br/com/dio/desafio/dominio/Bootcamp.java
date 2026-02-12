package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();


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

    public void listarInscritosPorBootcamp(){
        System.out.printf("\nBootcamp: %s\n", this.nome);
        System.out.printf("Descrição: %s\n ", this.descricao);

        if(devsInscritos.isEmpty()){
            System.out.println("\nBootcamp sem Devs inscritos!");
        }

        for(Dev v : devsInscritos){
            var conteudosInscritos = v.getConteudosInscritos();
            var conteudosConcluidos = v.getConteudosConcluidos();

            System.out.println("-----------------------------------------");
            System.out.printf("Dev: %s - XP Atual: %s\n", v.getNome(), v.calcularTotalXp());
            System.out.println("-----------------------------------------");
            System.out.println("Conteudos inscritos:");

            if(conteudosInscritos.isEmpty()) System.out.println("    Nenhum conteudo inscrito");

            for(Conteudo c : conteudosInscritos){
                System.out.printf("    (%s) - Titulo: %s\n",c.getClass().getSimpleName(), c.getTitulo());
            }

            System.out.println("\nConteudos Concluidos:");

            if(conteudosConcluidos.isEmpty()) System.out.println("    Nenhum conteudo concluido");

            for(Conteudo c1 : conteudosConcluidos){
                System.out.printf("    (%s)- Titulo: %s\n", c1.getClass().getSimpleName(),c1.getTitulo());
            }
            System.out.println();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) && Objects.equals(descricao, bootcamp.descricao) && Objects.equals(dataInicial, bootcamp.dataInicial) && Objects.equals(dataFinal, bootcamp.dataFinal) && Objects.equals(devsInscritos, bootcamp.devsInscritos) && Objects.equals(conteudos, bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal, devsInscritos, conteudos);
    }
}
