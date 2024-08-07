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

import mx.com.curso.Dto.EmpleadoDto;
import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.UsuariosAdminDto;
import mx.com.curso.Entidades.UsuariosAdmin;
import mx.com.curso.Service.UsuariosAdminService;


@Controller
@RequestMapping(value = "api/usuarioAdmin")
public class UsuariosAdminController {

	@Autowired
	private UsuariosAdminService usuariosAdminService;
	
	
	
	@ResponseBody
	@RequestMapping(value = "/getListUsuariosAdmin", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<List<UsuariosAdmin>> getUsuariosAdmin() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		List<UsuariosAdmin> usuarios = usuariosAdminService.obtieneListaUsuariosAdmin();

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<List<UsuariosAdmin>>(usuarios, httpHeaders, HttpStatus.OK);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/getUsuariosAdminById", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<UsuariosAdmin> getUsuariosAdminById(@RequestBody UsuariosAdminDto datos) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		UsuariosAdmin response = usuariosAdminService.obtieneUsuariosAdminById(datos);

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<UsuariosAdmin>(response, httpHeaders, HttpStatus.OK);
	}

	
	@ResponseBody
	@RequestMapping(value = "/getUsuariosByIdRead", method = RequestMethod.POST, produces = "application/json")
	ResponseDto getUsuariosByIdRead(@RequestBody UsuariosAdminDto datos) {
		
		return usuariosAdminService.getUsuariosByIdRead(datos);

	}
	
	
	

	@ResponseBody
	@RequestMapping(value = "/insertUsuariosAdmin", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<ResponseDto> insertUsuariosAdmin(@RequestBody UsuariosAdminDto datos) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = new ResponseDto();

//		response = usuariosAdminService.insertUsuarioAdmin(datos); // Create sin validaciones
		response = usuariosAdminService.insertUsuarioAdmin2(datos); // Create con validaciones

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}

	
	// Eliminar registro
	@ResponseBody
    @RequestMapping(value="/eliminarUsuario", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity <ResponseDto> eliminarUsuario(@RequestBody UsuariosAdminDto datos){
		final HttpHeaders httpHeaders = new HttpHeaders();

		ResponseDto respuesta = usuariosAdminService.eliminarUsuario(datos);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <ResponseDto> (respuesta, httpHeaders, HttpStatus.OK);	
    }
	
	
	
	@ResponseBody
	@RequestMapping(value = "/updateUsuariosAdmin", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<ResponseDto> updateUsuariosAdmin(@RequestBody UsuariosAdminDto datos) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = new ResponseDto();

		response = usuariosAdminService.updateUsuarioAdmin(datos);

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
	}
	
	
	
} // Fin de la clase
