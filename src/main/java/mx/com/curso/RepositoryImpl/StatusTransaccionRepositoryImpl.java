package mx.com.curso.RepositoryImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.com.curso.Dto.StatusTransaccionDto;
import mx.com.curso.Repository.StatusTransaccionRepository;
import mx.com.curso.mapper.StatusTransaccionMapper;

@Repository
public class StatusTransaccionRepositoryImpl implements StatusTransaccionRepository {

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	@Override
	public List<StatusTransaccionDto> getStatusTransaccion() {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query("SELECT * FROM STATUSTRANSACCIONES",
				new StatusTransaccionMapper<StatusTransaccionDto>());
	}

	@Override
	public Integer insertStatusTransaccion(StatusTransaccionDto statusTransaccion) {
		jdbcTemplate.setDataSource(getDataSource());
		Integer nextId = jdbcTemplate.queryForObject("SELECT SEQ_TRANSACCIONES_STATUS.NEXTVAL FROM DUAL",
				Integer.class);

		return jdbcTemplate.update("INSERT INTO STATUSTRANSACCIONES (ID_STATUS_TRANSACCION, NOMBRE_STATUS_TRANSACCION, DESCRIPCION_STATUS_TRANSACCION) VALUES (?,?,?)",
				new Object[] { nextId, statusTransaccion.getNombreStatusTransaccion(), statusTransaccion.getDescripcionStatusTransaccion() });
	}

	@Override
	public Integer updateStatusTransaccion(StatusTransaccionDto statusTransaccion) {
		jdbcTemplate.setDataSource(getDataSource());

		return jdbcTemplate.update("UPDATE STATUSTRANSACCIONES SET NOMBRE_STATUS_TRANSACCION = ?, DESCRIPCION_STATUS_TRANSACCION = ? WHERE ID_STATUS_TRANSACCION = ?",
				new Object[] { statusTransaccion.getNombreStatusTransaccion(), statusTransaccion.getDescripcionStatusTransaccion(),
						statusTransaccion.getIdStatusTransaccion() });
	}

	@Override
	public Integer deleteStatusTransaccion(StatusTransaccionDto statusTransaccion) {
		jdbcTemplate.setDataSource(getDataSource());

		return jdbcTemplate.update("DELETE FROM STATUSTRANSACCIONES WHERE ID_STATUS_TRANSACCION = ?",
				new Object[] { statusTransaccion.getIdStatusTransaccion() });
	}

	@Override
	public StatusTransaccionDto getByIdStatusTransaccion(Integer idStatusT) {
		jdbcTemplate.setDataSource(getDataSource());

		return jdbcTemplate.queryForObject("SELECT * FROM STATUSTRANSACCIONES WHERE ID_STATUS_TRANSACCION = ?",
				new Object[] { idStatusT }, new StatusTransaccionMapper<StatusTransaccionDto>());
	}


	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
