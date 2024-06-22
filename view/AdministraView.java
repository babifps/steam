import java.util.Scanner;
import controller.UsuarioController;
import model.Cliente;
import model.Funcionario;
import model.Jogo;
import model.Produtora;
import java.util.List;

public class AdministradorView {

    private UsuarioController usuarioController;
    private Scanner scanner;}

    public AdministradorView() {
        this.usuarioController = new UsuarioController();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarVisaoGeral() {
        int totalClientes = usuarioController.contarClientes();
        int totalFuncionarios = usuarioController.contarFuncionarios();

        System.out.println("Visão Geral:");
        System.out.println("Total de Clientes: " + totalClientes);
        System.out.println("Clientes:");

        List<Cliente> clientes = usuarioController.listarClientes();
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + ", Nome: " + cliente.getNome());
        }

        System.out.println();
        System.out.println("Total de Funcionários: " + totalFuncionarios);
        System.out.println("Funcionários:");

        List<Funcionario> funcionarios = usuarioController.listarFuncionarios();
        for (Funcionario funcionario : funcionarios) {
            System.out.println("ID: " + funcionario.getId() + ", Nome: " + funcionario.getNome());
        }
    }

    public void exibirMenuAdministrador() {
        boolean sair = false;
        while (!sair) {
            System.out.println("===== Menu Administrador =====");
            System.out.println("1. Ver Visão Geral");
            System.out.println("2. Gerenciar Clientes");
            System.out.println("3. Gerenciar Funcionários");
            System.out.println("4. Gerenciar Jogos");
            System.out.println("5. Gerenciar Produtoras");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    mostrarVisaoGeral();
                    break;
                case 2:
                    menuClientes();
                    break;
                case 3:
                    menuFuncionarios();
                    break;
                case 4:
                    menuJogos();
                    break;
                case 5:
                    menuProdutoras();
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        System.out.println("Encerrando sessão do administrador.");
    }

    private void menuClientes() {
        boolean sair = false;
        while (!sair) {
            System.out.println("===== Menu Clientes =====");
            System.out.println("1. Listar Clientes");
            System.out.println("2. Adicionar Cliente");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Remover Cliente");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    listarClientes();
                    break;
                case 2:
                    adicionarCliente();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    removerCliente();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void menuFuncionarios() {
        boolean sair = false;
        while (!sair) {
            System.out.println("===== Menu Funcionários =====");
            System.out.println("1. Listar Funcionários");
            System.out.println("2. Adicionar Funcionário");
            System.out.println("3. Atualizar Salário de Funcionário");
            System.out.println("4. Remover Funcionário");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    listarFuncionarios();
                    break;
                case 2:
                    adicionarFuncionario();
                    break;
                case 3:
                    atualizarSalarioFuncionario();
                    break;
                case 4:
                    removerFuncionario();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void menuJogos() {
        boolean sair = false;
        while (!sair) {
            System.out.println("===== Menu Jogos =====");
            System.out.println("1. Listar Jogos");
            System.out.println("2. Cadastrar Novo Jogo");
            System.out.println("3. Atualizar Jogo");
            System.out.println("4. Remover Jogo");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    listarJogos();
                    break;
                case 2:
                    cadastrarNovoJogo();
                    break;
                case 3:
                    atualizarJogo();
                    break;
                case 4:
                    removerJogo();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void menuProdutoras() {
        boolean sair = false;
        while (!sair) {
            System.out.println("===== Menu Produtoras =====");
            System.out.println("1. Listar Produtoras");
            System.out.println("2. Cadastrar Nova Produtora");
            System.out.println("3. Atualizar Produtora");
            System.out.println("4. Remover Produtora");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    listarProdutoras();
                    break;
                case 2:
                    cadastrarNovaProdutora();
                    break;
                case 3:
                    atualizarProdutora();
                    break;
                case 4:
                    removerProdutora();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void listarClientes() {
        List<Cliente> clientes = usuarioController.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
        } else {
            System.out.println("Lista de Clientes:");
            for (Cliente cliente : clientes) {
                System.out.println("ID: " + cliente.getId() + ", Nome: " + cliente.getNome());
            }
        }
    }

    private void adicionarCliente() {
        System.out.println("===== Adicionar Novo Cliente =====");
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        Cliente novoCliente = new Cliente(nome);
        usuarioController.adicionarCliente(novoCliente);
        System.out.println("Cliente adicionado com sucesso.");
    }

    private void atualizarCliente() {
        System.out.println("===== Atualizar Cliente =====");
        System.out.print("Digite o ID do cliente a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Cliente cliente = usuarioController.buscarClientePorId(id);
        if (cliente != null) {
            System.out.print("Digite o novo nome do cliente (ou deixe em branco para manter o mesmo): ");
            String novoNome = scanner.nextLine().trim();
            if (!novoNome.isEmpty()) {
                cliente.setNome(novoNome);
            }
            usuarioController.atualizarCliente(cliente);
            System.out.println("Cliente atualizado com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void removerCliente() {
        System.out.println("===== Remover Cliente =====");
        System.out.print("Digite o ID do cliente a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Cliente cliente = usuarioController.buscarClientePorId(id);
        if (cliente != null) {
            usuarioController.removerCliente(cliente);
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void listarFuncionarios() {
        List<Funcionario> funcionarios = usuarioController.listarFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else }
           
