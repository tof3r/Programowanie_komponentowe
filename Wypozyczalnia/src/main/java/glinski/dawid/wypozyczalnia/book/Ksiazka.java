package glinski.dawid.wypozyczalnia.book;

public class Ksiazka {
	private int id;
	private int id_gatunku;
	private String tytul;
	private String autor;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_gatunku() {
		return id_gatunku;
	}
	public void setId_gatunku(int id_gatunku) {
		this.id_gatunku = id_gatunku;
	}
	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
}
