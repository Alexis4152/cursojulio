package mx.com.curso.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import mx.com.curso.Dto.StatusUserDto;
public class StatusUserMapper <T> implements RowMapper<StatusUserDto> {
	

	@Override
	public StatusUserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		 StatusUserDto registro = new  StatusUserDto();
		registro.setIdStatus(rs.getInt("ID_STATUS"));
		registro.setNombreStatus(rs.getString("NOMBRE_STATUS"));
		registro.setDescripcion(rs.getString("DESCRIPCION"));
		
		return registro;
	}

}
