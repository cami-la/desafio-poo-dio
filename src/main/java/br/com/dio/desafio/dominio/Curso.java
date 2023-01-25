package br.com.dio.desafio.dominio;

import lombok.NoArgsConstructor;

/**
 * Classe {@link Curso} que representa os cursos que fazem parte do bootcamp.
 * @author Edielson Assis
 */
@NoArgsConstructor
public class Curso extends Conteudo {
    
    private Integer cargaHoraria;

    public Curso(String titulo, String descricao, Integer cargaHoraria) {
        super(titulo, descricao);
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }
    
    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /** 
     * Método usado para calcular Xp
     * @return double
     */
    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso: {"
                + "titulo: " + getTitulo()
                + ", descricao: " + getDescricao()
                +", carga horaria: " + cargaHoraria + "}";
    }  
}