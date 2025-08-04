package br.com.dio.desafio.dominio;

import java.math.BigDecimal; 

public class Curso extends Conteudo {

    private int cargaHoraria;

    @Override
    public BigDecimal calcularXp() { 
        
        return XP_PADRAO.multiply(new BigDecimal(cargaHoraria));
    }

    public Curso() {
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Curso{");
        sb.append("titulo='").append(getTitulo()).append('\'');
        sb.append(", descricao='").append(getDescricao()).append('\'');
        sb.append(", cargaHoraria=").append(cargaHoraria);
        sb.append('}');
        return sb.toString();
    }
}