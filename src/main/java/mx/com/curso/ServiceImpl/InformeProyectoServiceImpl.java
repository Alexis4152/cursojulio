package mx.com.curso.ServiceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.curso.Dto.InformeProyectoDTO;
import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Entidades.BitacoraInformeEstatus;
import mx.com.curso.Entidades.InformeProyecto;
import mx.com.curso.Entidades.InformeProyectoId;
import mx.com.curso.Entidades.InformeUsuarioStatus;
import mx.com.curso.Repository.BitacoraInformeEstatusDAO;
import mx.com.curso.Repository.InformeProyectoDAO;
import mx.com.curso.Repository.InformeUsuariosStatusDAO;
import mx.com.curso.Service.InformeProyectoService;

@Service
public class InformeProyectoServiceImpl implements InformeProyectoService {
	
	@Autowired
	private InformeProyectoDAO informeProyectoDAO;
	
	@Autowired
	private InformeUsuariosStatusDAO informeUsuarioStatusDAO;
	
	@Autowired
	private BitacoraInformeEstatusDAO bitacoraInformeEstatusDAO; 

	@Override
	public ResponseDto getInformesByIdRead(InformeProyectoDTO datos) {
		ResponseDto response = new ResponseDto();

		InformeProyectoId id = new InformeProyectoId();
		id.setIdInforme(datos.getIdInforme());
		id.setIdProyecto(datos.getIdProyecto());
		id.setAnio(datos.getAnio());
		id.setNumeroConvocatoria(datos.getNumeroConvocatoria());
		id.setCveTipoInforme(datos.getCveTipoInforme());

		InformeProyecto resultado = informeProyectoDAO.read(id); // select * from tabla where id1 = ? and id2 = ?
																	// and......
System.out.println(datos.getIdInforme());
		if (resultado != null) {
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
		Date date = datosInforme.getFechaRegistroInforme();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		formatter.format(date);
		informeEntity.setFechaRegistroInforme(date);
		informeEntity.setFechaEnvioInforme(datosInforme.getFechaEnvioInforme());
		informeEntity.setCveEstatusInforme(datosInforme.getCveEstatusInforme());
		informeEntity.setCveInstitucion(datosInforme.getCveInstitucion());
		informeEntity.setEsDecimoAnio(datosInforme.getEsDecimoAnio());

		informeProyectoDAO.create(informeEntity); // insert into....tabla

		return new ResponseDto(200, "Informe registrado con exito");
	}

	@Override
	public List<Map<String, Object>> consultaRegistro(InformeProyectoDTO datos) {
		List<InformeProyecto> listaInforme = informeProyectoDAO.consultaRegistro(datos);
		List<Map<String, Object>> listaFiltrada = new ArrayList<>();
		List<String> listaFiltroConsulta = new ArrayList<>();
		
		InformeUsuarioStatus registros = new InformeUsuarioStatus();
		BitacoraInformeEstatus datosBitacora = new BitacoraInformeEstatus();
		
		String r, status = "", anio = "", bandera = "", idProyecto = "", folio = "";
		
		
		//System.out.println("(ANIO)_(ID_PROYECTO)_(NUMERO_CONVOCATORIA)_(CVE_ESTATUS_INFORME)_(ES_DECIMO_ANIO)_(Fecha_Actual)");
		for (InformeProyecto informe : listaInforme) {
			Map<String, Object> mapeo = new HashMap<>();
			mapeo.put("anio", informe.getId().getAnio());
			mapeo.put("idProyecto", informe.getId().getIdProyecto());
			mapeo.put("numeroConvocatoria", informe.getId().getNumeroConvocatoria());
			mapeo.put("cveEstatusInforme", informe.getCveEstatusInforme());
			mapeo.put("esDecimoAnio", informe.getEsDecimoAnio());
			r = informe.getId().getAnio() + "-" + informe.getId().getIdProyecto()
					+ "-" + informe.getId().getNumeroConvocatoria() + "-"
					+ informe.getCveEstatusInforme() + "-" + informe.getEsDecimoAnio() + "-" 
					+ new Date();
			//System.out.println(r);
			listaFiltroConsulta.add(r);
			listaFiltrada.add(mapeo);
			
			registros.setUsuario(informe.getUsuario());
			registros.setFechaActual(new Date());
			registros.setNumeroProyecto(informe.getId().getIdProyecto());
			status = informe.getCveEstatusInforme().equals(1) ? "En captura" :
					 informe.getCveEstatusInforme().equals(2) ? "Enviados" : null;
			registros.setStatus(status);
			for (String valorR : listaFiltroConsulta) {
				registros.setConsultaInformeUsuario(valorR);
			}
			informeUsuarioStatusDAO.create(registros);
			
			datosBitacora.setIdProyecto(informe.getId().getIdProyecto());
			datosBitacora.setUsuario(informe.getUsuario());
			datosBitacora.setFechaActual(new Date());
			datosBitacora.setFechaRegistroInforme(informe.getFechaRegistroInforme());
			datosBitacora.setFechaEnvioInforme(informe.getFechaEnvioInforme());
			bandera = informe.getCveEstatusInforme().equals(1) ? "01_ACTIVO" :
					  informe.getCveEstatusInforme().equals(2) ? "02_EN_PROCESO_DE_VALIDACION" : null;
			datosBitacora.setBanderaTransaccion(bandera);
			anio = String.valueOf(informe.getId().getAnio()).substring(2);
			idProyecto = String.valueOf(informe.getId().getIdProyecto()); 
			folio = anio + idProyecto;
			datosBitacora.setFolioProyecto(Integer.valueOf(folio));
			//System.out.println(folio);
			bitacoraInformeEstatusDAO.create(datosBitacora);
		}

		System.out.println("Si se registro");

		return null;
	}

	/*
	 * 
	 * -> INFORME_PROYECTO De preferencia con hibernate/ si no con JDBC -> ESto es
	 * solo para entregar FUNCIONALIDAD
	 * 
	 * 1.- Un servicio que consulte todos los registros del año = 2014 y el tipo
	 * informe sea el trienal y ES_DECIMO_ANIO = 1
	 * 
	 * 1.2.- Sobre la consulta del punto #1 recorrer cada una y crear la siguiente
	 * estrutura:
	 * 
	 * RESULTADO =
	 * (ANIO)_(ID_PROYECTO)_(NUMERO_CONVOCATORIA)_(CVE_ESTATUS_INFORME)_(
	 * ES_DECIMO_ANIO) ---------->
	 * 2014_500_CATEDRAS-2014-01_2_1_Fecha_actual->(YYYY-MM-DD HR-MM-SS)-> fecha en
	 * que se procesa la información
	 * 
	 * Crear una nueva tabla: Nombre lo ponen ustedes
	 * 
	 * Usuario:X_dnoriega1439 Fecha actual: fecha en que se guarda ese registro
	 * Numero de proyecto Estatus = 1 = en capotura o 2 = enviados SE DEBE REGISTRA
	 * EN ESTATUS EN TEXTO -> En captura/ Enviado
	 * 
	 * 
	 * Stream() -> Agiliza los filtros en lugar de un for, pero solo con registros mayores a miles o incluso millones
	 * }
	 * 
	 */

} // fin de clase
