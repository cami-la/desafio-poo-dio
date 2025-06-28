import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Bootcamp bootcamp = criarBootcamp();

        Dev camila = new Dev("Camila");
        Dev joao = new Dev("João");

        camila.inscreverBootcamp(bootcamp);
        joao.inscreverBootcamp(bootcamp);

        System.out.println("== Progresso de Camila ==");
        progredirEExibirStatus(camila, 2);

        System.out.println("\n== Progresso de João ==");
        progredirEExibirStatus(joao, 3);
    }

    private static Bootcamp criarBootcamp() {
        Curso curso1 = new Curso("Curso Java", "Descrição curso Java", 8);
        Curso curso2 = new Curso("Curso JS", "Descrição curso JS", 4);
        Mentoria mentoria = new Mentoria("Mentoria de Java", "Descrição mentoria Java", LocalDate.now());

        Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer");
        bootcamp.adicionarConteudo(curso1);
        bootcamp.adicionarConteudo(curso2);
        bootcamp.adicionarConteudo(mentoria);

        return bootcamp;
    }

    private static void progredirEExibirStatus(Dev dev, int vezes) {
        for (int i = 0; i < vezes; i++) {
            dev.progredir();
        }
        System.out.println("Conteúdos Inscritos: " + dev.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos: " + dev.getConteudosConcluidos());
        System.out.println("XP Total: " + dev.calcularTotalXp());
    }
}
