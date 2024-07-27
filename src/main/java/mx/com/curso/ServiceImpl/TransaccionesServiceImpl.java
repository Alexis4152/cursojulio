package mx.com.curso.ServiceImpl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.TransaccionesAprobadasDto;
import mx.com.curso.Dto.TransaccionesDto;
import mx.com.curso.Repository.TransaccionesRepository;
import mx.com.curso.Service.TransaccionesService;

@Service
public class TransaccionesServiceImpl implements TransaccionesService {

	@Autowired
	private TransaccionesRepository transaccionesRepository;

	@Override
	public List<TransaccionesAprobadasDto> getTransacciones() {
		// TODO Auto-generated method stub
		return transaccionesRepository.getTransacciones();
	}

	@Override
	public ResponseDto insertTransaccion(TransaccionesDto transaccion) {
		//SIMPLIFICAR TODO ESTO, METERLO EN LA PAQUETERIA UTIL Y TRAERLO AQUI EN EL SERVICE
		ResponseDto response = new ResponseDto();
		BigInteger maxValue = new BigInteger("99999999999999999999");
		BigDecimal maxCantidad = new BigDecimal("99999999.99");
		
		LocalDate fechaActual = LocalDate.now();
		LocalDate fecha = transaccion.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
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
						
		if(fecha.isAfter(fechaActual)) {
			response.setCode(0);
			response.setMessage("Error!: No puedes modificar la fecha para futuros");
			return response;
		}
		if (transaccion.getCantidad() == null) {
			response.setCode(0);
			response.setMessage("Error!: No puede ser Nulo el MONTO");
			return response;
		} else if (transaccion.getCantidad().compareTo(maxCantidad) > 0) {
			response.setCode(0);
			response.setMessage("Error!, te has excedido con rango del MONTO, solo acepta un maximo de 10 digitos");
			return response;
		}
		
		if (transaccion.getMoneda() == null) {
			response.setCode(0);
			response.setMessage("Error!: No puede ser Nulo la MONEDA");
			return response;
		} else if (transaccion.getMoneda().length() > 3 || transaccion.getMoneda().length() < 3) {
			response.setCode(0);
			response.setMessage("Error!: Debe agregar solo 3 letras, no mas, no menos, ejemplo EUR, USD, MXN, etc...");
			return response;
		}		
		
		if (transaccion.getMetodoPago() == null) {
			response.setCode(0);
			response.setMessage("Error!: No puede ser Nulo el METODO DE PAGO");
			return response;
		} else if (transaccion.getMetodoPago().length() > 20) {
			response.setCode(0);
			response.setMessage("Error!: Debe respetar el rango con el METODO DE PAGO, solo acepta hasta 20 caracteres");
			return response;
		}
			
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
		if (transaccion.getNombreSucursalEmisor() == null) {
			response.setCode(0);
			response.setMessage("Error!: No puede ser Nulo el NOMBRE DE LA SUCURSAL EMISORA de la transferencia");
			return response;
		} else if (transaccion.getNombreSucursalEmisor().length() > 15) {
			response.setCode(0);
			response.setMessage(
					"Error!: Excedio el rango con el NOMBRE DE LA SUCURSAL EMISORA, solo se admiten 15 caracteres en este apartado, intenta de nuevo");
			return response;
		}
		if (transaccion.getNombreSucursalReceptor() == null) {
			response.setCode(0);
			response.setMessage("Error!: No puede ser Nulo el NOMBRE DE LA SUCURSAL RECEPTORA de la transferencia");
			return response;
		} else if (transaccion.getNombreSucursalReceptor().length() > 15) {
			response.setCode(0);
			response.setMessage(
					"Error!: Excedio el rango con el NOMBRE DE LA SUCURSAL RECEPTORA, solo se admiten 15 caracteres en este apartado, intenta de nuevo");
			return response;
		}
		if (transaccion.getIdCuentaTransaccion() == null) {
			response.setCode(0);
			response.setMessage("Error!: No puede ser Nulo la ID_USUARIO");
			return response;
		} else {
			Integer respuestaInsercion = transaccionesRepository.insertTransaccion(transaccion);
			if (respuestaInsercion == 1) {
				response.setCode(1);
				response.setMessage("Se insertó correctamente la transacción");
			} else {
				response.setCode(0);
				response.setMessage("No se insertó la transacción, favor de validar");
			}

		}
		return response;
	}

	@Override
	public ResponseDto updateTransaccion(TransaccionesDto transaccion) {
		ResponseDto response = new ResponseDto();

		Integer respuestaActualizacion = transaccionesRepository.updateTransaccion(transaccion);

		if (respuestaActualizacion == 1) {
			response.setCode(1);
			response.setMessage("Se actualizo correctamente la transacción");
		} else {
			response.setCode(0);
			response.setMessage("No se actualizo correctamente la transacción, favor de validar");
		}

		return response;
	}

	@Override
	public ResponseDto deleteTransaccion(TransaccionesDto transaccion) {
		ResponseDto response = new ResponseDto();

		Integer respuestaEliminacion = transaccionesRepository.deleteTransaccion(transaccion);

		if (respuestaEliminacion == 1) {
			response.setCode(1);
			response.setMessage("Se elimino correctamente la transacción");
		} else {
			response.setCode(0);
			response.setMessage("Error!, no se pudo eliminar la transacción, favor de validar");
		}
		return response;
	}

	@Override
	public ResponseDto getTransaccionById(Integer idTransaccion) {
		ResponseDto response = new ResponseDto();
		try {
			TransaccionesAprobadasDto respuestaGetById = transaccionesRepository.getTransaccionById(idTransaccion);

			if (respuestaGetById != null) {
				response.setCode(1);
				response.setContent(respuestaGetById);
				response.setMessage("Transaccion obtenida");
			}
		} catch (Exception e) {
			response.setCode(0);
			response.setMessage("No se encontro la transaccion, revisa de nuevo");
		}
		return response;
	}

}
