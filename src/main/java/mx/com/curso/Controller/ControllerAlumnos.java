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


import mx.com.curso.Dto.AlumnosDto;
import mx.com.curso.Dto.ResponseDto;

@Controller
@RequestMapping(value="Alumnos")

 

public class ControllerAlumnos {
	@ResponseBody
	
	 @RequestMapping(value="/getAlumnos", method=RequestMethod.GET,produces="application/json")
	
	ResponseEntity<List<AlumnosDto>>getAlumnos(){
		
		final HttpHeaders htpHeaders = new HttpHeaders();
		List<AlumnosDto>Alumnos = new ArrayList<>();
		
		AlumnosDto Alumno = new AlumnosDto();
		
		Alumno.setNombre ("Lorena");
		Alumno.setApellido ("Ponce");
		Alumno.setEdad (30);
		Alumno.setDireccion ("Juarez 58");

		htpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity<List<AlumnosDto>>(Alumnos,htpHeaders,HttpStatus.OK);
		
		

	
		
	}
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
   @RequestMapping(value="/insertAlumnos", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <ResponseDto> insertEmpleados(@RequestBody AlumnosDto alumno){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = new ResponseDto();
		List<AlumnosDto> alumnos = new ArrayList<>();

		response.setCode(200);
		response.setMessage("Alumno insertado");
	
		alumnos.add(alumno);
		
		response.setContent(alumnos);
	
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity <ResponseDto> (response, httpHeaders, HttpStatus.OK);	
	}

	
}
