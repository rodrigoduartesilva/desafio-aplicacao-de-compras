package br.com.duarte.comprasapp.model;

public class SaldoCartaoDebito extends Cartao implements DadosDoCliente{
    private String saldoEmConta;

    public String getSaldoEmConta() {
        return saldoEmConta;
    }

    public void setSaldoEmConta(String saldoEmConta) {
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
                
                **************************************************************************
                
                """.formatted(getNomeDoTitular(), getNumeroDoCartao(), getBandeira(), getBancoEmissor());
    }
}