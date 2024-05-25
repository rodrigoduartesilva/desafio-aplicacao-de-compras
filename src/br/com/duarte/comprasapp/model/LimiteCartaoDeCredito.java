package br.com.duarte.comprasapp.model;

public class LimiteCartaoDeCredito extends Cartao implements DadosDoCliente{
    private double limiteDoCartao;

    public double getLimiteDoCartao() {
        return limiteDoCartao;
    }

    public void setLimiteDoCartao(double limiteDoCartao) {
        this.limiteDoCartao = limiteDoCartao;
    }


    @Override
    public String getMensagem() {
        return """
                ****************** Dados do Cliente - Cartão de Crédito ******************
                
                    Titular: %s
                    Numero do Cartao: %s
                    Bandeira: %s
                    Banco Emissor: %s
                    Limite total: R$ %.2f
                
                **************************************************************************
                
                """.formatted(getNomeDoTitular(), getNumeroDoCartao(), getBandeira(), getBancoEmissor(),
                        getLimiteDoCartao());
    }
}