# Exercício - Sistema de Compras com cartão de crédito ou débito 

### Autor:

#### Rodrigo Duarte

[Linkedin](https://www.linkedin.com/in/rodrigoduar-te/)

[GitHub](https://github.com/rodrigoduartesilva/)

[Link do Repositório](https://github.com/rodrigoduartesilva/desafio-aplicacao-de-compras)

Para resolução desses exercícios é necessário ter conhecimentos de : Como criar pacotes, herança, encapsulamento, 
uso de getters e setters, sobrescrita de métodos, polimorfimo, interfaces, Collections.sort, LinkedList, Comparable, 
compareTo, sort e ArrayLists, try/catch.

### Enunciado: 
#### Crie um programa em Java que simule um sistema de compras, nele precisaremos dos dados do cliente, numero do cartao de crédito ou debito, limite do cartão / saldo em conta.
#### No ato da compra deve ser validado se o cliente possui limite/saldo para realizar esta compra.
#### Cada compra deve ter sua descrição e valor informado e ao final, deve ser dado ao usuário a opção de continuar comprando ou não, caso o mesmo possua saldo/limite disponiveis.
#### Em caso de saldo/limite insuficientes, a aplicação deve ser encerrada com uma mensagem de aviso.
#### Ao final, a aplicação deverá exibir os dados do cliente, total de compras efetuadas, e uma lista ordenada do menor ao maior valor de compras finalizadas.
#### Use try/catch para realizar algum tipo de tratamento de exceções dentro da aplicação.

#### Abaixo segue um passo a passo com a implementação da resolução:

1. Crie uma classe chamada Cartao. Essa classe será a super classe das classes LimiteCartaoDeCredito e SaldoCartaoDebito,
Os atributos sugeridos para esta classe são: nomeDoTitular, numeroDoCartao, bandeira, bancoEmissor:

```Java

public class Cartao {
    private String nomeDoTitular;
    private String numeroDoCartao;
    private String bandeira;
    private String bancoEmissor;

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
}


```

2. Crie uma interface chamada DadosDoCliente, essa interface tem como objetivo, gerar uma mensagem com os dados cliente que será exibida ao final da aplicação.

```Java

public interface DadosDoCliente {
    String getMensagem();
}

```

3. Crie uma classe chamada LimiteCartaoDeCredito e SaldoCartaoDebito, estas classes devem herdar da classe Cartao como também devem implementar a interface DadosDoCliente.
Crie um atributo que se refira ao limite/saldo do cliente nas respectivas classes, assim como a interface DadosDoCliente deve ser sobrescrista afim de que esta possa exibir os dados do cliente.

```Java

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


```

```Java

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


```

4. Crie uma classe Compra, crie dois atributos nessa classe, valorDaCompra e descricaoDaCompra, sobrescreva nela o 
método toString para que a impressão dos dados da compra seja feita por nome do produto e valor da compra dentro do arrayList que será
criado na classe Main.

```Java

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

```

5. E Finalmente, implemente as regras de negócios informadas no enunciado.  

```Java

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
        try {
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
        }catch (Exception err) {
            System.err.println("O valor digitado não corresponde a um número inteiro. " + err);
        }
    }
}


```

#### Observação: Importante lembrar que as soluções acima são apenas uma proposta de solução. Aconselho a antes de tentar consulta-las, tentar você mesmo desenvolver suas repostas.

Bons Estudos!