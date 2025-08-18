package br.com.desafiopoodio;


public class ContaPoupanca extends Conta {
    public ContaPoupanca(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Poupança: Saldo = " + getSaldo());
    }
}