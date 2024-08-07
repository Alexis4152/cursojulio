package mx.com.curso.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Entidades.InformeEstudianteDocumento;
import mx.com.curso.Repository.InformeEstudianteDocumentoDAO;
import mx.com.curso.Service.InformeEstudianteDocumentoService;

@Service
public class InformeEstudianteDocumentoServiceImpl implements InformeEstudianteDocumentoService {
	
	@Autowired
	private InformeEstudianteDocumentoDAO informeEstudianteDocumentoDAO;

	@Override
	public List<InformeEstudianteDocumento> obtieneListaInformeEstudianteDocumento() {
		
		List<InformeEstudianteDocumento> listaInformeEstudiante = informeEstudianteDocumentoDAO.obtieneListaInformeEstudianteDocumento();
		
		return listaInformeEstudiante;
	}

	@Override
	public ResponseDto insertInformeEstudianteDocumento(InformeEstudianteDocumento datos) {
		ResponseDto response  = new ResponseDto();
		
		try {
			InformeEstudianteDocumento datosInforme = new InformeEstudianteDocumento();
			if (datos != null) {
								
				datosInforme.setIdInforme(datos.getIdInforme());
				datosInforme.setCveTipoInforme(datos.getCveTipoInforme());
				datosInforme.setIdProyecto(datos.getIdProyecto());
				datosInforme.setAnio(datos.getAnio());
				datosInforme.setNumeroConvocatoria(datos.getNumeroConvocatoria());
				datosInforme.setCveInstitucion(datos.getCveInstitucion());
				datosInforme.setNumeroCatedra(datos.getNumeroCatedra());
				datosInforme.setCveTipoDocumento(datos.getCveTipoDocumento());
				datosInforme.setNombreDocumento(datos.getNombreDocumento());
				datosInforme.setFechaRegistro(datos.getFechaRegistro());
				
				informeEstudianteDocumentoDAO.create(datosInforme);
				response.setCode(200);
				response.setMessage("Datos insertados correctamente...");	
			} else {
				response.setCode(100);
				response.setMessage("Hay datos que vienen vacios");
			}
			
		} catch(Exception e) {
			response.setCode(500);
			response.setMessage("Hubo un error dentro de tu codigo, verifica porque e intentalo de nuevo...");
		}
		
		return response;
	}

	@Override
	public ResponseDto deleteInformeEstudianteDocumento(InformeEstudianteDocumento datos) {
		ResponseDto response = new ResponseDto();
		
		try {
			if (datos.getIdInforme() != null && datos.getIdInforme() != 0) {
				informeEstudianteDocumentoDAO.delete(datos.getIdInforme());
				response.setCode(200);
				response.setMessage("El registro se elimino correctamente");
			} else {
				response.setCode(100);
				response.setMessage("Para eliminar la ID del usuario es necesario que no este vacio el campo y mucho menos ser igual o menor a 0");
			}
			
		} catch (Exception e) {
			response.setCode(500);
			response.setMessage("Hubo un error dentro de tu codigo, verifica porque e intentalo de nuevo...");
		}
		return response;
	}

	@Override
	public ResponseDto updateInformeEstudianteDocumento(InformeEstudianteDocumento datos) {
		ResponseDto response = new ResponseDto();
		
		try {
			InformeEstudianteDocumento updateDatosInforme = new InformeEstudianteDocumento();
			if (datos.getIdInforme() != null && datos.getIdInforme() != 0) {
				updateDatosInforme.setIdInforme(datos.getIdInforme());
				updateDatosInforme.setCveTipoInforme(datos.getCveTipoInforme());
				updateDatosInforme.setIdProyecto(datos.getIdProyecto());
				updateDatosInforme.setAnio(datos.getAnio());
				updateDatosInforme.setNumeroConvocatoria(datos.getNumeroConvocatoria());
				updateDatosInforme.setCveInstitucion(datos.getCveInstitucion());
				updateDatosInforme.setNumeroCatedra(datos.getNumeroCatedra());
				updateDatosInforme.setCveTipoDocumento(datos.getCveTipoDocumento());
				updateDatosInforme.setNombreDocumento(datos.getNombreDocumento());
				updateDatosInforme.setFechaRegistro(datos.getFechaRegistro());
				
				informeEstudianteDocumentoDAO.update(updateDatosInforme);
				response.setCode(200);
				response.setMessage("Datos actualizados correctamente...");	
				
			} else {
				response.setCode(100);
				response.setMessage("Para eliminar la ID del usuario es necesario que no este vacio el campo y mucho menos ser igual o menor a 0");
			}
		} catch (Exception e) {
			response.setCode(500);
			response.setMessage("Hubo un error dentro de tu codigo, verifica porque e intentalo de nuevo...");
		}
		return response;
	}
	
	
}
