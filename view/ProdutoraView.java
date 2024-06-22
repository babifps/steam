package view;

import controller.ProdutoraController;
import model.Produtora;

public class ProdutoraView {
    public ProdutoraView() {
        new ProdutoraController();
    }

        public void exibirDetalhesProdutora(Produtora produtora) {
            System.out.println("Detalhes da Produtora:");
            System.out.println("ID: " + produtora.getId());
            System.out.println("Nome: " + produtora.getNome());
            System.out.println();
        }
    }    
    
