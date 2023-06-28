package controller;

import model.CartaoDeCretido;
import java.util.Scanner;

public class CartaoDeCreditoController {

    private CartaoDeCretido contaCartaoCredito;

    public CartaoDeCreditoController(String nome, String cpf, double saldoValor){
        this.contaCartaoCredito = new CartaoDeCretido(nome, cpf, saldoValor);
        System.out.println("Conta Corrente Criada.");
    }

    public CartaoDeCreditoController(){};

    public void operacoes(){
        int operacao = -1;
        double valor;
        Scanner input = new Scanner(System.in);

        while (operacao != 0){
            System.out.println("Operações:\n1- Fatura: \n2- PagarCompra: \n3- Pagar Fatura: \n4- Fatura Delhada: \n5- Fatura Mes: \n6- Saldo: \n7- Movimentações: \n0- Sair");
            operacao = input.nextInt();

            switch (operacao){
                case 1 -> {
                    double fatura;
                    fatura = this.contaCartaoCredito.getFatura();
                    System.out.printf("Fatura Atual: %.2f\n", fatura);
                }

                case 2 -> {
                    System.out.println("Digite o valor da compra: ");
                    valor = input.nextDouble();
                    this.contaCartaoCredito.pagarCompra(valor);
                    System.out.printf("Compra Efetuada no valor: R$ %.2f \n", valor);
                }

                case 3 -> {
                    System.out.println("Digite o valor que você deseja pagar da fatura: ");
                    valor = input.nextDouble();
                    this.contaCartaoCredito.pagarFatura(valor);
                }

                case 4 -> this.contaCartaoCredito.faturaDetalhadaCompleta();

                case 5 -> this.contaCartaoCredito.faturaMes();

                case 6 -> {
                    double valorSaldo = this.contaCartaoCredito.getSaldo();
                    System.out.printf("Saldo: R$%.2f \n", valorSaldo);
                }

                case 7 -> this.contaCartaoCredito.getExtrato();

                default -> System.out.println("Opção Inválida!");
            }
        }
    }
}
