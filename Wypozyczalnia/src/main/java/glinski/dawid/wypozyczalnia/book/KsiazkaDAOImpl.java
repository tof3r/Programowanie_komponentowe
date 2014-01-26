package glinski.dawid.wypozyczalnia.book;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class KsiazkaDAOImpl implements KsiazkaDAO {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(Ksiazka ksiazka) {
		final String SQL_KLIENT_INS = "INSERT INTO `ksiazka` (`id_gatunku`,`tytul`, `autor`) VALUES (?,?,?)";
		jdbcTemplate.update(SQL_KLIENT_INS,
				new Object[] { ksiazka.getId_gatunku(), ksiazka.getTytul(), ksiazka.getAutor() });
	}

	@Override
	public void update(int id, Ksiazka ksiazka) {
		String sql = "UPDATE `ksiazka` set `id_gatunku` = ?, `tytul` = ?, `autor` = ? where id = "
				+ id;

		jdbcTemplate.update(sql, new Object[] { ksiazka.getId_gatunku(),
				ksiazka.getTytul(), ksiazka.getAutor() });
	}

	@Override
	public void delete(int id) {
		String sql_u_t = "DELETE FROM `ksiazka` WHERE id=?";
		jdbcTemplate.update(sql_u_t, new Object[] { id });
	}

	@Override
	public Ksiazka get(int id) {
		Ksiazka ksiazka;
		String sql = "SELECT * FROM `ksiazka` WHERE id=?";
		try {
			ksiazka = (Ksiazka) jdbcTemplate.queryForObject(sql,
					new Object[] { id }, new BeanPropertyRowMapper<Ksiazka>(
							Ksiazka.class));
		} catch (EmptyResultDataAccessException e) {
			ksiazka = new Ksiazka();
			ksiazka.setId(0);
		}

		return ksiazka;
	}

}
