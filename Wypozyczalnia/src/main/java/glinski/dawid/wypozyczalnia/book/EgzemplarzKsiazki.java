package glinski.dawid.wypozyczalnia.book;

public class EgzemplarzKsiazki {
	private int id;
	private int id_ksiazki;
	private int rok_wydania;
	private String numerISBN;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_ksiazki() {
		return id_ksiazki;
	}

	public void setId_ksiazki(int id_ksiazki) {
		this.id_ksiazki = id_ksiazki;
	}

	public int getRok_wydania() {
		return rok_wydania;
	}

	public void setRok_wydania(int rok_wydania) {
		this.rok_wydania = rok_wydania;
	}

	public String getNumerISBN() {
		return numerISBN;
	}

	public void setNumerISBN(String numerISBN) {
		this.numerISBN = numerISBN;
	}
}
