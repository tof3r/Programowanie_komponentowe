package glinski.dawid.wypozyczalnia.book;

import java.util.List;

public class KsiazkaServiceImpl implements KsiazkaService {

	private KsiazkaDAO ksiazkaDAO;
	
	public void setKsiazkaDAO(KsiazkaDAO ksiazkaDAO) {
		this.ksiazkaDAO = ksiazkaDAO;
	}

	@Override
	public void dodajKsiazke(Ksiazka ksiazka) {
		ksiazkaDAO.insert(ksiazka);
	}

	@Override
	public void modyfikujKsiazke(int id, Ksiazka ksiazka) {
		ksiazkaDAO.update(id, ksiazka);
	}

	@Override
	public void usunKsiazke(int id) {
		ksiazkaDAO.delete(id);		
	}

	@Override
	public Ksiazka getKsiazka(int id) {
		return ksiazkaDAO.get(id);
	}
	
	@Override
	public Ksiazka getKsiazka(String tytul) {
		return ksiazkaDAO.get(tytul);
	}

	@Override
	public List<Ksiazka> wszystkieKsiazki() {
		return ksiazkaDAO.getAll();
	}

}
