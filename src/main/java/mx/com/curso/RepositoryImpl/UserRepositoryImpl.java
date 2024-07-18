package mx.com.curso.RepositoryImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.com.curso.Dto.EmpleadoDto;
import mx.com.curso.Repository.UserRepository;
import mx.com.curso.mapper.EmpleadosMapper;

@Repository
public class UserRepositoryImpl implements UserRepository {

	
	// JDBC TEMPLATE - NECESITA UNA CONEXIÓN A BASE DE DATOS

	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	@Override
	public List<EmpleadoDto> getUsers() {
        jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query("SELECT * FROM USUARIOS", new EmpleadosMapper<EmpleadoDto>() );
	}
	
	@Override
	public Integer insertEmpleado(EmpleadoDto empleado) {
        jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("INSERT INTO USUARIOS(ID_ALUMNO, NOMBRE, SALARIO, EDAD) VALUES (?,?,?,?)",
        		new Object[] {empleado.getIdAlumno(), empleado.getNombre(), empleado.getSalario(), empleado.getEdad()} );
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
