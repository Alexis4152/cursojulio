package mx.com.curso.Controller;


import java.util.ArrayList;
import java.util.List;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import mx.com.curso.Dto.UsuariosDto;
import mx.com.curso.Dto.ResponseDto;

@Controller
@RequestMapping(value="Usuarios") 

public class ControllerUsuarios {
	@ResponseBody
	
	 @RequestMapping(value="/getUsuarios", method=RequestMethod.GET,produces = "application/json")
	ResponseEntity<List<UsuariosDto>>getUsuarios(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<UsuariosDto> Usuario = new ArrayList<>();
		
		UsuariosDto Usuarios = new UsuariosDto();
		
		
		Usuarios.setNombre("Jazmin");
		Usuarios.setApellido("Herrera");
		Usuarios.setBanco("BBVA");
		Usuarios.setDireccionCorreoElectronico("jazhe@gmail.com");
		
		
		Usuario.add(Usuarios);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity<List<UsuariosDto>>(Usuario,httpHeaders,HttpStatus.OK);
	
}
	
	@ResponseBody 
    @RequestMapping(value="/insertUsuarios", method = RequestMethod.POST, produces = "application/json") 
	ResponseEntity <ResponseDto> insertUsuarios(@RequestBody UsuariosDto Usuario){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = new ResponseDto();
		List<UsuariosDto> Usuarios = new ArrayList<>();

		response.setCode(500);
		response.setMessage("Usuario  insertado");
	
		Usuarios.add(Usuario);
		
		response.setContent(Usuarios);
	
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <ResponseDto> (response, httpHeaders, HttpStatus.OK);	
	}
}
