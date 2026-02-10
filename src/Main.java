import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=".repeat(80));
        System.out.println("🚀 DESAFIO POO - BOOTCAMP DIO");
        System.out.println("=".repeat(80));
        
        // Criando cursos
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java Básico");
        curso1.setDescricao("Aprenda os fundamentos de Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JavaScript");
        curso2.setDescricao("Domine JavaScript moderno");
        curso2.setCargaHoraria(4);

        Curso curso3 = new Curso();
        curso3.setTitulo("Curso Spring Boot");
        curso3.setDescricao("Desenvolva APIs REST com Spring Boot");
        curso3.setCargaHoraria(12);

        // Criando instrutor - DEMONSTRA HERANÇA E POLIMORFISMO
        Instrutor instrutor1 = new Instrutor("Camila Santos", "camila@dio.me", "Java Backend");
        
        // Criando mentoria
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria: Carreira em Java");
        mentoria.setDescricao("Orientações sobre carreira em desenvolvimento Java");
        mentoria.setData(LocalDate.now());
        
        // Instrutor ministra a mentoria - DEMONSTRA ENCAPSULAMENTO
        instrutor1.ministrarMentoria(mentoria);

        // Criando bootcamp - DEMONSTRA ABSTRAÇÃO
        System.out.println("\n📚 Criando Bootcamp...");
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Torne-se um desenvolvedor Java completo");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(curso3);
        bootcamp.getConteudos().add(mentoria);

        System.out.println("✅ Bootcamp criado: " + bootcamp.getNome());
        System.out.println("📖 Total de conteúdos: " + bootcamp.getConteudos().size());

        // DEV 1: Camila - DEMONSTRA TODOS OS PILARES DA POO
        System.out.println("\n" + "-".repeat(80));
        System.out.println("👩‍💻 DEV: CAMILA");
        System.out.println("-".repeat(80));
        
        Dev devCamila = new Dev("Camila", "camila.dev@email.com");
        devCamila.inscreverBootcamp(bootcamp);
        
        System.out.println("📋 Conteúdos Inscritos: " + devCamila.getConteudosInscritos().size());
        System.out.println("🎯 Nível Atual: " + devCamila.getNivelAtual());
        
        // Progredindo
        System.out.println("\n⏩ Progredindo nos estudos...");
        devCamila.progredir();
        devCamila.progredir();
        
        System.out.println("📋 Conteúdos Restantes: " + devCamila.getConteudosInscritos().size());
        System.out.println("✅ Conteúdos Concluídos: " + devCamila.getConteudosConcluidos().size());
        System.out.println("⭐ XP Total: " + devCamila.calcularTotalXp());
        System.out.println("🎯 Nível Atual: " + devCamila.getNivelAtual());

        // DEV 2: João - Completando todo o bootcamp
        System.out.println("\n" + "-".repeat(80));
        System.out.println("👨‍💻 DEV: JOÃO");
        System.out.println("-".repeat(80));
        
        Dev devJoao = new Dev("João", "joao.dev@email.com");
        devJoao.inscreverBootcamp(bootcamp);
        
        System.out.println("📋 Conteúdos Inscritos: " + devJoao.getConteudosInscritos().size());
        System.out.println("🎯 Nível Inicial: " + devJoao.getNivelAtual());
        
        // João completa TODOS os conteúdos
        System.out.println("\n⏩ Completando todos os conteúdos...");
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        
        System.out.println("📋 Conteúdos Restantes: " + devJoao.getConteudosInscritos().size());
        System.out.println("✅ Conteúdos Concluídos: " + devJoao.getConteudosConcluidos().size());
        System.out.println("⭐ XP Total: " + devJoao.calcularTotalXp());
        System.out.println("🎯 Nível Final: " + devJoao.getNivelAtual());
        
        // EMITINDO CERTIFICADO - DEMONSTRA ABSTRAÇÃO E ENCAPSULAMENTO
        System.out.println("\n🎓 Emitindo certificado...");
        devJoao.emitirCertificado(bootcamp);
        
        if (!devJoao.getCertificados().isEmpty()) {
            System.out.println("📜 Certificados de João: " + devJoao.getCertificados().size());
        }

        // DEV 3: Maria - Teste com diferentes níveis
        System.out.println("\n" + "-".repeat(80));
        System.out.println("👩‍💻 DEV: MARIA - DEMONSTRAÇÃO DE NÍVEIS");
        System.out.println("-".repeat(80));
        
        Dev devMaria = new Dev("Maria", "maria.dev@email.com");
        
        // Criando um bootcamp menor para Maria
        Bootcamp bootcampIniciante = new Bootcamp();
        bootcampIniciante.setNome("Bootcamp Iniciante");
        bootcampIniciante.setDescricao("Bootcamp para iniciantes");
        
        Curso cursoBasico = new Curso();
        cursoBasico.setTitulo("Lógica de Programação");
        cursoBasico.setDescricao("Fundamentos da programação");
        cursoBasico.setCargaHoraria(20);
        
        bootcampIniciante.getConteudos().add(cursoBasico);
        
        devMaria.inscreverBootcamp(bootcampIniciante);
        System.out.println("🎯 Nível Inicial Maria: " + devMaria.getNivelAtual());
        
        devMaria.progredir();
        System.out.println("⭐ XP após conclusão: " + devMaria.calcularTotalXp());
        System.out.println("🎯 Nível após curso: " + devMaria.getNivelAtual());
        
        // RESUMO FINAL - DEMONSTRA POLIMORFISMO
        System.out.println("\n" + "=".repeat(80));
        System.out.println("📊 RESUMO FINAL DO BOOTCAMP");
        System.out.println("=".repeat(80));
        System.out.println("\n👥 Instrutores:");
        System.out.println("   " + instrutor1);
        System.out.println("\n💻 Desenvolvedores:");
        System.out.println("   " + devCamila);
        System.out.println("   " + devJoao);
        System.out.println("   " + devMaria);
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("✅ PILARES DA POO DEMONSTRADOS:");
        System.out.println("=".repeat(80));
        System.out.println("🔹 ABSTRAÇÃO: Classes modelam conceitos reais (Bootcamp, Dev, Curso, etc)");
        System.out.println("🔹 ENCAPSULAMENTO: Atributos privados, validações, métodos controlados");
        System.out.println("🔹 HERANÇA: Dev e Instrutor herdam de Pessoa; Curso e Mentoria de Conteudo");
        System.out.println("🔹 POLIMORFISMO: calcularXp() implementado diferente em Curso e Mentoria");
        System.out.println("=".repeat(80));
    }
}
