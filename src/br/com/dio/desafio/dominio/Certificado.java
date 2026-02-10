package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

/**
 * Classe que representa um Certificado de conclusão de Bootcamp
 * Demonstra ABSTRAÇÃO: modelo de certificado do mundo real
 */
public class Certificado {
    private final String codigo;
    private final Dev dev;
    private final Bootcamp bootcamp;
    private final LocalDate dataEmissao;
    private final double xpTotal;

    public Certificado(Dev dev, Bootcamp bootcamp) {
        this.codigo = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.dev = dev;
        this.bootcamp = bootcamp;
        this.dataEmissao = LocalDate.now();
        this.xpTotal = dev.calcularTotalXp();
    }

    public String getCodigo() {
        return codigo;
    }

    public Dev getDev() {
        return dev;
    }

    public Bootcamp getBootcamp() {
        return bootcamp;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public double getXpTotal() {
        return xpTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Certificado that = (Certificado) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Certificado{" +
                "codigo='" + codigo + '\'' +
                ", dev='" + dev.getNome() + '\'' +
                ", bootcamp='" + bootcamp.getNome() + '\'' +
                ", dataEmissao=" + dataEmissao.format(formatter) +
                ", xpTotal=" + xpTotal +
                '}';
    }
}
