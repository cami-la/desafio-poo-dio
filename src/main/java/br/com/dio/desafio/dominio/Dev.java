package br.com.dio.desafio.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.DoubleStream;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void concluirConteudo(Conteudo conteudo) {
        if(this.conteudosInscritos.contains(conteudo)) this.conteudosInscritos.remove(conteudo);
        this.conteudosConcluidos.add(conteudo);
    }

    public double calcularTotalXp() {
        DoubleStream streamXP = this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp);
        return streamXP.reduce(0, Double::sum);
    }
}
