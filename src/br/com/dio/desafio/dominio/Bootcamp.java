package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {

    private String name;
    private String description;
    private final LocalDate startDate = LocalDate.now();
    private LocalDate endDate = startDate.plusDays(45); // Duração de 45 dias
    private final Set<Dev> subscribedDevs = new HashSet<>();
    private final Set<Content> contents = new LinkedHashSet<>();
    
    // Getters e Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public Set<Dev> getSubscribedDevs() {
        return subscribedDevs;
    }
    public Set<Content> getContents() {
        return contents;
    }
    
    // Equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return name.equals(bootcamp.name) && description.equals(bootcamp.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, startDate, endDate, subscribedDevs, contents);
    }
   
}
