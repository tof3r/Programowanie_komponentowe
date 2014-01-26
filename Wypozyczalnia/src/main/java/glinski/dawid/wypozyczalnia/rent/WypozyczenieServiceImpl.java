package glinski.dawid.wypozyczalnia.rent;

public class WypozyczenieServiceImpl implements WypozyczenieService {

	private WypozyczenieDAO wypozyczenieDAO;
	
	public void setWypozyczenieDAO(WypozyczenieDAO wypozyczenieDAO) {
		this.wypozyczenieDAO = wypozyczenieDAO;
	}

	@Override
	public void dodajWypozyczenie(Wypozyczenie wypozyczenie) {
		wypozyczenieDAO.dodajWypozyczenie(wypozyczenie);		
	}

	@Override
	public void modyfikujWypozyczenie(Wypozyczenie wypozyczenie) {
		wypozyczenieDAO.modyfikujWypozyczenie(wypozyczenie);		
	}

	@Override
	public void usunWypozyczenie(int id) {
		wypozyczenieDAO.usunWypozyczenie(id);
	}

	@Override
	public Wypozyczenie getWypozyczenie(int id) {
		return wypozyczenieDAO.getWypozyczenie(id);
	}
}
