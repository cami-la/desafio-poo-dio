package br.com.dio.desafio.dominio;

import java.math.BigDecimal;

public class DesafioDeCodigo extends Conteudo {

    private NivelDificuldade nivel;

    @Override
    public BigDecimal calcularXp() { 
       
        return XP_PADRAO.multiply(new BigDecimal(nivel.getMultiplicadorXp()));
    }

    public NivelDificuldade getNivel() {
        return nivel;
    }

    public void setNivel(NivelDificuldade nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "DesafioDeCodigo{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}