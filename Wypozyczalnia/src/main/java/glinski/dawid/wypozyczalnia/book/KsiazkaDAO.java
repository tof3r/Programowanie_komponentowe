package glinski.dawid.wypozyczalnia.book;

public interface KsiazkaDAO {

	public void insert(Ksiazka ksiazka);

	public void update(int id, Ksiazka ksiazka);

	public void delete(int id);

	public Ksiazka get(int id);
}
