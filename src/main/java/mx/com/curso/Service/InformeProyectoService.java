package mx.com.curso.Service;

import mx.com.curso.Dto.InformeProyectoDTO;
import mx.com.curso.Dto.ResponseDto;

public interface InformeProyectoService {

	ResponseDto getInformesByIdRead(InformeProyectoDTO datos);

}
