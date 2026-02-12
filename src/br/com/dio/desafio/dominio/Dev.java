package br.com.dio.desafio.dominio;

import java.util.*;

/**
 * Representa um desenvolvedor participante de bootcamps.
 * Gerencia a inscrição em bootcamps, progresso de conteúdos e cálculo de XP.
 *
 * @author DIO - Digital Innovation One
 * @version 1.1
 */
public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    /**
     * Inscreve o desenvolvedor em um bootcamp.
     * Adiciona todos os conteúdos do bootcamp aos conteúdos inscritos
     * e registra o desenvolvedor na lista de inscritos do bootcamp.
     *
     * @param bootcamp o bootcamp no qual o desenvolvedor será inscrito
     */
    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    /**
     * Progride para o próximo conteúdo do bootcamp.
     * Move o primeiro conteúdo inscrito para a lista de conteúdos concluídos.
     * Se não houver conteúdos inscritos, exibe uma mensagem de erro.
     */
    public void progredir() {
        this.conteudosInscritos.stream()
                .findFirst()
                .ifPresentOrElse(
                        conteudo -> {
                            this.conteudosConcluidos.add(conteudo);
                            this.conteudosInscritos.remove(conteudo);
                        },
                        () -> System.err.println("Você não está matriculado em nenhum conteúdo!")
                );
    }

    /**
     * Calcula o total de XP acumulado pelo desenvolvedor.
     * O XP é calculado somando o XP de todos os conteúdos concluídos.
     *
     * @return o total de XP acumulado
     */
    public double calcularTotalXp() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
