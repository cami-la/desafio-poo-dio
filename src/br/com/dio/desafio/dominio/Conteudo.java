package br.com.dio.desafio.dominio;

import br.com.dio.desafio.dominio.interfaces.EstrategiaCalculoXP;
import java.util.Objects;

public abstract class Conteudo {
    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;
    protected EstrategiaCalculoXP estrategiaCalculoXP;

    public double calcularXp() {
        return estrategiaCalculoXP != null ? estrategiaCalculoXP.calcularXP() : XP_PADRAO;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conteudo conteudo = (Conteudo) o;
        return Objects.equals(titulo, conteudo.titulo) &&
               Objects.equals(descricao, conteudo.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, descricao);
    }
}
