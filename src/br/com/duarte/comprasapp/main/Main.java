package br.com.duarte.comprasapp.main;

import br.com.duarte.comprasapp.model.Compra;
import br.com.duarte.comprasapp.model.LimiteCartaoDeCredito;
import br.com.duarte.comprasapp.model.SaldoCartaoDebito;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int opcao;
        double convertDoubleLimiteSaldo = 0.0;
        int comprar = 1;
        ArrayList<Compra> listaDeCompras = new ArrayList<>();

        System.out.println("""
                *************************************************************
                
                Opção de Pagamento via Cartão:
                
                1 - Crédito
                2 - Débito
                
               
                *************************************************************
                """);

        System.out.print("Digite a opção desejada: ");
        opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao){
            case 1:

                LimiteCartaoDeCredito cartaoDeCredito = new LimiteCartaoDeCredito();

                System.out.print("Digite o nome do titular do cartão de crédito: ");
                cartaoDeCredito.setNomeDoTitular(scanner.nextLine());

                System.out.print("Digite o número do cartão: ");
                cartaoDeCredito.setNumeroDoCartao(scanner.nextLine());

                System.out.print("Digite a bandeira do cartão: ");
                cartaoDeCredito.setBandeira(scanner.nextLine());

                System.out.print("Digite o nome do banco ao qual o cartão está vinculado: ");
                cartaoDeCredito.setBancoEmissor(scanner.nextLine());

                System.out.print("Informe o limite atual do cartão: R$ ");
                cartaoDeCredito.setLimiteDoCartao(scanner.nextLine());

                convertDoubleLimiteSaldo = Double.parseDouble(cartaoDeCredito.getLimiteDoCartao());

                System.out.println("""
                        
                            ************* Dados da Compra *************
                        
                        """);

                while(comprar != 0) {
                    Compra compra = new Compra();

                    System.out.println("Limite atual do Cartão: R$ " + convertDoubleLimiteSaldo);

                    System.out.println("""
                            
                            -------------------------------------------------------
                            
                            """);

                    System.out.print("Digite a descrição da compra: ");
                    compra.setDescricaoDaCompra(scanner.nextLine());

                    System.out.print("Digite o valor da compra: R$ ");
                    compra.setValorDaCompra(scanner.nextDouble());

                    if(convertDoubleLimiteSaldo >= compra.getValorDaCompra()) {

                        listaDeCompras.add(compra);

                        System.out.println("""
                                
                                Compra realizada!
                                
                                """);

                        convertDoubleLimiteSaldo -= compra.getValorDaCompra();
                    } else {
                        System.out.println("""
                                    
                                    Compra não realizada!
                                    
                                    Motivo: Limite insuficiente!
                                    
                                    Operação finalizada!
                                    
                                """);
                        break;
                    }

                    System.out.print("Digite 0 para sair ou 1 para continuar: ");
                    comprar = scanner.nextInt();

                    System.out.println("");

                    scanner.nextLine();

                }

                scanner.close();

                System.out.println(cartaoDeCredito.getMensagem());

                System.out.println("Quantidade de compras realizadas: " + listaDeCompras.size());
                System.out.println("");

                Collections.sort(listaDeCompras);

                for (Compra compra : listaDeCompras) {
                    System.out.println(compra);
                }

                break;

            case 2:

                SaldoCartaoDebito cartaoDebito = new SaldoCartaoDebito();

                System.out.print("Digite o nome do titular do cartão de débito: ");
                cartaoDebito.setNomeDoTitular(scanner.nextLine());

                System.out.print("Digite o número do cartão: ");
                cartaoDebito.setNumeroDoCartao(scanner.nextLine());

                System.out.print("Digite a bandeira do cartão: ");
                cartaoDebito.setBandeira(scanner.nextLine());

                System.out.print("Digite o nome do banco ao qual o cartão está vinculado: ");
                cartaoDebito.setBancoEmissor(scanner.nextLine());

                System.out.print("Informe o saldo atual da conta corrente: R$ ");
                cartaoDebito.setSaldoEmConta(scanner.nextLine());

                convertDoubleLimiteSaldo = Double.parseDouble(cartaoDebito.getSaldoEmConta());

                System.out.println("""
                        
                            ************* Dados da Compra *************
                        
                        """);

                while(comprar != 0) {
                    Compra compra = new Compra();

                    System.out.println("Saldo em conta atual: R$ " + convertDoubleLimiteSaldo);

                    System.out.println("""
                            
                            -------------------------------------------------------
                            
                            """);

                    System.out.print("Digite a descrição da compra: ");
                    compra.setDescricaoDaCompra(scanner.nextLine());

                    System.out.print("Digite o valor da compra: R$ ");
                    compra.setValorDaCompra(scanner.nextDouble());

                    if(convertDoubleLimiteSaldo >= compra.getValorDaCompra()) {

                        listaDeCompras.add(compra);

                        System.out.println("""
                                
                                Compra realizada!
                                
                                """);

                        convertDoubleLimiteSaldo -= compra.getValorDaCompra();
                    } else {
                        System.out.println("""
                                    
                                    Compra não realizada!
                                    
                                    Motivo: Limite insuficiente!
                                    
                                    Operação finalizada!
                                    
                                """);
                        break;
                    }

                    System.out.print("Digite 0 para sair ou 1 para continuar: ");
                    comprar = scanner.nextInt();

                    System.out.println("");

                    scanner.nextLine();

                }

                scanner.close();

                System.out.println(cartaoDebito.getMensagem());

                System.out.println("Quantidade de compras realizadas: " + listaDeCompras.size());
                System.out.println("");

                Collections.sort(listaDeCompras);

                for (Compra compra : listaDeCompras) {
                    System.out.println(compra);
                }

                break;

            default:
                System.out.println("Opção Inválida!");
                break;
        }
    }
}