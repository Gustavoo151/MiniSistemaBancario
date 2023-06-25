package model;

import model.interfaces.Rendimento;

import java.time.LocalDate;

public class ContaCorrente extends Conta implements Rendimento {

    public void setDeposito(double valor){
        if (valor > 0){
            super.setSaldo(valor);
            super.setMovimentacoes("Deposito-> Hora: " + LocalDate.now().toString() + " Valor: " + valor);
        }
    }

    public void saque(double valor){
        if (super.getSaldo() >= valor){
            super.setSaldo(valor);
            super.setMovimentacoes("Saque-> Hora: " + LocalDate.now().toString() + " Valor: " + valor);
        }
    }

    @Override
    public double getRendimento() {
        return TaxaJuros.getTaxa() * super.getSaldo();
    }

    public void tranferencia(double valor, int numeroContaTransferencia){
        if (valor > super.getSaldo()){
            super.setSaldo(valor);
            System.out.printf("R$ %f transferido para a conta %d", valor, numeroContaTransferencia);
        }
    }
}
