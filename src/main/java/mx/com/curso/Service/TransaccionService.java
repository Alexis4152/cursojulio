package mx.com.curso.Service;

import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.TransaccionDto;

public interface TransaccionService {
	
	Integer getIdTransaccionByIdUsuarios(Long idUsuario);
	Integer deleteId(Integer Id);
	
}
