package br.com.desafiopoodio;

public class Banco {
    public static void main(String[] args) {
        Conta cc = new ContaCorrente("João", 1000);
        Conta cp = new ContaPoupanca("Maria", 2000);

        cc.depositar(500);
        cp.sacar(300);

        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }
}