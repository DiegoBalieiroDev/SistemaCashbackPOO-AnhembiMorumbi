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

    public Cliente cadastrarCliente(String nome, String cpf, String email, int anoNascimento) {
        int anoAtual = LocalDate.now().getYear();
        int idade = anoAtual - anoNascimento;

        if (idade < 18) {
            System.out.println("Cadastro negado! É necessário ser maior de idade para criar uma conta no banco.");
            return null;
        }
        Cliente cliente = new Cliente(nome, cpf, email, anoNascimento);
        clientes.add(cliente);
        return cliente;
    }

    public Conta criarConta(Cliente cliente) {
        Conta conta = new Conta("C" + (contas.size() + 1), cliente);
        cliente.getContas().add(conta);
        contas.add(conta);
        return conta;
    }

    public Conta buscarConta(String numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equalsIgnoreCase(numeroConta)) {
                return conta;
            }
        }
        return null;
    }
}
