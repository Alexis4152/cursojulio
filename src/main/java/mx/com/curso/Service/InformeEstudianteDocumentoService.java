package mx.com.curso.Service;

import java.util.List;

import mx.com.curso.Dto.InformeEstudianteDocumentoDto;
import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Entidades.InformeEstudianteDocumento;

public interface InformeEstudianteDocumentoService {
	
	List<InformeEstudianteDocumento> getListInformeEstudianteDocumento();
	
	ResponseDto insertInformeEstudianteDocumento(InformeEstudianteDocumentoDto datos);
}
