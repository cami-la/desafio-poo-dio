import java.time.LocalDate;
import java.util.NoSuchElementException;

import br.com.challenge.Bootcamp;
import br.com.challenge.Course;
import br.com.challenge.Developer;
import br.com.challenge.Mentorship;

public class Main {
    public static void main(String[] args) {
        Course course1 = new Course("Curso Java", "Descrição curso Java", 8);
        Course course2 = new Course("Curso Js", "Descrição curso Js", 4);

        Mentorship mentorship = new Mentorship("Mentoria Java", "Descrição mentoria Java", LocalDate.now());

        Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer");
        bootcamp.getContent().add(course1);
        bootcamp.getContent().add(course2);
        bootcamp.getContent().add(mentorship);

        Developer devDiego = new Developer("Diego");
        devDiego.signUp(bootcamp);
        System.out.println("Conteúdos Inscritos Diego:" + devDiego.getSubscribedContents());

        try {
            devDiego.makeProgress();
            devDiego.makeProgress();
        } catch (NoSuchElementException e) {
            System.out.println("You are not enrolled in any content!");
        }

        System.out.println("-");
        System.out.println("Conteúdos Inscritos Diego:" + devDiego.getSubscribedContents());
        System.out.println("Conteúdos Concluídos Diego:" + devDiego.getCompletedContents());
        System.out.println("XP:" + devDiego.computeTotalXp());

        System.out.println("-------");

        Developer devRafoca = new Developer("Rafoca");
        devRafoca.signUp(bootcamp);
        System.out.println("Conteúdos Inscritos Rafoca:" + devRafoca.getSubscribedContents());

        try {
            devRafoca.makeProgress();
            devRafoca.makeProgress();
            devRafoca.makeProgress();
        } catch (NoSuchElementException e) {
            System.out.println("You are not enrolled in any content!");
        }

        System.out.println("-");
        System.out.println("Conteúdos Inscritos Rafoca:" + devRafoca.getSubscribedContents());
        System.out.println("Conteúdos Concluidos Rafoca:" + devRafoca.getCompletedContents());
        System.out.println("XP:" + devRafoca.computeTotalXp());

    }

}
