package glinski.dawid.wypozyczalnia.client;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class KlientDAOImpl implements KlientDAO {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int insert(Klient klient) {

		final String SQL_KLIENT_INS = "INSERT INTO `klient` (`user_id`,`imie`, `nazwisko`, `email`, `login`, `haslo`, enabled) VALUES (DEFAULT,?,?,?,?,?,?)";
		jdbcTemplate.update(SQL_KLIENT_INS, new Object[] { klient.getImie(),
				klient.getNazwisko(), klient.getEmail(), klient.getLogin(),
				klient.getHaslo(), 0 });
		return jdbcTemplate.queryForInt("SELECT last_insert_id()");

	}

	@Override
	public void update(int id, Klient klient) {
		String sql = "UPDATE `klient` set `imie` = '?', `nazwisko` = '?', `email` = '?', `login` = '?', `haslo` = '?', `enabled` = '?' where user_id = ?";

		jdbcTemplate.update(
				sql,
				new Object[] { klient.getImie(), klient.getNazwisko(),
						klient.getEmail(), klient.getLogin(),
						klient.getHaslo(), klient.getEnabled(),
						klient.getUserId() });
	}

	@Override
	public void delete(int user_id) {
		String sql_u_t = "DELETE FROM `klient` WHERE id=?";
		jdbcTemplate.update(sql_u_t, new Object[] { user_id });
	}

	@Override
	public Klient get(int user_id) {
		Klient klient;
		String sql = "SELECT * FROM `user` WHERE user_id=?";
		try {
			klient = jdbcTemplate.queryForObject(sql, new Object[] { user_id },
					new BeanPropertyRowMapper<Klient>(Klient.class));
		} catch (EmptyResultDataAccessException e) {
			klient = new Klient();
			klient.setUserId(0);
		}

		return klient;
	}

	@Override
	public void enable(Klient klient) {
		String sql = "UPDATE `klient` SET `enabled`=? WHERE user_id=?";
		jdbcTemplate.update(sql,
				new Object[] { klient.getEnabled(), klient.getUserId() });
	}

	@Override
	public List<Klient> getAll() {
		List<Klient> klienci = null;
		try {
			final String sql = "SELECT * FROM `klient`";

			klienci =  jdbcTemplate.query(sql,new BeanPropertyRowMapper(Klient.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			klienci = null;
		}
		return klienci;
	}
}
