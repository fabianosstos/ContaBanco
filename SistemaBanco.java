import java.util.Locale;
import java.util.Scanner;

public class SistemaBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Bem-vindo ao Sistema Bancário!");

        // Cadastro do nome do titular
        System.out.print("Por favor, digite o nome do titular da conta: ");
        String nomeTitular = scanner.nextLine();
        
        ContaBancaria conta = new ContaBancaria(nomeTitular);
        System.out.println("\nConta de " + conta.getNomeTitular() + " cadastrada com sucesso!");

        int opcao = -1;

        // Loop principal do menu
        while (opcao != 0) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Consultar Saldo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            // Tratamento para entrada de dados não numéricos
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner
            } else {
                System.out.println("\nOpção inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpar o buffer
                continue; // Pula para a próxima iteração do loop
            }

            switch (opcao) {
                case 1:
                    // Opção de Depósito
                    System.out.print("\nDigite o valor a ser depositado: R$ ");
                    if (scanner.hasNextDouble()) {
                        double valorDeposito = scanner.nextDouble();
                        conta.depositar(valorDeposito);
                        scanner.nextLine(); // Limpar o buffer
                        
                        // Pergunta se deseja verificar o saldo
                        System.out.print("\nDeseja verificar o seu saldo? (S/N): ");
                        String verificarSaldo = scanner.nextLine().toLowerCase();
                        if (verificarSaldo.equals("s")) {
                            System.out.println("Seu saldo atual é de R$ " + String.format(Locale.US, "%.2f", conta.getSaldo()));
                        }
                    } else {
                        System.out.println("\nValor inválido. Tente novamente.");
                        scanner.nextLine(); // Limpar o buffer
                    }
                    break;
                case 2:
                    // Opção de Saque
                    System.out.print("\nDigite o valor a ser sacado: R$ ");
                    if (scanner.hasNextDouble()) {
                        double valorSaque = scanner.nextDouble();
                        conta.sacar(valorSaque);
                        scanner.nextLine(); // Limpar o buffer
                    } else {
                        System.out.println("\nValor inválido. Tente novamente.");
                        scanner.nextLine(); // Limpar o buffer
                    }
                    break;
                case 3:
                    // Opção de Consultar Saldo
                    if (conta.getSaldo() == 0) {
                        System.out.println("\nSaldo insuficiente. Saldo atual: R$ 0.00");
                    } else {
                        System.out.println("\nSeu saldo atual é de R$ " + String.format(Locale.US, "%.2f", conta.getSaldo()));
                    }
                    break;
                case 0:
                    // Opção de Sair
                    System.out.println("\nObrigado por usar nosso sistema. Até mais!");
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}