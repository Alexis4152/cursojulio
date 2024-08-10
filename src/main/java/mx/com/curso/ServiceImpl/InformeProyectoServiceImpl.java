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


	
	@Override
	public ResponseDto registrarNuevoInforme(InformeProyectoDTO datosInforme) {
//		ResponseDto response = new ResponseDto();

		InformeProyectoId id = new InformeProyectoId();
		id.setIdInforme(datosInforme.getIdInforme());
		id.setIdProyecto(datosInforme.getIdProyecto());
		id.setAnio(datosInforme.getAnio());
		id.setNumeroConvocatoria(datosInforme.getNumeroConvocatoria());
		id.setCveTipoInforme(datosInforme.getCveTipoInforme());
		
//		System.class...datosInforme.id.getIdInforme()
		
		InformeProyecto informeEntity = new InformeProyecto();
		informeEntity.setId(id);
		informeEntity.setUsuario(datosInforme.getUsuario());
		informeEntity.setFechaRegistroInforme(datosInforme.getFechaRegistroInforme());
		informeEntity.setFechaEnvioInforme(datosInforme.getFechaEnvioInforme());
		informeEntity.setCveEstatusInforme(datosInforme.getCveEstatusInforme());
		informeEntity.setCveInstitucion(datosInforme.getCveInstitucion());
		informeEntity.setEsDecimoAnio(datosInforme.getEsDecimoAnio());
		
		informeProyectoDAO.create(informeEntity); // insert into....tabla
//		response.setCode(200);
//		response.setMessage("Informe registrado con exito");
		
		return new ResponseDto(200, "Informe registrado con exito");
	}
	
	
	
/*
 
-> INFORME_PROYECTO
De preferencia con hibernate/ si no con JDBC -> ESto es solo para entregar FUNCIONALIDAD

1.- Un servicio que consulte todos los registros del año = 2014 y el tipo informe sea el trienal y ES_DECIMO_ANIO = 1

1.2.- Sobre la consulta del punto #1 recorrer cada una y crear la siguiente estrutura:

RESULTADO = (ANIO)_(ID_PROYECTO)_(NUMERO_CONVOCATORIA)_(CVE_ESTATUS_INFORME)_(ES_DECIMO_ANIO)
----------> 2014_500_CATEDRAS-2014-01_2_1_Fecha_actual->(YYYY-MM-DD HR-MM-SS)-> fecha en que se procesa la información

Crear una nueva tabla: Nombre lo ponen ustedes

Usuario:X_dnoriega1439
Fecha actual: fecha en que se guarda ese registro
Numero de proyecto
Estatus = 1 = en capotura o 2 = enviados SE DEBE REGISTRA EN ESTATUS EN TEXTO -> En captura/ Enviado



}







*/
	
	
	
	
	
	
} // fin de clase
