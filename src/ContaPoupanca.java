import interfaces.Rendimento;

public class ContaPoupanca extends Conta implements Rendimento {

    @Override
    public double getRendimento() {
        return super.getSaldo() * TaxaJuros.getTaxa();
    }
}
