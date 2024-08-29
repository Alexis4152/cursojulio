package mx.com.curso.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import mx.com.curso.Dto.EmpleadosIsaulDTO;
import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Service.EmpleadosIsaulService;


@Controller
@RequestMapping(value="api/DatosEmpleados")
public class EmpleadosIsaulController {
	
	@Autowired
	private EmpleadosIsaulService empleadosService;
	
	
	//-----------Agregar Empleado-------------
		@ResponseBody 
		@RequestMapping(value="/agregarEmpleados", method = RequestMethod.POST, produces = "application/json") 
		public ResponseDto agregarNuevoEmpleados(@RequestBody EmpleadosIsaulDTO datos){
			
			return empleadosService.agregarEmpleado(datos);	
	    }
	
		
		@ResponseBody 
		@RequestMapping(value="/deleteEmpleados", method = RequestMethod.POST, produces = "application/json") 
		public ResponseDto deleteEmpleados(@RequestBody EmpleadosIsaulDTO datos){
			
			return empleadosService.deleteEmpleados(datos);	
	    }
	
		
		@ResponseBody 
		@RequestMapping(value="/consultarByM", method = RequestMethod.POST, produces = "application/json") 
		public ResponseDto consultarByM(@RequestBody EmpleadosIsaulDTO datos){
			
			return empleadosService.consultarByM(datos);
	    }
		
		
		@ResponseBody 
		@RequestMapping(value="/consultarByFT", method = RequestMethod.POST, produces = "application/json") 
		public ResponseDto consultarByFT(@RequestBody EmpleadosIsaulDTO datos){
			
			return empleadosService.consultarByFT(datos);	
	    }
		
		
		@ResponseBody 
		@RequestMapping(value="/consultarRFC", method = RequestMethod.POST, produces = "application/json") 
		public ResponseDto consultarRFC(@RequestBody EmpleadosIsaulDTO datos){
			
			return empleadosService.consultarRFC(datos);	
	    }
	

}
