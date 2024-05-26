package br.com.duarte.comprasapp.model;

public class LimiteCartaoDeCredito extends Cartao implements DadosDoCliente{
    private String limiteDoCartao;

    public String getLimiteDoCartao() {
        return limiteDoCartao;
    }

    public void setLimiteDoCartao(String limiteDoCartao) {
        this.limiteDoCartao = limiteDoCartao;
    }

    @Override
    public String getMensagem() {
        return """
                ****************** Dados do Cliente - Cartão de Crédito ******************
                
                    Titular: %s
                    Numero do Cartao: %s
                    Bandeira: %s
                    Banco Emissor: %S
                
                **************************************************************************
                
                """.formatted(getNomeDoTitular(), getNumeroDoCartao(), getBandeira(), getBancoEmissor());
    }
}