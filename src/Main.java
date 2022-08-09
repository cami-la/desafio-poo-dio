import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import br.com.dio.desafio.dominio.ProjetoPratico;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso Spring Framework");
        curso2.setDescricao("Descrição curso spring");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição mentoria java");
        mentoria.setData(LocalDate.now());
        
        ProjetoPratico projeto = new ProjetoPratico();
        projeto.setTitulo("Projeto Prático de Java");
        projeto.setDescricao("Descrição do projeto java");
        projeto.setNivelDificuldade(2);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);
        bootcamp.getConteudos().add(projeto);

        Dev dev1 = new Dev();
        dev1.setNome("Maria");
        dev1.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos de"+ dev1.getNome()+":" + dev1.getConteudosInscritos());
        dev1.progredir();
        dev1.progredir();
        dev1.progredir();
        dev1.progredir();
        System.out.println("-");
        System.out.println("Conteudos Inscritos de"+ dev1.getNome()+":" + dev1.getConteudosInscritos());
        System.out.println("Conteudos Concluidos de"+ dev1.getNome()+":" + dev1.getConteudosConcluidos());
        System.out.println("XP:" + dev1.calcularTotalXp());
        

        System.out.println("-------");

        Dev dev2 = new Dev();
        dev2.setNome("Sebastian");
        dev2.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos de"+ dev2.getNome()+":" + dev2.getConteudosInscritos());
        dev2.progredir();
        dev2.progredir();
        dev2.progredir();
        System.out.println("-");
        System.out.println("Conteudos Inscritos de"+ dev2.getNome()+":" + dev2.getConteudosInscritos());
        System.out.println("Conteudos Concluidos de"+ dev2.getNome()+":" + dev2.getConteudosConcluidos());
        System.out.println("XP:" + dev2.calcularTotalXp());
        
    }

}
