package controller;

import model.*;

import java.util.Scanner;

public class UserController {
    private String nome;
    private String cpf;
    private double saldoValor;
    private int opcaoMenu;


    public void CriacaoConta(){
        this.menu();

        switch (this.opcaoMenu){
            case 1:
                this.setDadosCliente();
                ContaCorrenteController contaCorrente = new ContaCorrenteController(this.nome, this.cpf, this.saldoValor);
                contaCorrente.operacoesContaCorrente();
                break;

            case 2:
                this.setDadosCliente();
                Conta contaPoupanca = new ContaPoupanca(this.nome, this.cpf, this.saldoValor);
                System.out.println("Conta Poupança criada.");
                break;

            case 3:
                this.setDadosCliente();
                Conta investimentoCli = new InvestimentoLci(this.nome, this.cpf, this.saldoValor);
                System.out.println("Conta Investimento LCI,");
                break;

            case 4:
                this.setDadosCliente();
                Conta cartaoDeCredito = new CartaoDeCretido(this.nome, this.cpf, this.saldoValor);
                System.out.println("Conta Cartão Crédito Criada.");
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }


    private void setDadosCliente(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        this.nome = input.nextLine();
        System.out.println("Digite seu cpf:");
        this.cpf = input.nextLine();
        System.out.println("Digite o Saldo Inicial:");
        this.saldoValor = input.nextDouble();
    }


    private void menu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite qual tipo de você deseja criar: \n1- Conta Corrente.\n2- Conta Poupança.\n3- Investimento Cli.\n4- Cartão de Crédito.");
        this.opcaoMenu = input.nextInt();
    }
}
