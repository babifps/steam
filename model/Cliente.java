// Model/Cliente.java
package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private String nome; // Adicionando o atributo nome
    private String email;
    private String senha;
    private List<Compra> compras = new ArrayList<>();
    private List<Jogo> carrinho = new ArrayList<>();

    public Cliente(int id, String nome, String email, String senha) {
        super(id, nome);
        this.nome = nome; // Inicializando o atributo nome
        this.email = email;
        this.senha = senha;
    }

    // Método para obter o nome do cliente
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void comprarJogo(Compra compra) {
        compras.add(compra);
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void adicionarAoCarrinho(Jogo jogo) {
        carrinho.add(jogo);
    }

    public List<Jogo> getCarrinho() {
        return carrinho;
    }

    public void limparCarrinho() {
        carrinho.clear();
    }

    @Override
    public void atualizarInformacoes() {
        // Implementação da atualização das informações do cliente
    }
}
