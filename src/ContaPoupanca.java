import interfaces.Rendimento;

import java.time.LocalDate;

public class ContaPoupanca extends Conta implements Rendimento {

    public ContaPoupanca(){

    }

    public double getRendimento() {
        return super.getSaldo() * TaxaJuros.getTaxa();
    }

    public void aplicacao(double valor){
        if (valor > 0)
            super.setSaldo(valor);
        super.setMovimentacoes("Aplição: Hora" + LocalDate.now().toString() + "Valor:" + valor);

    }

    public void resgate(double valor){
        if (valor <= super.getSaldo()){
            super.setSaldo(valor);
            super.setMovimentacoes("Resgate: Hora" + LocalDate.now().toString() + "Valor:" + valor);
        }
    }
}
