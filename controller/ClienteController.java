package controller;

import model.Cliente;
import model.Compra;
import model.Jogo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteController {
    private List<Cliente> clientes;
    private Map<Integer, Jogo> jogos;
    private List<Compra> compras;
    private int proximoIdCompra; // Contador para gerar IDs de compra sequencialmente

    public ClienteController() {
        this.clientes = new ArrayList<>();
        this.jogos = new HashMap<>();
        this.compras = new ArrayList<>();
        this.proximoIdCompra = 1; // Inicia o ID de compra a partir de 1
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente getClienteLogado() {
        // Suponha que você tenha um método para obter o cliente logado
        // Implementação fictícia
        return null;
    }

    public void adicionarJogoAoCarrinho(Cliente cliente, Jogo jogo) {
        cliente.adicionarJogoNoCarrinho(jogo);
    }

    public void finalizarCompra(Cliente cliente, List<Jogo> jogosNoCarrinho) {
        double total = calcularTotalCompra(jogosNoCarrinho);
        Compra compra = new Compra(proximoIdCompra++, LocalDate.now(), total, cliente);
        compras.add(compra);
        cliente.limparCarrinho(); // Limpa o carrinho após finalizar a compra
    }

    public void removerJogoDoCarrinho(Cliente cliente, Jogo jogo) {
        cliente.removerJogoDoCarrinho(jogo);
    }

    public List<Compra> getComprasPorCliente(Cliente cliente) {
        List<Compra> comprasDoCliente = new ArrayList<>();
        for (Compra compra : compras) {
            if (compra.getCliente().equals(cliente)) {
                comprasDoCliente.add(compra);
            }
        }
        return comprasDoCliente;
    }

    public List<Compra> getTodasAsCompras() {
        return compras;
    }

    public Jogo buscarJogoPorId(int idJogo) {
        return jogos.get(idJogo);
    }

    private double calcularTotalCompra(List<Jogo> jogos) {
        double total = 0.0;
        for (Jogo jogo : jogos) {
            total += jogo.getPreco();
        }
        return total;
    }

    // Métodos adicionais para manipulação de clientes, jogos, etc., conforme necessário

}

