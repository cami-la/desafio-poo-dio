package model;

public class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public double calcularTaxa() {
        return getSaldo() * 0.01; // taxa proporcional ao saldo
    }
}

