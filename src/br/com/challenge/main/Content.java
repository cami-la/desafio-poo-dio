package br.com.challenge.main;

public abstract class Content {

    protected static final double XP_DEFAULT = 10d;

    private String title;
    private String description;

    public abstract double computeXp();

    public Content(String title, String description) {
        this.title = title;
        this.description = description;
    }

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

}
