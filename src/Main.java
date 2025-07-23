import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Console de Criação de Devs, Bootcamps, Mentorias e Cursos
        int option;
        System.out.println("Bootcamp DIO - Console de Criação");
        do{
            System.out.println("Selecione uma opção:");
            System.out.println("1. Criar Dev");
            System.out.println("2. Criar Bootcamp");
            System.out.println("3. Criar Mentoria");
            System.out.println("4. Criar Curso");
            System.out.println("5. Listar Devs");
            System.out.println("6. Entrar em um Bootcamp");
            System.out.println("7. Sair");

            option = sc.nextInt();
            sc.nextLine(); // Consumir a nova linha

            switch (option) {
                case 1 -> Create.createDev();
                case 2 -> Create.createBootcamp();
                case 3 -> Create.createMentoria();
                case 4 -> Create.createCurso();
                case 5 -> Create.listarDevs();
                case 6 -> {
                    System.out.println("Digite o nome do Dev:");
                    String devName = sc.nextLine();
                    Dev dev = Create.getDevByName(devName);
                    if (dev != null) {
                        System.out.println("Digite o nome do Bootcamp:");
                        String bootcampName = sc.nextLine();
                        Bootcamp bootcamp = Create.getBootcampByName(bootcampName);
                        if (bootcamp != null) {
                            dev.inscreverBootcamp(bootcamp);
                            System.out.println("Dev " + dev.getNome() + " inscrito no Bootcamp " + bootcamp.getNome() + ".");
                            System.out.println("Conteúdos disponíveis: " + bootcamp.getConteudos());
                        } else {
                            System.out.println("Bootcamp não encontrado.");
                        }
                    } else {
                        System.out.println("Dev não encontrado.");
                    }
                }
                case 7 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }


        }while (option != 7);


    }



}
