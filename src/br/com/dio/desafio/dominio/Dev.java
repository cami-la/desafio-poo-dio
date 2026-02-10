package br.com.dio.desafio.dominio;

import java.util.*;

/**
 * Classe Dev que herda de Pessoa
 * Demonstra HERANÇA: Dev é uma especialização de Pessoa
 */
public class Dev extends Pessoa {
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    private Set<Certificado> certificados = new LinkedHashSet<>();

    public Dev() {
        super();
    }

    public Dev(String nome, String email) {
        super(nome, email);
    }

    /**
     * Retorna o nível atual do Dev baseado no XP acumulado
     * Demonstra ENCAPSULAMENTO: lógica interna calculada dinamicamente
     */
    public NivelDev getNivelAtual() {
        return NivelDev.calcularNivel(calcularTotalXp());
    }

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    /**
     * Verifica se o Dev completou todos os conteúdos do bootcamp
     */
    public boolean completouBootcamp(Bootcamp bootcamp) {
        return this.conteudosConcluidos.containsAll(bootcamp.getConteudos());
    }

    /**
     * Emite certificado ao completar o bootcamp
     * Demonstra ABSTRAÇÃO: esconde a complexidade da emissão de certificados
     */
    public void emitirCertificado(Bootcamp bootcamp) {
        if (completouBootcamp(bootcamp)) {
            Certificado certificado = new Certificado(this, bootcamp);
            this.certificados.add(certificado);
            System.out.println("🎓 Certificado emitido: " + certificado);
        } else {
            System.err.println("⚠️ " + getNome() + " ainda não completou o bootcamp " + bootcamp.getNome());
        }
    }

    public Set<Certificado> getCertificados() {
        return certificados;
    }

    public void setCertificados(Set<Certificado> certificados) {
        this.certificados = certificados;
    }


    public String getNome() {
        return super.getNome();
    }

    public void setNome(String nome) {
        super.setNome(nome);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dev dev = (Dev) o;
        return Objects.equals(conteudosInscritos, dev.conteudosInscritos) && 
               Objects.equals(conteudosConcluidos, dev.conteudosConcluidos) &&
               Objects.equals(certificados, dev.certificados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), conteudosInscritos, conteudosConcluidos, certificados);
    }

    @Override
    public String toString() {
        return "Dev{" +
                "nome='" + getNome() + '\'' +
                ", nivel=" + getNivelAtual() +
                ", xp=" + calcularTotalXp() +
                ", conteudosInscritos=" + conteudosInscritos.size() +
                ", conteudosConcluidos=" + conteudosConcluidos.size() +
                ", certificados=" + certificados.size() +
                '}';
    }
}
