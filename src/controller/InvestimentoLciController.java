package controller;
import model.InvestimentoLci;
import java.util.Scanner;

public class InvestimentoLciController {
    InvestimentoLci contaLCI;

    public InvestimentoLciController(String nome, String cpf, double saldoValor){
        this.contaLCI = new InvestimentoLci(nome, cpf, saldoValor);
        System.out.println("Conta investimento CLI criada com sucesso.");
    }

    public void operacoes(){
        int operacao = -1;
        double valor;
        Scanner input = new Scanner(System.in);

        while (operacao != 0){
            System.out.println("Operações:\n1- Mostrar Rendimento Mensal: \n2- Fazer Aporte: \n3- Fazer Resgate: \n4- Saldo: \n5- Extrato: \n0- Sair");
            operacao = input.nextInt();

            switch (operacao){
                case 1 -> {
                    double rendimento;
                    rendimento = contaLCI.getRendimento();
                    System.out.printf("O rendimento mensal será R$%.2f: \n", rendimento);
                }

                case 2 -> {
                    System.out.println("Digite o valor do aporte: ");
                    valor = input.nextDouble();
                    this.contaLCI.SetAporte(valor);
                }

                case 3 -> {
                    boolean validacao;
                    System.out.println("Digite o Valor de Regate.");
                    valor = input.nextDouble();
                    validacao = contaLCI.resgate(valor);

                    if(validacao){
                        System.out.println("Regate realizado com sucesso.");
                    }
                    else
                        System.out.println("Erro ao fazer resgate.");
                }

                case 4 -> {
                    double valorSaldo;
                    valorSaldo = this.contaLCI.getSaldo();
                    System.out.printf("Saldo: R$%.2f \n", valorSaldo);
                }

                case 5 -> contaLCI.getRendimento();

                default -> System.out.println("Opção Inválida!");
            }
        }
    }
}
