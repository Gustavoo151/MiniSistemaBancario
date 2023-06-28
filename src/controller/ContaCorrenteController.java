package controller;

import model.ContaCorrente;

import java.util.Scanner;

public class ContaCorrenteController {

    private ContaCorrente contaCorrente = new ContaCorrente();

    public ContaCorrenteController(String nome, String cpf, double saldoValor){
        this.contaCorrente.setNome(nome);
        this.contaCorrente.setCpf(cpf);
        this.contaCorrente.setSaldo(saldoValor);

        System.out.println("Conta Corrente Criada.");
    }


    public void operacoes(){
        int operacao = 1;
        double valor;

        Scanner input = new Scanner(System.in);

        while(operacao != 0){
            System.out.println("Operações:\n1- Mostrar Rendimento Mensal: \n2- Fazer Deposito: \n3- Fazer Saque: \n4- Fazer Transferência: \n5- Saldo: \n6- Extrato: \n0- Sair");
            operacao = input.nextInt();

            switch (operacao){
                case 1:
                    double rendimento;
                    rendimento = this.contaCorrente.getRendimento();
                    System.out.printf("O rendimento mensal será R$%.2f: \n", rendimento);
                    break;

                case 2:
                    System.out.println("Digite o valor: ");
                    valor = input.nextDouble();
                    this.contaCorrente.setDeposito(valor);
                    break;

                case 3:
                    System.out.println("Digite o Valor Do saque: ");
                    valor = input.nextDouble();
                    this.contaCorrente.saque(valor);
                    break;

                case 4:
                    int numeroConta;
                    System.out.println("Digite o Número da conta que você deseja transferior o valor.");
                    numeroConta = input.nextInt();
                    System.out.println("Digite o Valor Que Você Deseja Transferir: ");
                    valor = input.nextDouble();
                    this.contaCorrente.tranferencia(valor, numeroConta);
                    break;

                case 5:
                    double valorSaldo;
                    valorSaldo = this.contaCorrente.getSaldo();
                    System.out.printf("Saldo: R$%.2f \n", valorSaldo);
                    break;

                case 6:
                    contaCorrente.getExtrato();
                    break;

                default:
                    System.out.println("Valor inváldo!");
            }
        }
    }
}
