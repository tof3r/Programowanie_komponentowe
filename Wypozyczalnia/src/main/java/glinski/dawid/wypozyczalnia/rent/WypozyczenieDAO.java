package glinski.dawid.wypozyczalnia.rent;

public interface WypozyczenieDAO {

	public void dodajWypozyczenie(Wypozyczenie wypozyczenie);

	public void modyfikujWypozyczenie(Wypozyczenie wypozyczenie);

	public void usunWypozyczenie(int id);

	public Wypozyczenie getWypozyczenie(int id);
}
