
import br.com.dio.desafio.dominio.*;
import br.com.dio.desafio.repositories.BootcampRepository;
import br.com.dio.desafio.views.MainPage;

import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {

        // Persistindo um primeiro bootcamp na memória
        Curso conteudo = new Curso();
        conteudo.setTitulo("Curso Java Dio");
        conteudo.setDescricao("Java iniciante");
        conteudo.setCargaHoraria(2);

        Mentoria conteudo2 = new Mentoria();

        conteudo2.setTitulo("Mentoria Java");
        conteudo2.setDescricao("Java DIO mentoria 1");
        conteudo2.setData(LocalDate.now().minusDays(15));

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Java start DIO");
        bootcamp.setDescricao("Iniciando em Java com a DIO");
        bootcamp.getConteudos().add(conteudo);
        bootcamp.getConteudos().add(conteudo2);

        BootcampRepository.save(bootcamp);

        MainPage mainPage = new MainPage();
        mainPage.mainPage();

    }

}
