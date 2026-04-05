package br.com.dio.desafio.dominio.Intermediaria;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.*;

public class MentoriaService  {

    private Bootcamp bootcamp;
    private Set<Mentoria> mentorias = new LinkedHashSet<>();

    public MentoriaService(Bootcamp bootcamp) {
        this.bootcamp = bootcamp;
    }

    public Mentoria CriarMentoria(String titulo, String descricao){
        Mentoria m = new Mentoria();

        m.setTitulo(titulo);
        m.setDescricao(descricao);
        m.setData(LocalDate.now());

        mentorias.add(m);
        return m;
    }

    public void SalvarBootCamps(){
        bootcamp.getConteudos().addAll(mentorias);
    }

    public Set<Mentoria> ListarMentorias(){
        Set mentor = mentorias;
        return mentor;
    }


}
