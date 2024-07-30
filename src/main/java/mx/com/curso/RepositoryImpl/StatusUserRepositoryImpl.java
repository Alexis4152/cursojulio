package mx.com.curso.RepositoryImpl;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import mx.com.curso.Dto.StatusUserDto;
import mx.com.curso.Repository.StatusUserRepository;
import mx.com.curso.mapper.StatusUserMapper;


@Repository

public class StatusUserRepositoryImpl implements StatusUserRepository {

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	
	@Override
	public List<StatusUserDto> getStatusUsers() {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query("SELECT * FROM STATUS_USER", new StatusUserMapper<StatusUserDto>());
	}

	
	/// insertar 
	@Override
	public Integer insertstatus(StatusUserDto status) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("INSERT INTO STATUS_USER (ID_STATUS,NOMBRE_STATUS,DESCRIPCION) VALUES (SEC_USUARIO.NEXTVAL,?,?)",
				new Object[] { status.getNombreStatus(), status.getDescripcion()});
	}
/// actualizar 
	@Override
	 public Integer updateStatus(StatusUserDto status) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("UPDATE STATUS_USER SET NOMBRE_STATUS =? , DESCRIPCION =?  WHERE ID_STATUS =?",
				new Object[] {status.getNombreStatus(), status.getDescripcion(),status.getIdStatus() });
	}

	/// eliminar 
	@Override
	public Integer deleteStatus(StatusUserDto status) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("DELETE FROM STATUS_USER  WHERE ID_STATUS= ? ",
				new Object[] { status.getIdStatus() });
	}
	

	@Override
	public Integer getIdStatusByIdUsuarios(Long idUsuario) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.queryForObject("SELECT ID_STATUS FROM STATUS_USER WHERE idUsuario = ?", 
				new Object[] {idUsuario}, Integer.class);
	}
	
	
	public Integer deleteStatus(Integer id) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("DELETE FROM ID_STATUS  WHERE ID_STATUS = ? ",
				new Object[] { id });
	}
		
	/// consultar Id 

	@Override
	public StatusUserDto getStatusById(Integer idStatus) {
		StatusUserDto result = new StatusUserDto();

		try {
			jdbcTemplate.setDataSource(getDataSource());

			result = jdbcTemplate.queryForObject("SELECT * FROM STATUS_USER WHERE ID_STATUS = ? ",
					new Object[] { idStatus }, new StatusUserMapper<StatusUserDto>());

		} catch (EmptyResultDataAccessException e) {
			result = null;
			System.out.println("Sucedio una excepcion: " + e.getMessage() + " no se obtuvieron resultados");
		} catch (NullPointerException npe) {
			result = null;
			System.out.println("Sucedio una excepcion: " + npe.getMessage() + " algun valor se encuentra como nulo");
		} catch (Exception e) {
			System.out.println("Sucedio una excepcion: " + e.getMessage());
		}

		return result;
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


	@Override
	public Integer deleteStataus(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
