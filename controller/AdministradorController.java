import java.util.List;

public class AdministradorController {
    private UsuarioController usuarioController;
    private FuncionarioController funcionarioController;

    public AdministradorController() {
        this.usuarioController = new UsuarioController();
        this.funcionarioController = new FuncionarioController();
    }

    // Métodos relacionados a Funcionários

    public void criarFuncionario(Funcionario funcionario) {
        funcionarioController.criarFuncionario(funcionario);
    }

    public Funcionario buscarFuncionarioPorId(int id) {
        return funcionarioController.buscarFuncionarioPorId(id);
    }

    public void atualizarSalario(Funcionario funcionario, double novoSalario) {
        funcionario.setSalario(novoSalario);
        funcionarioController.atualizarSalario(funcionario);
    }

    public void atualizarInformacoes(Funcionario funcionario) {
        funcionarioController.atualizarInformacoes(funcionario);
    }

    public void deletarFuncionario(int id) {
        funcionarioController.deletarFuncionario(id);
    }

    // Métodos adicionais de gerenciamento

    public List<Usuario> buscarTodosUsuarios() {
        return usuarioController.buscarTodosUsuarios();
    }

    public void deletarUsuario(int id) {
        usuarioController.deletarUsuario(id);
    }

    // Métodos específicos para gestão de compras, se necessário

    public void finalizarCompra(Cliente cliente, Compra compra) {
        clienteController.finalizarCompra(cliente, compra);
    }

    public double calcularTotalCompra(Compra compra) {
        return clienteController.calcularTotalCompra(compra);
    }
}
