import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {
    private List<Funcionario> funcionarios;

    public FuncionarioController() {
        this.funcionarios = new ArrayList<>();
    }

    public void criarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void atualizarSalario(int idFuncionario, double novoSalario) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == idFuncionario) {
                funcionario.setSalario(novoSalario);
                break;
            }
        }
    }

    public Funcionario buscarFuncionarioPorId(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }

    public Funcionario buscarFuncionarioPorEmail(String email) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getEmail().equals(email)) {
                return funcionario;
            }
        }
        return null;
    }

    public void deletarFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }
}
