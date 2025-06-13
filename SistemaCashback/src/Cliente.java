import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String cpf;
    private String email;
    private int anoNascimento;
    List<Conta> contas;

    public Cliente(String nome, String cpf, String email, int anoNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.anoNascimento = anoNascimento;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public List<Conta> getContas() {
        return contas;
    }
}
