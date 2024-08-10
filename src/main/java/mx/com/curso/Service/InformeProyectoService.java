package mx.com.curso.Service;

import java.util.List;

import mx.com.curso.Dto.InformeProyectoDto;
import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Entidades.InformeProyecto;

public interface InformeProyectoService {
	
	List<InformeProyecto> obtieneListaInformeProyecto();
	
	InformeProyecto getInformeProyectoById(InformeProyectoDto datos);
	
	ResponseDto getInformeProyectoByIdRead(InformeProyectoDto datos);
}
