package mx.com.curso.Controller;

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
import mx.com.curso.Dto.UsuariosAdminDto;
import mx.com.curso.Service.InformeProyectoService;

@Controller
@RequestMapping(value = "api/informeProyecto")
public class InformeProyectoController {

	
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
	
	
	
	
	
	
	
}// fin de la clase
