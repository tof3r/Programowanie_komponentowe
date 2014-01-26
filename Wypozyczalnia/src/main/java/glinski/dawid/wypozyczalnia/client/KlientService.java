package glinski.dawid.wypozyczalnia.client;

import java.util.List;

public interface KlientService {

	public int dodajKlienta(Klient klient);

	public void modyfikujKlienta(int id, Klient klient);

	public void usunKlienta(int user_id);

	public Klient getKlient(int user_id);

	public void enableKlient(Klient klient);
	
	public List<Klient> wszyscyKlienci();
}
