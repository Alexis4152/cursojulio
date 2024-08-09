package mx.com.curso.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.curso.Dto.InformeProyectoDTO;
import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Entidades.InformeProyecto;
import mx.com.curso.Entidades.InformeProyectoId;
import mx.com.curso.Repository.InformeProyectoDAO;
import mx.com.curso.Service.InformeProyectoService;


@Service
public class InformeProyectoServiceImpl implements InformeProyectoService {

	@Autowired
	private InformeProyectoDAO informeProyectoDAO;

	
	@Override
	public ResponseDto getInformesByIdRead(InformeProyectoDTO datos) {
		ResponseDto response = new ResponseDto();
		
		InformeProyectoId id = new InformeProyectoId();
		id.setIdInforme(datos.getIdInforme());
		id.setIdProyecto(datos.getIdProyecto());
		id.setAnio(datos.getAnio());
		id.setNumeroConvocatoria(datos.getNumeroConvocatoria());
		id.setCveTipoInforme(datos.getCveTipoInforme());
		
		InformeProyecto resultado = informeProyectoDAO.read(id); // select * from tabla where id1 = ? and id2 = ? and......
		
		if(resultado != null) {
			response.setCode(200);
			response.setContent(resultado);
			response.setMessage("Informe encontrado");
		} else {
			response.setCode(100);
			response.setMessage("Informe NO encontrado");
		}
		
		return response;
	}
	
	
	
	
	
	
	
	
} // fin de clase
