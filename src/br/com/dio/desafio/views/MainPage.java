package br.com.dio.desafio.views;

import br.com.dio.desafio.services.BootcampService;
import br.com.dio.desafio.services.DevService;

import java.util.Scanner;

public class MainPage {

    private Scanner scan = new Scanner(System.in);

    private BootcampView bootcampView = new BootcampView();
    private DevView devView = new DevView();

    BootcampService bootcampService = new BootcampService();
    DevService devService = new DevService();

    public void mainPage(){

        boolean status = true;

        while(status){
            System.out.println("\n\n===== SISTEMA DE GERENCIAMENTO DE BOOTCAMP =====");

            System.err.println("\nEsse é um projeto desenvolvido para desafio de projeto DIO"
                    + "\nAbstraindo um Bootcamp Usando Orientação a Objetos em Java");

            System.out.println("\nBootcamps cadastrados: " + bootcampService.findAll().size());
            System.out.println("Devs cadastrador: " + devService.findAll().size());

            System.out.println("\n----- Selecione uma opção -----");
            System.out.println("[1] Gerenciar Bootcamps");
            System.out.println("[2] Gerenciar Devs");
            System.out.println("[S] Sair");


            String opc = scan.nextLine().toUpperCase();

            switch (opc){
                case "1" :
                    bootcampView.inicialPage();
                    break;
                case "2" :
                    devView.inicialView();
                    break;
                case "S" :
                    status = false;
                    break;

                default:
                    System.err.println("Selecione uma opção válida");
                    mainPage();
            }
        }


    }
}
