package mx.com.curso.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.curso.Dto.InformeProyectoDto;
import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Entidades.InformeProyecto;
import mx.com.curso.Entidades.InformeProyectoPrimaryKey;
import mx.com.curso.Repository.InformeProyectoDAO;
import mx.com.curso.Service.InformeProyectoService;

@Service
public class InformeProyectoServiceImpl implements InformeProyectoService {

	@Autowired
	private InformeProyectoDAO informeProyectoDAO;

	@Override
	public List<InformeProyecto> obtieneListaInformeProyecto() {

		List<InformeProyecto> listaInformeProyecto = informeProyectoDAO.obtieneListaInformeProyecto();

		return listaInformeProyecto;
	}

	@Override
	public InformeProyecto getInformeProyectoById(InformeProyectoDto datos) {
		InformeProyecto datosInformeById = informeProyectoDAO.getInformeProyectoById(datos);
		return datosInformeById;
	}

	@Override
	public ResponseDto getInformeProyectoByIdRead(InformeProyectoDto datos) {
		ResponseDto response = new ResponseDto();
		InformeProyectoPrimaryKey primaryKey = new InformeProyectoPrimaryKey();

		primaryKey.setIdInforme(datos.getIdInforme());
		primaryKey.setIdProyecto(datos.getIdProyecto());
		primaryKey.setAnio(datos.getAnio());
		primaryKey.setNumeroConvocatoria(datos.getNumeroConvocatoria());
		primaryKey.setCveTipoInforme(datos.getCveTipoInforme());
		InformeProyecto result = informeProyectoDAO.read(primaryKey);

		if (result != null) { // que no sea null
			response.setCode(200);
			response.setContent(result);
			response.setMessage("Informe proyecto encontrado");
		} else {
			response.setCode(100);
			//response.setContent(primaryKey);
			response.setMessage("Informe proyecto NO encontrado");
		}

		return response;
	}

}
