package br.com.duarte.comprasapp.main;

import br.com.duarte.comprasapp.model.LimiteCartaoDeCredito;
import br.com.duarte.comprasapp.model.SaldoCartaoDebito;

public class Main {
    public static void main(String[] args) {
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

        cartaoDebito.setNomeDoTitular("Samira Duarte da Silva");
        cartaoDebito.setNumeroDoCartao("4321 4321 4321 4321");
        cartaoDebito.setBandeira("Master Card");
        cartaoDebito.setBancoEmissor("Banco do Brasil");
        cartaoDebito.setSaldoEmConta(20000.00);

        System.out.println(cartaoDebito.getMensagem());
    }
}