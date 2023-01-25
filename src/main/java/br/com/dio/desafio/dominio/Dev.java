package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe {@link Dev} representa um aluno inscrito no bootcamp.
 * @author Edielson Assis
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dev {
    
    private String nome;
    
    final private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    final private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
 
    /** 
     * Método que recebe um bootcamp como parâmetro e inscreve o aluno no bootcamp
     * @param bootcamp
     */
    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    /** 
     * Método que informa o status do aluno bootcamp
     */
    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        }
        else {
            System.err.println("Voce nao esta matriculado em nenhum conteudo!");
        }
    }

    /** 
     * Método usado para calcular Xp
     * @return double
     */
    public double calcularTotalXp() {
        return this.conteudosConcluidos.stream().mapToDouble(conteudo -> conteudo.calcularXp()).sum();
    }
}