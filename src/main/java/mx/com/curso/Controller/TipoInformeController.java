package mx.com.curso.Controller;

import java.util.List;

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

import mx.com.curso.Entidades.TipoInforme;
import mx.com.curso.Entidades.UsuariosAdmin;
import mx.com.curso.Service.TipoInformeService;

@Controller
@RequestMapping(value = "api/TipoInforme")
public class TipoInformeController {
	
	@Autowired
	private TipoInformeService tipoInformeService;
	
	@ResponseBody
	@RequestMapping(value = "/getListTipoInforme", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<List<TipoInforme>> getTipoInforme() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		List<TipoInforme> getTipoInforme = tipoInformeService.getListTipoInforme();

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<List<TipoInforme>>(getTipoInforme, httpHeaders, HttpStatus.OK);
	}
	
}
