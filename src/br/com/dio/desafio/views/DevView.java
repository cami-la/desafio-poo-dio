package br.com.dio.desafio.views;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.services.BootcampService;
import br.com.dio.desafio.services.DevService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DevView {

    private Scanner scan = new Scanner(System.in);
    private DevService devService = new DevService();
    private BootcampService bootcampService = new BootcampService();


    public void inicialView(){

        System.out.println("===== Dev =====");
        System.out.println("Selecione uma opção:");
        System.out.println("[1] Listar Devs cadastrados");
        System.out.println("[2] Buscar por ID");
        System.out.println("[3] Cadastrar novo");
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

            default :
                System.err.println("Selecione uma das opções válidas!");
                inicialView();
        }

    }


    private void getAll(){
        ArrayList<Dev>  devs = devService.findAll();

        if(devs.isEmpty()){
            System.err.println("Não há Devs cadastrados!");

        }else{
            System.out.println("===== Devs Cadastrados =====");
            for (Dev d : devs) {
                System.out.println(d);
            }
        }

        inicialView();
    }

    private void getById(){

        System.out.println("===== Buscar Dev =====");
        System.out.println("Digite o ID: ");

        try {
            int id = scan.nextInt();
            scan.nextLine(); // limpa o buffer

            Dev dev = devService.findById(id);

            System.out.print("ID: ");
            System.out.println(dev.getId());
            System.out.print("Nome: ");
            System.out.println(dev.getNome());
            System.out.print("XP: ");
            System.out.println(devService.calculateXP(dev.getId()));

            if(!dev.getConteudosInscritos().isEmpty()){
                System.out.println("  ---Inscrições---");
                for(Conteudo c : dev.getConteudosInscritos()){
                    System.out.println("   - " + c.getTitulo());
                }
            }else {
                System.out.println("Não está cadastrado em nenhum conteúdo");
            }

            if(!dev.getConteudosConcluidos().isEmpty()){
                System.out.println("  ---Concluídos---");
                for(Conteudo c : dev.getConteudosConcluidos()){
                    System.out.println("   - " + c.getTitulo());
                }
            }else{
                System.out.println("Ainda nao concluiu nenhum conteúdo");
            }

            devOptions(dev);


        } catch (InputMismatchException e) {
            System.err.println("O ID deve ser um número");
            inicialView();
        }
        catch (Exception e ){
            System.err.println(e.getMessage());
            inicialView();
        }

    }

    private void create(){
        String opc;
        System.out.println("===== Novo Dev =====");
        System.out.println("Digite o nome:");
        opc = scan.nextLine();

        Dev dev = new Dev();
        dev.setNome(opc);

        try {
            dev = devService.newDev(dev);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Dev cadastrado com sucesso!");
        System.out.println(dev);
        inicialView();

    }

    private void devOptions(Dev dev){

        System.out.println("----------------------");
        System.out.println("Selecione uma opção");
        System.out.println("[1] Cadastrar em um Bootcamp");
        System.out.println("[2] Avançar conteúdo"); // simula o avanço dos cursos
        System.out.println("[3] Deletar Dev");
        System.out.println("[S] Voltar");

        String opc = scan.nextLine().toUpperCase();

        switch (opc){
            case "1" :
                subscribe(dev);
                break;
            case "2" :
                progress(dev);
                break;
            case "3" :
                delete();
            case "S" :
                inicialView();

            default :
                System.err.println("Selecione uma das opções válidas!");
                devOptions(dev);
        }

    }

    private void progress(Dev dev){
        try {
            devService.progress(dev.getId());

        } catch (Exception e) {
            System.err.println(e.getMessage());
            devOptions(dev);
        }

        System.out.println("Progresso realizado com sucesso!");
        inicialView();

    }

    private void delete(){

        System.out.println("Confirme o ID para deletar: ");

        int id = scan.nextInt();
        scan.nextLine();

        if(devService.deleteById(id)) {
            System.out.println("Dev removido com sucesso");
        }

        inicialView();
    }

    private void subscribe(Dev dev){

        List<Bootcamp> bootcamps = bootcampService.findAll();

        if(bootcamps.isEmpty()){
            System.err.println("Não há Bootcamps para se inscrever");
            inicialView();
        }

        System.out.println("===== Bootcamps =====");
        for(Bootcamp b : bootcamps){
            System.out.println(b.getId() + " - " + b.getNome() + " Desc: " + b.getDescricao());
        }

        System.out.println("Selecione um bootcamp: ");
        int id = scan.nextInt();
        scan.nextLine();

        try {
            devService.subscribeBootcamp(dev.getId(), id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            inicialView();
        }

        System.out.println("Inscrição realizada com sucesso!");
        inicialView();

    }
}
