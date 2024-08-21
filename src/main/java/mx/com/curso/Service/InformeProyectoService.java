package mx.com.curso.Service;

import java.util.List;
import java.util.Map;

import mx.com.curso.Dto.InformeProyectoDTO;
import mx.com.curso.Dto.ResponseDto;


public interface InformeProyectoService {

	ResponseDto getInformesByIdRead(InformeProyectoDTO datos);

	ResponseDto registrarNuevoInforme(InformeProyectoDTO datosInforme);
	
	List<Map<String, Object>>  consultaRegistro(InformeProyectoDTO datos);
}
