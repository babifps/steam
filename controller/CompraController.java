package controller;

import model.Cliente;
import model.Compra;
import model.Jogo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private List<Cliente> clientes;
    private int proximoIdCliente;

    public ClienteController() {
        this.clientes = new ArrayList<>();
        this.proximoIdCliente = 1; // Inicializa o ID para clientes
    }

    public Cliente cadastrarCliente(String nome) {
        Cliente cliente = new Cliente(proximoIdCliente++, nome);
        clientes.add(cliente);
        return cliente;
    }

    public Cliente getClienteLogado() {
        // Suponha que você tenha um método para obter o cliente logado
        // Implementação fictícia
        return null;
    }

    public void adicionarJogoAoCarrinho(Cliente cliente, Jogo jogo) {
        cliente.adicionarAoCarrinho(jogo);
    }

    public void finalizarCompra(Cliente cliente) {
        List<Jogo> carrinho = cliente.getCarrinho();
        if (!carrinho.isEmpty()) {
            Compra compra = new Compra(proximoIdCliente++, LocalDateTime.now(), carrinho);
            cliente.comprarJogo(compra);
            cliente.limparCarrinho();
        }
    }

    public void removerJogoDoCarrinho(Cliente cliente, Jogo jogo) {
        cliente.getCarrinho().remove(jogo);
    }

    public List<Compra> getComprasPorCliente(Cliente cliente) {
        return cliente.getCompras();
    }

    public Jogo buscarJogoPorId(int idJogo) {
        // Implementação fictícia para buscar jogo por ID
        return null;
    }
}
