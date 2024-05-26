package br.com.duarte.comprasapp.main;

import br.com.duarte.comprasapp.model.LimiteCartaoDeCredito;
import br.com.duarte.comprasapp.model.SaldoCartaoDebito;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        String opcao;

        System.out.println("""
                *************************************************************
                
                Opção de Pagamento via Cartão:
                
                1 - Crédito
                2 - Débito
                
               
                *************************************************************
                """);

        System.out.print("Digite a opção desejada: ");
        opcao = scanner.nextLine();

        switch (opcao){
            case "1":

                LimiteCartaoDeCredito cartaoDeCredito = new LimiteCartaoDeCredito();

                System.out.print("Digite o nome do titular do cartão de crédito: ");
                cartaoDeCredito.setNomeDoTitular(scanner.nextLine());

                System.out.print("Digite o número do cartão: ");
                cartaoDeCredito.setNumeroDoCartao(scanner.nextLine());

                System.out.print("Digite a bandeira do cartão: ");
                cartaoDeCredito.setBandeira(scanner.nextLine());

                System.out.print("Digite o nome do banco ao qual o cartão está vinculado: ");
                cartaoDeCredito.setBancoEmissor(scanner.nextLine());

                System.out.print("Informe o limite atual do cartão: ");
                cartaoDeCredito.setLimiteDoCartao(scanner.nextDouble());

                scanner.close();

                System.out.println(cartaoDeCredito.getMensagem());
                break;

            case "2":

                SaldoCartaoDebito cartaoDebito = new SaldoCartaoDebito();

                System.out.print("Digite o nome do titular do cartão de débito: ");
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
                break;

            default:
                System.out.println("Opção Inválida!");
                break;
        }
    }
}