import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Curso cursoJava = criarCurso("Curso Java", "Descrição curso Java", 8);
        Curso cursoJs = criarCurso("Curso JavaScript", "Descrição curso JavaScript", 4);
        Mentoria mentoriaJava = criarMentoria("Mentoria Java", "Descrição mentoria Java", LocalDate.now());

        Bootcamp bootcampJava = new Bootcamp();
        bootcampJava.setNome("Bootcamp Java Developer");
        bootcampJava.setDescricao("Descrição Bootcamp Java Developer");
        bootcampJava.getConteudos().add(cursoJava);
        bootcampJava.getConteudos().add(cursoJs);
        bootcampJava.getConteudos().add(mentoriaJava);

        Dev camila = new Dev();
        camila.setNome("Camila");
        camila.inscreverBootcamp(bootcampJava);

        System.out.println("Conteúdos Inscritos - Camila: " + camila.getConteudosInscritos());
        camila.progredir();
        camila.progredir();
        System.out.println("Conteúdos Inscritos - Camila: " + camila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos - Camila: " + camila.getConteudosConcluidos());
        System.out.println("XP Total - Camila: " + camila.calcularTotalXp());

        System.out.println("-------");

        Dev joao = new Dev();
        joao.setNome("João");
        joao.inscreverBootcamp(bootcampJava);

        System.out.println("Conteúdos Inscritos - João: " + joao.getConteudosInscritos());
        joao.progredir();
        joao.progredir();
        joao.progredir();
        System.out.println("Conteúdos Inscritos - João: " + joao.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos - João: " + joao.getConteudosConcluidos());
        System.out.println("XP Total - João: " + joao.calcularTotalXp());
    }

    private static Curso criarCurso(String titulo, String descricao, int cargaHoraria) {
        Curso curso = new Curso();
        curso.setTitulo(titulo);
        curso.setDescricao(descricao);
        curso.setCargaHoraria(cargaHoraria);
        return curso;
    }

    private static Mentoria criarMentoria(String titulo, String descricao, LocalDate data) {
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo(titulo);
        mentoria.setDescricao(descricao);
        mentoria.setData(data);
        return mentoria;
    }
}
