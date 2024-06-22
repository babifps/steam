package controller;

import model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {
    private List<Funcionario> funcionarios; 

    public FuncionarioController() {
        this.funcionarios = new ArrayList<>();
    }

    public FuncionarioController(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void atualizarSalario(int id, double novoSalario) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                funcionario.setSalario(novoSalario);
                break;
            }
        }
    }

    public void criarFuncionario(Funcionario novoFuncionario) {
        funcionarios.add(novoFuncionario);
    }

    public Funcionario buscarFuncionarioPorId(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null; 
    }

    
}
