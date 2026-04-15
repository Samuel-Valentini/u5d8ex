package samuelvalentini.u5d8ex.playload;


import samuelvalentini.u5d8ex.enumeration.Categoria;

public class BlogPlayload {
    Categoria categoria;
    String titolo;
    String contenuto;

    public BlogPlayload(Categoria categoria, String titolo, String contenuto) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }
}
