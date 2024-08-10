package mx.com.curso.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.curso.Dto.InformeEstudianteDocumentoDto;
import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Entidades.InformeEstudianteDocumento;
import mx.com.curso.Entidades.InformeEstudianteDocumentoPrimaryKey;
import mx.com.curso.Repository.InformeEstudianteDocumentoDAO;
import mx.com.curso.Service.InformeEstudianteDocumentoService;

@Service
public class InformeEstudianteDocumentoServiceImpl implements InformeEstudianteDocumentoService {
	
	@Autowired
	private InformeEstudianteDocumentoDAO informeEstudianteDocumentoDAO;

	@Override
	public List<InformeEstudianteDocumento> getListInformeEstudianteDocumento() {
		List<InformeEstudianteDocumento> listaInformeEstudiante = informeEstudianteDocumentoDAO.getListInformeEstudianteDocumento();
		return listaInformeEstudiante;
	}

	@Override
	public ResponseDto insertInformeEstudianteDocumento(InformeEstudianteDocumentoDto datos) {
		ResponseDto response = new ResponseDto();
		InformeEstudianteDocumentoPrimaryKey pk = new InformeEstudianteDocumentoPrimaryKey();
		pk.setIdInforme(datos.getIdInformeDto());
		pk.setCveTipoInforme(datos.getCveTipoInformeDto());
		pk.setIdProyecto(datos.getIdProyectoDto());
		pk.setAnio(datos.getAnioDto());
		pk.setNumeroConvocatoria(datos.getNumeroConvocatoriaDto());
		pk.setCveInstitucion(datos.getCveInstitucionDto());
		pk.setNumeroCatedra(datos.getNumeroCatedraDto());
		pk.setCveTipoDocumento(datos.getCveTipoDocumentoDto());
		
		InformeEstudianteDocumento informeDatos = new InformeEstudianteDocumento();
		informeDatos.setId(pk);
		informeDatos.setNombreDocumento(datos.getNombreDocumentoDto());
		informeDatos.setFechaRegistro(datos.getFechaRegistroDto());
		
		if (datos != null) {
			informeEstudianteDocumentoDAO.create(informeDatos);
			response.setCode(200);
			response.setMessage("Datos de la tabla INFORME_ESTUDIANTE_DOCUMENTO fueron insertados correctamente");
		} else {
			response.setCode(100);
			response.setContent(informeDatos);
			response.setMessage("Informe proyecto NO encontrado");
		}
		
		
		
		return response;
	}
}
