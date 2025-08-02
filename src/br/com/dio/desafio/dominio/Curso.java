package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {

    private int cargaHoraria;

    public Curso() {
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        if (cargaHoraria <= 0) {
            System.out.println("Erro: A carga horária deve ser maior que zero.");
            return; // Sai do método se a validação falhar
        }
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }

    @Override
    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            System.out.println("Erro: A descrição não pode ser nula ou vazia.");
            return; // Sai do método se a validação falhar
        }
        super.setDescricao(descricao);
    }

    @Override
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            System.out.println("Erro: O título não pode ser nulo ou vazio.");
            return; // Sai do método se a validação falhar
        }
        super.setTitulo(titulo);
    }
}
