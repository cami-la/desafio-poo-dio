import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Create {
    static final Scanner SCANNER = new Scanner(System.in);
    static private ArrayList <Curso> cursos = new ArrayList<>();
    static private ArrayList <Mentoria> mentorias = new ArrayList<>();
    static private ArrayList <Dev> devs = new ArrayList<>();
    static private ArrayList <Bootcamp> bootcamps = new ArrayList<>();

    public static void createDev(){
        System.out.println("Digite o nome do Dev:");
        String devName = SCANNER.nextLine();
        Dev dev = new Dev(devName);
        devs.add(dev);
        System.out.println("Dev criado: " + dev.getNome());

    }
    public static void createBootcamp(){
        System.out.println("Digite o nome do Bootcamp:");
        String bootcampName = SCANNER.nextLine();
        System.out.println("Digite a descrição do Bootcamp:");
        String bootcampDescription = SCANNER.nextLine();
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome(bootcampName);
        bootcamp.setDescricao(bootcampDescription);

        //Add conteudos ao Bootcamp
        System.out.println("Adicione cursos ou mentorias ao Bootcamp (digite 'fim' para encerrar):");
        System.out.println("=".repeat(30));
        //Cursos
        for(Curso curso : cursos){
            System.out.println("#"+ cursos.lastIndexOf(curso) + " - Curso: " + curso.getTitulo() + " - Carga Horária: " + curso.getCargaHoraria() + " horas");
        } if (cursos.isEmpty()) {
            System.out.println("Nenhum curso disponível.");
        }
        System.out.println("=".repeat(30));
        System.out.println("Digite: ");
        String option = SCANNER.nextLine();
        if(option != null && !option.equalsIgnoreCase("fim")) {
            int index = Integer.parseInt(option);
            if (index >= 0 && index < cursos.size()) {
                bootcamp.getConteudos().add(cursos.get(index));
                System.out.println("Curso adicionado ao Bootcamp: " + cursos.get(index).getTitulo());
            } else {
                System.out.println("Índice inválido.");
            }

        }
        //Mentorias
        System.out.println("=".repeat(30));
        for(Mentoria mentoria : mentorias){
            System.out.println("#"+ mentorias.lastIndexOf(mentoria) + " - Mentoria: " + mentoria.getTitulo() + " - Data: " + mentoria.getData());
        } if (mentorias.isEmpty()) {
            System.out.println("Nenhuma mentoria disponível.");
        }
        System.out.println("=".repeat(30));
        System.out.println("Digite: ");
        option = SCANNER.nextLine();
        if(option != null && !option.equalsIgnoreCase("fim")) {
            int index = Integer.parseInt(option);
            if (index >= 0 && index < mentorias.size()) {
                bootcamp.getConteudos().add(mentorias.get(index));
                System.out.println("Mentoria adicionada ao Bootcamp: " + mentorias.get(index).getTitulo());
            } else {
                System.out.println("Índice inválido.");
            }
        }

        bootcamps.add(bootcamp);
        System.out.println("Bootcamp criado: " + bootcamp.getNome());
    }
    public static void createMentoria(){
        System.out.println("Digite o título da Mentoria:");
        String mentoriaTitle = SCANNER.nextLine();
        System.out.println("Digite a descrição da Mentoria:");
        String mentoriaDescription = SCANNER.nextLine();
        LocalDate mentoriaDate = LocalDate.now();

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo(mentoriaTitle);
        mentoria.setDescricao(mentoriaDescription);
        mentoria.setData(mentoriaDate);
        mentorias.add(mentoria);

        System.out.println("Mentoria criada: " + mentoria.getTitulo());
    }
    public static void createCurso(){
        System.out.println("Digite o título do Curso:");
        String cursoTitle = SCANNER.nextLine();
        System.out.println("Digite a descrição do Curso:");
        String cursoDescription = SCANNER.nextLine();
        System.out.println("Digite a carga horária do Curso (em horas):");
        int cargaHoraria = SCANNER.nextInt();
        SCANNER.nextLine();

        Curso curso = new Curso();
        curso.setTitulo(cursoTitle);
        curso.setDescricao(cursoDescription);
        curso.setCargaHoraria(cargaHoraria);
        cursos.add(curso);

        System.out.println("Curso criado: " + curso.getTitulo());
    }

    public static Dev getDevByName(String devName) {

        for (Dev dev : devs) {
            if (dev.getNome().equalsIgnoreCase(devName)) {
                return dev;
            }
        }
        return null;


    }

    public static Bootcamp getBootcampByName(String bootcampName) {
        for (Bootcamp bootcamp : bootcamps) {
            if (bootcamp.getNome().equalsIgnoreCase(bootcampName)) {
                return bootcamp;
            }
        }
        return null;
    }

    public static void listarDevs() {
        for(Dev dev : devs){
            System.out.println("Dev: " + dev.getNome());
            System.out.println("Conteúdos Inscritos: " + dev.getConteudosInscritos());
            System.out.println("Conteúdos Concluídos: " + dev.getConteudosConcluidos());
            System.out.println("Total XP: " + dev.calcularTotalXp());
            System.out.println("-".repeat(30));
        }
    }
}
