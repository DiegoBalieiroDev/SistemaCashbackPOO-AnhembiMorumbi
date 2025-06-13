import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta {

    private String numeroConta;
    private double saldo;
    private Cliente titular;
    private List<Transacao> transacoes;

    public Conta(String numeroConta, Cliente titular) {
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
        this.titular = titular;
        this.transacoes = new ArrayList<>();
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void realizaDeposito(double valor){
        if (valor <= 0) {
            System.out.println("O depósito não pode ser igual ou menor que 0.");
            return;
        }

        saldo += valor;

        Transacao transacao = new Transacao(valor, TipoTransacao.DEPOSITO);
        transacoes.add(transacao);
        System.out.println("Depósito de R$: " + valor + " realizado com sucesso.\nSaldo atual: " + saldo);
    }

    public void realizarSaque(double valor){
        if (valor > saldo) {
            System.out.println("Não é possível sacar um valor superior ao saldo da conta.");
            return;
        }
        saldo -= valor;
        Transacao transacao = new Transacao(valor, TipoTransacao.SAQUE);
        transacoes.add(transacao);
        System.out.println("Saque no valor de R$ " + valor + " foi realizado.\nSaldo atual: " + saldo);

    }

    public void fazCompra(String produtoComprado, double valorProduto) {
        if (valorProduto > saldo) {
            System.out.println("Saldo insuficiente para realizar a compra.");
            return;
        }

        saldo -= valorProduto;
        Transacao compra = new Transacao(valorProduto, TipoTransacao.COMPRA, produtoComprado);
        transacoes.add(compra);

        // Cashback de 5%
        double cashbackValor = valorProduto * 0.05;
        saldo += cashbackValor;
        Cashback cashback = new Cashback(cashbackValor, "Cashback de compra: " + produtoComprado);
        transacoes.add(cashback);
        cashback.processaCashback();
    }

    public void mostrarExtrato() {
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação encontrada");
            return;
        }
        System.out.println("Extrato da conta " + numeroConta + " :");
        for (Transacao transacoes : transacoes) {
            String extrato = transacoes.getTipo() + " de R$ " + transacoes.getValor();
            if (transacoes.getTipo() == TipoTransacao.COMPRA || transacoes.getTipo() == TipoTransacao.CASHBACK) {
                extrato += " - " + transacoes.getNomeProduto();
            }
            extrato += " - " + transacoes.getDataFormatada();
            System.out.println(extrato);
        }
        System.out.println("Saldo atual: R$ " + saldo);
    }


}
