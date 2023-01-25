package br.com.dio.desafio;

import java.time.LocalDate;
import java.util.Arrays;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

/**
 * Classe {@link App} contem o método main
 * @author Edielson Assis
 */
public class App {
    public static void main(String[] args) {

        Conteudo curso1 = new Curso("Java", "Java fundamentos", 20);
        Conteudo curso2 = new Curso("SpringBoot", "Aprenda a usar o Spring framework", 8);
        Conteudo mentoria1 = new Mentoria("Java POO", "Aprenda os conceitos da orientacao a objetos", LocalDate.now());
        
        Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Aprenda Java de forma pratica");
        bootcamp.getConteudos().addAll(Arrays.asList(curso1, mentoria1, curso2));

        Dev Edielson = new Dev("Edielson");
        Edielson.inscreverBootcamp(bootcamp);

        System.out.println("Conteudos inscritos: " + Edielson.getConteudosInscritos());

        System.out.println("----------------------------");

        Edielson.progredir();
        Edielson.progredir();

        System.out.println("Conteudos concluidos: " + Edielson.getConteudosConcluidos());
        System.out.println("Xp: " + Edielson.calcularTotalXp());
    }
}