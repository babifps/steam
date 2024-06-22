import java.util.Scanner;
import model.Funcionario;
import model.Jogo;
import model.Produtora;
import controller.FuncionarioController;
import controller.JogoController;
import controller.ProdutoraController;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FuncionarioController funcionarioController = new FuncionarioController();
        JogoController jogoController = new JogoController();
        ProdutoraController produtoraController = new ProdutoraController();

        
        Funcionario novoFuncionario = new Funcionario(1, "João", 5000.0, 1);
        funcionarioController.criarFuncionario(novoFuncionario);

        Jogo novoJogo = new Jogo(1, "Super Adventure", 1);
        jogoController.criarJogo(novoJogo);

        
        Produtora novaProdutora = new Produtora(1, "Game Studios");
        produtoraController.criarProdutora(novaProdutora);

  
        System.out.println("Detalhes do Jogo:");
        Jogo jogoEncontrado = jogoController.buscarJogoPorId(1);
        if (jogoEncontrado != null) {
            System.out.println("Nome: " + jogoEncontrado.getNome());
            System.out.println("ID da Produtora: " + jogoEncontrado.getIdProdutora());
        } else {
            System.out.println("Jogo não encontrado.");
        }

        System.out.println("\nDetalhes da Produtora:");
        Produtora produtoraEncontrada = produtoraController.buscarProdutoraPorId(1);
        if (produtoraEncontrada != null) {
            System.out.println("Nome: " + produtoraEncontrada.getNome());
        } else {
            System.out.println("Produtora não encontrada.");
        }

        
        Funcionario funcionarioAtualizado = funcionarioController.buscarFuncionarioPorId(1);
        if (funcionarioAtualizado != null) {
            funcionarioAtualizado.setSalario(5500.0);
          
            System.out.println("\nSalário atualizado para " + funcionarioAtualizado.getSalario());
        } else {
            System.out.println("Funcionário não encontrado.");
        }

       
        System.out.println("\nDeseja deletar o jogo? (s/n)");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            jogoController.deletarJogo(1);
            System.out.println("Jogo deletado.");
        } else {
            System.out.println("Operação de exclusão cancelada.");
        }

        scanner.close();
    }
}
