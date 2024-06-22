package model;

public class Funcionario extends Usuario {
    private double salario;
    private int idProdutora;

    public Funcionario(int id, String nome, double salario, int idProdutora) {
        super(id, nome); 
        this.salario = salario;
        this.idProdutora = idProdutora;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
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
