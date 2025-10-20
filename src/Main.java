import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("---------------------CONTEUDOS INSCRITOS DA " + devCamila.getNome().toUpperCase() + "---------------------");
        Set<Conteudo> listaConteudosInscritos = devCamila.getConteudosInscritos();
        Set<Conteudo> listarConteudosConcluidos = devCamila.getConteudosConcluidos();
        listaConteudosInscritos.forEach(l -> System.out.println(l.getClass().getSimpleName()+": " + l.getTitulo() + "   |   " + "Descrição: " + l.getDescricao() + "   |   XP: " + l.calcularXp()));

        devCamila.progredir();
        devCamila.progredir();

        System.out.println("---------------------CONTEUDOS INSCRITOS APÓS O PROGREDIR---------------------");
        listaConteudosInscritos.forEach(l -> System.out.println(l.getClass().getSimpleName()+": " + l.getTitulo() + "   |   " + "Descrição: " + l.getDescricao() + "   |   XP: " + l.calcularXp()));

        System.out.println("---------------------CONTEUDOS CONCLUIDOS APÓS O PROGREDIR---------------------");
        listarConteudosConcluidos.forEach(l -> System.out.println(l.getClass().getSimpleName()+": "+ l.getTitulo() + "   |   " + "Descrição: " + l.getDescricao() + "   |   XP: " + l.calcularXp()));
        System.out.println("TOTAL DE XP ADQUIRIDOS:" + devCamila.calcularTotalXp());
        System.out.println();
    }

}
