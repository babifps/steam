package view;

import controller.ClienteController;
import model.Cliente;
import model.Compra;
import model.Jogo;

import java.util.List;
import java.util.Scanner;

public class ClienteView {
    private ClienteController clienteController;
    private Scanner scanner;

    public ClienteView() {
        this.clienteController = new ClienteController(); // Instanciação do controller
        this.scanner = new Scanner(System.in); // Scanner para entrada do usuário
    }

    public void verJogosDisponiveis() {
        List<Jogo> jogosDisponiveis = clienteController.listarJogosDisponiveis();
        System.out.println("===== Jogos Disponíveis =====");
        for (Jogo jogo : jogosDisponiveis) {
            System.out.println("ID: " + jogo.getId() + ", Nome: " + jogo.getNome());
            // Adicionar mais detalhes se necessário
        }
        System.out.println();
        System.out.println("Digite o ID do jogo para adicionar ao carrinho (ou 0 para voltar): ");
        int idJogo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        if (idJogo != 0) {
            Jogo jogoSelecionado = clienteController.buscarJogoPorId(idJogo);
            if (jogoSelecionado != null) {
                adicionarJogoAoCarrinho(clienteController.getClienteLogado(), jogoSelecionado);
            } else {
                System.out.println("Jogo não encontrado.");
            }
        }
    }

    public void verCarrinho() {
        Cliente cliente = clienteController.getClienteLogado();
        List<Jogo> itensCarrinho = clienteController.listarItensCarrinho(cliente);
        double totalCompra = clienteController.calcularTotalCompra(cliente);

        if (itensCarrinho.isEmpty()) {
            System.out.println("Carrinho vazio.");
        } else {
            System.out.println("===== Carrinho de Compras =====");
            for (Jogo jogo : itensCarrinho) {
                System.out.println("ID: " + jogo.getId() + ", Nome: " + jogo.getNome());
                // Adicionar mais detalhes se necessário
            }
            System.out.println("Total da Compra: R$ " + totalCompra);
            System.out.println();
            System.out.println("1. Finalizar Compra");
            System.out.println("2. Remover Item do Carrinho");
            System.out.println("3. Limpar Carrinho");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    finalizarCompra(cliente);
                    break;
                case 2:
                    System.out.print("Digite o ID do jogo para remover do carrinho: ");
                    int idJogo = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    Jogo jogoRemover = clienteController.buscarJogoPorId(idJogo);
                    if (jogoRemover != null) {
                        removerJogoDoCarrinho(cliente, jogoRemover);
                    } else {
                        System.out.println("Jogo não encontrado no carrinho.");
                    }
                    break;
                case 3:
                    clienteController.limparCarrinho(cliente);
                    System.out.println("Carrinho limpo com sucesso.");
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public void verMeusJogos() {
        Cliente cliente = clienteController.getClienteLogado();
        List<Jogo> meusJogos = clienteController.listarCompras(cliente);

        if (meusJogos.isEmpty()) {
            System.out.println("Você ainda não comprou nenhum jogo.");
        } else {
            System.out.println("===== Meus Jogos =====");
            for (Jogo jogo : meusJogos) {
                System.out.println("ID: " + jogo.getId() + ", Nome: " + jogo.getNome());
                // Adicionar mais detalhes se necessário
            }
        }
    }

    public void iniciar() {
        boolean sair = false;
        while (!sair) {
            System.out.println("===== Menu Cliente =====");
            System.out.println("1. Ver Jogos Disponíveis");
            System.out.println("2. Ver Carrinho");
            System.out.println("3. Ver Meus Jogos");
            System.out.println("4. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    verJogosDisponiveis();
                    break;
                case 2:
                    verCarrinho();
                    break;
                case 3:
                    verMeusJogos();
                    break;
                case 4:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        System.out.println("Sessão encerrada.");
    }

    private void adicionarJogoAoCarrinho(Cliente cliente, Jogo jogo) {
        clienteController.adicionarJogoAoCarrinho(cliente, jogo);
        System.out.println("Jogo adicionado ao carrinho com sucesso.");
    }

    private void finalizarCompra(Cliente cliente) {
        clienteController.finalizarCompra(cliente);
        System.out.println("Compra finalizada com sucesso.");
    }

    private void removerJogoDoCarrinho(Cliente cliente, Jogo jogo) {
        clienteController.removerJogoDoCarrinho(cliente, jogo);
        System.out.println("Jogo removido do carrinho com sucesso.");
    }

    private void exibirComprasDoCliente(Cliente cliente) {
        List<Compra> compras = clienteController.getComprasPorCliente(cliente);
        if (compras.isEmpty()) {
            System.out.println("Nenhuma compra realizada pelo cliente.");
        } else {
            System.out.println("Compras realizadas pelo cliente:");
            for (Compra compra : compras) {
                System.out.println("ID: " + compra.getId());
                System.out.println("Data: " + compra.getData());
                // Outros detalhes da compra, se houver
                System.out.println();
            }
        }
    }
}
