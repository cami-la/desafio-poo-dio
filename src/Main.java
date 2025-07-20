import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso();
        curso1.setTitulo("Curso java");
        curso1.setDescricao("Descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev dev1 = new Dev();
        dev1.setNome("Camila");
        dev1.inscreverBootcamp(bootcamp);

        System.out.println(dev1.getNome() + ", conteúdos inscritos: ");
        for (Conteudo conteudo : dev1.getConteudosInscritos()) {
            System.out.println(conteudo);
        }

        dev1.progredir();
        dev1.progredir();

        System.out.println("___________________________________");
        System.out.println(dev1.getNome() + ", conteúdos concluídos: ");
        for (Conteudo conteudo : dev1.getConteudosConcluidos()) {
            System.out.println(conteudo);
        }

        System.out.println();
        System.out.println("XP: " + dev1.calcularTotalXp());

        System.out.println();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println();

        Dev dev2 = new Dev();
        dev2.setNome("Joao");
        dev2.inscreverBootcamp(bootcamp);

        System.out.println(dev2.getNome() + ", conteúdos inscritos: ");
        for (Conteudo conteudo : dev2.getConteudosInscritos()) {
            System.out.println(conteudo);
        }

        dev2.progredir();
        dev2.progredir();
        dev2.progredir();

        System.out.println("___________________________________");

        System.out.println(dev2.getNome() + ", conteúdos concluídos: ");
        for (Conteudo conteudo : dev2.getConteudosConcluidos()) {
            System.out.println(conteudo);
        }
        System.out.println();
        System.out.println("XP: " + dev2.calcularTotalXp());
    }
}
