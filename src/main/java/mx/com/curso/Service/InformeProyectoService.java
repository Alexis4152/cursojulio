package mx.com.curso.Service;

import mx.com.curso.Dto.InformeProyectoDTO;
import mx.com.curso.Dto.ResponseDto;

public interface InformeProyectoService {

	ResponseDto getInformesByIdRead(InformeProyectoDTO datos);

	ResponseDto registrarNuevoInforme(InformeProyectoDTO datosInforme);

	ResponseDto eliminarInformeProyecto(InformeProyectoDTO datosInforme);

	ResponseDto updateInforme(InformeProyectoDTO datosInforme);

	ResponseDto procesoBatchProyectoInforme(InformeProyectoDTO datos);

}
