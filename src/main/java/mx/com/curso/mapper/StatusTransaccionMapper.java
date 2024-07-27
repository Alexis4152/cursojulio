package mx.com.curso.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.curso.Dto.StatusTransaccionDto;

public class StatusTransaccionMapper<T> implements RowMapper<StatusTransaccionDto> {

	@Override
	public StatusTransaccionDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		StatusTransaccionDto registro = new StatusTransaccionDto();
		registro.setIdStatusTransaccion(rs.getInt("ID_STATUS_TRANSACCION"));
		registro.setNombreStatusTransaccion(rs.getString("NOMBRE_STATUS_TRANSACCION"));
		registro.setDescripcionStatusTransaccion(rs.getString("DESCRIPCION_STATUS_TRANSACCION"));
		return registro;
	}

}
