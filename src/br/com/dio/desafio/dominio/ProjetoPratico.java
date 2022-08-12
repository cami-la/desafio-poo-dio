package br.com.dio.desafio.dominio;

//Classe de Projeto onde o Dev pode aprimorar o aprendizado 
public class ProjetoPratico extends Conteudo {
	
	private int nivelDificuldade;
	
	@Override
	public double calcularXp() {
		return XP_PADRAO * nivelDificuldade;
	}

	public int getNivelDificuldade() {
		return nivelDificuldade;
	}

	public void setNivelDificuldade(int nivelDificuldade) {
		this.nivelDificuldade = nivelDificuldade;
	}

	public ProjetoPratico() {
	}

	public ProjetoPratico(String titulo, String descricao, int nivelDificuldade) {
		super(titulo, descricao); //se refere a classe mãe
		this.nivelDificuldade = nivelDificuldade;
	}

	@Override
	public String toString() {
		return "Projeto Pratico: " + getTitulo()
				+ "\nDescrição" + getDescricao()
				+ "\nNivel de Dificuldade: " + nivelDificuldade;
	}
	//CTRL + SHIFT + L -> Atalhos pra ver os atalhos no eclipse
	
}
