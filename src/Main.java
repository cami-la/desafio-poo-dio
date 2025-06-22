import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Course;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoring;

public class Main {

  public static void main(String[] args) {
    Bootcamp bootcamp = new Bootcamp();
    bootcamp.setName("Bootcamp Java Developer");
    bootcamp.setDescription("Aprenda Java do zero ao avançado com este bootcamp incrível!");
    bootcamp.getContents().add(new Course("Curso de Java Básico", "Aprenda os fundamentos do Java", 8));
    bootcamp.getContents().add(new Mentoring("Mentoria de Java Básico", "Dicas e truques para deixar o código mais limpo", LocalDate.now()));

    Bootcamp bootcamp2 = new Bootcamp();
    bootcamp2.setName("Bootcamp Python Developer");
    bootcamp2.setDescription("Aprenda Python do zero ao avançado com este bootcamp incrível!");
    bootcamp2.getContents().add(new Course("Curso de Python Básico", "Aprenda os fundamentos do Python", 6));
    bootcamp2.getContents().add(new Mentoring("Mentoria de Python Avançado", "Dicas e truques para dominar Python", LocalDate.now()));

    Dev dev1 = new Dev("Alice");
        dev1.subscribeBootcamp(bootcamp);
        System.out.println("\n=== Conteúdos inscritos por " + dev1.getName() + " ===");
        dev1.getSubscribedContents().forEach(content -> System.out.println("- " + content));

        System.out.println("\n------ Progredindo no bootcamp ------\n");
        dev1.progress();
        dev1.progress(); 
        
        System.out.println("\n=== Conteúdos inscritos por " + dev1.getName() + " ===");
        System.out.println("");
        dev1.getSubscribedContents().forEach(content -> System.out.println("- " + content));
        System.out.println("=== Conteúdos concluídos por " + dev1.getName() + " ===");
        dev1.getCompletedContents().forEach(content -> System.out.println("- " + content)); // For each para facilitar a leitura

        System.out.println("\n------ Calculando o XP ------\n");
        System.out.println("XP total de " + dev1.getName() + ": " + dev1.calculateTotalXP());



        Dev dev2 = new Dev("Bob");
        dev2.subscribeBootcamp(bootcamp2);
        System.out.println("\n=== Conteúdos inscritos por " + dev2.getName() + " ===");
        dev2.getSubscribedContents().forEach(content -> System.out.println("- " + content));

        System.out.println("\n------ Progredindo no bootcamp ------\n");
        dev2.progress();

        System.out.println("\n=== Conteúdos inscritos por " + dev2.getName() + " ===");
        dev2.getSubscribedContents().forEach(content -> System.out.println("- " + content));
        System.out.println("");
        System.out.println("=== Conteúdos concluídos por " + dev2.getName() + " ===");
        dev2.getCompletedContents().forEach(content -> System.out.println("- " + content));

        System.out.println("\n------ Calculando o XP ------\n");
        System.out.println("XP total de " + dev2.getName() + ": " + dev2.calculateTotalXP());
  }
}
