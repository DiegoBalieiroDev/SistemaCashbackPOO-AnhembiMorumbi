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

    // Metodo para realizar compras no sistema
    public void fazCompra(String produtoComprado, double valorProduto) {
        // Se o saldo for menor que o valor do produto a compra é negada.
        if (valorProduto > saldo) {
            System.out.println("Saldo insuficiente para realizar a compra.");
            return;
        }
        // Caso o saldo seja suficiente o valor do produto é debitado do saldo
        saldo -= valorProduto;
        // É instanciada a classe Transacao com uma compra e adicionado a lista de transacoes da compra.
        Transacao compra = new Transacao(valorProduto, TipoTransacao.COMPRA, produtoComprado);
        transacoes.add(compra);

        // é definido o cashback de 5% e adicionado ao saldo
        double cashbackValor = valorProduto * 0.05;
        saldo += cashbackValor;
        // Instancia a classe Cashback, criando um novo "cashback" e adicionado a lista de transacoes
        Cashback cashback = new Cashback(cashbackValor, "Cashback de compra: " + produtoComprado);
        transacoes.add(cashback);
        cashback.processaCashback();
    }

    // mostra o extrato da conta, se a lista de transacoes estiver vazia, informa que não há transacoes.
    public void mostrarExtrato() {
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação encontrada");
            return;
        }
        // Caso encontre transacoes de determinada conta --> irá informar o numero da conta
        System.out.println("Extrato da conta " + numeroConta + " :");
        // O loop percorre a lista de transacoes da classe Transacao, definindo cada linha como: tipo de transacao + valor da transacao
        for (Transacao transacoes : transacoes) {
            String extrato = transacoes.getTipo() + " de R$ " + transacoes.getValor();
            // Se o tipo de transacao for = COMPRA OU for = CASHBACK é adicionado na linha do extrado o nome do produto
            if (transacoes.getTipo() == TipoTransacao.COMPRA || transacoes.getTipo() == TipoTransacao.CASHBACK) {
                extrato += " - " + transacoes.getNomeProduto();
            }
            // Por fim é adicionado na linha de extrato as informacoes de data e hora
            extrato += " - " + transacoes.getDataFormatada();
            System.out.println(extrato);
        }
        System.out.println("Saldo atual: R$ " + saldo);
    }


}
