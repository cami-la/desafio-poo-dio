package br.com.dio.desafio.dominio;

public class Course extends Content {

    // Atributos
    private int workload;

    // Construtor
    public Course(String title, String description, int workload) {
        this.title = title;
        this.description = description;
        this.workload = workload;
    }

    // Getters e Setters
    public int getWorkload() {
        return workload;
    }
    public void setWorkload(int workload) {
        this.workload = workload;
    }



    // Método toString
    @Override
    public String toString() {
        return "Curso {" +
                "Título ='" + title + '\'' +
                ", Descrição ='" + description + '\'' +
                ", Carga Horária=" + workload +
                '}';
    }

    @Override
    public double calculateXP() {
        return DEFAULT_XP * workload ;  // A carga horária influencia no cálculo de XP
    }


    

   
}
