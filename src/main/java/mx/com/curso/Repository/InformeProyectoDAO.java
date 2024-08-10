package mx.com.curso.Repository;

import java.util.List;

import mx.com.curso.Dto.InformeProyectoDto;
import mx.com.curso.Entidades.InformeProyecto;
import mx.com.curso.Entidades.InformeProyectoPrimaryKey;

public interface InformeProyectoDAO extends DAO<InformeProyecto, InformeProyectoPrimaryKey>{
	
	List<InformeProyecto> obtieneListaInformeProyecto();
	
	InformeProyecto getInformeProyectoById(InformeProyectoDto datos);
	
}
