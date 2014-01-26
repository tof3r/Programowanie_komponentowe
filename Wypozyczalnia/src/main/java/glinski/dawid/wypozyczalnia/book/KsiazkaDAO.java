package glinski.dawid.wypozyczalnia.book;

import java.util.List;

public interface KsiazkaDAO {

	public void insert(Ksiazka ksiazka);

	public void update(int id, Ksiazka ksiazka);

	public void delete(int id);

	public Ksiazka get(int id);
	
	public List<Ksiazka> getAll();
}
