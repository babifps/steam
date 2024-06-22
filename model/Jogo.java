package model;

public class Jogo {
    private int id;
    private String nome;
    private int idProdutora;

    public Jogo(int id, String nome, int idProdutora) {
        this.id = id;
        this.nome = nome;
        this.idProdutora = idProdutora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdProdutora() {
        return idProdutora;
    }

    public void setIdProdutora(int idProdutora) {
        this.idProdutora = idProdutora;
    }

    
}
