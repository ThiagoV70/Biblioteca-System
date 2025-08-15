import status.StatusLivro;

import java.util.List;

public class Biblioteca {

    private List<Usuario> usuarios;
    private List<Livro> livros;

    public void AddUsuario (Usuario usuario) {
        usuarios.add(usuario);
    }

    public void AddLivro (Livro livro) {
        livros.add(livro);
    }

    public void EMPlivro (Livro livro,Usuario usuario) {
        while (livro.getStatus() != StatusLivro.DISPONIVEL) {
            System.out.println("Esse livro não está disponível, escolha outro.");
            for (Livro l : livros) {
                if (l.getStatus() == StatusLivro.DISPONIVEL) {
                    System.out.println("- " + l.getTitulo() + " (" + l.getAutor() + ")");
                }
            }
        }
        usuario.getEmprestatos().add(livro);
        livro.setStatus(StatusLivro.INDISPONIVEL);
        System.out.println("Livro '" + livro.getTitulo() + "' emprestado para " + usuario.getNome());

    }
}
