public class Cashback extends Transacao {

    public Cashback(double valor, TipoTransacao tipo, String nomeProduto) {
        super(valor, tipo, nomeProduto);
    }

    public Cashback(double valor, TipoTransacao tipo) {
        super(valor, tipo);
    }

    public Cashback(double valor, String descricao) {
        super(valor, TipoTransacao.CASHBACK, descricao);
    }

    public void processaCashback() {
        System.out.println("Cashback concedido: " + getNomeProduto() + " - R$ " + getValor());
    }
}
