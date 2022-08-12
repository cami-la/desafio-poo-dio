import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import br.com.dio.desafio.dominio.ProjetoPratico;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        //dados de Dev
        String nome;

        //Cadastrando curso
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descricao Curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso Spring Framework");
        curso2.setDescricao("Descricao Curso Spring");
        curso2.setCargaHoraria(4);

        //Cadastrando mentoria
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descricao Mentoria Java");
        mentoria.setData(LocalDate.now());

        //Cadastrando Projeto
        ProjetoPratico projeto = new ProjetoPratico();
        projeto.setTitulo("Projeto Prático de Java");
        projeto.setDescricao("Descricao do Projeto Java");
        projeto.setNivelDificuldade(3);

        //Inicializando um bootcamp
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descricao Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);
        bootcamp.getConteudos().add(projeto);

        //Usuario Dev e opcoes
        Dev dev1 = new Dev();
        System.out.println("Nome:");
        nome = leitor.next();
        dev1.setNome(nome);
        dev1.inscreverBootcamp(bootcamp);
        int op;
        {
            System.out.println("O que quer fazer "+ dev1.getNome()+"?");
            System.out.println("Digite: \n1- Visualizar Conteudos a Fazer");
            System.out.println("2- Progredir no Bootcamp \n3- Visualizar Conteudos Concluidos");
            System.out.println("4- Pontos de Experiencias (XP) \n5- Emitir Certificado do Bootcamp");
            System.out.println("0- Sair");
            op = leitor.nextInt();
            switch (op){
                case 1:
                    dev1.conteudosInscritos();
                case 2:
                    dev1.progredir();
                case 3:
                    dev1.conteudosConcluidos();
                case 4:
                    System.out.println("XP:" + dev1.calcularTotalXp());
                case 5:
                    dev1.emitirCertificado();
                default:
                    break;
            }
        }while (op != 0)

        leitor.close();
    }
}
