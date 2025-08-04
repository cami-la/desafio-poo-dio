package br.com.dio.desafio.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Mentoria extends Conteudo {

    private LocalDateTime data; 

    @Override
    public BigDecimal calcularXp() {
       
        return XP_PADRAO.add(new BigDecimal("20"));
    }

    public Mentoria() {
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Override
    public String toString() {
      
        StringBuilder sb = new StringBuilder();
        sb.append("Mentoria{");
        sb.append("titulo='").append(getTitulo()).append('\'');
        sb.append(", descricao='").append(getDescricao()).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}