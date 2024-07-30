 package mx.com.curso.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import mx.com.curso.Dto.UsuariosDto;

public class UsuariosMapper <T> implements RowMapper<UsuariosDto> {

	@Override
	public UsuariosDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		UsuariosDto registro = new UsuariosDto();
		registro.setIdUsuario(rs.getLong("ID_USUARIO"));
		registro.setNombre(rs.getString("NOMBRE"));
		registro.setEdad(rs.getInt("EDAD"));
		registro.setApellido(rs.getString("APELLIDO"));
		registro.setNumerocuenta(rs.getBigDecimal("NUMERO_CUENTA"));
		registro.setBanco(rs.getString("BANCO"));
		registro.setTelefono(rs.getLong("TELEFONO"));
		registro.setDireccionCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));
		registro.setEstadoUsuario(rs.getString("ESTADO_USUARIO"));
		return registro;
	}

}


