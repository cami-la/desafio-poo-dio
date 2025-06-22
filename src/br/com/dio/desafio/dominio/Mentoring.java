package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoring extends Content {

    // Atributos
    private LocalDate date;

    // Construtor
    public Mentoring(String title, String description, LocalDate date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }
    
    // Getters e Setters
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Método toString
    @Override
    public String toString() {
        return "Mentoria {" +
                "Título ='" + title + '\'' +
                ", Descrição ='" + description + '\'' +
                ", Data=" + date +
                '}';
    }

    // Implementação do método calcular XP
    @Override
    public double calculateXP() {
       return DEFAULT_XP + 20d;  // A mentoria tem um bônus de 20 XP
    }
   
}
