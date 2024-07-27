package mx.com.curso.Service;

import java.util.List;

import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.TransaccionesAprobadasDto;
import mx.com.curso.Dto.TransaccionesDto;

public interface TransaccionesService {
	
	List<TransaccionesAprobadasDto> getTransacciones();
	
	ResponseDto insertTransaccion(TransaccionesDto transaccion);
	
	ResponseDto updateTransaccion(TransaccionesDto transaccion);
	
	ResponseDto deleteTransaccion(TransaccionesDto transaccion);
	
	ResponseDto getTransaccionById(Integer idTransaccion);
}
