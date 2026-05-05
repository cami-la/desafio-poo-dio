package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Set;

public class Dev {

    private String nome;
    private Set<Conteudo> inscritos = new LinkedHashSet<>();
    private Set<Conteudo> concluidos = new LinkedHashSet<>();

    public void inscrever(Bootcamp bootcamp) {
        inscritos.addAll(bootcamp.getConteudos());
    }

    public void progredir() {
        Conteudo conteudo = inscritos.stream().findFirst().orElse(null);
        if (conteudo != null) {
            concluidos.add(conteudo);
            inscritos.remove(conteudo);
        }
    }

    public double calcularXp() {
        return concluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
    }

    public void setNome(String nome) { this.nome = nome; }
}
