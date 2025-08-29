package br.com.dio.desafio.dominio;


import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args){

//        Criação de 3 cursos
        Curso curso1 = new Curso();
        curso1.setTitulo("Java basico");
        curso1.setDescricao("Curso introdutorio de JAVA");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Heranca e polimorfismo");
        curso2.setDescricao("Curso intermediario de JAVA");
        curso2.setCargaHoraria(12);

        Curso curso3 = new Curso();
        curso3.setTitulo("Seguranca na nuvem");
        curso3.setDescricao("Curso intermediario 2 de JAVA");
        curso3.setCargaHoraria(5);

//        Criação de 1 mentoria fixa geral
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de JAVA");
        mentoria.setDescricao("Do basico ao avancado");
        mentoria.setData(LocalDate.now().plusDays(2));

//        Criação de 1 Bootcamp que entrega tudo
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("GFT Start #7 -Java");
        bootcamp.setDescricao("Bootcamp completo para iniciantes");

//        Adicionar os cursos e a mentoria ao único bootcamp:
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(curso3);
        bootcamp.getConteudos().add(mentoria);

//        Inserção da Dev
        Dev dev = new Dev();
        dev.setNome("YumiSuzana");
        dev.inscreverBootcamp(bootcamp);

//        cursos concluidoss da YumiSuzana
        Set<Conteudo> concluidosYS = new LinkedHashSet<>();
        concluidosYS.add(curso1);
        concluidosYS.add(curso2);
        dev.setConteudosConcluidos(concluidosYS);

//        cursos inscritos & mentoria da YumiSuzana:
        Set <Conteudo> inscritosYS = new LinkedHashSet<>();
        inscritosYS.add(curso1);
        inscritosYS.add(curso2);
        inscritosYS.add(curso3);
        inscritosYS.add(mentoria);
        dev.setConteudosInscritos(inscritosYS);

//        começar a imprimir as infos.....
        System.out.println("Dev: " + dev.getNome() + "\n \nCursos Inscritos: ");

        dev.getConteudosInscritos().forEach(c ->
                System.out.println("- " + c.getTitulo())
        );

        System.out.println("\nCursos ja concluidos: ");

        AtomicReference<Double> total = new AtomicReference<>(10d);

        dev.getConteudosConcluidos().forEach(c -> {
            System.out.println("- " + c.getTitulo());
            total.updateAndGet(v -> new Double((double) (v + c.calcularXp())));

        });

        System.out.println("\nTotal de XP até o momento: " + total + "\nContinue assim, " + dev.getNome() + "!");


    }

}
