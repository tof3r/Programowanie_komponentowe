package glinski.dawid.wypozyczalnia.client;

import java.util.List;

public class KlientServiceImpl implements KlientService {

	private KlientDAO klientDAO;

	public void setKlientDAO(KlientDAO klientDAO) {
		this.klientDAO = klientDAO;
	}

	@Override
	public void modyfikujKlienta(int id, Klient klient) {
		klientDAO.update(id,klient);
	}

	@Override
	public void usunKlienta(int user_id) {
		klientDAO.delete(user_id);
	}

	@Override
	public Klient getKlient(int user_id) {
		return klientDAO.get(user_id);
	}

	@Override
	public void enableKlient(Klient klient) {
		klientDAO.enable(klient);
	}

	@Override
	public int dodajKlienta(Klient klient) {
		return klientDAO.insert(klient);
	}

	@Override
	public List<Klient> wszyscyKlienci() {
		return klientDAO.getAll();
	}

}
