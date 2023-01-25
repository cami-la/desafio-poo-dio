package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe {@link Bootcamp} exibe todos os bootcamps disponíveis.
 * @author Edielson Assis
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bootcamp {
    
    private String nome;
    private String descricao;
    final private LocalDate dataInicio = LocalDate.now();
    final private LocalDate dataFim = dataInicio.plusDays(45);
    
    final private Set<Conteudo> conteudos = new LinkedHashSet<>();    
    final private Set<Dev> devsInscritos = new HashSet<>();
}