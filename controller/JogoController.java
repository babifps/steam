package controller;

import model.Jogo;
import java.util.List;
import java.util.ArrayList;


public class JogoController {
    private List<Jogo> jogos = new ArrayList<>();

    public void criarJogo(Jogo jogo) {
        jogos.add(jogo);
    }

    public Jogo buscarJogoPorId(int id) {
        for (Jogo jogo : jogos) {
            if (jogo.getId() == id) {
                return jogo;
            }
        }
        return null;
    }

    public void atualizarJogo(Jogo jogo) {
        for (int i = 0; i < jogos.size(); i++) {
            if (jogos.get(i).getId() == jogo.getId()) {
                jogos.set(i, jogo);
                break;
            }
        }
    }

    public void deletarJogo(int id) {
        jogos.removeIf(jogo -> jogo.getId() == id);
    }
}
