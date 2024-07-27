package mx.com.curso.Repository;

import java.util.List;

import mx.com.curso.Dto.TransaccionesAprobadasDto;
import mx.com.curso.Dto.TransaccionesDto;

public interface TransaccionesRepository {
	
	List<TransaccionesAprobadasDto> getTransacciones();
	
	Integer insertTransaccion(TransaccionesDto transaccion);
	
	Integer updateTransaccion(TransaccionesDto transaccion);
	
	Integer deleteTransaccion(TransaccionesDto transaccion);
	
	TransaccionesAprobadasDto getTransaccionById(Integer idTransaccion);	
}
