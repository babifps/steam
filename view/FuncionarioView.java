package view;

import controller.FuncionarioController;
import model.Funcionario;
import java.util.List;

public class FuncionarioView {
    private FuncionarioController funcionarioController;

    public FuncionarioView(FuncionarioController funcionarioController) {
        this.funcionarioController = funcionarioController;
    }

    public void exibirDetalhesFuncionario(int idFuncionario) {
        Funcionario funcionario = funcionarioController.buscarFuncionarioPorId(idFuncionario);
        if (funcionario != null) {
            System.out.println("Detalhes do Funcionário:");
            System.out.println("ID: " + funcionario.getId());
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Salário: " + funcionario.getSalario());
            System.out.println();
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public void listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("Lista de Funcionários:");
            for (Funcionario funcionario : funcionarios) {
                System.out.println("ID: " + funcionario.getId() + ", Nome: " + funcionario.getNome() + ", Salário: " + funcionario.getSalario());
            }
        }
    }
}
