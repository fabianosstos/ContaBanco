import java.util.Locale;

public class ContaBancaria {
    private String nomeTitular;
    private double saldo;

    // Construtor para criar uma nova conta
    public ContaBancaria(String nomeTitular) {
        this.nomeTitular = nomeTitular;
        this.saldo = 0.0;
    }

    // Método para depositar dinheiro
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("\nDepósito de R$ " + String.format(Locale.US, "%.2f", valor) + " realizado com sucesso.");
        } else {
            System.out.println("\nValor de depósito inválido.");
        }
    }

    // Método para sacar dinheiro
    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("\nSaque de R$ " + String.format(Locale.US, "%.2f", valor) + " realizado com sucesso.");
            return true; // Retorna true para indicar que o saque foi bem-sucedido
        } else if (valor > saldo) {
            System.out.println("\nSaldo insuficiente para realizar o saque.");
            return false;
        } else {
            System.out.println("\nValor de saque inválido.");
            return false;
        }
    }

    // Método para consultar o saldo
    public double getSaldo() {
        return saldo;
    }

    // Método para obter o nome do titular
    public String getNomeTitular() {
        return nomeTitular;
    }
}