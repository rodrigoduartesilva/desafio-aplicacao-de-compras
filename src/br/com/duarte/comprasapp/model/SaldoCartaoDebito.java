package br.com.duarte.comprasapp.model;

public class SaldoCartaoDebito extends Cartao implements DadosDoCliente{
    private double saldoEmConta;

    public double getSaldoEmConta() {
        return saldoEmConta;
    }

    public void setSaldoEmConta(double saldoEmConta) {
        this.saldoEmConta = saldoEmConta;
    }

    @Override
    public String getMensagem() {
        return """
                ****************** Dados do Cliente - Cartão de Débito ******************
                
                    Titular: %s
                    Numero do Cartao: %s
                    Bandeira: %s
                    Banco Emissor: %s
                    Saldo em conta: R$ %.2f
                
                **************************************************************************
                
                """.formatted(getNomeDoTitular(), getNumeroDoCartao(), getBandeira(), getBancoEmissor(),
                getSaldoEmConta());
    }
}