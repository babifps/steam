package model;

public class Cliente extends Usuario {
    private int idProdutora; 

    public Cliente(int id, String nome, int idProdutora) {
        super(id, nome); 
        this.idProdutora = idProdutora;
    }

    public int getIdProdutora() {
        return idProdutora;
    }

    public void setIdProdutora(int idProdutora) {
        this.idProdutora = idProdutora;
    }

    @Override
    public void atualizarInformacoes() {
       
}
}