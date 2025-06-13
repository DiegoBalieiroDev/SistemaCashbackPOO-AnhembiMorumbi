public class CartaoDeCredito implements Comparable<CartaoDeCredito> {
    private int limite;
    private String nomeProduto;
    private int valorProduto;

    public CartaoDeCredito(String nomeProdutoproduto, int valorProduto) {
        this.nomeProduto = nomeProdutoproduto;
        this.valorProduto = valorProduto;
    }

    public int getValorProduto() {
        return valorProduto;
    }

    @Override
    public String toString() {
        return "Produto: " + nomeProduto + "(R$ " + valorProduto + ")";
    }

    @Override
    public int compareTo(CartaoDeCredito outraCompra) {
        return Integer.valueOf(this.valorProduto).compareTo(Integer.valueOf(outraCompra.valorProduto));
    }
}
