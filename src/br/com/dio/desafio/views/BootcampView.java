package br.com.dio.desafio.views;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Mentoria;
import br.com.dio.desafio.services.BootcampService;

import java.util.List;
import java.util.Scanner;

public class BootcampView {

    private BootcampService bootcampService = new BootcampService();
    private Scanner scan = new Scanner(System.in);

    boolean status = true;

    public void inicialPage(){

        System.out.println("\n===== Bootcamp =====");
        System.out.println("Selecione uma opção:");
        System.out.println("[1] Listar Bootcamps");
        System.out.println("[2] Buscar Bootcamp");
        System.out.println("[3] Cadastrar Bootcamp");
        System.out.println("[S] Voltar");

        String opc = scan.nextLine().toUpperCase();

        switch (opc){

            case "1" :
                getAll();
                break;
            case "2" :
                getById();
                break;
            case "3" :
                create();
                break;
            case "S" :
                return;
            default:
                System.out.println("Selecione uma opção válida");
                inicialPage();
        }

    }

    private void getAll(){

        List<Bootcamp> bootcamps = bootcampService.findAll();

        if(bootcamps.isEmpty()){
            System.err.println("Não há bootcamps cadastrados");
            inicialPage();
        }

        System.out.println("\n===== Bootcamps =====");
        for(Bootcamp b : bootcamps){
            System.out.println(b.getId()
                    + " - " + b.getNome()
                    + " -  Iniciado em: " + b.getDataInicial().toString()
                    + " - Finaliza em: " + b.getDataFinal().toString());
        }

        inicialPage();

    }

    private void getById(){

        System.out.println("\n===== Buscar Bootcamp =====");
        System.out.println("Digite o ID: ");
        int id = scan.nextInt();
        scan.nextLine();

        try {

            Bootcamp bootcamp = bootcampService.findById(id);

            System.out.print("ID: ");
            System.out.println(bootcamp.getId());
            System.out.print("Nome: ");
            System.out.println(bootcamp.getNome());
            System.out.print("Descrição: ");
            System.out.println(bootcamp.getDescricao());
            System.out.print("Iniciado em: ");
            System.out.println(bootcamp.getDataInicial());
            System.out.print("Finaliza em: ");
            System.out.println(bootcamp.getDataFinal());
            System.out.print("Devs inscritos: ");
            System.out.println(bootcamp.getDevsInscritos().size());

            System.out.println("\n----- Conteúdos -----");
            for(Conteudo c : bootcamp.getConteudos()){
                System.out.println(c.getTitulo() + " - " + c.getDescricao());
            }

            bootcampOptions(bootcamp);

        }catch (Exception e) {
            System.err.println(e.getMessage());
        }

        inicialPage();
    }

    private void create(){

        Bootcamp newBootcamp = new Bootcamp();

        System.out.println("===== Cadastrar novo Bootcamp");
        System.out.println("Nome: ");
        newBootcamp.setNome(scan.nextLine());
        System.out.println("Descrição: ");
        newBootcamp.setDescricao(scan.nextLine());
        System.out.println("Descrição: ");

        String opc = "";
        this.status = true;
        while(status){

            System.out.println("\n----- Adicionar novo conteúdo -----");
            System.out.println("Selecione o tipo de conteúdo: ");
            System.out.println("[1] Curso");
            System.out.println("[2] Mentoria");
            System.out.println("[S] Voltar");

            opc = scan.nextLine().toUpperCase();

            switch (opc){
                case "1" :

                    Conteudo curso = new Curso();
                    System.out.println("\n----- Novo Curso -----");
                    System.out.println("Título do curso: ");
                    curso.setTitulo(scan.nextLine());
                    System.out.println("Descrição do curso: ");
                    curso.setDescricao(scan.nextLine());

                    newBootcamp.getConteudos().add(curso);
                    break;

                case "2" :

                    Conteudo mentoria = new Mentoria();
                    System.out.println("\n----- Nova mentoria -----");
                    System.out.println("Título da mentoria: ");
                    mentoria.setTitulo(scan.nextLine());
                    System.out.println("Descrição da mentoria: ");
                    mentoria.setDescricao(scan.nextLine());

                    newBootcamp.getConteudos().add(mentoria);
                    break;

                case "S" :
                    this.status = false;
                    break;

                default :
                    System.err.println("Selecione uma das opções válidas!");

            }

        }

        try {
            bootcampService.newBootcamp(newBootcamp);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            create();
        }

        System.out.println("\n Bootcamp cadastrado com sucesso!");
        inicialPage();

    }

    private void bootcampOptions( Bootcamp b){

        System.out.println("\n----------------------");
        System.out.println("Selecione uma opção");
        System.out.println("[1] Deletar Bootcamp");
        System.out.println("[S] Voltar");

        String opc = scan.nextLine().toUpperCase();

        switch (opc){
            case "1" :

                System.out.println("Digite o ID para confirmar a remoção:");
                int id = scan.nextInt();
                scan.nextLine();

                if(id != b.getId()){
                    System.err.println("O ID informado não corresponde a esse Bootcamp");
                    bootcampOptions(b);
                }

                if(bootcampService.deleteById(id)){
                    System.out.println("\nBootcamp removido com sucesso");
                    inicialPage();
                }
                break;

            case "S" :
                inicialPage();

            default :
                System.err.println("Selecione uma das opções válidas!");
                bootcampOptions(b);
        }
    }


}
