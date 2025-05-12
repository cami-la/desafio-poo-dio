package br.com.dio.desafio.dominio;

// A classe Curso é uma extensão de Conteudo, provavelmente uma classe abstrata ou interface que define métodos como calcularXp()
public class Curso extends Conteudo {

    // Atributo privado que define a carga horária do curso
    private int cargaHoraria;

    // Método para calcular a quantidade de XP (provavelmente com base na carga horária do curso)
    @Override
    public double calcularXp() {
        // Retorna o valor do XP calculado multiplicando a carga horária pelo valor padrão de XP (XP_PADRAO)
        return XP_PADRAO * cargaHoraria;
    }

    // Construtor vazio, provavelmente utilizado para a criação de objetos sem inicializar valores diretamente
    public Curso() {
    }

    // Getter para acessar o valor da carga horária
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    // Setter para modificar o valor da carga horária
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    // Sobrescrita do método toString para representar a classe Curso como uma string, incluindo o título, a descrição e a carga horária
    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +  // Chama o método getTitulo da classe pai Conteudo
                ", descricao='" + getDescricao() + '\'' +  // Chama o método getDescricao da classe pai Conteudo
                ", cargaHoraria=" + cargaHoraria +  // Exibe o valor da carga horária do curso
                '}';
    }
}