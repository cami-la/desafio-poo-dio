import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Tutor rogerioTutor = new Tutor("Rogério", 30);
        Curso curso1 = new Curso("Curso Java", "descrição curso java", rogerioTutor, 15);

        Tutor robertoTutor = new Tutor("Roberto", 31);
        LocalDate dataEvento = LocalDate.of(2025, 12, 20);
        Mentoria mentoria = new Mentoria("Mentoria de java", "Descrição mentoria java", robertoTutor, dataEvento);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("CI&T - Backend com Java & AWS");
        bootcamp.setDescricao("Domine o desenvolvimento backend profissional com Java e AWS.");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(mentoria);

        Dev devVinicius = new Dev();
        devVinicius.setNome("Marcos Vinicius");
        devVinicius.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Vinicius:" + devVinicius.getConteudosInscritos());
        devVinicius.progredir();
        devVinicius.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Vinicius:" + devVinicius.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Vinicius:" + devVinicius.getConteudosConcluidos());
        System.out.println("XP:" + devVinicius.calcularTotalXp());

        System.out.println("-------");

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
        System.out.println("XP:" + devJoao.calcularTotalXp());

    }

}
