package br.com.dio.desafio.dominio;

import java.time.LocalDate;

import lombok.NoArgsConstructor;

/**
 * Classe {@link Mentoria} que representa as mentorias que fazem parte do bootcamp.
 * @author Edielson Assis
 */
@NoArgsConstructor
public class Mentoria extends Conteudo {

    private LocalDate data;

    public Mentoria(String titulo, String descricao, LocalDate data) {
        super(titulo, descricao);
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
  
    /** 
     * Método usado para calcular Xp
     * @return double
     */
    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    @Override
    public String toString() {
        return "Mentoria: {" 
                + "titulo: " + getTitulo() 
                + ", descricao: " + getDescricao() 
                + ", data: " + data + "}";
    }
}