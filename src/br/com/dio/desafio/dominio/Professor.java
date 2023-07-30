package br.com.dio.desafio.dominio;

public class Professor {
    private String firstName;
    private String secondName;


    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString(){
        return firstName + " " + secondName;
    }
}
