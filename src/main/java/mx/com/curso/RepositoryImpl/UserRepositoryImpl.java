package mx.com.curso.RepositoryImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
		return jdbcTemplate.query("SELECT * FROM USUARIOS", new EmpleadosMapper<EmpleadoDto>());
	}

	@Override
	public Integer insertEmpleado(EmpleadoDto empleado) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("INSERT INTO USUARIOS(ID_ALUMNO, NOMBRE, SALARIO, EDAD) VALUES (?,?,?,?)",
				new Object[] { empleado.getIdAlumno(), empleado.getNombre(), empleado.getSalario(),
						empleado.getEdad() });
	}

	@Override
	public Integer updateEmpleado(EmpleadoDto empleado) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("UPDATE USUARIOS SET NOMBRE =?, SALARIO = ?, EDAD = ? WHERE ID_ALUMNO = ?",
				new Object[] { empleado.getNombre(), empleado.getSalario(), empleado.getEdad(),
						empleado.getIdAlumno() });
	}

	@Override
	public Integer deleteEmpleado(EmpleadoDto empleado) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("DELETE FROM USUARIOS WHERE ID_ALUMNO = ? ",
				new Object[] { empleado.getIdAlumno() });
	}

	@Override
	public EmpleadoDto getEmpleadoById(Integer idAlumno) {
		EmpleadoDto result = new EmpleadoDto();

		try {
			jdbcTemplate.setDataSource(getDataSource());

			result = jdbcTemplate.queryForObject("SELECT * FROM USUARIOS WHERE ID_ALUMNO = ? ",
					new Object[] { idAlumno }, new EmpleadosMapper<EmpleadoDto>());

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

}
