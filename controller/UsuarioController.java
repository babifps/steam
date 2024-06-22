package controller;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    public void criarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public void atualizarUsuario(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuario.getId()) {
                usuarios.set(i, usuario);
                break;
            }
        }
    }

    public void deletarUsuario(int id) {
        usuarios.removeIf(usuario -> usuario.getId() == id);
    }

     public int contarClientes() {
        int contadorClientes = 0;
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Cliente) {
                contadorClientes++;
            }
        }
        return contadorClientes;
    }

    public int contarFuncionarios() {
        int contadorFuncionarios = 0;
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Funcionario) {
                contadorFuncionarios++;
            }
        }
        return contadorFuncionarios;
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Cliente) {
                clientes.add((Cliente) usuario);
            }
        }
        return clientes;
    }

    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Funcionario) {
                funcionarios.add((Funcionario) usuario);
            }
        }
        return funcionarios;
    }
}

    // Métodos adicionais, se necessário

}
