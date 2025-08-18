import java.util.List;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.addLivro(new Livro("L1", "Dom Casmurro", "Machado de Assis"));
        biblioteca.addLivro(new Livro("L2", "O Cortiço", "Aluísio Azevedo"));

        biblioteca.addUsuario(new Usuario("U1", "Maria", "maria@email"));
        biblioteca.addUsuario(new Usuario("U2", "João", "joao@email"));

        try {
            biblioteca.emprestarLivro("L1", "U1");
            biblioteca.devolverLivro("L1", "U1");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}