package br.com.desafiopoodio;


public class ContaCorrente extends Conta {
    public ContaCorrente(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Corrente: Saldo = " + getSaldo());
    }
}