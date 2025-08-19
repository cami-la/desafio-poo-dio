package br.com.dio.desafio.service;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Dev;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MenuService {
    Scanner scanner = new Scanner(System.in);
    DataService dataService = new DataService();

    private void mostrarMenuPrincipal() {
        System.out.println("-".repeat(30));
        System.out.println("Menu de opções:");
        System.out.println("1 - Entrar como Dev/Aluno");
        System.out.println("2 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void iniciarSistema() {
        System.out.println("BEM-VINDO À PLATAFORMA DE BOOTCAMPS DA DIO!");
        dataService.inicializarDados();

        while (true) {
            mostrarMenuPrincipal();
            try {
                int op = scanner.nextInt();

                switch (op) {
                    case 1:
                        menuInterativoDev();
                        break;
                    case 2:
                        fechar();
                        return;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }
            } catch (Exception e) {
                break;
            }
        }
    }

    private void menuInterativoDev() {
        Dev dev = login();
        if (dev == null) return;

        while (true) {
            mostrarMenuDev();
            try {
                int op = scanner.nextInt();
                switch (op) {
                    case 1:
                        verConteudosDisponiveis();
                        break;
                    case 2:
                        inscreverEmBootcamp(dev);
                        break;
                    case 3:
                        inscreverEmConteudo(dev);
                        break;
                    case 4:
                        desinscreverDeConteudo(dev);
                        break;
                    case 5:
                        dev.progredir();
                        mostrarProgressoXp(dev);
                        break;
                    case 6:
                        mostrarProgressoXp(dev);
                        break;
                    case 7:
                        mostrarInscricoes(dev);
                        break;
                    case 8:
                        dataService.listarDevsInscritosEmBootcamps();
                        break;
                    default:
                        return;
                }
            } catch (Exception e) {
                System.err.println("Entrada inválida! Voltando ao menu...");
                scanner.nextLine();
            }
        }
    }

    private void mostrarMenuDev() {
        System.out.println("-".repeat(50));
        System.out.println("=== MENU DEV ===");
        System.out.println("1 - Ver conteúdos disponíveis");
        System.out.println("2 - Inscrever-se em bootcamp");
        System.out.println("3 - Inscrever-se em conteúdo individual");
        System.out.println("4 - Desinscrever-se de conteúdo");
        System.out.println("5 - Progredir nos estudos");
        System.out.println("6 - Ver progresso e XP");
        System.out.println("7 - Minhas inscrições");
        System.out.println("8 - Ver devs inscritos em bootcamps");
        System.out.println("(qualquer outro número para sair)");
        System.out.print("Digite uma opção: ");
    }

    private void verConteudosDisponiveis() {
        System.out.println("-".repeat(30));
        System.out.println(dataService);
    }

    private void inscreverEmBootcamp(Dev dev) {
        System.out.println("-".repeat(30));
        List<Bootcamp> bootcamps = dataService.getBootcamps();
        int contador = 0;
        
        System.out.println("Bootcamps disponíveis:");
        for (Bootcamp bootcamp : bootcamps) {
            System.out.println((contador++) + " - " + bootcamp.getNome());
        }

        try {
            System.out.print("Qual bootcamp deseja se inscrever: ");
            int index = scanner.nextInt();

            if (index < 0 || index >= bootcamps.size()) {
                System.err.println("Opção inválida!");
                return;
            }

            dev.inscreverBootcamp(bootcamps.get(index));
        } catch (Exception e) {
            System.err.println("Erro: Digite apenas números!");
            scanner.nextLine();
        }
    }

    private void inscreverEmConteudo(Dev dev) {
        System.out.println("-".repeat(30));
        System.out.println("1 - Inscrever em curso");
        System.out.println("2 - Inscrever em mentoria");
        System.out.print("Escolha: ");
        
        try {
            int tipo = scanner.nextInt();
            if (tipo == 1) {
                mostrarEEscolherCurso(dev, true);
            } else if (tipo == 2) {
                mostrarEEscolherMentoria(dev, true);
            } else {
                System.err.println("Opção inválida!");
            }
        } catch (Exception e) {
            System.err.println("Erro: Digite apenas números!");
            scanner.nextLine();
        }
    }

    private void desinscreverDeConteudo(Dev dev) {
        System.out.println("-".repeat(30));
        System.out.println("1 - Desinscrever de curso");
        System.out.println("2 - Desinscrever de mentoria");
        System.out.print("Escolha: ");
        
        try {
            int tipo = scanner.nextInt();
            if (tipo == 1) {
                mostrarEEscolherCurso(dev, false);
            } else if (tipo == 2) {
                mostrarEEscolherMentoria(dev, false);
            } else {
                System.err.println("Opção inválida!");
            }
        } catch (Exception e) {
            System.err.println("Erro: Digite apenas números!");
            scanner.nextLine();
        }
    }

    private void mostrarEEscolherCurso(Dev dev, boolean inscrever) {
        var cursos = dataService.getCursos();
        System.out.println("Cursos disponíveis:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println((i + 1) + " - " + cursos.get(i).getTitulo());
        }
        
        try {
            System.out.print("Escolha o curso: ");
            int indice = scanner.nextInt() - 1;
            if (indice >= 0 && indice < cursos.size()) {
                if (inscrever) {
                    dev.inscreverConteudo(cursos.get(indice));
                } else {
                    dev.desinscreverConteudo(cursos.get(indice));
                }
            } else {
                System.err.println("Opção inválida!");
            }
        } catch (Exception e) {
            System.err.println("Erro: Digite apenas números!");
            scanner.nextLine();
        }
    }

    private void mostrarEEscolherMentoria(Dev dev, boolean inscrever) {
        var mentorias = dataService.getMentorias();
        System.out.println("Mentorias disponíveis:");
        for (int i = 0; i < mentorias.size(); i++) {
            System.out.println((i + 1) + " - " + mentorias.get(i).getTitulo());
        }
        
        try {
            System.out.print("Escolha a mentoria: ");
            int indice = scanner.nextInt() - 1;
            if (indice >= 0 && indice < mentorias.size()) {
                if (inscrever) {
                    dev.inscreverConteudo(mentorias.get(indice));
                } else {
                    dev.desinscreverConteudo(mentorias.get(indice));
                }
            } else {
                System.err.println("Opção inválida!");
            }
        } catch (Exception e) {
            System.err.println("Erro: Digite apenas números!");
            scanner.nextLine();
        }
    }

    private void mostrarProgressoXp(Dev dev) {
        System.out.println("-".repeat(30));
        System.out.println("XP Total: " + dev.calcularTotalXp());
        System.out.println("Conteúdos concluídos: " + dev.getConteudosConcluidos().size());
        System.out.println("Conteúdos restantes: " + dev.getConteudosInscritos().size());
    }

    private void mostrarInscricoes(Dev dev) {
        System.out.println("-".repeat(30));
        Set<Conteudo> conteudosInscritos = dev.getConteudosInscritos();
        Set<Conteudo> conteudosConcluidos = dev.getConteudosConcluidos();

        System.out.println(conteudosInscritos.isEmpty() 
            ? "Nenhuma inscrição ativa!" 
            : "=== INSCRIÇÕES ATIVAS ===\n" + conteudosInscritos);
            
        System.out.println(conteudosConcluidos.isEmpty() 
            ? "Nenhum conteúdo concluído!" 
            : "=== CONTEÚDOS CONCLUÍDOS ===\n" + conteudosConcluidos);
    }
    private Dev login() {
        System.out.println("-".repeat(5));
        System.out.print("email: ");
        String email = scanner.next();
        System.out.print("senha: ");
        String senha = scanner.next();

        List<Dev> devs = dataService.getDevs();

        if (devs == null || devs.isEmpty()) {
            System.out.println("Nenhum dev foi encontrado!");
            return null;
        }

        for (Dev dev : devs) {
            if (dev.getEmail().equals(email) && dev.getSenha().equals(senha)) {
                System.out.println("-".repeat(30));
                System.out.println("Login realizado com sucesso!");
                return dev;
            }
        }

        System.out.println("Email ou senha inválidas!");
        return null;
    }

    public void fechar() {
        System.out.println("Obrigado por usar a plataforma DIO!");
        scanner.close();
    }
}
