package mx.com.curso.Repository;

import java.util.List;

import mx.com.curso.Entidades.InformeEstudianteDocumento;

public interface InformeEstudianteDocumentoDAO extends DAO<InformeEstudianteDocumento, Long> {
	
	List<InformeEstudianteDocumento> obtieneListaInformeEstudianteDocumento();
}
