import java.util.Scanner;

import banco.entidades.Agencia;
import banco.entidades.ContaSimples;

public class CadastroSimples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastroSimples cadastro = new CadastroSimples();
        cadastro.cadastroContaSimples(scanner);
        scanner.close();
    }

    public static String lerEntradaDoUsuario(Scanner scanner) {
        return scanner.nextLine();
    }

    public void cadastroContaSimples(Scanner scanner) {

        String nome, cpf;
        System.out.print("Digite o nome completo: ");
        nome = lerEntradaDoUsuario(scanner);
        System.out.print("Digite o CPF: ");
        cpf = lerEntradaDoUsuario(scanner);
        System.out.println();
        ContaSimples umaConta = new ContaSimples(nome, cpf);
        Agencia.addConta(umaConta);

        System.out.println("Conta adicionada! Seu número de conta é " + umaConta.getNúmero());
    }
}