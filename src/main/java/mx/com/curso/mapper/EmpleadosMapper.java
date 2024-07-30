package mx.com.curso.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.com.curso.Dto.EmpleadoDto;

public class EmpleadosMapper<T> implements RowMapper<EmpleadoDto>{

	@Override
	public EmpleadoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmpleadoDto registro = new EmpleadoDto();
		registro.setIdAlumno(rs.getInt("ID_ALUMNO"));
		registro.setNombre(rs.getString("NOMBRE"));
		registro.setNombre(rs.getString("APELLIDO"));
		registro.setEdad(rs.getInt("EDAD"));
		registro.setSalario(rs.getBigDecimal("SALARIO"));
		return registro;
	}

}
