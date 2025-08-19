package br.com.dio.desafio.service;

import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;
import java.util.*;

/**
 * Classe responsável por inicializar dados padrão do sistema
 */
public class DataService {
    
    private List<Curso> cursos;
    private List<Mentoria> mentorias;
    private List<Bootcamp> bootcamps;
    private List<Dev> devs;

    public void inicializarDados() {
        inicializarCursos();
        inicializarMentorias();
        inicializarBootcamps();
        inicializarDevs();

        assert cursos != null;
        assert mentorias != null;
        assert bootcamps != null;
        assert devs != null;

        System.out.println("   - " + cursos.size() + " cursos");
        System.out.println("   - " + mentorias.size() + " mentorias");
        System.out.println("   - " + bootcamps.size() + " bootcamps");
        System.out.println("   - " + devs.size() + " devs");
    }

    private void inicializarCursos() {
        cursos = new ArrayList<>();
        
        Curso java = new Curso();
        java.setTitulo("Java Básico");
        java.setDescricao("Aprenda os fundamentos da linguagem Java");
        java.setCargaHoraria(40);
        
        Curso spring = new Curso();
        spring.setTitulo("Spring Framework");
        spring.setDescricao("Framework para desenvolvimento Java");
        spring.setCargaHoraria(60);
        
        Curso javascript = new Curso();
        javascript.setTitulo("JavaScript Avançado");
        javascript.setDescricao("JavaScript moderno e suas funcionalidades");
        javascript.setCargaHoraria(35);
        
        Curso python = new Curso();
        python.setTitulo("Python para Iniciantes");
        python.setDescricao("Introdução à programação com Python");
        python.setCargaHoraria(30);
        
        Curso react = new Curso();
        react.setTitulo("React.js");
        react.setDescricao("Biblioteca para construção de interfaces");
        react.setCargaHoraria(45);

        cursos.addAll(Arrays.asList(java, spring, javascript, python, react));
    }

    private void inicializarMentorias() {
        mentorias = new ArrayList<>();
        
        Mentoria carreira = new Mentoria();
        carreira.setTitulo("Como construir uma carreira em tech");
        carreira.setDescricao("Dicas e estratégias para crescer na área de tecnologia");
        carreira.setData(LocalDate.now().plusDays(7));
        
        Mentoria algoritmos = new Mentoria();
        algoritmos.setTitulo("Algoritmos e Estruturas de Dados");
        algoritmos.setDescricao("Fundamentos essenciais para todo programador");
        algoritmos.setData(LocalDate.now().plusDays(14));
        
        Mentoria entrevista = new Mentoria();
        entrevista.setTitulo("Preparação para Entrevistas Técnicas");
        entrevista.setDescricao("Como se preparar para processos seletivos");
        entrevista.setData(LocalDate.now().plusDays(21));
        
        Mentoria arquitetura = new Mentoria();
        arquitetura.setTitulo("Arquitetura de Software");
        arquitetura.setDescricao("Padrões e boas práticas de arquitetura");
        arquitetura.setData(LocalDate.now().plusDays(28));

        mentorias.addAll(Arrays.asList(carreira, algoritmos, entrevista, arquitetura));
    }

