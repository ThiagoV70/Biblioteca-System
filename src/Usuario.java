import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String id;
    private String nome;
    private String email;

    private List<Livro> emprestados = new ArrayList<Livro>();

    public Usuario() {
    }

    public Usuario(String id,String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getEmprestados() {
        return emprestados;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nome + " - " + email;
    }
}
