package glinski.dawid.wypozyczalnia.book;

public interface KsiazkaService {
	
	public void dodajKsiazke(Ksiazka ksiazka);

	public void modyfikujKsiazke(int id, Ksiazka ksiazka);

	public void usunKsiazke(int id);

	public Ksiazka getKsiazka(int id);
}
