package mx.com.curso.Controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.TransaccionesDto;

@Controller
@RequestMapping(value = "transacciones")
public class ControllerTransacciones {
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/getTransacciones", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity <List<TransaccionesDto>> getTransacciones(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<TransaccionesDto> transacciones = new ArrayList<>();
		
		TransaccionesDto transac1 = new TransaccionesDto();
		BigDecimal cantidad = new BigDecimal(300);
		Date fecha = new Date();
		SimpleDateFormat formatoSimple = new SimpleDateFormat("dd-MM-yyyy");
		String fechaFormateada = formatoSimple.format(fecha);
		
		transac1.setIdTransaccion("1234-5678-9012-3456");
		transac1.setFecha(fechaFormateada);
		transac1.setCantidad(cantidad);
		transac1.setMoneda("MXN");
		transac1.setConcepto("Pago servicio CFE");
		transac1.setIdCuentaTransaccion("9876-5432-1012-3456");
		
		transacciones.add(transac1);
			
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(transacciones);
	}
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/insertTransacciones", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity <ResponseDto> insertTransacciones(@RequestBody TransaccionesDto transaccion){
		final HttpHeaders httpHeaders = new HttpHeaders();
		ResponseDto response = new ResponseDto();
		List<TransaccionesDto> listaTransacciones = new ArrayList<>();

		response.setCode(200);
		response.setMessage("Empleado insertado");
	
		listaTransacciones.add(transaccion);
		
		response.setContent(listaTransacciones);
	
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(response);	
	}
	
}
