package mx.com.curso.Repository;

import java.util.List;

import mx.com.curso.Entidades.InformeProyecto;

public interface InformeProyectoDAO extends DAO<InformeProyecto, Long>{
	
	List<InformeProyecto> obtieneListaInformeProyecto();
	
}
