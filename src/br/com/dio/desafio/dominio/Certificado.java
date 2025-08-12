package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Certificado {
    private String nomeDev;
    private String nomeBootcamp;
    private LocalDate dataConclusao;
    private double totalXp;

    public Certificado(String nomeDev, String nomeBootcamp, LocalDate dataConclusao, double totalXp) {
        this.nomeDev = nomeDev;
        this.nomeBootcamp = nomeBootcamp;
        this.dataConclusao = dataConclusao;
        this.totalXp = totalXp;
    }

    public Certificado() {
    }

    public String getNomeDev() {
        return nomeDev;
    }

    public void setNomeDev(String nomeDev) {
        this.nomeDev = nomeDev;
    }

    public String getNomeBootcamp() {
        return nomeBootcamp;
    }

    public void setNomeBootcamp(String nomeBootcamp) {
        this.nomeBootcamp = nomeBootcamp;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public double getTotalXp() {
        return totalXp;
    }

    public void setTotalXp(double totalXp) {
        this.totalXp = totalXp;
    }

    @Override
    public String toString() {
        return "Certificado emitido para " + nomeDev +
                " - Bootcamp: " + nomeBootcamp +
                " - Data: " + dataConclusao +
                " - XP: " + totalXp;
    }
}
