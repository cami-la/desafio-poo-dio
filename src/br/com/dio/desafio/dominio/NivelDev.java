package br.com.dio.desafio.dominio;

/**
 * Enum que representa os níveis de um desenvolvedor
 * Demonstra ENCAPSULAMENTO: níveis bem definidos com XP mínimo necessário
 */
public enum NivelDev {
    JUNIOR("Júnior", 0),
    PLENO("Pleno", 100),
    SENIOR("Sênior", 300),
    ESPECIALISTA("Especialista", 500);

    private final String descricao;
    private final double xpMinimo;

    NivelDev(String descricao, double xpMinimo) {
        this.descricao = descricao;
        this.xpMinimo = xpMinimo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getXpMinimo() {
        return xpMinimo;
    }

    /**
     * Calcula o nível baseado no XP total
     * Demonstra POLIMORFISMO: comportamento dinâmico baseado em dados
     */
    public static NivelDev calcularNivel(double xpTotal) {
        if (xpTotal >= ESPECIALISTA.xpMinimo) {
            return ESPECIALISTA;
        } else if (xpTotal >= SENIOR.xpMinimo) {
            return SENIOR;
        } else if (xpTotal >= PLENO.xpMinimo) {
            return PLENO;
        } else {
            return JUNIOR;
        }
    }

    @Override
    public String toString() {
        return descricao + " (XP mínimo: " + xpMinimo + ")";
    }
}
