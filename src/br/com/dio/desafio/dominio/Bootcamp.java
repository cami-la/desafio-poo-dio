package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.*;

public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private final Set<Dev> devsInscritos = new HashSet<>();
    private final Set<Conteudo> conteudos = new LinkedHashSet<>();

    // MÉTODOS NOVOS -----------------------

    // Adiciona conteúdo de forma segura
    public void adicionarConteudo(Conteudo conteudo) {
        if (this.conteudos.contains(conteudo)) {
            System.out.println("⚠ Conteúdo já existe no bootcamp: " + conteudo.getTitulo());
        } else {
            this.conteudos.add(conteudo);
        }
    }

    // Inscreve Dev de forma segura
    public void inscreverDev(Dev dev) {
        if (this.devsInscritos.contains(dev)) {
            System.out.println("⚠ Dev já inscrito no bootcamp: " + dev.getNome());
        } else {
            this.devsInscritos.add(dev);
            dev.inscreverBootcamp(this);
        }
    }

    // Retorna quantidade de conteúdos
    public int getQuantidadeConteudos() {
        return conteudos.size();
    }

    // Retorna quantidade de devs inscritos
    public int getQuantidadeDevs() {
        return devsInscritos.size();
    }

    // GETTERS / SETTERS -------------------

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDate getDataInicial() { return dataInicial; }

    public LocalDate getDataFinal() { return dataFinal; }

    public Set<Dev> getDevsInscritos() {
        return Collections.unmodifiableSet(devsInscritos);
    }

    public Set<Conteudo> getConteudos() {
        return Collections.unmodifiableSet(conteudos);
    }

    // EQUALS & HASHCODE -------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bootcamp bootcamp)) return false;
        return Objects.equals(nome, bootcamp.nome) &&
                Objects.equals(descricao, bootcamp.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }
}
