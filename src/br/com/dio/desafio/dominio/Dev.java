package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
        System.out.println("Parabéns! Voce se inscreveu no Bootcamp "+getNome());
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
            System.out.println("Parabens! Voce está progredindo!");
        } else {
            System.err.println("Voce nao esta matriculado em nenhum conteudo!");
        }
    }

    public void conteudosInscritos(){
        System.out.println("Conteudos Inscritos de" + getNome() + ":" + getConteudosInscritos());
    }

    public void conteudosConcluidos(){
        System.out.println("Conteudos Concluidos de" + getNome() + ":" + getConteudosConcluidos());
    }

  //Método que autoriza a emissão do certificado de conclusão do Bootcamp
    public void emitirCertificado() {
    	Iterator<Conteudo> iterator = this.conteudosInscritos.iterator();
    	if (iterator.hasNext()) {
            System.err.println("Voce ainda tem atividades a completar");
    	} else {
            System.out.println("PARABENS! Voce concluiu o Bootcamp! Ja pode emitir seu certificado de conclusao!");
        }
    }

    public double calcularTotalXp() {
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcularXp();
            soma += next;
        }
        return soma;

        /* Usando Stream API para somar o XP dentro de uma lista 
         * return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
         */
    }

    //setters e getters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    //equals e hash code
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
