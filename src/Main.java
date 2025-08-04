import br.com.dio.desafio.dominio.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Aprenda os fundamentos de Java.");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JavaScript");
        curso2.setDescricao("Aprenda os fundamentos de JavaScript.");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Carreira");
        mentoria.setDescricao("Tire suas dúvidas sobre o mercado de trabalho.");
        mentoria.setData(LocalDateTime.now().plusDays(1)); 

        DesafioDeCodigo desafio = new DesafioDeCodigo();
        desafio.setTitulo("Desafio de Lógica");
        desafio.setDescricao("Resolva um desafio de ordenação de arrays.");
        desafio.setNivel(NivelDificuldade.MEDIO);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("O bootcamp definitivo para se tornar um desenvolvedor Java.");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);
        bootcamp.getConteudos().add(desafio);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);

        System.out.println(">>> INICIANDO BOOTCAMP PARA OS DEVS <<<");
        Thread threadCamila = new Thread(new ProgressoDev(devCamila));
        Thread threadJoao = new Thread(new ProgressoDev(devJoao));

        threadCamila.start();
        threadJoao.start();

        threadCamila.join();
        threadJoao.join();
        System.out.println(">>> BOOTCAMP FINALIZADO <<<");
        System.out.println("------------------------------------");

        System.out.println("Resultados para " + devCamila.getNome() + ":");
        System.out.println("Conteúdos Concluídos: " + devCamila.getConteudosConcluidos());
        System.out.println("XP Total: " + devCamila.calcularTotalXp());
        
        devCamila.avaliarConteudo(curso1, 9.5);
        System.out.println("Notas de Camila: " + devCamila.getNotas());
        
        System.out.println("------------------------------------");

        System.out.println("Resultados para " + devJoao.getNome() + ":");
        System.out.println("Conteúdos Concluídos: " + devJoao.getConteudosConcluidos());
        System.out.println("XP Total: " + devJoao.calcularTotalXp());

        devJoao.avaliarConteudo(desafio, 8.0);
        System.out.println("Notas de Joao: " + devJoao.getNotas());
    }
}