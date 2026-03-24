package model;

public class ContaCorrente extends ContaBancaria {
    public ContaCorrente(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public double calcularTaxa() {
        return 10.0; // taxa fixa
    }
}
