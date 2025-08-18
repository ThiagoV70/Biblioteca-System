import Exceptions.livro.LivroIndisponivelException;
import Exceptions.livro.LivroNaoEmprestadoParaUsuarioException;
import Exceptions.livro.LivroNaoEncontradoException;
import Exceptions.usuario.UsuarioNaoEncontradoException;
import status.StatusLivro;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Usuario> usuarios = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();

    public void addUsuario (Usuario usuario) {
        usuarios.add(usuario);
    }

    public void addLivro(Livro livro) {
        livros.add(livro);
    }

    public void emprestarLivro(String livroId, String usuarioId)
            throws UsuarioNaoEncontradoException, LivroNaoEncontradoException, LivroIndisponivelException {

        Usuario usuario = buscarUsuarioPorId(usuarioId);
        Livro livro = buscarLivroPorId(livroId);

        if (livro.getStatus() != StatusLivro.DISPONIVEL) {
            throw new LivroIndisponivelException("O livro '" + livro.getTitulo() + "' não está disponível.");
        }

        livro.setStatus(StatusLivro.INDISPONIVEL);
        usuario.getEmprestados().add(livro);
        System.out.println("Livro emprestado com sucesso para " + usuario.getNome());
    }

    public void devolverLivro(String livroId, String usuarioId)
            throws UsuarioNaoEncontradoException, LivroNaoEncontradoException, LivroNaoEmprestadoParaUsuarioException {

        Usuario usuario = buscarUsuarioPorId(usuarioId);
        Livro livro = buscarLivroPorId(livroId);

        if (!usuario.getEmprestados().contains(livro)) {
            throw new LivroNaoEmprestadoParaUsuarioException("O usuário não possui este livro emprestado.");
        }

        usuario.getEmprestados().remove(livro);
        livro.setStatus(StatusLivro.DISPONIVEL);
        System.out.println("Livro devolvido com sucesso por " + usuario.getNome());
    }

    private Usuario buscarUsuarioPorId(String id)
            throws UsuarioNaoEncontradoException {
        return usuarios.stream().filter(usuario -> usuario.getId().equalsIgnoreCase(id)).findFirst()
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado."));
    }

    private Livro buscarLivroPorId(String id) throws LivroNaoEncontradoException {
        return livros.stream().filter(l -> l.getId().equalsIgnoreCase(id)).findFirst()
                .orElseThrow(() -> new LivroNaoEncontradoException("Livro não encontrado."));
    }
}
