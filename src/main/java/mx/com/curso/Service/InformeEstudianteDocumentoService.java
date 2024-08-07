package mx.com.curso.Service;

import java.util.List;

import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Entidades.InformeEstudianteDocumento;

public interface InformeEstudianteDocumentoService {
	
	List<InformeEstudianteDocumento> obtieneListaInformeEstudianteDocumento();
	
	ResponseDto insertInformeEstudianteDocumento(InformeEstudianteDocumento datos);
	
	ResponseDto deleteInformeEstudianteDocumento(InformeEstudianteDocumento datos);
	
	ResponseDto updateInformeEstudianteDocumento(InformeEstudianteDocumento datos);
}
