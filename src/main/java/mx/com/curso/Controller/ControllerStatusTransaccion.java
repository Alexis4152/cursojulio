package mx.com.curso.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.StatusTransaccionDto;
import mx.com.curso.Service.StatusTransaccionService;

@Controller
@RequestMapping(value = "statusTransaccion")
public class ControllerStatusTransaccion {
	
	List<StatusTransaccionDto> statusTransacciones = new ArrayList<>();
	final HttpHeaders httpHeaders = new HttpHeaders();
	ResponseDto response = new ResponseDto();
	
	@Autowired
	private StatusTransaccionService statusTransaccionService;
	
	// SE LE LLAMA NOMBRE DEL SERVICIO AL VALOR QUE OBTIENE EN LA URL, ES DECIR /GETTRANSACCIONES
	@ResponseBody // NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	@RequestMapping(value = "/getStatusTransacciones", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<List<StatusTransaccionDto>> getStatusTransacciones() {
		
		StatusTransaccionDto transac1 = new StatusTransaccionDto();

		transac1.setIdStatusTransaccion(1);
		transac1.setNombreStatusTransaccion("FAILED");
		transac1.setDescripcionStatusTransaccion("Hubo un error, lo sentimos... Fallo la transacción");
		
		statusTransacciones.add(transac1);

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(statusTransacciones);
	}
	
	@ResponseBody // NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	@RequestMapping(value = "/getStatusTransaccion", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<List<StatusTransaccionDto>> getStatusTransaccion() {
		
		statusTransacciones = statusTransaccionService.getStatusTransaccion();

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(statusTransacciones);
	}
	
	@ResponseBody // NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	@RequestMapping(value = "/insertStatusTransaccion", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity <ResponseDto> insertStatusTransaccion(@RequestBody StatusTransaccionDto statusTransaccion) {
		
		response = statusTransaccionService.insertStatusTransaccion(statusTransaccion);

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(response);
	}
	
	@ResponseBody // NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	@RequestMapping(value = "/updateStatusTransaccion", method = RequestMethod.PUT, produces = "application/json")
	ResponseEntity <ResponseDto> updateStatusTransaccion(@RequestBody StatusTransaccionDto statusTransaccion) {
		
		response = statusTransaccionService.updateStatusTransaccion(statusTransaccion);

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(response);
	}
	
	@ResponseBody // NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	@RequestMapping(value = "/deleteStatusTransaccion", method = RequestMethod.DELETE, produces = "application/json")
	ResponseEntity <ResponseDto> deleteStatusTransaccion(@RequestBody StatusTransaccionDto statusTransaccion) {
		
		response = statusTransaccionService.deleteStatusTransaccion(statusTransaccion);

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(response);
	}
	
	@ResponseBody // NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	@RequestMapping(value = "/getByIdStatusTransaccion/{id}", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity <ResponseDto> getByIdStatusTransaccion(@PathVariable("id") Integer idStatusT) {
		
		response = statusTransaccionService.getByIdStatusTransaccion(idStatusT);

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(response);
	}
	
}
