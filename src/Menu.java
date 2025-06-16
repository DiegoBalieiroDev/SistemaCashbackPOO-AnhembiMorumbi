import java.util.Scanner;

public class Menu {

    public void iniciaMenu(){
        Scanner scan = new Scanner(System.in);
        SistemaBancario sistema = new SistemaBancario();

        int opcaomenu = 0;

        while (opcaomenu != 5) {
            System.out.println("\nDigite:\n(1) Cadastrar um cliente\n(2) Realizar um deposito\n(3) Realizar um saque\n(4) Realizar uma compra\n(5) Visualizar extrato \n(6) Para sair ");
            opcaomenu = scan.nextInt();
            scan.nextLine(); // Limpa o buffer

            if (opcaomenu == 1) {
                System.out.println("******************************");
                System.out.println("******Cadastrar Cliente*******");
                System.out.println("******************************");

                System.out.print("Nome: ");
                String nome = scan.nextLine();

                System.out.print("CPF: ");
                String cpf = scan.nextLine();

                System.out.print("Email: ");
                String email = scan.nextLine();

                System.out.print("Ano de nascimento: ");
                int anoNascimento = scan.nextInt();

                Cliente cliente = sistema.cadastrarCliente(nome, cpf, email, anoNascimento);
                // o nulo define o valor do metodo cadastrarCliente (se for menor que 18 anos retorna nulo e é negada a criacao da conta)
                 if (cliente != null) {
                     // puxa os valores com os getters
                    Conta conta = sistema.criarConta(cliente);
                    System.out.println("\nCadastro realizado com sucesso!");
                    System.out.println("Cliente: " + cliente.getNome());
                    System.out.println("Número da Conta: " + conta.getNumeroConta());
                    System.out.println("Saldo Inicial: " + conta.getSaldo());
                }
            }
            else if (opcaomenu == 2) {
                System.out.print("Digite o número da conta para depósito: ");
                String numConta = scan.nextLine();

                Conta contaSelecionada = sistema.buscarConta(numConta);

                // o nulo defino o valor do metodo buscarConta(se o valor registrado do cliente for igual ao informado
                if (contaSelecionada != null) {
                    System.out.print("Digite o valor para depósito: ");
                    double valor = scan.nextDouble();

                    contaSelecionada.realizaDeposito(valor);
                } else {
                    System.out.println("Conta não encontrada.");
                }
            }
            else if (opcaomenu == 3) {
                System.out.println("Digite o numero da conta para sacar: ");
                String numConta = scan.nextLine();

                Conta contaSelecionada = sistema.buscarConta(numConta);
                if (contaSelecionada != null) {
                    System.out.println("Digite o valor do saque: ");
                    double valor = scan.nextDouble();

                    contaSelecionada.realizarSaque(valor);
                } else {
                    System.out.println("Conta não encontrada.");
                }
            } else if (opcaomenu == 4) {
                System.out.print("Digite o número da conta para compra: ");
                String numConta = scan.nextLine();
                Conta contaSelecionada = sistema.buscarConta(numConta);

                if (contaSelecionada != null) {
                    System.out.print("Nome do produto: ");
                    String nomeProduto = scan.nextLine();
                    System.out.print("Valor do produto: ");
                    double valorProduto = scan.nextDouble();
                    contaSelecionada.fazCompra(nomeProduto, valorProduto);
                } else {
                    System.out.println("Conta não encontrada");
                }
            } else if (opcaomenu == 5) {
                System.out.println("Digite o numero da conta para para ver o extrato: ");
                String numConta = scan.nextLine();

                Conta contaSelecionada = sistema.buscarConta(numConta);
                if (contaSelecionada != null) {
                    contaSelecionada.mostrarExtrato();
                } else {
                    System.out.println("Conta não encontrada");
                }
            } else if (opcaomenu == 6) {
                System.out.println("Encerrando o sistema...");
                break;
            }
        }
    }
}
