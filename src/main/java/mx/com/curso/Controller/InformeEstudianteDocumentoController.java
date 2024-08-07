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

import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.TransaccionesDto;
import mx.com.curso.Entidades.InformeEstudianteDocumento;
import mx.com.curso.Service.InformeEstudianteDocumentoService;

@Controller
@RequestMapping(value = "api/informeEstudianteDocumento")
public class InformeEstudianteDocumentoController {
	
	final HttpHeaders httpHeaders = new HttpHeaders();
	ResponseDto response = new ResponseDto();
	
	@Autowired
	private InformeEstudianteDocumentoService informeEstudianteDocumentoService;
	
	@ResponseBody
	@RequestMapping(value = "/getListInformeEstudianteDocumento", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<List<InformeEstudianteDocumento>> getInformeEstudianteDocumento() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		List<InformeEstudianteDocumento> informeEstudiantedocumento = informeEstudianteDocumentoService.obtieneListaInformeEstudianteDocumento();
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(informeEstudiantedocumento);
	}
	
	@ResponseBody
	@RequestMapping(value = "/insertInformeEstudianteDocumento", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<ResponseDto> insertInformeEstudianteDocumento(@RequestBody InformeEstudianteDocumento datos) {
		
		response = informeEstudianteDocumentoService.insertInformeEstudianteDocumento(datos);

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(response);
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteInformeEstudianteDocumento", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<ResponseDto> deleteInformeEstudianteDocumento(@RequestBody InformeEstudianteDocumento datos) {
		
		response = informeEstudianteDocumentoService.deleteInformeEstudianteDocumento(datos);

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(response);
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateInformeEstudianteDocumento", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<ResponseDto> updateInformeEstudianteDocumento(@RequestBody InformeEstudianteDocumento datos) {
		
		response = informeEstudianteDocumentoService.updateInformeEstudianteDocumento(datos);

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(response);
	}
}
