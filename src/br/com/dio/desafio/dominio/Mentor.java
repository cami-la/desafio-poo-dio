package br.com.dio.desafio.dominio;

import java.util.List;

public class Mentor {
    private final Integer DEFAULT_HOURS = 30;
    private String name;
    private Integer hours;
    private List<String> themes;

    public Mentor(String name, Integer hours, List<String> themes) {
        this.name = name;
        this.hours = hours;
        this.themes = themes;
    }
    
    public Mentor(String name, List<String> themes) {
        this.name = name;
        this.hours = DEFAULT_HOURS;
        this.themes = themes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank() || name.length() < 3) {
            throw new IllegalArgumentException("O nome deve conter mais de 3 letras");
        }
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        if (hours < 0 || hours > 44) {
            throw new IllegalArgumentException("Horas deve ser entre 0 e 44");
        }
        this.hours = hours;
    }

    public List<String> getThemes() {
        return themes;
    }

    public void setThemes(List<String> themes) {
        if (themes == null) {
            throw new IllegalArgumentException("Deve ter ao menos um com um tema");
        }
        this.themes = themes;
    }
}
