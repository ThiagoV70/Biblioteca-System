import Exceptions.livro.LivroIndisponivelException;
import Exceptions.livro.LivroNaoEncontradoException;
import Exceptions.usuario.UsuarioNaoEncontradoException;
import status.StatusLivro;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        // Criando dados de teste
        Usuario u1 = new Usuario("1", "Thiago", "thiago@email.com");
        Usuario u2 = new Usuario("2", "Maria", "maria@email.com");

        Livro l1 = new Livro("101", "Clean Code", "Robert C. Martin");
        Livro l2 = new Livro("102", "Java Efetivo", "Joshua Bloch");

        biblioteca.addUsuario(u1);
        biblioteca.addUsuario(u2);
        biblioteca.addLivro(l1);
        biblioteca.addLivro(l2);

        try {
            biblioteca.emprestarLivro("101", "1");
            System.out.println("Livro " + l1.getTitulo() + " emprestado com sucesso para " + u1.getNome());

            biblioteca.devolverLivro("101", "1");
            System.out.println("Livro devolvido com sucesso por " + u1.getNome());

        } catch (UsuarioNaoEncontradoException | LivroNaoEncontradoException | LivroIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}