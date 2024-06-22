package controller;

import java.util.ArrayList;
import java.util.List;

import model.Produtora;


public class ProdutoraController {

    private List<Produtora> produtoras = new ArrayList<>();

    public void criarProdutora(Produtora produtora) {
        produtoras.add(produtora);
    }

    public Produtora buscarProdutoraPorId(int id) {
        for (Produtora produtora : produtoras) {
            if (produtora.getId() == id) {
                return produtora;
            }
        }
        return null;
    }

    public void atualizarProdutora(Produtora produtora) {
        for (int i = 0; i < produtoras.size(); i++) {
            if (produtoras.get(i).getId() == produtora.getId()) {
                produtoras.set(i, produtora);
                break;
            }
        }
    }

    public void deletarProdutora(int id) {
        produtoras.removeIf(produtora -> produtora.getId() == id);
    }
}
