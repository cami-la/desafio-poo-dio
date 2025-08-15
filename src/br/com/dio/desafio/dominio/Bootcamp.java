package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {

    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private final Set<Dev> devsInscritos = new LinkedHashSet<>();
    private final Set<Conteudo> conteudos = new LinkedHashSet<>();

    // Construtor obrigatório para garantir nome e descrição
    public Bootcamp(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    // Retorna coleções como não modificáveis para proteger encapsulamento
    public Set<Dev> getDevsInscritos() {
        return Collections.unmodifiableSet(devsInscritos);
    }

    public Set<Conteudo> getConteudos() {
        return Collections.unmodifiableSet(conteudos);
    }

    // Métodos para manipular coleções de forma controlada
    public void inscreverDev(Dev dev) {
        devsInscritos.add(dev);
    }

    public void removerDev(Dev dev) {
        devsInscritos.remove(dev);
    }

    public void adicionarConteudo(Conteudo conteudo) {
        conteudos.add(conteudo);
    }

    public void removerConteudo(Conteudo conteudo) {
        conteudos.remove(conteudo);
    }

    // equals e hashCode baseados apenas em 'nome' (identidade do bootcamp)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bootcamp)) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
