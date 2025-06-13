import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<CartaoDeCredito> listaProdutos = new LinkedList<>();

        System.out.println("Digite o limite do cartão: ");
        int limite = scan.nextInt();
        scan.nextLine();

        int saldo = limite;
        int sair = 1;

        while (sair != 0) {

            System.out.println("Produto: ");
            String nomeProduto = scan.nextLine();

            System.out.println("Valor do produto: ");
            int valorProduto = scan.nextInt();
            scan.nextLine();

            if (valorProduto > saldo) {
                System.out.println("Limite indisponível para a compra!");

            } else {
                saldo -= valorProduto;
                System.out.println("Produto comprado! Limite disponivel: " + saldo);
                listaProdutos.add(new CartaoDeCredito(nomeProduto, valorProduto));
            }

            System.out.println("(1) Para comprar | (0) Para sair");
            sair = scan.nextInt();
            scan.nextLine();  // corrige buffer para leitura no próximo loop
        }

        //Sem o compareTo pode ser utilizado apenas:
        // listaProdutos.sort(Comparator.comparing(CartaoDeCredito::getValorProduto)); // ordena pelo valor das compras
        Collections.sort(listaProdutos);
        System.out.println("**********************************");
        System.out.println("COMPRAS REALIZADAS:\n");
        for (CartaoDeCredito lista : listaProdutos) {
            System.out.println(lista);
        }
        System.out.println("\n**********************************");
        System.out.println("Saldo final do cartão: " + saldo);

    }
}
