import banco.entidades.Agencia;
import banco.entidades.Conta;
import banco.entidades.Extrato;
import banco.entidades.util.Data;

import java.util.Scanner;

public class ChatBoat {
    public static void main(String[] args) {
        CadastroSimples cadastro = new CadastroSimples();
        Scanner scanner = new Scanner(System.in);
        menuIncialLogica(scanner, cadastro);

        scanner.close();
    }

    public static void menuIncialLogica(Scanner scanner, CadastroSimples cadastro) {
        boolean sair = false;
        while (!sair) {
            exibirMenuInicial();
            int escolha = scanner.nextInt();
            scanner.nextLine();
            switch (escolha) {
                case 1:
                    cadastro.cadastroContaSimples(scanner);
                    break;
                case 2:
                    encontrarConta(scanner);
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Digite uma opção válida");
            }
        }
    }

    public static void exibirMenuConta(Conta conta, Scanner scanner) {
        while (true) {
            exibirMenuContas();
            int escolha = scanner.nextInt();
            scanner.nextLine();
            switch (escolha) {
                case 1:
                    System.out.println("Qual valor você quer depositar?");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    System.out.println("Valor depositado.");
                    break;
                case 2:
                    System.out.println("Qual valor você quer sacar?");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    System.out.println("Valor Sacado.");
                    break;
                case 3:
                    operacaoExtract(conta, scanner);
                    break;
                case 4:
                    operacaoTransfer(conta, scanner);
                    break;
                case 5:
                    System.out.println("Saldo atual: " + conta.getSaldo());
                    break;
                case 6:
                    Agencia.fecharCaixa();
                    return;
                default:
                    System.out.println("Digite uma opção válida");
            }
        }
    }

    public static void exibirMenuInicial() {
        System.out.println("========= Escolha uma das opções =========");
        System.out.println("(1). Para criar uma conta.");
        System.out.println("(2). Para buscar uma conta pelo número.");
        System.out.println("(3). Para Sair.");
        System.out.println("===========================================");
        System.out.print("Escolha uma opção: ");
    }

    public static void exibirMenuContas() {
        System.out.println("========= Menu da conta =========");
        System.out.println("1. Depositar");
        System.out.println("2. Sacar");
        System.out.println("3. Extrato");
        System.out.println("4. Transferir");
        System.out.println("5. Saldo");
        System.out.println("6. Sair da conta");
        System.out.println("================================");
        System.out.print("Escolha uma opção: ");
    }

    private static void encontrarConta(Scanner scanner) {
        System.out.println("Digite o número da conta:");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();
        Conta conta = Agencia.localizarConta(numeroConta);
        if (conta != null) {
            exibirMenuConta(conta, scanner);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public static void operacaoTransfer(Conta conta, Scanner scanner) {
        System.out.println("Qual valor você quer transferir?");
        double valorTransferencia = scanner.nextDouble();
        System.out.println("Digite o número da conta de destino:");
        int numeroDestino = scanner.nextInt();
        Conta contaDestino = Agencia.localizarConta(numeroDestino);
        if (contaDestino != null) {
            conta.transferir(contaDestino, valorTransferencia);
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Conta de destino não encontrada.");
        }
    }

    public static void operacaoExtract(Conta conta, Scanner scanner) {
        System.out.println("Extrato da conta:");
        System.out.println("Informe o dia de abertura do extrato:");
        int diaI = scanner.nextInt();
        System.out.println("Informe o mês de abertura do extrato:");
        int mesI = scanner.nextInt();
        System.out.println("Informe o ano de abertura do extrato:");
        int anoI = scanner.nextInt();
        System.out.println("Informe o dia de fechamento do extrato:");
        int diaF = scanner.nextInt();
        System.out.println("Informe o mês de fechamento do extrato:");
        int mesF = scanner.nextInt();
        System.out.println("Informe o ano de fechamento do extrato:");
        int anoF = scanner.nextInt();
        Data dataInit = new Data(diaI, mesI, anoI);
        Data dataFim = new Data(diaF, mesF, anoF);
        Extrato extrato = conta.criarExtrato(dataInit, dataFim);
        System.out.println(extrato.formatar());

    }

}
