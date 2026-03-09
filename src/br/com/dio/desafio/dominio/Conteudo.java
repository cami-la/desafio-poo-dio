package br.com.dio.desafio.dominio;

public abstract class Conteudo {

    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;
    private Conteudo preRequisito;

    public abstract double calcularXp();

    public Conteudo getPreRequisito() {
        return preRequisito;
    }

    public void setPreRequisito(Conteudo preRequisito) {
        this.preRequisito = preRequisito;
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
}
