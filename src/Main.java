import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Desafio;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição do curso de Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JavaScript");
        curso2.setDescricao("Descrição do curso de JavaScript");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição da mentoria de Java");
        mentoria.setData(LocalDate.now());

        Desafio desafio1 = new Desafio();
        desafio1.setTitulo("Desafio de Projeto");
        desafio1.setDescricao("Refatorando o projeto de POO");
        desafio1.setNivelDificuldade(3);

        Desafio desafio2 = new Desafio();
        desafio2.setTitulo("Desafio de Algoritmo");
        desafio2.setDescricao("Resolvendo um desafio de lógica");
        desafio2.setNivelDificuldade(5);


        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);
        bootcamp.getConteudos().add(desafio1);
        bootcamp.getConteudos().add(desafio2);


        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("Nível de Camila: " + devCamila.getNivel());

        devCamila.progredir();
        devCamila.progredir();
        devCamila.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos());
        System.out.println("Conteúdos Inscritos restantes:" + devCamila.getConteudosInscritos());
        System.out.println("XP Total de Camila:" + devCamila.calcularTotalXp());
        System.out.println("Nível de Camila: " + devCamila.getNivel());


        System.out.println("\n-------");

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        System.out.println("Nível de João: " + devJoao.getNivel());

        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Concluídos João:" + devJoao.getConteudosConcluidos());
        System.out.println("Conteúdos Inscritos restantes:" + devJoao.getConteudosInscritos());
        System.out.println("XP Total de João:" + devJoao.calcularTotalXp());
        System.out.println("Nível de João: " + devJoao.getNivel());

    }
}