package br.com.challenge;

import java.util.*;

public class Developer {

    private String name;
    private Set<Content> subscribedContents = new LinkedHashSet<>();
    private Set<Content> completedContents = new LinkedHashSet<>();

    public Developer(String name) {
        this.name = name;
    }

    public void signUp(Bootcamp bootcamp) {
        this.subscribedContents.addAll(bootcamp.getContent());
        bootcamp.getSubscribedDevelopers().add(this);
    }

    public void makeProgress() throws NoSuchElementException {
        Optional<Content> content = this.subscribedContents.stream().findFirst();
        
        if (content.isEmpty()) {
            throw new NoSuchElementException("You are not enrolled in any content!");
        }

        this.completedContents.add(content.get());
        this.subscribedContents.remove(content.get());
    }

    public double computeTotalXp() {
        return this.completedContents
                .stream()
                .mapToDouble(Content::computeXp)
                .sum();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Content> getSubscribedContents() {
        return subscribedContents;
    }

    public void setSubscribedContents(Set<Content> subscribedContents) {
        this.subscribedContents = subscribedContents;
    }

    public Set<Content> getCompletedContents() {
        return completedContents;
    }

    public void setCompletedContents(Set<Content> completedContents) {
        this.completedContents = completedContents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Developer dev = (Developer) o;
        return Objects.equals(name, dev.name) && Objects.equals(subscribedContents, dev.subscribedContents)
                && Objects.equals(completedContents, dev.completedContents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subscribedContents, completedContents);
    }
}
