package mx.com.curso.Repository;

import java.util.List;

import mx.com.curso.Dto.InformeProyectoDTO;
import mx.com.curso.Entidades.InformeProyecto;
import mx.com.curso.Entidades.InformeProyectoId;

public interface InformeProyectoDAO extends DAO<InformeProyecto, InformeProyectoId>{

	List<InformeProyecto> procesoBatchProyectoInforme(InformeProyectoDTO datos);
	
	
	

}
