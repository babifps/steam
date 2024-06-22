package view;

import controller.UsuarioController;
import model.Usuario;

public class UsuarioView {
    public UsuarioView() {
        new UsuarioController();
    }

        public void exibirDetalhesUsuario(Usuario usuario) {
            System.out.println("Detalhes do Usuário:");
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nome: " + usuario.getNome());
            System.out.println();
        }
    }
    
   
