import status.StatusLivro;

public class Livro {

    private String id;
    private String titulo;
    private String autor;

    private StatusLivro status;

    public Livro() {
    }

    public Livro(String id, String titulo, String autor, StatusLivro status) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.status = StatusLivro.DISPONIVEL;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public StatusLivro getStatus() {
        return status;
    }

    public void setStatus(StatusLivro status) {
        this.status = status;
    }
}
