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


import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.StatusUserDto;
import mx.com.curso.Service.StatusUserService;

@Controller
@RequestMapping(value="Status") 

public class ControllerStatusUser {

	/// pos statusUser
	
	@Autowired
	private StatusUserService StatusUserService;
	
		@ResponseBody 
	    @RequestMapping(value="/insertStatusUser", method = RequestMethod.POST, produces = "application/json") 
		ResponseEntity <ResponseDto> insertStatusUser(@RequestBody StatusUserDto status){
			final HttpHeaders httpHeaders = new HttpHeaders();
			ResponseDto response = new ResponseDto();
			List<StatusUserDto> Status = new ArrayList<>();

			response.setCode(500);
			response.setMessage("status  insertado");
		
			Status.add(status);
			
			response.setContent(status);
		
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity <ResponseDto> (response, httpHeaders, HttpStatus.OK);	
		}
		
		////
		
		
		@ResponseBody 
	    @RequestMapping(value="/InsertStatusUser", method = RequestMethod.POST, produces = "application/json") 
		ResponseEntity <ResponseDto> InsertStatusUser(@RequestBody StatusUserDto status){
			final HttpHeaders httpHeaders = new HttpHeaders();
			ResponseDto response = new ResponseDto();

			response = StatusUserService.insertstatus(status);

			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity<ResponseDto>(response, httpHeaders, HttpStatus.OK);
		}
		
	/////get insertar StatusUser 

		@ResponseBody // NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
		@RequestMapping(value = "/getStatusUser", method = RequestMethod.GET, produces = "application/json") // = select * from																								// Aspirantes
		ResponseEntity<List<StatusUserDto>> getStatusUser () {
			final HttpHeaders httpHeaders = new HttpHeaders();
			List<StatusUserDto> status = new ArrayList<>();

			status = StatusUserService.getUsers();

			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity<List<StatusUserDto>>(status, httpHeaders, HttpStatus.OK);
		}
		
		
		///////actualizar status
		
		@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	    @RequestMapping(value="/updateStatusUser", method = RequestMethod.PUT, produces = "application/json") //= select * from Aspirantes
		ResponseEntity <ResponseDto> updateStatusUser(@RequestBody StatusUserDto status){
			final HttpHeaders httpHeaders = new HttpHeaders();
			ResponseDto response = new ResponseDto();
			
			response = StatusUserService.updatestatus(status);
		
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity <ResponseDto> (response, httpHeaders, HttpStatus.OK);	
		}
		
		////eliminar status 
		@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	    @RequestMapping(value="/deleteStatusUser", method = RequestMethod.DELETE, produces = "application/json") //= select * from Aspirantes
		ResponseEntity <ResponseDto> deleteStatusUser(@RequestBody StatusUserDto status){
			final HttpHeaders httpHeaders = new HttpHeaders();
			ResponseDto response = new ResponseDto();
			
			response =  StatusUserService.deletestatus(status);
		
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity <ResponseDto> (response, httpHeaders, HttpStatus.OK);	
		}
		//// consulta id 
		@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	    @RequestMapping(value="/getStatusUserById/{id}", method = RequestMethod.GET, produces = "application/json") //= select * from Aspirantes
		ResponseEntity <ResponseDto> getStatusUserById(@PathVariable("id") Integer idstatus){
			final HttpHeaders httpHeaders = new HttpHeaders();
			ResponseDto response = new ResponseDto();
			
			response = StatusUserService.getstatusById(idstatus);
		
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity <ResponseDto> (response, httpHeaders, HttpStatus.OK);	
		}
}
