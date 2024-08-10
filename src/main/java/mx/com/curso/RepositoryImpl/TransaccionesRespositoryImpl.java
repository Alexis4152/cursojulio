package mx.com.curso.RepositoryImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.com.curso.Dto.TransaccionesAprobadasDto;
import mx.com.curso.Dto.TransaccionesDto;
import mx.com.curso.Repository.TransaccionesRepository;
import mx.com.curso.mapper.TransaccionesAprobadasMapper;

@Repository
public class TransaccionesRespositoryImpl implements TransaccionesRepository {

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	@Override
	public List<TransaccionesAprobadasDto> getTransacciones() {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query(
				"SELECT A.ID_TRANSACCION, A.FECHA, A.MONTO, A.MONEDA, A.METODO_PAGO, A.DETALLE_PAGO, A.CONCEPTO, A.NOMBRE_SUCURSAL_EMISOR, "
						+ "A.NOMBRE_SUCURSAL_RECEPTOR, A.ID_USUARIO, B.NOMBRE_STATUS_TRANSACCION "
						+ "FROM ADMIN1.TRANSACCIONES A " 
						+ "LEFT JOIN ADMIN1.STATUSTRANSACCIONES B "
						+ "ON A.ID_STATUS_TRANSACCION = B.ID_STATUS_TRANSACCION",
				new TransaccionesAprobadasMapper<TransaccionesAprobadasDto>());
	}

	@Override
	public Integer insertTransaccion(TransaccionesDto transaccion) {
		jdbcTemplate.setDataSource(getDataSource());
		Integer nextId = jdbcTemplate.queryForObject("SELECT ADMIN1.SEQ_TRANSACCIONES.NEXTVAL FROM DUAL", Integer.class);
		
		LocalDateTime fechaActual = LocalDateTime.now();
		LocalDate fecha = LocalDate.from(fechaActual.atZone(ZoneId.systemDefault()));

		return jdbcTemplate.update(
				"INSERT INTO ADMIN1.TRANSACCIONES (ID_TRANSACCION,FECHA,MONTO,MONEDA,METODO_PAGO,DETALLE_PAGO,CONCEPTO,NOMBRE_SUCURSAL_EMISOR,NOMBRE_SUCURSAL_RECEPTOR,ID_USUARIO,ID_STATUS_TRANSACCION)"
						+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)",
				new Object[] { nextId, fecha, transaccion.getCantidad(), transaccion.getMoneda(),
						transaccion.getMetodoPago(), transaccion.getDetallePago(), transaccion.getConcepto(),
						transaccion.getNombreSucursalEmisor(), transaccion.getNombreSucursalReceptor(),
						transaccion.getIdCuentaTransaccion(), transaccion.getIdStatusTransaccion() });
	}

	@Override
	public Integer updateTransaccion(TransaccionesDto transaccion) {
		jdbcTemplate.setDataSource(getDataSource());

		return jdbcTemplate.update(
				"UPDATE ADMIN1.TRANSACCIONES SET FECHA = ?,MONTO = ?,MONEDA = ?,METODO_PAGO = ?,DETALLE_PAGO = ?,CONCEPTO = ?,NOMBRE_SUCURSAL_EMISOR = ?,NOMBRE_SUCURSAL_RECEPTOR = ?,"
						+ "ID_USUARIO = ?,ID_STATUS_TRANSACCION = ? WHERE ID_TRANSACCION = ?",
				new Object[] { transaccion.getFecha(), transaccion.getCantidad(), transaccion.getMoneda(),
						transaccion.getMetodoPago(), transaccion.getDetallePago(), transaccion.getConcepto(),
						transaccion.getNombreSucursalEmisor(), transaccion.getNombreSucursalReceptor(),
						transaccion.getIdCuentaTransaccion(), transaccion.getIdStatusTransaccion(),
						transaccion.getIdTransaccion() });
	}

	@Override
	public Integer deleteTransaccion(TransaccionesDto transaccion) {
		jdbcTemplate.setDataSource(getDataSource());

		return jdbcTemplate.update("DELETE FROM ADMIN1.TRANSACCIONES WHERE ID_TRANSACCION = ?",
				new Object[] { transaccion.getIdTransaccion() });
	}

	@Override
	public TransaccionesAprobadasDto getTransaccionById(Integer idTransaccion) {
		TransaccionesAprobadasDto result = new TransaccionesAprobadasDto();
		try {
			jdbcTemplate.setDataSource(getDataSource());
			result = jdbcTemplate.queryForObject(
					"SELECT A.ID_TRANSACCION, A.FECHA, A.MONTO, A.MONEDA, A.METODO_PAGO, A.DETALLE_PAGO, A.CONCEPTO, "
							+ "A.NOMBRE_SUCURSAL_EMISOR, A.NOMBRE_SUCURSAL_RECEPTOR, A.ID_USUARIO, B.NOMBRE_STATUS_TRANSACCION "
							+ "FROM ADMIN1.TRANSACCIONES A " 
							+ "LEFT JOIN ADMIN1.STATUSTRANSACCIONES B "
							+ "ON A.ID_STATUS_TRANSACCION = B.ID_STATUS_TRANSACCION " 
							+ "WHERE A.ID_TRANSACCION = ?",
					new Object[] { idTransaccion }, new TransaccionesAprobadasMapper<TransaccionesAprobadasDto>());
		} catch (EmptyResultDataAccessException erdae) {
			result = null;
			System.out.println("Sucedio una exception: " + erdae.getMessage() + " no se obetuvieron resultados");
		} catch (NullPointerException npe) {
			result = null;
			System.out.println("Sucedio una exception: " + npe.getMessage() + " algun valor se encuentra como nulo");
		} catch (Exception e) {
			System.out.println("Sucedio una exception: " + e.getMessage());
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
