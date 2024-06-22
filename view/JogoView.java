package view;

import controller.JogoController;
import model.Jogo;


public class JogoView {
    
    public JogoView() {
        new JogoController();
    }

    public void exibirDetalhesJogo(Jogo jogo) {
        System.out.println("Detalhes do Jogo:");
        System.out.println("ID: " + jogo.getId());
        System.out.println("Nome: " + jogo.getNome());
        System.out.println("ID da Produtora: " + jogo.getIdProdutora());
        System.out.println();
    }
}


