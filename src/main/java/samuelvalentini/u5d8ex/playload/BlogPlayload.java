package samuelvalentini.u5d8ex.playload;


import samuelvalentini.u5d8ex.enumeration.Categoria;

public class BlogPlayload {
    Categoria categoria;
    String titolo;
    String contenuto;
    long autoreId;

    public BlogPlayload(Categoria categoria, String titolo, String contenuto, long autoreId) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.autoreId = autoreId;
    }

    public long getAutoreId() {
        return autoreId;
    }

    public void setAutoreId(long autoreId) {
        this.autoreId = autoreId;
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
