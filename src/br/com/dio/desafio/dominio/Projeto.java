package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Projeto extends Conteudo{

    private String dificuldade;
    private LocalDate prazoEntrega;

    @Override
    public double calcularXp() {
        switch (dificuldade.toLowerCase()){
            case "dificil": return XP_PADRAO * 3;
            case  "médio": return XP_PADRAO * 2;
            default:
                return XP_PADRAO;
        }
    }

    @Override
    public String Projeto() {
        return "";
    }

    public String getDificuldade(){
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public LocalDate getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(LocalDate prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", dificuldade='" + dificuldade + '\'' +
                ", prazoEntrega=" + prazoEntrega +
                '}';
    }
}