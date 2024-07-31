package mx.com.curso.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.TransaccionesAprobadasDto;
import mx.com.curso.Dto.TransaccionesDto;
import mx.com.curso.Repository.TransaccionesRepository;
import mx.com.curso.Service.TransaccionesService;
import mx.com.curso.util.ValidacionesTransaccionesUtil;

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
		ValidacionesTransaccionesUtil validacion = new ValidacionesTransaccionesUtil(transaccion);
					
		response = validacion.validacionIdTransaccion();
		response = validacion.validacionFecha();
		response = validacion.validacionCantidad();
		response = validacion.validacionMoneda();
		response = validacion.validacionMetodoPago();
		response = validacion.validacionDetallePago();
		response = validacion.validacionNombreSucursal();
		if (response.getCode() == 0) return response;
							
		if (transaccion.getIdCuentaTransaccion() == null) {
			response.setCode(0);
			response.setMessage("Error!: No puede ser Nulo la ID_USUARIO");
			return response;
		} else {
			Integer respuestaInsercion = transaccionesRepository.insertTransaccion(transaccion);
			if (respuestaInsercion == 1) {
				response.setCode(1);
				response.setMessage("Se inserto correctamente la transaccion");
			} else {
				response.setCode(0);
				response.setMessage("No se inserto la transaccion, favor de validar");
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
			response.setMessage("Se actualizo correctamente la transacci�n");
		} else {
			response.setCode(0);
			response.setMessage("No se actualizo correctamente la transacci�n, favor de validar");
		}

		return response;
	}

	@Override
	public ResponseDto deleteTransaccion(TransaccionesDto transaccion) {
		ResponseDto response = new ResponseDto();

		Integer respuestaEliminacion = transaccionesRepository.deleteTransaccion(transaccion);

		if (respuestaEliminacion == 1) {
			response.setCode(1);
			response.setMessage("Se elimino correctamente la transacci�n");
		} else {
			response.setCode(0);
			response.setMessage("Error!, no se pudo eliminar la transacci�n, favor de validar");
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
