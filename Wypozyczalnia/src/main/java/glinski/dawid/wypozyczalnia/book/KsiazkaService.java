package glinski.dawid.wypozyczalnia.book;

import java.util.List;

public interface KsiazkaService {
	
	public void dodajKsiazke(Ksiazka ksiazka);

	public void modyfikujKsiazke(int id, Ksiazka ksiazka);

	public void usunKsiazke(int id);

	public Ksiazka getKsiazka(int id);
	
	public List<Ksiazka> wszystkieKsiazki();
}
