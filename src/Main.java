import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

// Importações das classes do domínio do projeto
import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Criação do primeiro curso
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8); // duração do curso em horas

        // Criação do segundo curso
        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4); // duração do curso em horas

        // Criação de uma mentoria
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now()); // data da mentoria (hoje)

        // Comentado: poderia exibir os detalhes dos cursos e da mentoria
        /*
        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);
        */

        // Criação de um bootcamp e adição de conteúdos (cursos e mentoria)
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        // Instanciação de um dev (Camila), inscrição no bootcamp e progresso
        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp); // inscreve a dev no bootcamp
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos()); // lista de conteúdos ainda não concluídos
        devCamila.progredir(); // conclui o primeiro conteúdo
        devCamila.progredir(); // conclui o segundo conteúdo
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos()); // atualiza lista de pendentes
        System.out.println("Conteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos()); // conteúdos já finalizados
        System.out.println("XP:" + devCamila.calcularTotalXp()); // soma da XP ganha com os conteúdos concluídos

        System.out.println("-------");

        // Outro dev (João) passando por um processo semelhante
        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp); // inscreve João
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        devJoao.progredir(); // conclui o primeiro conteúdo
        devJoao.progredir(); // conclui o segundo conteúdo
        devJoao.progredir(); // conclui o terceiro conteúdo (mentoria)
        System.out.println("-");
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
        System.out.println("XP:" + devJoao.calcularTotalXp()); // XP total de João
    }
}
