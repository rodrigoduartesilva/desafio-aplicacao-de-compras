package br.com.duarte.comprasapp.main;

import br.com.duarte.comprasapp.model.LimiteCartaoDeCredito;
import br.com.duarte.comprasapp.model.SaldoCartaoDebito;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        LimiteCartaoDeCredito cartaoDeCredito = new LimiteCartaoDeCredito();
//
//        cartaoDeCredito.setNomeDoTitular("Rodrigo Duarte");
//        cartaoDeCredito.setNumeroDoCartao("1234 1234 1234 1234");
//        cartaoDeCredito.setBandeira("Visa");
//        cartaoDeCredito.setBancoEmissor("CEF");
//        cartaoDeCredito.setLimiteDoCartao(10000.00);
//
//        System.out.println(cartaoDeCredito.getMensagem());

        SaldoCartaoDebito cartaoDebito = new SaldoCartaoDebito();

        System.out.print("Digite o nome do titular do cartão: ");
        cartaoDebito.setNomeDoTitular(scanner.nextLine());

        System.out.print("Digite o número do cartão: ");
        cartaoDebito.setNumeroDoCartao(scanner.nextLine());

        System.out.print("Digite a bandeira do cartão: ");
        cartaoDebito.setBandeira(scanner.nextLine());

        System.out.print("Digite o nome do banco ao qual o cartão está vinculado: ");
        cartaoDebito.setBancoEmissor(scanner.nextLine());

        System.out.print("Informe o saldo atual em conta: ");
        cartaoDebito.setSaldoEmConta(scanner.nextDouble());

        scanner.close();

        System.out.println(cartaoDebito.getMensagem());
    }
}