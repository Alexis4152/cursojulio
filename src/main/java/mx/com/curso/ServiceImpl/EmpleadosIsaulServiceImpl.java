package mx.com.curso.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.curso.Dto.EmpleadosIsaulDTO;
import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Entidades.EmpleadosIsaul;
import mx.com.curso.Repository.EmpleadosIsaulDAO;
import mx.com.curso.Service.EmpleadosIsaulService;


@Service
public class EmpleadosIsaulServiceImpl implements EmpleadosIsaulService{ // Las reglas de negocio
	
	@Autowired
	private EmpleadosIsaulDAO empleadosDAO;
	
	String regexCurp = "^[A-Z]{1}[AEIOU]{1}[A-Z]{2}\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])([HM]{1})"
			+ "(AS|BC|BS|CC|CL|CM|CS|CH|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)"
			+ "[B-DF-HJ-NP-TV-Z]{3}[A-Z\\d]{1}\\d{1}";
	
	String regexRfc = "^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{3}$";
	String regexDiezDijitos = "^\\d{10}$";
	String regexNumber = "^\\d+$";
	
	
//	1.- Un service para insertar nuevos empleados
//	REGLA I.- Antes de insertar un empleado verificar si ya EXISTE ese usuario en la base de datos

	@Override
	public ResponseDto agregarEmpleado(EmpleadosIsaulDTO datos) {// select * from tabla where CURP = ?		
		ResponseDto response = new ResponseDto();
		
		try {
			if(datos.getCurp().matches(regexCurp)) {
				if(datos.getRfc().matches(regexRfc)) {
					if(validaNSSNumerico(datos.getNss())) { // -> validaNSS(datos.getNss()) = true/false
						if(validaNSSDiezDigitos(datos.getNss())) { // -> validaNSS(datos.getNss()) = true/false
							EmpleadosIsaul existeReg = empleadosDAO.buscarPorCurpRfcNss(datos.getCurp(), datos.getRfc(), datos.getNss()); // Consulta si EXISTE select * from tabla where CURP = ? and RFC = ? AND NSS = ?;
							System.out.println("Log#01 -> existeReg -> " + existeReg);
							
							if(existeReg != null ){// existeReg es diferente de null, Es decir si existe un reg ?
								response.setMessage("El usuario ya se encuentra registrado...!!!");
								response.setCode(100);
							}else{ // Si no NO EXISTE REG VIENE VACION
								EmpleadosIsaul ob = new EmpleadosIsaul();
//								ob.setIdEmpleados(datos.getIdEmpleados());
								ob.setNombreCompleto(datos.getNombreCompleto());
								ob.setRfc(datos.getRfc());
								ob.setCurp(datos.getCurp());
								ob.setEdad(datos.getEdad());
								ob.setSexo(datos.getSexo());
								ob.setDireccion(datos.getDireccion());
								ob.setNss(datos.getNss());
								ob.setTelefono(datos.getTelefono());
								ob.setActivo(datos.getActivo());

								empleadosDAO.create(ob);
								response.setMessage("Registro exitoso");
								response.setCode(201);
									
								}
						} else {
							response.setMessage("Su nss no cuenta con la estrutura adecuada");
							response.setCode(400);
						}
					} else {
						response.setMessage("El campo nss debe ser númerico");
						response.setCode(400);
					}
				}else {
					response.setMessage("El rfc no cuenta con la estrutura adecuada");
					response.setCode(400);
				}
			} else {
				response.setMessage("La curp no cuenta con la estrutura adecuada");
				response.setCode(400);
			}
			
		}catch(Exception e) {
			response.setCode(500);
			response.setMessage("Ocurrio un error al registrar un nuevo empleado, en la clase: EmpleadosServiceImpl en el metodo: agregarEmpleado");
		}
		return response;
	}



	
	private boolean validaNSSNumerico(String nss) {
		boolean respuesta = false;

		if(nss.matches(regexNumber)) {
			respuesta = true;
		} else {
			respuesta = false;
		}
		
		return respuesta;
	}

