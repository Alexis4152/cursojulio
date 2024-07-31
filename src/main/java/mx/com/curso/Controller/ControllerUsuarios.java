package mx.com.curso.Controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import mx.com.curso.Service.UsuarioService;


import mx.com.curso.Dto.UsuariosDto;

import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.StatusUserDto;


@Controller
@RequestMapping(value="User") 

public class ControllerUsuarios {
	
	@Autowired
	private UsuarioService UsuarioService;
	
	
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
	

	 @RequestMapping(value="/InsertUsuarios", method = RequestMethod.POST, produces = "application/json") 
		ResponseEntity <ResponseDto> InsertUsuarios(@RequestBody UsuariosDto status){
			final HttpHeaders httpHeaders = new HttpHeaders();
			ResponseDto response = new ResponseDto();

			response = UsuarioService.insertUsuario(status);

			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
		}
	///// obtener 

	@ResponseBody 
    @RequestMapping(value="/getusuarios", method = RequestMethod.GET, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <List<UsuariosDto>> getUser(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<UsuariosDto> Usuarios = new ArrayList<>();
		
		Usuarios = UsuarioService.getUsers();
	
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <List<UsuariosDto>> (Usuarios, httpHeaders, HttpStatus.OK);	
	}
	
	///////actualizar
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/updateUsuarios", method = RequestMethod.PUT, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <ResponseDto> updateUsuarios(@RequestBody UsuariosDto Usuario){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = new ResponseDto();
		
		response =  UsuarioService.updateUsuario(Usuario);
	
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <ResponseDto> (response, httpHeaders, HttpStatus.OK);	
	}
	
	////eliminar
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/deleteUsuario", method = RequestMethod.DELETE, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <ResponseDto> deleteUsuario(@RequestBody UsuariosDto Usuario){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = new ResponseDto();
		
		response =  UsuarioService.deleteUsuario(Usuario);
	
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <ResponseDto> (response, httpHeaders, HttpStatus.OK);	
	}
	//// consulta id 
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/getUsuarioById/{id}", method = RequestMethod.GET, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <ResponseDto> getUsuarioById(@PathVariable("id") Long idUsuario){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = new ResponseDto();
		
		response = UsuarioService.getUsuarioById(idUsuario);
	
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <ResponseDto> (response, httpHeaders, HttpStatus.OK);	
	}
	
	

	
	
	
	

	
	
}

