package mx.com.curso.Repository;

import java.util.List;

import mx.com.curso.Dto.StatusTransaccionDto;

public interface StatusTransaccionRepository {
	
	List<StatusTransaccionDto> getStatusTransaccion();
	
	Integer insertStatusTransaccion(StatusTransaccionDto statusTransaccion);
	
	Integer updateStatusTransaccion(StatusTransaccionDto statusTransaccion);
	
	Integer deleteStatusTransaccion(StatusTransaccionDto statusTransaccion);
	
	StatusTransaccionDto getByIdStatusTransaccion(Integer idStatusT);
	
}
