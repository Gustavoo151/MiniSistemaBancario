package model;

public class TaxaJuros {
    private static double taxajuros = 0.10;

    public static double  getTaxa(){
        return taxajuros;
    }

    public void setTaxa(double juros){
        taxajuros = juros;
    }
}