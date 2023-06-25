package controller;

import model.*;

import java.util.Scanner;

public class Controller {
    private String nome;
    private String cpf;
    private double saldoValor;
    private int opcaoMenu;

    public void CriacaoConta(){
        this.menu();

        switch (this.opcaoMenu){
            case 1:
                this.setDadosCliente();
                Conta contaCorrente = new ContaCorrente(this.nome, this.cpf, this.saldoValor);
                System.out.println("Conta Corrente Criada.");

            case 2:
                this.setDadosCliente();
                Conta contaPoupanca = new ContaPoupanca(this.nome, this.cpf, this.saldoValor);
                System.out.println("Conta Poupança criada.");

            case 3:
                this.setDadosCliente();
                Conta investimentoCli = new InvestimentoLci(this.nome, this.cpf, this.saldoValor);
                System.out.println("Conta Investimento LCI,");

            case 4:
                this.setDadosCliente();
                Conta cartaoDeCredito = new CartaoDeCretido(this.nome, this.cpf, this.saldoValor);
                System.out.println("Conta Cartão Crédito Criada.");
        }
    }


    private void setDadosCliente(){
        Scanner input2 = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        this.nome = input2.nextLine();
        System.out.println("Digite seu cpf:");
        this.cpf = input2.nextLine();
        System.out.println("Digite o Saldo Inicial:");
        this.saldoValor = input2.nextDouble();
    }


    private void menu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite qual tipo de você deseja criar: \n1- Conta Corrente.\n2- Conta Poupança.\n3- Investimento Cli.\n4- Cartão de Crédito.");
        this.opcaoMenu = input.nextInt();
    }

    // Fazer Operações para os cartões
}
