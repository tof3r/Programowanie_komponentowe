package glinski.dawid.wypozyczalnia.client;

import java.util.List;

public interface KlientDAO {

	public int insert(Klient klient);

	public void update(int id, Klient klient);

	public void delete(int user_id);

	public Klient get(int user_id);
	
	public void enable(Klient klient);
	
	public List<Klient> getAll();
}
