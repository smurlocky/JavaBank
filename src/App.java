import java.util.Scanner;

public class App {
    static CadastroSimples cadastro = new CadastroSimples();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcoes;

        System.out.println("##--Menu Principal--##\n");
        System.out.println("|--------------------------------|");
        System.out.println("| Opção 1 - Cadastrar Conta      |");
        System.out.println("| Opção 2 - Outra Funcionalidade |");
        System.out.println("| Opção 3 - Sair                 |");
        System.out.println("|--------------------------------|");
        System.out.print("Digite uma opção: ");

        opcoes = scanner.nextInt();
        scanner.nextLine();

        switch (opcoes) {
            case 1:
                cadastro.cadastroContaSimples(scanner);
                break;

            default:
                break;
        }

        scanner.close();
    }
}
