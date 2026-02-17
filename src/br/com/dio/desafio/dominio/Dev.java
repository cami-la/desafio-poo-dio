package br.com.dio.desafio.dominio;

import br.com.dio.desafio.dominio.SemConteudoException;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Data
public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = conteudosInscritos.stream().findFirst();
        if (conteudo.isEmpty()) {
            throw new SemConteudoException("O Dev não possui conteúdos para progredir.");
        }
        conteudosConcluidos.add(conteudo.get());
        conteudosInscritos.remove(conteudo.get());
    }

    public double calcularTotalXp() {
        return conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }
}
