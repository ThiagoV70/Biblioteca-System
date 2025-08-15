package Exceptions.livro;

public class LivroNaoEmprestadoParaUsuarioException extends Exception {
    public LivroNaoEmprestadoParaUsuarioException(String message) {
        super(message);
    }
}
