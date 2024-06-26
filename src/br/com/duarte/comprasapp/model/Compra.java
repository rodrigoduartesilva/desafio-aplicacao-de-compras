package br.com.duarte.comprasapp.model;

public class Compra implements Comparable<Compra>{
    private double valorDaCompra;
    private String descricaoDaCompra;

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

    @Override
    public String toString() {
        return "Produto: " + getDescricaoDaCompra() + " - " + " Valor: R$" + getValorDaCompra();
    }

    @Override
    public int compareTo(Compra compra) {
        return Double.valueOf(this.valorDaCompra).compareTo(Double.valueOf(compra.valorDaCompra));
    }
}
