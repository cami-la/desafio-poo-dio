package model;

public abstract class ContaBancaria {
    private double saldo; // Encapsulamento

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    // Polimorfismo: cada tipo de conta define sua taxa
    public abstract double calcularTaxa();
}

