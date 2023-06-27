package controller;

import model.ContaPoupanca;
import java.util.Scanner;

public class ContaPoupancaController {

    ContaPoupanca contaPoupanca;

    public ContaPoupancaController(String nome, String cpf, double saldoValor){
        this.contaPoupanca = new ContaPoupanca(nome, cpf, saldoValor);
        System.out.println("Conta Corrente Criada.");
    }


    public void operacoes(){
        int operacao = -1;
        double valor;

        Scanner input = new Scanner(System.in);

        while (operacao != 0){
            System.out.println("Operações:\n1- Mostrar Rendimento Mensal: \n2- Fazer Aplicação: \n3- Fazer Resgate: \n4- Saldo: \n5- Extrato: \n0- Sair");
            operacao = input.nextInt();

            switch (operacao){
                case 1 -> {
                    double rendimento;
                    rendimento = contaPoupanca.getRendimento();
                    System.out.printf("O rendimento mensal será R$%.2f: \n", rendimento);
                }

                case 2 -> {
                    System.out.println("Digite o valor da aplicaçãp: ");
                    valor = input.nextDouble();
                    contaPoupanca.aplicacao(valor);
                }

                case 3 -> {
                    boolean validacao;
                    System.out.println("Digite o Valor de Regate.");
                    valor = input.nextDouble();
                    validacao = contaPoupanca.resgate(valor);

                    if(validacao){
                        System.out.println("Regate realizado com sucesso.");
                    }
                    else
                        System.out.println("Erro ao fazer resgate.");
                }

                case 4 -> {
                    double valorSaldo;
                    valorSaldo = this.contaPoupanca.getSaldo();
                    System.out.printf("Saldo: R$%.2f \n", valorSaldo);
                }
                case 5 -> contaPoupanca.getExtrato();

                default -> System.out.println("Opção Inválida!");
            }
        }
    }
}
