package model;

import model.interfaces.Rendimento;

import java.time.LocalDate;

public class ContaCorrente extends Conta implements Rendimento {

    public ContaCorrente(String nome, String cpf, double valorInicialSaldo){
        super.setNome(nome);
        super.setCpf(cpf);
        super.setSaldo(valorInicialSaldo);
    }

    public ContaCorrente(){};

    public void setDeposito(double valor){
        if (valor > 0){
            super.setSaldo(valor);
            super.setMovimentacoes("Deposito-> Hora: " + LocalDate.now().toString() + " Valor: R$" + valor);
        }
    }

    public void saque(double valor){
        if (super.getSaldo() >= valor){
            super.setSaldo(-valor);
            super.setMovimentacoes("Saque-> Hora: " + LocalDate.now().toString() + " Valor: R$" + valor);
            System.out.printf("Saque no valor de R$%.2f efetuado.\n", valor);
        }
    }

    @Override
    public double getRendimento() {
        return TaxaJuros.getTaxa() * super.getSaldo();
    }

    public void tranferencia(double valor, int numeroContaTransferencia){
        if (valor <= super.getSaldo()){
            super.setSaldo(-valor);
            super.setMovimentacoes("Tranferencia-> Hora: " + LocalDate.now().toString() + " Valor: R$" + valor);
            System.out.printf("R$ %.2f transferido para a conta %d.\n", valor, numeroContaTransferencia);
        }
    }
}
