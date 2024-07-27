package mx.com.curso.util;

import java.math.BigInteger;

import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.TransaccionesDto;

public class ValidacionesTransaccionesUtil {
	
	public ResponseDto validacionIdTransaccion(TransaccionesDto transaccion) {
		ResponseDto response = new ResponseDto();
		BigInteger maxValue = new BigInteger("99999999999999999999");
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
}
