package mx.com.curso.Repository;

import java.util.List;

import mx.com.curso.Entidades.InformeEstudianteDocumento;
import mx.com.curso.Entidades.InformeEstudianteDocumentoPrimaryKey;

public interface InformeEstudianteDocumentoDAO extends DAO<InformeEstudianteDocumento,InformeEstudianteDocumentoPrimaryKey>{
	
	List<InformeEstudianteDocumento> getListInformeEstudianteDocumento();
}
