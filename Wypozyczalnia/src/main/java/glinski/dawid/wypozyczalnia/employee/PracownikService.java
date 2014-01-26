package glinski.dawid.wypozyczalnia.employee;

import java.util.List;

public interface PracownikService {
	
	public void dodajPracownika(Pracownik pracownik);

	public void modyfikujPracownika(int id, Pracownik pracownik);

	public void usunPracownika(int user_id);

	public Pracownik getPracownik(int user_id);
	
	public List<Pracownik> wszyscyPracownicy();
}
