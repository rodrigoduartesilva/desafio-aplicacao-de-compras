package br.com.duarte.comprasapp.model;

public class Cartao {
    private String nomeDoTitular;
    private String numeroDoCartao;
    private String bandeira;
    private String bancoEmissor;
    private double valorDaCompra;
    private String descricaoDaCompra;

    public String getNomeDoTitular() {
        return nomeDoTitular;
    }

    public void setNomeDoTitular(String nomeDoTitular) {
        this.nomeDoTitular = nomeDoTitular;
    }

    public String getNumeroDoCartao() {
        return numeroDoCartao;
    }

    public void setNumeroDoCartao(String numeroDoCartao) {
        this.numeroDoCartao = numeroDoCartao;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getBancoEmissor() {
        return bancoEmissor;
    }

    public void setBancoEmissor(String bancoEmissor) {
        this.bancoEmissor = bancoEmissor;
    }

    public double getValorDaCompra() {
        return valorDaCompra;
    }

    public void setValorDaCompra(double valorDaCompra) {
        this.valorDaCompra = valorDaCompra;
    }

    public String getDescricaoDaCompra() {
        return descricaoDaCompra;
    }

    public void setDescricaoDaCompra(String descricaoDaCompra) {
        this.descricaoDaCompra = descricaoDaCompra;
    }
}
