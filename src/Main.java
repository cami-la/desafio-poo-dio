import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando conteúdos
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

        // Criando Dev
        Dev dev = new Dev();

        int opcao;

        do {
            System.out.printf("===== MENU =====\n");
            System.out.println("1 - Criar Dev");
            System.out.println("2 - Inscrever no Bootcamp");
            System.out.println("3 - Progredir");
            System.out.println("4 - Ver conteúdos inscritos");
            System.out.println("5 - Ver conteúdos concluídos");
            System.out.println("6 - Ver XP");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o nome do Dev: ");
                    String nome = scanner.nextLine();
                    dev.setNome(nome);
                    System.out.println("Dev criado com sucesso!");
                }

                case 2 -> {
                    if (dev.getNome() == null) {
                        System.out.println("Crie um Dev primeiro!");
                    } else {
                        dev.inscreverBootcamp(bootcamp);
                        System.out.println("Inscrito no bootcamp!");
                    }
                }

                case 3 -> {
                    if (dev.getNome() == null) {
                        System.out.println("Crie um Dev primeiro!");
                    } else if (dev.getConteudosInscritos().isEmpty()) {
                        System.out.println("Nenhum conteúdo para progredir!");
                    } else {
                        dev.progredir();
                        System.out.println("Progresso realizado!");
                    }
                }

                case 4 -> {
                    if (dev.getConteudosInscritos().isEmpty()) {
                    System.out.println("Nenhum conteúdo inscrito.");
                     } else {
                    System.out.println(dev.getConteudosInscritos());
                    }
                }


                case 5 -> {
                    if (dev.getNome() == null) {
                        System.out.println("Crie um Dev primeiro!");
                    } else {
                        System.out.println("Conteúdos concluídos: " + dev.getConteudosConcluidos());
                    }
                }

                case 6 ->{
                    if (dev.getNome() == null) {
                        System.out.println("Crie um Dev primeiro!");
                    } else {
                        System.out.println("XP total: " + dev.calcularTotalXp());
                    }
                }

                case 0 -> System.out.println("Saindo...");

                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

    }
}