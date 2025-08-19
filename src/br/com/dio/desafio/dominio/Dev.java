package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev extends User {
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        boolean adicionou = bootcamp.getDevsInscritos().add(this);

        if (adicionou) {
            System.out.println("Você foi inscrito no Bootcamp: " + bootcamp.getNome());
        } else {
            System.err.println("Você já está inscrito neste Bootcamp!");
        }
    }

    public void inscreverConteudo(Conteudo conteudo) {
        boolean adicionou = this.conteudosInscritos.add(conteudo);
        if (adicionou) {
            System.out.println("Você foi inscrito no conteúdo: " + conteudo.getTitulo());
        } else {
            System.err.println("Você já está inscrito neste conteúdo!");
        }
    }

    public void desinscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.removeAll(bootcamp.getConteudos());
        boolean removido = bootcamp.getDevsInscritos().remove(this);
        
        if (removido) {
            System.out.println("Você foi desinscrito do Bootcamp: " + bootcamp.getNome());
        } else {
            System.err.println("Você não estava inscrito neste Bootcamp!");
        }
    }

    public void desinscreverConteudo(Conteudo conteudo) {
        boolean removido = this.conteudosInscritos.remove(conteudo);
        if (removido) {
            System.out.println("Você foi desinscrito do conteúdo: " + conteudo.getTitulo());
        } else {
            System.err.println("Você não estava inscrito neste conteúdo!");
        }
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
            System.out.println("Parabéns! Você concluiu o conteúdo: " + conteudo.get().getTitulo());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(getNome(), dev.getNome()) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), conteudosInscritos, conteudosConcluidos);
    }
}
