package mx.com.curso.Controller;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import mx.com.curso.Service.UserService;

@Controller
@RequestMapping(value ="api")
public class ControllerPrincipal {
	
	
	@Autowired
	private UserService userService;

	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/getEmpleados", method = RequestMethod.GET, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <List<EmpleadoDto>> getEmpleados(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<EmpleadoDto> empleados = new ArrayList<>();
		
		EmpleadoDto empleado1 = new EmpleadoDto();
		EmpleadoDto empleado2 = new EmpleadoDto();
		BigDecimal salario = new BigDecimal(0);

		empleado1.setNombre("Luis");
		empleado1.setEdad(30);
		empleado1.setSalario( salario );
		empleado2.setNombre("hector");
		empleado2.setEdad(30);
		empleado2.setSalario( salario );
		
		empleados.add(empleado1);
		empleados.add(empleado2);
	
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <List<EmpleadoDto>> (empleados, httpHeaders, HttpStatus.OK);	
	}
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/insertEmpleados", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <ResponseDto> insertEmpleados(@RequestBody EmpleadoDto empleado){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = new ResponseDto();
		
		response =  userService.insertEmpleado(empleado);
	
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <ResponseDto> (response, httpHeaders, HttpStatus.OK);	
	}
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/getUsers", method = RequestMethod.GET, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <List<EmpleadoDto>> getUser(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<EmpleadoDto> empleados = new ArrayList<>();
		
		empleados = userService.getUsers();
	
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <List<EmpleadoDto>> (empleados, httpHeaders, HttpStatus.OK);	
	}
	
}

