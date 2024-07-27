package mx.com.curso.Service;

import java.util.List;

import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.StatusTransaccionDto;

public interface StatusTransaccionService {
	
	List<StatusTransaccionDto> getStatusTransaccion();
	
	ResponseDto insertStatusTransaccion(StatusTransaccionDto statusTransaccion);
	
	ResponseDto updateStatusTransaccion(StatusTransaccionDto statusTransaccion);
	
	ResponseDto deleteStatusTransaccion(StatusTransaccionDto statusTransaccion);
	
	ResponseDto getByIdStatusTransaccion(Integer idStatusT); //@VariablePath
	
}
