package mx.com.curso.RepositoryImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.com.curso.Dto.StatusUserDto;
import mx.com.curso.Dto.TransaccionDto;

import org.springframework.dao.EmptyResultDataAccessException;

import mx.com.curso.Repository.TransaccionRepository;
import mx.com.curso.mapper.StatusUserMapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TransaccionRepositoryImpl implements TransaccionRepository {

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	/// eliminar

	@Override
	public Integer deleteTransaction(Integer id) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("DELETE FROM TRANSACCIONES WHERE idTransaccion = ? ",
				new Object[] { id });
	}

	//usuario
	@Override
	public Integer getIdTransaccionByIdUsuarios(Long idUsuario) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.queryForObject("SELECT idTransaccion FROM TRANSACCIONES WHERE idUsuario = ?", 
				new Object[] {idUsuario}, Integer.class);
	}
	
	/* /Status
	@Override
	public Integer getIdTransaccionByIdStatus(Integer idStatus) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.queryForObject("SELECT ID_STATUS FROM TSTATUS_USER WHERE idUsuario = ?", 
				new Object[] {idStatus}, Integer.class);
		
	}
	*/
	
	
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
