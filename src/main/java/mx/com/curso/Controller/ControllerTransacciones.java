package mx.com.curso.Controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import mx.com.curso.Dto.TransaccionesAprobadasDto;
import mx.com.curso.Dto.TransaccionesDto;
import mx.com.curso.Service.TransaccionesService;

@Controller
@RequestMapping(value = "transacciones")
public class ControllerTransacciones {

	List<TransaccionesDto> transacciones = new ArrayList<>();
	final HttpHeaders httpHeaders = new HttpHeaders();
	ResponseDto response = new ResponseDto();

	@Autowired
	private TransaccionesService transaccionesService;

	@ResponseBody // NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	@RequestMapping(value = "/getTransaccion", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<List<TransaccionesDto>> getTransaccion() {
		TransaccionesDto transac1 = new TransaccionesDto();
		BigDecimal cantidad = new BigDecimal(300);
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			LocalDate fecha = LocalDate.parse("20/07/2024", formateador);

			transac1.setIdTransaccion(new BigInteger("150235"));
			transac1.setFecha(java.sql.Date.valueOf(fecha));
			transac1.setCantidad(cantidad);
			transac1.setMoneda("MXN");
			transac1.setConcepto("Pago servicio CFE");
			transac1.setIdCuentaTransaccion(1);

			transacciones.add(transac1);
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok().headers(httpHeaders).body(transacciones);
	}

	@ResponseBody // NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	@RequestMapping(value = "/insertTransacciones", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<ResponseDto> insertTransacciones(@RequestBody TransaccionesDto transaccion) {

		response.setCode(200);
		response.setMessage("Empleado insertado");

		transacciones.add(transaccion);

		response.setContent(transacciones);

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(response);
	}

	@ResponseBody // NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	@RequestMapping(value = "/getTransacciones", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<List<TransaccionesAprobadasDto>> getTransacciones() {
		List<TransaccionesAprobadasDto> transacciones = new ArrayList<>();
		
		transacciones = transaccionesService.getTransacciones();

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(transacciones);
	}

	@ResponseBody // NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	@RequestMapping(value = "/insertTransaccion", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<ResponseDto> insertTransaccion(@RequestBody TransaccionesDto transaccion) {
		
		response = transaccionesService.insertTransaccion(transaccion);

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(response);
	}

	@ResponseBody
	@RequestMapping(value = "/updateTransaccion", method = RequestMethod.PUT, produces = "application/json")
	ResponseEntity<ResponseDto> updateTransaccion(@RequestBody TransaccionesDto transaccion) {

		response = transaccionesService.updateTransaccion(transaccion);

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(response);
	}

	@ResponseBody
	@RequestMapping(value = "/deleteTransaccion", method = RequestMethod.DELETE, produces = "application/json")
	ResponseEntity<ResponseDto> deleteTransaccion(@RequestBody TransaccionesDto transaccion) {

		response = transaccionesService.deleteTransaccion(transaccion);

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(response);
	}

	@ResponseBody
	@RequestMapping(value = "/getTransaccionById/{id}", method = RequestMethod.GET, produces = "application/json")
	ResponseEntity<ResponseDto> getTransaccionById(@PathVariable("id") Integer idTransaccion) {
		
		response = transaccionesService.getTransaccionById(idTransaccion);

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return ResponseEntity.ok().headers(httpHeaders).body(response);
	}
}
