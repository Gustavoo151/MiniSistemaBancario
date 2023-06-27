package model;

import model.interfaces.Cliente;

import java.util.ArrayList;

public class Conta implements Cliente {
    private double saldo;
    private ArrayList<String> movimentacoes = new ArrayList<>();
    private String cpfCliente;
    private String nomeCliente;

    public void getExtrato() {
        for (int i = 0; i < this.movimentacoes.size(); i++){
            System.out.println(i+1 + "º movientação do mês: " + this.movimentacoes.get(i));
        }
    }

    public void setMovimentacoes(String movimentacoes) {
        this.movimentacoes.add(movimentacoes);
    }

    public void setSaldo(double valor){
        this.saldo += valor;
    }

    public double getSaldo(){
        return this.saldo;
    }

    @Override
    public void setNome(String nome) {
        this.nomeCliente = nome;
    }

    @Override
    public String getNome() {
        return this.nomeCliente;
    }

    @Override
    public void setCpf(String Cpf) {
        this.cpfCliente = Cpf;
    }

    @Override
    public String getCpf() {
        return this.cpfCliente;
    }
}
