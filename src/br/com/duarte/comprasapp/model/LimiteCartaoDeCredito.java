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
        return "";
    }
}
