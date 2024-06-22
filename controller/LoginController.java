import java.util.Scanner;

public class LoginController {
    private UsuarioController usuarioController;
    private ClienteController clienteController;
    private FuncionarioController funcionarioController;
    private Scanner scanner;

    public LoginController(UsuarioController usuarioController, ClienteController clienteController, FuncionarioController funcionarioController, Scanner scanner) {
        this.usuarioController = usuarioController;
        this.clienteController = clienteController;
        this.funcionarioController = funcionarioController;
        this.scanner = scanner;
    }

    public void exibirMenuLogin() {
        System.out.println("Bem-vindo à Stream!");
        System.out.println("Opções de Login:");
        System.out.println("1. Cliente");
        System.out.println("2. Funcionário");
        System.out.println("3. Administrador");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        switch (opcao) {
            case 1:
                loginCliente();
                break;
            case 2:
                loginFuncionario();
                break;
            case 3:
                loginAdministrador();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                exibirMenuLogin();
                break;
        }
    }

    private void loginCliente() {
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Cliente clienteLogado = clienteController.loginCliente(email, senha);
        if (clienteLogado != null) {
            ClienteView clienteView = new ClienteView(clienteController, scanner, clienteLogado);
            clienteView.exibirMenuCliente();
        } else {
            System.out.println("Email ou senha incorretos. Tente novamente.");
            exibirMenuLogin();
        }
    }

    private void loginFuncionario() {
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Funcionario funcionarioLogado = funcionarioController.loginFuncionario(email, senha);
        if (funcionarioLogado != null) {
            FuncionarioView funcionarioView = new FuncionarioView(funcionarioController, scanner);
            funcionarioView.exibirMenuFuncionario();
        } else {
            System.out.println("Email ou senha incorretos. Tente novamente.");
            exibirMenuLogin();
        }
    }

    private void loginAdministrador() {
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        if (usuarioController.loginAdministrador(email, senha)) {
            AdministradorView administradorView = new AdministradorView(usuarioController, clienteController, funcionarioController, scanner);
            administradorView.exibirMenuAdministrador();
        } else {
            System.out.println("Email ou senha incorretos. Tente novamente.");
            exibirMenuLogin();
        }
    }
}
