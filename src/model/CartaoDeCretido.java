package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class CartaoDeCretido extends Conta {

    private double fatura;
    private ArrayList<String> faturaDetalhada = new ArrayList<>();

    public CartaoDeCretido(String nome, String cpf, double valorInicialSaldo){
        super.setNome(nome);
        super.setCpf(cpf);
        super.setSaldo(valorInicialSaldo);
    }

    public CartaoDeCretido() {}

    public double getFatura(){
        return this.fatura;
    }

    public void pagarCompra(double valor){
        if (valor < super.getSaldo()){
            super.setSaldo(-valor);
            super.setMovimentacoes("Compra Debito-> Hora: " + LocalDate.now().toString() + " Valor: R$" + valor);
        }
        else{
            fatura += valor;
            this.faturaDetalhada.add("Compra Crédito-> Hora: " + LocalDate.now().toString() + " Valor: R$" + valor);
        }
    }

    public void pagarFatura(double valor){
        if (valor <= super.getSaldo()){
            this.fatura -= valor;
            super.setSaldo(-valor);
            super.setMovimentacoes("Pagamento da fatura-> Hora: " + LocalDate.now().toString() + " Valor: R$" + valor);
            this.faturaDetalhada.add("Pagagamento da fatura-> Hora: " + LocalDate.now().toString() + " Valor: R$" + valor);
            System.out.println("Pagamento efetuado com sucesso:");
        }
        else
            System.out.println("Saldo insuficiente!");
    }

    public void faturaDetalhadaCompleta(){
        for (int i = 0; i < this.faturaDetalhada.size(); i++){
            System.out.println(i+1 + "º compra em crédito no mês: " + this.faturaDetalhada.get(i));
        }
    }

    public void faturaMes(){

    }
}
