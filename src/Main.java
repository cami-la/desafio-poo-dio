import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // ===== Criando conteúdos =====
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JavaScript");
        curso2.setDescricao("Descrição curso JavaScript");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição mentoria Java");
        mentoria.setData(LocalDate.now());

        // ===== Criando bootcamp =====
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        // ===== Dev Camila =====
        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos (Camila): " + devCamila.getConteudosInscritos());

        devCamila.progredir();
        devCamila.progredir();

        System.out.println("Conteúdos Inscritos (Camila): " + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos (Camila): " + devCamila.getConteudosConcluidos());
        System.out.println("XP Total: " + devCamila.calcularTotalXp());

        // Tentativa de certificado
        Certificado certCamila = devCamila.gerarCertificado(bootcamp);
        if (certCamila != null) {
            System.out.println(certCamila);
        }

        System.out.println("====================================");

        // ===== Dev João =====
        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos (João): " + devJoao.getConteudosInscritos());

        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();

        System.out.println("Conteúdos Inscritos (João): " + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos (João): " + devJoao.getConteudosConcluidos());
        System.out.println("XP Total: " + devJoao.calcularTotalXp());

        // Tentativa de certificado
        Certificado certJoao = devJoao.gerarCertificado(bootcamp);
        if (certJoao != null) {
            System.out.println(certJoao);
        }
    }
}
