import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaBancario {

    private List<Cliente> clientes;
    private List<Conta> contas;

    public SistemaBancario() {
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    // recebe dados do cliente( nome, copf, email e anoNascimento), se for menor de 18 anos retorna nulo e a conta não é criada
    public Cliente cadastrarCliente(String nome, String cpf, String email, int anoNascimento) {
        int anoAtual = LocalDate.now().getYear();
        int idade = anoAtual - anoNascimento;

        if (idade < 18) {
            System.out.println("Cadastro negado! É necessário ser maior de idade para criar uma conta no banco.");
            return null;
        }
        // Caso o cliente for criado é instanciado da classe Cliente um novo objeto "cliente" e adicionado a lista de clientes.
        Cliente cliente = new Cliente(nome, cpf, email, anoNascimento);
        clientes.add(cliente);
        return cliente;
    }

    // Metodo que cria um novo objeto da classe Conta, com base na letra "C" + tamanho da lista de contas + 1, adicionando cliente a lista de contas
    public Conta criarConta(Cliente cliente) {
        Conta conta = new Conta("C" + (contas.size() + 1), cliente);
        cliente.getContas().add(conta);
        contas.add(conta);
        return conta;
    }

    //  Metodo que vai percorrer com o loop(for) a listas "contas" do objeto Conta, caso nao encontrar nenhuma conta retorna nulo.
    public Conta buscarConta(String numeroConta) {
        for (Conta conta : contas) {
            // Se o numero da conta registrado for = numero da conta informado continua a execucao
            if (conta.getNumeroConta().equalsIgnoreCase(numeroConta)) {
                return conta;
            }
        }
        return null;
    }
}