	private boolean validaNSSDiezDigitos(String nss) {
		boolean respuesta = false;

		if(nss.matches(regexDiezDijitos)) {
			respuesta = true;
		} else {
			respuesta = false;
		}
		
		return respuesta;
	}

/* Otro metodo que puede conbinar las 2 validaciones, falta ajustarlo y hacerlo funcionar
public Response validaNSS(String nss) {
    Response response = new Response();

    // Validar que sea numérico
    if (!nss.matches(regexNumber)) {
        response.setMessage("El campo nss debe ser numérico");
        response.setCode(400);
        return response;
    }

    // Validar que tenga exactamente 10 dígitos
    if (!nss.matches(regexDiezDijitos)) {
        response.setMessage("Su nss no cuenta con la estructura adecuada");
        response.setCode(400);
        return response;
    }

    // Si pasa ambas validaciones, se puede devolver una respuesta positiva
    response.setMessage("El NSS es válido");
    response.setCode(200); // Código de éxito (puedes ajustarlo según necesites)
    return response;
}

 */



	@Override
	public ResponseDto deleteEmpleados(EmpleadosIsaulDTO datos) {
		ResponseDto response = new ResponseDto();
		try {
			EmpleadosIsaul consultarEstado = empleadosDAO.buscarPorCurpRfcNss(datos.getCurp(), datos.getRfc(), datos.getNss()); // Consulta si EXISTE select * from tabla where CURP = ? and RFC = ? AND NSS = ?;
			if(consultarEstado != null) {
				if(consultarEstado.getActivo() == 0){// es decir si es ==0
					
					empleadosDAO.delete(consultarEstado.getIdEmpleados());
					response.setMessage("Empleado eliminado correctamente");
					response.setCode(200);
					
				} else {
					response.setMessage("Imposible eliminar Empleado, Sigue Laborando (Activo)...!");
					response.setCode(100);
				}

			} else {
				response.setMessage("Los datos del usuario no existen.");
				response.setCode(400);
			}
			
		}catch(Exception e) {
			response.setCode(500);
			response.setMessage("Ocurrio un error al eliminar el empleado, en la clase: EmpleadosServiceImpl en el metodo: deleteEmpleados");
		}
		
		return response;
	}




	@Override
	public ResponseDto consultarByM(EmpleadosIsaulDTO datos) {
		ResponseDto response = new ResponseDto();
		try {
			List<EmpleadosIsaul> listDatos = empleadosDAO.consultaEmpeladosMasculino(datos.getSexo());
			response.setCode(200);
			response.setContent(listDatos);
		
		}catch(Exception e) {
			response.setCode(500);
			response.setMessage("Ocurrio un error al eliminar el empleado, en la clase: EmpleadosServiceImpl en el metodo: deleteEmpleados");
		}
	
		return response;
	}




	@Override
	public ResponseDto consultarByFT(EmpleadosIsaulDTO datos) {
		ResponseDto response = new ResponseDto();
		try {
			List<EmpleadosIsaul> listDatos = empleadosDAO.consultaEmpeladosFEdad(datos.getSexo(), datos.getEdad());
			response.setCode(200);
			response.setContent(listDatos);
		
		}catch(Exception e) {
			response.setCode(500);
			response.setMessage("Ocurrio un error al eliminar el empleado, en la clase: EmpleadosServiceImpl en el metodo: deleteEmpleados");
		}
	
		return response;
	}




	@Override
	public ResponseDto consultarRFC(EmpleadosIsaulDTO datos) {
		ResponseDto response = new ResponseDto();
		try {
			EmpleadosIsaul listDatos = empleadosDAO.consultaEmpeladoRFC(datos.getRfc());
			response.setCode(200);
			response.setContent(listDatos);
		
		}catch(Exception e) {
			response.setCode(500);
			response.setMessage("Ocurrio un error al eliminar el empleado, en la clase: EmpleadosServiceImpl en el metodo: deleteEmpleados");
		}
	
		return response;
	}
	
	
	
	
	
	
	
	
	

}