    private void inicializarBootcamps() {
        bootcamps = new ArrayList<>();
        
        // Bootcamp Java
        Bootcamp bootcampJava = new Bootcamp();
        bootcampJava.setNome("Bootcamp Java Developer");
        bootcampJava.setDescricao("Formação completa em Java para desenvolvimento backend");
        Set<Conteudo> conteudosJava = new LinkedHashSet<>();
        conteudosJava.add(cursos.get(0)); // Java Básico
        conteudosJava.add(cursos.get(1)); // Spring Framework
        conteudosJava.add(mentorias.get(1)); // Algoritmos
        bootcampJava.setConteudos(conteudosJava);
        
        // Bootcamp Frontend
        Bootcamp bootcampFrontend = new Bootcamp();
        bootcampFrontend.setNome("Bootcamp Frontend React");
        bootcampFrontend.setDescricao("Desenvolvimento de interfaces modernas com React");
        Set<Conteudo> conteudosFrontend = new LinkedHashSet<>();
        conteudosFrontend.add(cursos.get(2)); // JavaScript Avançado
        conteudosFrontend.add(cursos.get(4)); // React.js
        conteudosFrontend.add(mentorias.get(2)); // Preparação para Entrevistas
        bootcampFrontend.setConteudos(conteudosFrontend);
        
        // Bootcamp Fullstack
        Bootcamp bootcampFullstack = new Bootcamp();
        bootcampFullstack.setNome("Bootcamp Fullstack Developer");
        bootcampFullstack.setDescricao("Formação completa para desenvolvedores fullstack");
        Set<Conteudo> conteudosFullstack = new LinkedHashSet<>();
        conteudosFullstack.add(cursos.get(0)); // Java Básico
        conteudosFullstack.add(cursos.get(2)); // JavaScript Avançado
        conteudosFullstack.add(cursos.get(4)); // React.js
        conteudosFullstack.add(mentorias.get(0)); // Como construir carreira
        conteudosFullstack.add(mentorias.get(3)); // Arquitetura de Software
        bootcampFullstack.setConteudos(conteudosFullstack);

        bootcamps.addAll(Arrays.asList(bootcampJava, bootcampFrontend, bootcampFullstack));
    }

    private void inicializarDevs() {
        devs = new ArrayList<>();

        Dev camila = new Dev("Camila", "camila@dev.br", "123");
        Dev joao = new Dev("João", "joao", "123");

        devs.addAll(Arrays.asList(camila, joao));
    }


    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    }


    public void adicionarMentoria(Mentoria mentoria) {
        mentorias.add(mentoria);
    }

    public void adicionarBootcamp(Bootcamp bootcamp) {
        bootcamps.add(bootcamp);
    }

    public void adicionarDev(Dev dev) {
        devs.add(dev);
    }

    // ==================== GETTERS ====================
    
    public List<Curso> getCursos() {
        return cursos;
    }

    public List<Mentoria> getMentorias() {
        return mentorias;
    }

    public List<Bootcamp> getBootcamps() {
        return bootcamps;
    }

    public List<Dev> getDevs() {
        return devs;
    }

    public Curso buscarCurso(int indice) {
        if (indice > 0 && indice <= cursos.size()) {
            return cursos.get(indice - 1);
        }
        return null;
    }

    public Mentoria buscarMentoria(int indice) {
        if (indice > 0 && indice <= mentorias.size()) {
            return mentorias.get(indice - 1);
        }
        return null;
    }

    public Bootcamp buscarBootcamp(int indice) {
        if (indice > 0 && indice <= bootcamps.size()) {
            return bootcamps.get(indice - 1);
        }
        return null;
    }

    public Dev buscarDev(int indice) {
        if (indice > 0 && indice <= devs.size()) {
            return devs.get(indice - 1);
        }
        return null;
    }

    public void listarDevsInscritosEmCursos() {
        System.out.println("=== DEVS INSCRITOS EM CURSOS ===");
        for (Dev dev : devs) {
            System.out.println(dev.getNome() + ":");
            dev.getConteudosInscritos().stream()
                .filter(conteudo -> conteudo instanceof Curso)
                .forEach(curso -> System.out.println("  - " + curso.getTitulo()));
        }
    }

    public void listarDevsInscritosEmMentorias() {
        System.out.println("=== DEVS INSCRITOS EM MENTORIAS ===");
        for (Dev dev : devs) {
            System.out.println(dev.getNome() + ":");
            dev.getConteudosInscritos().stream()
                .filter(conteudo -> conteudo instanceof Mentoria)
                .forEach(mentoria -> System.out.println("  - " + mentoria.getTitulo()));
        }
    }

    public void listarDevsInscritosEmBootcamps() {
        System.out.println("=== DEVS INSCRITOS EM BOOTCAMPS ===");
        for (Bootcamp bootcamp : bootcamps) {
            System.out.println(bootcamp.getNome() + ":");
            bootcamp.getDevsInscritos()
                .forEach(dev -> System.out.println("  - " + dev.getNome()));
        }
    }

    @Override
    public String toString() {
        return "{\n" +
                "    \"cursos\": " + cursos + "\n" +
                "    \"mentorias\": " + mentorias + "\n" +
                "    \"bootcamps\": " + bootcamps + "\n" +
                '}';
    }
}