import br.com.dio.desafio.dominio.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Set<Curso> cursos = new HashSet<>();
    static Set<Mentoria> mentorias = new HashSet<>();
    static List<Bootcamp> bootcamps = new ArrayList<>();
    static Map<String, Dev> devs = new HashMap<>();

    public static void criarCurso() {
        Curso curso = new Curso();
        System.out.print("Título: ");
        curso.setTitulo(sc.nextLine());
        System.out.print("Descrição: ");
        curso.setDescricao(sc.nextLine());
        System.out.print("Carga horária: ");
        curso.setCargaHoraria(sc.nextInt());
        sc.nextLine();
        cursos.add(curso);
        System.out.println("Curso criado!");
    }

    public static void criarMentoria() {
        Mentoria mentoria = new Mentoria();
        System.out.print("Título: ");
        mentoria.setTitulo(sc.nextLine());
        System.out.print("Descrição: ");
        mentoria.setDescricao(sc.nextLine());
        mentoria.setData(LocalDate.now());
        mentorias.add(mentoria);
        System.out.println("Mentoria criada!");
    }

    public static void criarBootcamp() {
        Bootcamp bootcamp = new Bootcamp();
        System.out.print("Nome: ");
        bootcamp.setNome(sc.nextLine());
        System.out.print("Descrição: ");
        bootcamp.setDescricao(sc.nextLine());

        bootcamp.getConteudos().addAll(cursos);
        bootcamp.getConteudos().addAll(mentorias);

        bootcamps.add(bootcamp);
        System.out.println("Bootcamp criado!");
    }

    public static void cadastrarDev() {
        System.out.print("Nome do Dev: ");
        String nome = sc.nextLine();
        Dev dev = new Dev();
        dev.setNome(nome);

        if (bootcamps.isEmpty()) {
            System.out.println("Nenhum bootcamp disponível!");
        } else {
            System.out.println("Escolha um bootcamp para inscrever:");
            for (int i = 0; i < bootcamps.size(); i++) {
                System.out.println((i+1) + " - " + bootcamps.get(i).getNome());
            }
            int idx = sc.nextInt()-1;
            sc.nextLine();
            if (idx >= 0 && idx < bootcamps.size()) {
                dev.inscreverBootcamp(bootcamps.get(idx));
                System.out.println("Dev inscrito!");
            }
        }
        devs.put(nome, dev);
    }

    public static void verificarDev() {
        System.out.print("Nome do Dev: ");
        String nome = sc.nextLine();
        Dev dev = devs.get(nome);
        if (dev != null) {
            System.out.println("Inscritos: " + dev.getConteudosInscritos());
            System.out.println("Concluídos: " + dev.getConteudosConcluidos());
        } else {
            System.out.println("Dev não encontrado!");
        }
    }

    public static void progredirDev() {
        System.out.print("Nome do Dev: ");
        String nome = sc.nextLine();
        Dev dev = devs.get(nome);
        if (dev != null) {
            dev.progredir();
            System.out.println("Dev progrediu!");
        } else {
            System.out.println("Dev não encontrado!");
        }
    }

    public static void verificarXP() {
        System.out.print("Nome do Dev: ");
        String nome = sc.nextLine();
        Dev dev = devs.get(nome);
        if (dev != null) {
            System.out.println("XP total: " + dev.calcularTotalXp());
        } else {
            System.out.println("Dev não encontrado!");
        }
    }

    // ===== MENU PRINCIPAL =====
    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Criar Curso");
            System.out.println("2 - Criar Mentoria");
            System.out.println("3 - Criar Bootcamp");
            System.out.println("4 - Cadastrar Dev");
            System.out.println("5 - Verificar conteúdos de Dev");
            System.out.println("6 - Progredir Dev");
            System.out.println("7 - Verificar XP de Dev");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> criarCurso();
                case 2 -> criarMentoria();
                case 3 -> criarBootcamp();
                case 4 -> cadastrarDev();
                case 5 -> verificarDev();
                case 6 -> progredirDev();
                case 7 -> verificarXP();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida!");
            }
        } while (true);
    }
}
