import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
// Criando os conteúdos base
        Curso cursoJava = new Curso();
        cursoJava.setTitulo("Curso Java");
        cursoJava.setDescricao("Fundamentos da linguagem Java");
        cursoJava.setCargaHoraria(8);

        Mentoria mentoriaJava = new Mentoria();
        mentoriaJava.setTitulo("Mentoria Java");
        mentoriaJava.setDescricao("Práticas avançadas com especialistas");
        mentoriaJava.setData(LocalDate.now());

        Curso cursoAvancado = new Curso();
        cursoAvancado.setTitulo("Curso Java Avançado");
        cursoAvancado.setDescricao("Explorando a API de Streams e Concorrência");
        cursoAvancado.setCargaHoraria(10);

// CONFIGURANDO OS PRÉ-REQUISITOS (Lógica nova)
// O curso avançado agora exige que a mentoria tenha sido concluída primeiro
        cursoAvancado.setPreRequisito(mentoriaJava);

// Configurando o Bootcamp
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição do Bootcamp");
        bootcamp.getConteudos().add(cursoJava);
        bootcamp.getConteudos().add(mentoriaJava);
        bootcamp.getConteudos().add(cursoAvancado);

// Criando o desenvolvedor e inscrevendo-o
        Dev devLeandro = new Dev();
        devLeandro.setNome("Leandro");
        devLeandro.inscreverBootcamp(bootcamp);

        System.out.println("Conteúdos Inscritos Leandro: " + devLeandro.getConteudosInscritos());

// TESTANDO A PROGRESSÃO
        System.out.println("\n--- Iniciando Progressão ---");

// 1. Deve concluir o Curso Java (sem pré-requisito)
        devLeandro.progredir();

// 2. Se tentar progredir e o sistema encontrar o "Curso Avançado" primeiro,
// a lógica do filter no Dev.java garantirá que ele pule para a Mentoria
// ou exiba erro se nada for compatível
        devLeandro.progredir();

// 3. Agora que a mentoria foi concluída, o Curso Avançado está liberado
        devLeandro.progredir();

        System.out.println("-");
        System.out.println("Conteúdos Concluídos Leandro: " + devLeandro.getConteudosConcluidos());
        System.out.println("XP Total: " + devLeandro.calcularTotalXp());
    }
}