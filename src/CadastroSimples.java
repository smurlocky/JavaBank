import java.util.Scanner;

import banco.entidades.ContaSimples;

public class CadastroSimples {
    public static void main(String[] args) {
        CadastroSimples cadastro = new CadastroSimples();
        cadastro.cadastroContaSimples();
    }

    public void cadastroContaSimples() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do titular:");
        String nomeTitular = scanner.nextLine();

        System.out.println("Digite o CPF do titular da conta: ");
        String cpfTitular = scanner.next();

        ContaSimples conta = new ContaSimples(nomeTitular, cpfTitular);

        System.out.println("Conta criada:");
        System.out.println("Nome do titular: " + conta.getNome());
        System.out.println("CPF do titular: " + conta.getCPF());

        // Lembre-se de fechar o Scanner
        scanner.close();
    }
}