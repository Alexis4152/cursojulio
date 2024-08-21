package mx.com.curso.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.curso.Dto.InformeProyectoDTO;
import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Service.InformeProyectoService;

@Controller
@RequestMapping(value = "api/informeProyecto")
public class InformeProyectoController {


	final HttpHeaders httpHeaders = new HttpHeaders();
	
	@Autowired
	private InformeProyectoService informeProyectoService;
	
	
	@ResponseBody
	@RequestMapping(value = "/getUsuariosByIdRead", method = RequestMethod.POST, produces = "application/json")
	ResponseDto getUsuariosByIdRead(@RequestBody InformeProyectoDTO datos) {
		
		return informeProyectoService.getInformesByIdRead(datos);

	}
	
	
	@ResponseBody
	@RequestMapping(value = "/nuevoInforme", method = RequestMethod.POST, produces = "application/json")
	ResponseDto insertInformeProyecto(@RequestBody InformeProyectoDTO datosInforme) {
		
		return informeProyectoService.registrarNuevoInforme(datosInforme);
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/consultaDatos", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<List<Map<String, Object>>> consultaDatos(@RequestBody InformeProyectoDTO datos) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		List<Map<String, Object>> informeProyecto = informeProyectoService.consultaRegistro(datos);

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<List<Map<String, Object>>>(informeProyecto, httpHeaders, HttpStatus.OK);
	}
	
	
	
	
	
}// fin de la clase