package br.com.challenge;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    private String name;
    private String description;
    private final LocalDate initialDate = LocalDate.now();
    private final LocalDate endDate = initialDate.plusDays(45);
    private Set<Developer> subscribedDevelopers = new HashSet<>();
    private Set<Content> content = new LinkedHashSet<>();

    public Bootcamp(String name, String description) {
        this.name = name;
        this.description = description;
    }

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

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Set<Developer> getSubscribedDevelopers() {
        return subscribedDevelopers;
    }

    public Set<Content> getContents() {
        return this.content;
    }

    public void setSubscribedDevelopers(Set<Developer> subscribedDevelopers) {
        this.subscribedDevelopers = subscribedDevelopers;
    }

    public void addContent(Content content) {
        this.content.add(content);
    }

    public void removeContent(Content content) {
        if (!this.content.contains(content)) {
            throw new NoSuchElementException("The content is not part of this Bootcamp.");
        }
        this.content.remove(content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(name, bootcamp.name) && Objects.equals(description, bootcamp.description)
                && Objects.equals(initialDate, bootcamp.initialDate) && Objects.equals(endDate, bootcamp.endDate)
                && Objects.equals(subscribedDevelopers, bootcamp.subscribedDevelopers)
                && Objects.equals(content, bootcamp.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, initialDate, endDate, subscribedDevelopers, content);
    }
}
