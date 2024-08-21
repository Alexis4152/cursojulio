package mx.com.curso.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.curso.Dto.InformeEstudianteDocumentoDto;
import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Entidades.InformeEstudianteDocumento;
import mx.com.curso.Service.InformeEstudianteDocumentoService;

@Controller
@RequestMapping(value = "api/InformeEstudianteDocumento")
public class InformeEstudianteDocumentoController {
	
	final HttpHeaders httpHeaders = new HttpHeaders();
	
	@Autowired
	private InformeEstudianteDocumentoService informeEstudianteDocumentoService;
	
	@ResponseBody
	@RequestMapping(value = "/getListInformeEstudianteDocumento", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<List<InformeEstudianteDocumento>> getListInformeEstudianteDocumento() {
		
		List<InformeEstudianteDocumento> informeEstudiante = informeEstudianteDocumentoService.getListInformeEstudianteDocumento();
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(informeEstudiante);
	}
	
	@ResponseBody
	@RequestMapping(value = "/insertInformeEstudianteDocumento", method = RequestMethod.POST, produces = "application/json")
	ResponseDto insertInformeEstudianteDocumento(@RequestBody InformeEstudianteDocumentoDto datos) {

		return informeEstudianteDocumentoService.insertInformeEstudianteDocumento(datos);
	}
	
}









/* INFORME_PROYECTO
 * GENERAR UN SERVICIO QUE CONSULTE TODOS LOS REGISTROS DEL AÑO 2024 Y EL TIPO INFORME SEA EL TRIENAL Y ES_DECIMO_ANIO = 1
 * 
 * SOBRE LA CONSULTA DEL PUNTO NUMERO 1 RECORRER CADA UNA Y CREAR LA SIGUIENTE ESTRUCTURA:
 * DEBE SER 1 PARA ES_DECIMO_ANIO
 */