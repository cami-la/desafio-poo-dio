package br.com.dio.desafio.dominio;

public enum Nivel {
    INICIANTE("Iniciante", 0, 100),
    INTERMEDIARIO("Intermediário", 100, 500),
    AVANCADO("Avançado", 500, Double.MAX_VALUE);

    private final String descricao;
    private final double xpMinimo;
    private final double xpMaximo;

    Nivel(String descricao, double xpMinimo, double xpMaximo) {
        this.descricao = descricao;
        this.xpMinimo = xpMinimo;
        this.xpMaximo = xpMaximo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getXpMinimo() {
        return xpMinimo;
    }

    public double getXpMaximo() {
        return xpMaximo;
    }

    public static Nivel calcularNivel(double xp) {
        if (xp < 100) {
            return INICIANTE;
        } else if (xp < 500) {
            return INTERMEDIARIO;
        } else {
            return AVANCADO;
        }
    }

    @Override
    public String toString() {
        return descricao;
    }
}