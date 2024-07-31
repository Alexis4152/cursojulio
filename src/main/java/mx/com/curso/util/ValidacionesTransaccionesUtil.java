package mx.com.curso.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.ZoneId;

import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.TransaccionesDto;

public class ValidacionesTransaccionesUtil {
	private TransaccionesDto transaccion;
	ResponseDto response = new ResponseDto();
	BigInteger maxValue = new BigInteger("99999999999999999999");
	BigDecimal maxCantidad = new BigDecimal("99999999.99");

	public ValidacionesTransaccionesUtil(TransaccionesDto transaccion) {
		this.transaccion = transaccion;
	}

	public ResponseDto validacionIdTransaccion() {
		if (transaccion.getIdTransaccion() == null) {
			response.setCode(0);
			response.setMessage("Error!: No puede ser Nulo la ID_TRANSACCION");
			return response;
		} else if (transaccion.getIdTransaccion().compareTo(maxValue) > 0) {
			response.setCode(0);
			response.setMessage(
					"Error!, te has excedido con rango de la ID_TRANSACCION, solo acepta un maximo de 20 digitos");
			return response;
		}
		return response;
	}
	
	public ResponseDto validacionFecha() {
		LocalDate fechaActual = LocalDate.now();
		LocalDate fecha = transaccion.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		if(fecha.isAfter(fechaActual)) {
			response.setCode(0);
			response.setMessage("Error!: No puedes modificar la fecha para futuros");
			return response; 
		}
		return response;
	}

	public ResponseDto validacionCantidad() {
		if (transaccion.getCantidad() == null) {
			response.setCode(0);
			response.setMessage("Error!: No puede ser Nulo el MONTO");
			return response;
		} else if (transaccion.getCantidad().compareTo(maxCantidad) > 0) {
			response.setCode(0);
			response.setMessage("Error!, te has excedido con rango del MONTO, solo acepta un maximo de 10 digitos");
			return response;
		}
		return response;
	}

	public ResponseDto validacionMoneda() {
		if (transaccion.getMoneda() == null) {
			response.setCode(0);
			response.setMessage("Error!: No puede ser Nulo la MONEDA");
			return response;
		} else if (transaccion.getMoneda().length() > 3 || transaccion.getMoneda().length() < 3) {
			response.setCode(0);
			response.setMessage("Error!: Debe agregar solo 3 letras, no mas, no menos, ejemplo EUR, USD, MXN, etc...");
			return response;
		}
		return response;
	}

	public ResponseDto validacionMetodoPago() {
		if (transaccion.getMetodoPago() == null) {
			response.setCode(0);
			response.setMessage("Error!: No puede ser Nulo el METODO DE PAGO");
			return response;
		} else if (transaccion.getMetodoPago().length() > 20) {
			response.setCode(0);
			response.setMessage(
					"Error!: Debe respetar el rango con el METODO DE PAGO, solo acepta hasta 20 caracteres");
			return response;
		}
		return response;
	}

	public ResponseDto validacionDetallePago() {
		if (transaccion.getDetallePago() == null) {
			response.setCode(0);
			response.setMessage("Error!: No puede ser Nulo el DETALLE DE PAGO");
			return response;
		} else if (transaccion.getDetallePago().length() > 25) {
			response.setCode(0);
			response.setMessage(
					"Error!: Excedio el rango con el DETALLE DE PAGO, solo se admiten 25 caracteres en este apartado, intenta de nuevo");
			return response;
		}
		return response;
	}

	public ResponseDto validacionConcepto() {
		if (transaccion.getConcepto() == null) {
			response.setCode(0);
			response.setMessage("Error!: No puede ser Nulo el CONCEPTO de la transferencia");
			return response;
		} else if (transaccion.getConcepto().length() > 20) {
			response.setCode(0);
			response.setMessage(
					"Error!: Excedio el rango con el CONCEPTO, solo se admiten 20 caracteres en este apartado, intenta de nuevo");
			return response;
		}
		return response;
	}

	public ResponseDto validacionNombreSucursal() {
		if (transaccion.getNombreSucursalEmisor() == null) {
			response.setCode(0);
			response.setMessage("Error!: No puede ser Nulo el NOMBRE DE LA SUCURSAL EMISORA de la transferencia");
			return response;
		} else if (transaccion.getNombreSucursalReceptor() == null) {
			response.setCode(0);
			response.setMessage("Error!: No puede ser Nulo el NOMBRE DE LA SUCURSAL RECEPTORA de la transferencia");
			return response;
		} else if (transaccion.getNombreSucursalEmisor().length() > 15) {
			response.setCode(0);
			response.setMessage(
					"Error!: Excedio el rango con el NOMBRE DE LA SUCURSAL EMISORA, solo se admiten 15 caracteres en este apartado, intenta de nuevo");
			return response;
		} else if (transaccion.getNombreSucursalReceptor().length() > 15) {
			response.setCode(0);
			response.setMessage(
					"Error!: Excedio el rango con el NOMBRE DE LA SUCURSAL RECEPTORA, solo se admiten 15 caracteres en este apartado, intenta de nuevo");
			return response;
		}
		return response;
	}

}
