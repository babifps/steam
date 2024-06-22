package view;

import controller.ClienteController;
import model.Cliente;
import model.Compra;
import model.Jogo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ClienteView {
    private ClienteController clienteController;
    private Scanner scanner;

    public ClienteView() {
        this.clienteController = new ClienteController(); // Instanciação do controller
        this.scanner = new Scanner(System.in); // Scanner para entrada do usuário
    }

    public void adicionarJogoAoCarrinho(Cliente cliente, Jogo jogo) {
        clienteController.adicionarJogoAoCarrinho(cliente, jogo);
        System.out.println("Jogo adicionado ao carrinho com sucesso.");
    }

    public void finalizarCompra(Cliente cliente) {
        clienteController.finalizarCompra(cliente);
        System.out.println("Compra finalizada com sucesso.");
    }

    public void removerJogoDoCarrinho(Cliente cliente, Jogo jogo) {
        clienteController.removerJogoDoCarrinho(cliente, jogo);
        System.out.println("Jogo removido do carrinho com sucesso.");
    }

    public void exibirComprasDoCliente(Cliente cliente) {
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

    public void iniciar() {
        boolean sair = false;
        while (!sair) {
            System.out.println("===== Menu Cliente =====");
            System.out.println("1. Adicionar jogo ao carrinho");
            System.out.println("2. Finalizar compra");
            System.out.println("3. Remover jogo do carrinho");
            System.out.println("4. Exibir compras do cliente");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do jogo: ");
                    int idJogo = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    Jogo jogo = clienteController.buscarJogoPorId(idJogo);
                    if (jogo != null) {
                        adicionarJogoAoCarrinho(clienteController.getClienteLogado(), jogo);
                    } else {
                        System.out.println("Jogo não encontrado.");
                    }
                    break;
                case 2:
                    finalizarCompra(clienteController.getClienteLogado());
                    break;
                case 3:
                    // Lógica para remover jogo do carrinho
                    break;
                case 4:
                    exibirComprasDoCliente(clienteController.getClienteLogado());
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        System.out.println("Sessão encerrada.");
    }
}
