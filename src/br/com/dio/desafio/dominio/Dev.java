package br.com.dio.desafio.dominio;

import java.util.*;

// Classe que representa um desenvolvedor (Dev) que pode se inscrever em um bootcamp e concluir conteúdos.
public class Dev {

    // Atributo que armazena o nome do desenvolvedor
    private String nome;

    // Conjunto de conteúdos nos quais o desenvolvedor está inscrito (usando LinkedHashSet para manter a ordem de inscrição)
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();

    // Conjunto de conteúdos que o desenvolvedor concluiu (também mantém a ordem de conclusão)
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    // Método para inscrever o desenvolvedor em um bootcamp, adicionando os conteúdos do bootcamp à sua lista de conteúdos inscritos
    public void inscreverBootcamp(Bootcamp bootcamp){
        // Adiciona todos os conteúdos do bootcamp à lista de conteúdos do desenvolvedor
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        // Adiciona o desenvolvedor à lista de inscritos do bootcamp
        bootcamp.getDevsInscritos().add(this);
    }

    // Método que simula o progresso do desenvolvedor, removendo o primeiro conteúdo da lista de inscritos e adicionando-o à lista de concluídos
    public void progredir() {
        // Tenta pegar o primeiro conteúdo da lista de inscritos
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();

        // Se o conteúdo estiver presente (se o desenvolvedor estiver inscrito em algum conteúdo)
        if(conteudo.isPresent()) {
            // Adiciona o conteúdo concluído à lista de conteúdos concluídos
            this.conteudosConcluidos.add(conteudo.get());
            // Remove o conteúdo da lista de inscritos
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            // Caso não haja conteúdo na lista de inscritos, exibe uma mensagem de erro
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    // Método para calcular o total de XP do desenvolvedor com base nos conteúdos concluídos
    public double calcularTotalXp() {
        // Cria um iterador para percorrer a lista de conteúdos concluídos
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;

        // Itera sobre os conteúdos concluídos e soma o XP de cada um
        while(iterator.hasNext()){
            double next = iterator.next().calcularXp(); // Chama o método calcularXp de cada conteúdo
            soma += next; // Soma o valor do XP
        }

        // Retorna o total de XP
        return soma;

        // Alternativamente, o código pode ser simplificado com a linha abaixo, usando stream para somar o XP:
        /*return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp) // Mapeia cada conteúdo para seu valor de XP
                .sum(); // Soma todos os valores de XP*/
    }

    // Métodos getters e setters para os atributos da classe
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    // Sobrescreve o método equals para comparar dois objetos Dev com base no nome e nos conjuntos de conteúdos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) &&
                Objects.equals(conteudosInscritos, dev.conteudosInscritos) &&
                Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    // Sobrescreve o método hashCode para gerar um código hash único com base no nome e nos conteúdos
    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
