import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private double valor;
    private TipoTransacao tipo;
    private LocalDateTime dataHora;
    private String nomeProduto;

    public Transacao(double valor, TipoTransacao tipo) {
        this.valor = valor;
        this.tipo = tipo;
        // Registra a data e hora atual da transação
        this.dataHora = LocalDateTime.now();
    }

    public Transacao(double valor, TipoTransacao tipo, String nomeProduto) {
        this.valor = valor;
        this.tipo = tipo;
        this.nomeProduto = nomeProduto;
        this.dataHora = LocalDateTime.now();
    }

    // definir como será exibido as informaçoes de data e hora
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public String getDataFormatada() {
        return dataHora.format(FORMATTER); // Formata para dd/MM/yyyy HH:mm:ss
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
