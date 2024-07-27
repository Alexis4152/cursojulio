package mx.com.curso.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.StatusTransaccionDto;
import mx.com.curso.Repository.StatusTransaccionRepository;
import mx.com.curso.Service.StatusTransaccionService;

@Service
public class StatusTransaccionServiceImpl implements StatusTransaccionService {

	@Autowired
	private StatusTransaccionRepository statusTransaccionRepository;

	@Override
	public List<StatusTransaccionDto> getStatusTransaccion() {
		// TODO Auto-generated method stub
		return statusTransaccionRepository.getStatusTransaccion();
	}

	@Override
	public ResponseDto insertStatusTransaccion(StatusTransaccionDto statusTransaccion) {
		ResponseDto response = new ResponseDto();
		Integer respuestaInsercion = statusTransaccionRepository.insertStatusTransaccion(statusTransaccion);

		if (respuestaInsercion == 1) {
			response.setCode(1);
			response.setMessage("Se registro correctamente");
		} else {
			response.setCode(0);
			response.setMessage("No se pudo registrar, favor de revisar y volver a intentar");
		}

		return response;
	}

	@Override
	public ResponseDto updateStatusTransaccion(StatusTransaccionDto statusTransaccion) {
		ResponseDto response = new ResponseDto();
		Integer respuestaUpdate = statusTransaccionRepository.updateStatusTransaccion(statusTransaccion);

		if (respuestaUpdate == 1) {
			response.setCode(1);
			response.setMessage("Se actualizo de forma correcta el registro");
		} else {
			response.setCode(0);
			response.setMessage("Error, hubo problemas al actualizar el registro, favor de analizar");
		}
		return response;
	}

	@Override
	public ResponseDto deleteStatusTransaccion(StatusTransaccionDto statusTransaccion) {
		ResponseDto response = new ResponseDto();
		Integer respuestaDelete = statusTransaccionRepository.deleteStatusTransaccion(statusTransaccion);

		if (respuestaDelete == 1) {
			response.setCode(1);
			response.setMessage("Se ha eliminado exitosamente el registro");
		} else {
			response.setCode(0);
			response.setMessage(
					"Hubo un error al intentar eliminar el registro, revisa de nuevo e intentalo mas tarde...");
		}
		return response;
	}

	@Override
	public ResponseDto getByIdStatusTransaccion(Integer idStatusT) {
		ResponseDto response = new ResponseDto();
		try {
			StatusTransaccionDto respuestaGetById = statusTransaccionRepository.getByIdStatusTransaccion(idStatusT);
			if (respuestaGetById != null) {
				response.setCode(1);
				response.setContent(respuestaGetById);
				response.setMessage("Se ha encontrado exitosamente");
			}
		} catch (EmptyResultDataAccessException e) {
			response.setMessage("Esta Id no se encuentra, intenta con otra...");
		}

		return response;
	}

}
