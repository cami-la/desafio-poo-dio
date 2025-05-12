package br.com.dio.desafio.dominio;

// Definição de uma classe abstrata chamada "Conteudo".
// A classe abstrata não pode ser instanciada diretamente, mas pode ser estendida por outras classes.
public abstract class Conteudo {

    // A constante XP_PADRAO é um valor padrão de XP (provavelmente para um sistema de gamificação).
    // Essa constante é compartilhada por todas as instâncias dessa classe e suas subclasses.
    protected static final double XP_PADRAO = 10d;

    // Atributos privados para armazenar o título e a descrição de um conteúdo.
    // Esses atributos são comuns a todos os tipos de conteúdo que herdam essa classe.
    private String titulo;
    private String descricao;

    // Método abstrato, obrigando as subclasses a implementarem o cálculo do XP.
    // Cada tipo de conteúdo calculará o XP de maneira diferente.
    public abstract double calcularXp();

    // Métodos getters e setters para o título.
    // Permitem acessar e modificar o título de um conteúdo.
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Métodos getters e setters para a descrição.
    // Permitem acessar e modificar a descrição de um conteúdo.
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
