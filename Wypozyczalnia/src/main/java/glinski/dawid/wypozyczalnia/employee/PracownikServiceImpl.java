package glinski.dawid.wypozyczalnia.employee;

import java.util.List;

public class PracownikServiceImpl implements PracownikService {

	private PracownikDAO pracownikDAO;
	
	public void setPracownikDAO(PracownikDAO pracownikDAO) {
		this.pracownikDAO = pracownikDAO;
	}

	@Override
	public void dodajPracownika(Pracownik pracownik) {
		pracownikDAO.insert(pracownik);
	}

	@Override
	public void modyfikujPracownika(int id, Pracownik pracownik) {
		pracownikDAO.update(id,pracownik);
	}

	@Override
	public void usunPracownika(int user_id) {
		pracownikDAO.delete(user_id);
	}

	@Override
	public Pracownik getPracownik(int user_id) {
		return pracownikDAO.get(user_id);
	}

	@Override
	public List<Pracownik> wszyscyPracownicy() {
		return pracownikDAO.getAll();
	}

}
