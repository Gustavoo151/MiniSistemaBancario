package model;

import model.interfaces.Rendimento;

import java.time.LocalDate;

public class InvestimentoLci extends Conta implements Rendimento {

    public void resgate(Double valor){
        if (valor < super.getSaldo()){
            super.setSaldo(valor);
            super.setMovimentacoes("Resgate-> Hora: " + LocalDate.now().toString() + " Valor: " + valor);
        }
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
