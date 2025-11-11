import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Curso curso = new Curso("Curso de java", "Curso básico de Java", 10);
        Mentoria mentoria = new Mentoria("Mentoria sobre java", "Principais pontos da atualização java", LocalDate.now());

        Bootcamp Java_and_QA_Developer = new Bootcamp();
        Java_and_QA_Developer.setNome("PcD Tech Bradesco - Java & QA Developer");
        Java_and_QA_Developer.setDescricao("Bootcamp sobre java e qualidade de software");
        Java_and_QA_Developer.getConteudos().add(curso);
        Java_and_QA_Developer.getConteudos().add(mentoria);

        Dev devIgor = new Dev();
        devIgor.setNome("Igor");
        devIgor.inscreverBootcamp(Java_and_QA_Developer);
        imprimeDev(devIgor);
        devIgor.progredir();
        imprimeDev(devIgor);
        devIgor.progredir();
        imprimeDev(devIgor);

        Dev devKanudo = new Dev();
        devKanudo.setNome("Cainan");
        devKanudo.inscreverBootcamp(Java_and_QA_Developer);
        imprimeDev(devKanudo);
        devKanudo.progredir();
        imprimeDev(devKanudo);
    }

    private static void imprimeDev(Dev dev){
        System.out.println("Conteúdos Inscritos do "+dev.getNome() +" : "+ dev.getConteudosInscritos());
        System.out.println("Conteúdos concluídos do "+dev.getNome() +" : "+ dev.getConteudosConcluidos());
        System.out.println("XP : " + dev.calcularTotalXp());
        System.out.println("#############################");
    }
}
