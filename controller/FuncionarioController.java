public class FuncionarioController {
    private List<Jogo> jogos;
    private List<Produtora> produtoras;

    public FuncionarioController() {
        this.jogos = new ArrayList<>();
        this.produtoras = new ArrayList<>();
    }

    // Métodos para Jogo
    public void cadastrarNovoJogo(Jogo jogo) {
        jogos.add(jogo);
    }

    public void atualizarJogo(Jogo jogoAtualizado) {
        for (Jogo jogo : jogos) {
            if (jogo.getId() == jogoAtualizado.getId()) {
                jogo.setNome(jogoAtualizado.getNome());
                jogo.setPreco(jogoAtualizado.getPreco());
                break;
            }
        }
    }

    public void removerJogo(Jogo jogo) {
        jogos.remove(jogo);
    }

    public List<Jogo> listarJogos() {
        return jogos;
    }

    public Jogo buscarJogoPorId(int id) {
        for (Jogo jogo : jogos) {
            if (jogo.getId() == id) {
                return jogo;
            }
        }
        return null;
    }

    // Métodos para Produtora
    public void cadastrarNovaProdutora(Produtora produtora) {
        produtoras.add(produtora);
    }

    public void atualizarProdutora(Produtora produtoraAtualizada) {
        for (Produtora produtora : produtoras) {
            if (produtora.getId() == produtoraAtualizada.getId()) {
                produtora.setNome(produtoraAtualizada.getNome());
                break;
            }
        }
    }

    public void removerProdutora(Produtora produtora) {
        produtoras.remove(produtora);
    }

    public List<Produtora> listarProdutoras() {
        return produtoras;
    }

    public Produtora buscarProdutoraPorId(int id) {
        for (Produtora produtora : produtoras) {
            if (produtora.getId() == id) {
                return produtora;
            }
        }
        return null;
    }
}
