package glinski.dawid.wypozyczalnia.employee;

import java.util.List;

public interface PracownikDAO {

	public void insert(Pracownik pracownik);

	public void update(int id, Pracownik pracownik);

	public void delete(int user_id);

	public Pracownik get(int user_id);
	
	public List<Pracownik> getAll();
}
