package br.com.dio.desafio.dominio;

// Classe abstrata Content - não pode ser instaciada
public abstract class Content {

    // Atributos 
    protected String title;
    protected String description;
    protected static final double DEFAULT_XP = 10d;


    // Getters e Setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
   

    // Método calcular XP
    public abstract double calculateXP();
    
}
