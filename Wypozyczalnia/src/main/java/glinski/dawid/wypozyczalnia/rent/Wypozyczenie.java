package glinski.dawid.wypozyczalnia.rent;

public class Wypozyczenie {

	private int id;
	private int id_klienta;
	private int id_pracownika;
	private int id_platnosci;
	private String data;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_klienta() {
		return id_klienta;
	}
	public void setId_klienta(int id_klienta) {
		this.id_klienta = id_klienta;
	}
	public int getId_pracownika() {
		return id_pracownika;
	}
	public void setId_pracownika(int id_pracownika) {
		this.id_pracownika = id_pracownika;
	}
	public int getId_platnosci() {
		return id_platnosci;
	}
	public void setId_platnosci(int id_platnosci) {
		this.id_platnosci = id_platnosci;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
