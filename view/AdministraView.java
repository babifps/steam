public class AdministradorView {

    private UsuarioController usuarioController;

    public AdministradorView() {
        this.usuarioController = new UsuarioController();
    }

    public void mostrarVisaoGeral() {
        int totalClientes = usuarioController.contarClientes();
        int totalFuncionarios = usuarioController.contarFuncionarios();

        System.out.println("Visão Geral:");
        System.out.println("Total de Clientes: " + totalClientes);
        System.out.println("Clientes:");

        List<Cliente> clientes = usuarioController.listarClientes();
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() + ", Nome: " + cliente.getNome());
        }

        System.out.println();
        System.out.println("Total de Funcionários: " + totalFuncionarios);
        System.out.println("Funcionários:");

        List<Funcionario> funcionarios = usuarioController.listarFuncionarios();
        for (Funcionario funcionario : funcionarios) {
            System.out.println("ID: " + funcionario.getId() + ", Nome: " + funcionario.getNome());
        }
    }
}
