import java.util.Scanner;
import controller.FuncionarioController;
import model.Funcionario;
import model.Jogo;
import model.Produtora;
import model.Cliente;
import java.util.List;

public class FuncionarioView {

    private FuncionarioController funcionarioController;
    private Scanner scanner;

    public FuncionarioView(FuncionarioController funcionarioController) {
        this.funcionarioController = funcionarioController;
        this.scanner = new Scanner(System.in);
    }

    public void exibirDetalhesFuncionario(int idFuncionario) {
        Funcionario funcionario = funcionarioController.buscarFuncionarioPorId(idFuncionario);
        if (funcionario != null) {
            System.out.println("Detalhes do Funcionário:");
            System.out.println("ID: " + funcionario.getId());
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Salário: " + funcionario.getSalario());
            System.out.println();
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public void listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("Lista de Funcionários:");
            for (Funcionario funcionario : funcionarios) {
                System.out.println("ID: " + funcionario.getId() + ", Nome: " + funcionario.getNome() + ", Salário: " + funcionario.getSalario());
            }
        }
    }

    public void exibirMenuFuncionario() {
        boolean sair = false;
        while (!sair) {
            System.out.println("===== Menu Funcionário =====");
            System.out.println("1. Gerenciar Jogos");
            System.out.println("2. Gerenciar Produtoras");
            System.out.println("3. Gerenciar Clientes");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    menuJogos();
                    break;
                case 2:
                    menuProdutoras();
                    break;
                case 3:
                    menuClientes();
                    break;
                case 4:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        System.out.println("Encerrando sessão do funcionário.");
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

    private void menuClientes() {
        boolean sair = false;
        while (!sair) {
            System.out.println("===== Menu Clientes =====");
            System.out.println("1. Listar Clientes");
            System.out.println("2. Cadastrar Novo Cliente");
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
                    cadastrarNovoCliente();
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

    private void listarJogos() {
        List<Jogo> jogos = funcionarioController.listarJogos();
        if (jogos.isEmpty()) {
            System.out.println("Não há jogos cadastrados.");
        } else {
            System.out.println("Lista de Jogos:");
            for (Jogo jogo : jogos) {
                System.out.println("ID: " + jogo.getId() + ", Nome: " + jogo.getNome() + ", Preço: " + jogo.getPreco());
            }
        }
    }

    private void listarProdutoras() {
        List<Produtora> produtoras = funcionarioController.listarProdutoras();
        if (produtoras.isEmpty()) {
            System.out.println("Não há produtoras cadastradas.");
        } else {
            System.out.println("Lista de Produtoras:");
            for (Produtora produtora : produtoras) {
                System.out.println("ID: " + produtora.getId() + ", Nome: " + produtora.getNome());
            }
        }
    }

    private void listarClientes() {
        List<Cliente> clientes = funcionarioController.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
        } else {
            System.out.println("Lista de Clientes:");
            for (Cliente cliente : clientes) {
                System.out.println("ID: " + cliente.getId() + ", Nome: " + cliente.getNome() + ", Email: " + cliente.getEmail() + ", Telefone: " + cliente.getTelefone());
            }
        }
    }

    private void cadastrarNovoJogo() {
        System.out.println("===== Cadastrar Novo Jogo =====");
        System.out.print("Digite o nome do jogo: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço do jogo: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do scanner

        Jogo novoJogo = new Jogo(nome, preco);
        funcionarioController.cadastrarNovoJogo(novoJogo);
        System.out.println("Jogo cadastrado com sucesso.");
    }

    private void atualizarJogo() {
        System.out.println("===== Atualizar Jogo =====");
        System.out.print("Digite o ID do jogo a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Jogo jogo = funcionarioController.buscarJogoPorId(id);
        if (jogo != null) {
            System.out.print("Digite o novo nome do jogo (ou deixe em branco para manter o mesmo): ");
            String novoNome = scanner.nextLine().trim();
            if (!novoNome.isEmpty()) {
                jogo.setNome(novoNome);
            }
            System.out.print("Digite o novo preço do jogo (ou deixe 0 para manter o mesmo): ");
            double novoPreco = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer do scanner
            if (novoPreco != 0) {
                jogo.setPreco(novoPreco);
            }
            funcionarioController.atualizarJogo(jogo);
            System.out.println("Jogo atualizado com sucesso.");
        } else {
            System.out.println("Jogo não encontrado.");
        }
    }

    private
