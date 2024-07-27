package mx.com.curso.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.com.curso.Dto.TransaccionesAprobadasDto;

public class TransaccionesAprobadasMapper<T> implements RowMapper<TransaccionesAprobadasDto>{

	@Override
	public TransaccionesAprobadasDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		TransaccionesAprobadasDto registro = new TransaccionesAprobadasDto();
		registro.setIdTransaccion(rs.getInt("ID_TRANSACCION"));
		registro.setFecha(rs.getDate("FECHA"));
		registro.setCantidad(rs.getBigDecimal("MONTO"));
		registro.setMoneda(rs.getString("MONEDA"));
		registro.setMetodoPago(rs.getString("METODO_PAGO"));
		registro.setDetallePago(rs.getString("DETALLE_PAGO"));
		registro.setConcepto(rs.getString("CONCEPTO"));
		registro.setNombreSucursalEmisor(rs.getString("NOMBRE_SUCURSAL_EMISOR"));
		registro.setNombreSucursalReceptor(rs.getString("NOMBRE_SUCURSAL_RECEPTOR"));
		registro.setIdCuentaTransaccion(rs.getInt("ID_USUARIO"));
		registro.setNombreStatusTransaccion(rs.getString("NOMBRE_STATUS_TRANSACCION"));
		return registro;
	}
	
}
