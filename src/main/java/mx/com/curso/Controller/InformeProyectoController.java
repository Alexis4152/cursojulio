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

import mx.com.curso.Dto.InformeProyectoDto;
import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Entidades.InformeProyecto;
import mx.com.curso.Service.InformeProyectoService;

@Controller
@RequestMapping(value = "api/informeProyecto")
public class InformeProyectoController {

	final HttpHeaders httpHeaders = new HttpHeaders();
	
	@Autowired
	private InformeProyectoService informeProyectoService;
	
	@ResponseBody
	@RequestMapping(value = "/getListInformeProyecto", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<List<InformeProyecto>> getInformeProyecto() {
		
		List<InformeProyecto> informeProyecto = informeProyectoService.obtieneListaInformeProyecto();
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(informeProyecto);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getInformeProyectoById", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<InformeProyecto> getInformeProyectoById(@RequestBody InformeProyectoDto datos) {
		
		InformeProyecto response = informeProyectoService.getInformeProyectoById(datos);

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(response);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getInformeProyectoByIdRead", method = RequestMethod.POST, produces = "application/json")
	ResponseDto getInformeProyectoByIdRead(@RequestBody InformeProyectoDto datos) {
		
		return informeProyectoService.getInformeProyectoByIdRead(datos);
	}
}
