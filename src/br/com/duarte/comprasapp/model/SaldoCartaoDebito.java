package br.com.duarte.comprasapp.model;

public class SaldoCartaoDebito extends Cartao implements DadosDoCliente{
    private double cartaoDeDebito;

    public double getCartaoDeDebito() {
        return cartaoDeDebito;
    }

    public void setCartaoDeDebito(double cartaoDeDebito) {
        this.cartaoDeDebito = cartaoDeDebito;
    }

    @Override
    public String getMensagem() {
        return "";
    }
}
