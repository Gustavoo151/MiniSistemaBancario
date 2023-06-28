package model;

import model.interfaces.Rendimento;

import java.time.LocalDate;

public class InvestimentoLci extends Conta implements Rendimento {

    public InvestimentoLci(String nome, String cpf, double valorInicialSaldo){
        super.setNome(nome);
        super.setCpf(cpf);
        super.setSaldo(valorInicialSaldo);
    }

    public InvestimentoLci(){}

    public boolean resgate(Double valor){
        if (valor < super.getSaldo()){
            super.setSaldo(-valor);
            super.setMovimentacoes("Resgate-> Hora: " + LocalDate.now().toString() + " Valor: " + valor);
            return true;
        }
        else
            return false;
    }

    public void SetAporte(double valor){
        if(valor > 0){
            super.setSaldo(valor);
            super.setMovimentacoes("Aporte-> Hora: " + LocalDate.now().toString() + " Valor: " + valor);
        }
    }

    @Override
    public double getRendimento() {
        return TaxaJuros.getTaxa() * super.getSaldo();
    }
}
