package model;
public class Main {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaCorrente(1000);
        ContaBancaria conta2 = new ContaPoupanca(500);

        conta1.depositar(200);
        conta2.sacar(100);

        System.out.println("Saldo Conta Corrente: " + conta1.getSaldo());
        System.out.println("Taxa Conta Corrente: " + conta1.calcularTaxa());

        System.out.println("Saldo Conta Poupança: " + conta2.getSaldo());
        System.out.println("Taxa Conta Poupança: " + conta2.calcularTaxa());
    }
}

