import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Curso c = new Curso("Java", 20, "Curso de java");
        System.out.println(c);
        Mentoria m = new Mentoria("Atributs", "shdkash", LocalDate.of(2020, 1, 1));
        System.out.println(m);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Java");
        bootcamp.setDescricao("Curso de java");
        bootcamp.setDataInicio(LocalDate.of(2020, 1, 1));
        bootcamp.getConteudos().add(m);
        bootcamp.getConteudos().add(c);

        Dev dev = new Dev();
        dev.setNome("João");
        dev.inscreverBootcamp(bootcamp);
        System.out.println(dev.getConteudoInscritos());
        System.out.println(dev.calcularTotalXP());
        System.out.println(dev.getConteudosConcluidos());
        dev.progredir();
        System.out.println(dev.getConteudosConcluidos());
        System.out.println(dev.getConteudoInscritos());
        System.out.println(dev.calcularTotalXP());

    }
}
