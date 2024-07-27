package mx.com.curso.mapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.curso.Dto.TransaccionesDto;

public class TransaccionesMapper<T> implements RowMapper<TransaccionesDto> {

	@Override
	public TransaccionesDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		TransaccionesDto registro = new TransaccionesDto();
		BigInteger idTransaccion = new BigInteger(rs.getString("ID_TRANSACCION"));
		//BigInteger idUsuario = new BigInteger(rs.getString("ID_USUARIO"));
		registro.setIdTransaccion(idTransaccion);
		registro.setFecha(rs.getDate("FECHA"));
		registro.setCantidad(rs.getBigDecimal("MONTO"));
		registro.setMoneda(rs.getString("MONEDA"));
		registro.setMetodoPago(rs.getString("METODO_PAGO"));
		registro.setDetallePago(rs.getString("DETALLE_PAGO"));
		registro.setConcepto(rs.getString("CONCEPTO"));
		registro.setNombreSucursalEmisor(rs.getString("NOMBRE_SUCURSAL_EMISOR"));
		registro.setNombreSucursalReceptor(rs.getString("NOMBRE_SUCURSAL_RECEPTOR"));
		registro.setIdCuentaTransaccion(rs.getInt("ID_USUARIO"));
		registro.setIdStatusTransaccion(rs.getInt("ID_STATUS_TRANSACCION"));
		return registro;
	}

	
}
