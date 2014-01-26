package glinski.dawid.wypozyczalnia.rent;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class WypozyczenieDAOImpl implements WypozyczenieDAO {

	private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public void dodajWypozyczenie(Wypozyczenie wypozyczenie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modyfikujWypozyczenie(Wypozyczenie wypozyczenie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void usunWypozyczenie(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Wypozyczenie getWypozyczenie(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
