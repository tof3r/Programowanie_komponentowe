package glinski.dawid.wypozyczalnia.employee;

import glinski.dawid.wypozyczalnia.client.Klient;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class PracownikDAOImpl implements PracownikDAO {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(Pracownik pracownik) {
		final String SQL_PRACOWNIK_INS = "INSERT INTO `pracownik` (`imie`, `nazwisko`, `email`, `telefon`, `adres`) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(
				SQL_PRACOWNIK_INS,
				new Object[] { pracownik.getImie(), pracownik.getNazwisko(),
						pracownik.getEmail(), pracownik.getTelefon(),
						pracownik.getAdres() });
	}

	@Override
	public void update(int id, Pracownik pracownik) {
		String sql = "UPDATE `pracownik` set `imie` = ?, `nazwisko` = ?, `email` = ?, `telefon` = ?, `adres` = ? where id = " + id;

		jdbcTemplate.update(
				sql,
				new Object[] { pracownik.getImie(), pracownik.getNazwisko(),
						pracownik.getEmail(), pracownik.getTelefon(),
						pracownik.getAdres() });
	}

	@Override
	public void delete(int user_id) {
		String sql_u_t = "DELETE FROM `pracownik` WHERE id=?";
		jdbcTemplate.update(sql_u_t, new Object[] { user_id });
	}

	@Override
	public Pracownik get(int user_id) {
		Pracownik pracownik;
		String sql = "SELECT * FROM `pracownik` WHERE id=?";
		try {
			pracownik = (Pracownik) jdbcTemplate.queryForObject(sql,
					new Object[] { user_id },
					new BeanPropertyRowMapper<Pracownik>(Pracownik.class));
		} catch (EmptyResultDataAccessException e) {
			pracownik = new Pracownik();
			pracownik.setId(0);
		}

		return pracownik;
	}

	@Override
	public List<Pracownik> getAll() {
		List<Pracownik> pracownicy = null;
		try {
			final String sql = "SELECT * FROM `pracownik`";

			pracownicy =  jdbcTemplate.query(sql,new BeanPropertyRowMapper(Pracownik.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			pracownicy = null;
		}
		return pracownicy;
	}
}
