import model.Cliente;
import model.Funcionario;
import model.Administrador;
import view.ClienteView;
import view.AdministradorView;
import view.FuncionarioView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Sistema de Gerenciamento de Jogos =====");
        System.out.println("Faça seu login:");

        // Realiza o login e obtém o tipo de usuário
        String tipoUsuario = realizarLogin(scanner);

        switch (tipoUsuario) {
            case "cliente":
                Cliente cliente = new Cliente(1, "Cliente1"); // Simulação de cliente logado
                ClienteView clienteView = new ClienteView();
                clienteView.menuCliente(cliente);
                break;
            case "administrador":
                AdministradorView administradorView = new AdministradorView();
                administradorView.menuAdministrador();
                break;
            case "funcionario":
                FuncionarioView funcionarioView = new FuncionarioView();
                funcionarioView.menuFuncionario();
                break;
            default:
                System.out.println("Tipo de usuário inválido. Encerrando o programa.");
                break;
        }

        scanner.close();
    }

    private static String realizarLogin(Scanner scanner) {
        System.out.println("Escolha o tipo de usuário:");
        System.out.println("1. Cliente");
        System.out.println("2. Administrador");
        System.out.println("3. Funcionário");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        switch (opcao) {
            case 1:
                // Implementar lógica para login do cliente
                return "cliente"; // Retornar "cliente" se o login for bem-sucedido
            case 2:
                // Implementar lógica para login do administrador
                return "administrador"; // Retornar "administrador" se o login for bem-sucedido
            case 3:
                // Implementar lógica para login do funcionário
                return "funcionario"; // Retornar "funcionario" se o login for bem-sucedido
            default:
                return "invalido"; // Caso a opção seja inválida
        }
    }
}
