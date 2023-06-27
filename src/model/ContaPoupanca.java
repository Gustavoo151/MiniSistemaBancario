package model;

import model.interfaces.Rendimento;

import java.time.LocalDate;

public class ContaPoupanca extends Conta implements Rendimento {

    public ContaPoupanca(String nome, String cpf, double valorInicialSaldo){
        super.setNome(nome);
        super.setCpf(cpf);
        super.setSaldo(valorInicialSaldo);
    }

    public ContaPoupanca(){}

    public double getRendimento() {
        return super.getSaldo() * TaxaJuros.getTaxa();
    }

    public void aplicacao(double valor){
        if (valor > 0){
            super.setSaldo(valor);
            super.setMovimentacoes("Aplição: Hora: " + LocalDate.now().toString() + "Valor: R$" + valor);
            System.out.println("Aplição realizada com sucesso.");
        }
    }

    public boolean resgate(double valor){
        if (valor <= super.getSaldo()){
            super.setSaldo(-valor);
            super.setMovimentacoes("Resgate: Hora" + LocalDate.now().toString() + "Valor:" + valor);
            return true;
        }
        else
            return false;
    }
}
