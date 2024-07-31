package mx.com.curso.ServiceImpl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.UsuariosDto;
import mx.com.curso.Service.TransaccionService;
import mx.com.curso.Service.UsuarioService;
import mx.com.curso.util.Util;
import mx.com.curso.Repository.UsuarioRepository;

@Service
public class UsuarioServicelmpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository UsuarioRepository;
	
	@Autowired
	private TransaccionService transaccionService;
	
	Util objeo = new Util();

	@Override
	public List<UsuariosDto> getUsers() {
		// TODO Auto-generated method stub
		return UsuarioRepository.getUsers();
	}


	/// insertar 
	

	@Override
	public ResponseDto insertUsuario(UsuariosDto Usuario) {
		ResponseDto response = new ResponseDto();
	    /* Integer respuestaInsercion = UsuarioRepository.insertUsuario(Usuario);*/
	     Long longValue = new Long (999999999999999999L);
	     BigInteger maxValue = new BigInteger("99999999999999999999");
	     BigDecimal maxCantidad = new BigDecimal("99999999.99");
	    
	    	     
	     
	    //if para validar el ID_USUARIO 
	     if (Usuario.getIdUsuario() == null) {
				response.setCode(0);
				response.setMessage("Error!: No puede ser Nulo la ID_USUARIO");
				return response;
			} else if (Usuario.getIdUsuario().compareTo(longValue) > 0) {
				response.setCode(0);
				response.setMessage(
						"Error!, te has excedido con rango de la ID_Usuario, solo acepta un maximo de 20 digitos");
				return response;
			}
     //if para validar el NOMBRE 
	     
	     if (Usuario.getNombre() == null) {
				response.setCode(0);
				response.setMessage("Error!: No puede ser Nulo el NOMBRE");
				return response;
			} else if (Usuario.getNombre().length() > 40) {
				response.setCode(0);
				response.setMessage(
						"Error!: Excedio el rango con el NOMBRE, solo se admiten 40 caracteres en este apartado, intenta de nuevo");
				
				return response;
			}
	     
	   //if para validar el APELLIDO
	     
	     if (Usuario.getApellido() == null) {
				response.setCode(0);
				response.setMessage("Error!: No puede ser Nulo el APELLIDO");
				return response;
			} else if (Usuario.getApellido().length() > 40) {
				response.setCode(0);
				response.setMessage(
						"Error!: Excedio el rango con el APELLIDO, solo se admiten 40 caracteres en este apartado, intenta de nuevo");
				
				return response;
			}
	     //if para validar el EDAD
	     
	     if (Usuario.getEdad() == null) {
				response.setCode(0);
				response.setMessage("Error!: No puede ser Nulo la EDAD");
				return response;
			} else if (Usuario.getEdad().compareTo(100) > 0) {
				response.setCode(0);
				response.setMessage(
						"Error!, te has excedido con rango de la EDAD, solo acepta un maximo de 2 digitos");
				return response;
			}
	     
	     /// //if para validar el NUMERO DE CUENTA 
	     if (Usuario.getNumerocuenta() == null) {
				response.setCode(0);
				response.setMessage("Error!: No puede ser Nulo el NUMERO DE CUENTA");
				return response;
			} else if (Usuario.getNumerocuenta().compareTo(maxCantidad) > 0) {
				response.setCode(0);
				response.setMessage("Error!, te has excedido con rango de NUMERO DE CUENTA, solo acepta un maximo de 25 digitos");
				return response;
			}
    //if para validar el BANCO
	     
	     if (Usuario.getBanco() == null) {
				response.setCode(0);
				response.setMessage("Error!: No puede ser Nulo el BANCO");
				return response;
			} else if (Usuario.getBanco().length() > 20) {
				response.setCode(0);
				response.setMessage(
						"Error!: Excedio el rango con el BANCO, solo se admiten 20 caracteres en este apartado, intenta de nuevo");
				
				return response;
			}
	     
   //if para validar el TELEFONO
	     
	     if (Usuario.getTelefono() == null) {
				response.setCode(0);
				response.setMessage("Error!: No puede ser Nulo la TELEFONO");
				return response;
			} else if (Usuario.getTelefono().compareTo(longValue) > 0) {
				response.setCode(0);
				response.setMessage(
						"Error!, te has excedido con rango de la TELEFONO, solo acepta un maximo de 16 digitos");
				return response;
			}
	     
	     //if para validar el CORREO ELECTRONICO
	     if (Usuario.getDireccionCorreoElectronico() == null) {
				response.setCode(0);
				response.setMessage("Error!: No puede ser Nulo el CORREO_ELECTRONICO");
				return response;
			} else if (Usuario.getDireccionCorreoElectronico().length() > 50) {
				response.setCode(0);
				response.setMessage(
						"Error!: Excedio el rango con el CORREO_ELECTRONICO, solo se admiten 50 caracteres en este apartado, intenta de nuevo");
				
				return response;
			}
	     
	     //if para validar el ESTADO_USUARIO
	     if (Usuario.getEstadoUsuario() == null) {
				response.setCode(0);
				response.setMessage("Error!: No puede ser Nulo el ESTADO_USUARIO");
				return response;
			} else if (Usuario.getEstadoUsuario().length() > 1) {
				response.setCode(0);
				response.setMessage(
						"Error!: Excedio el rango con el ESTADO_USUARIO, solo se admiten 50 caracteres en este apartado, intenta de nuevo");
				
				
			}
	     return response;
	}
	

	
	//// actualizar 
	@Override
	public ResponseDto updateUsuario(UsuariosDto Usuario) {
		ResponseDto response = new ResponseDto();
		Integer respuestInsert = UsuarioRepository.updateUsuario(Usuario);
		
		 if(respuestInsert == 1) {
	    	 response.setCode(1);
	    	 response.setMessage("Se actualizo el usuario");
	     }
		 else {
	    	 response.setCode(0);
	    	 response.setMessage("No se actualizo el usuario, favor de validar");
	     }
		return response;
	}

	////eliminar 
	
	//1.  primero borrar la transacciÓn  (REALIZAR PUNTO 1 )
	// 2. borrar el usuario (PUNTO REALIZADO)
	
	// obtener la transacción mediante el usuario, para obtener el id de la transaccion (select  * from transaccion where id_usuario)
	//borrar la transaccion  (ya lo hicimos, esta en la linea 85)
	// borrar el usuario (en la linea 86)
	
	@Override
	public ResponseDto deleteUsuario(UsuariosDto usuario) {
	ResponseDto response = new ResponseDto();
	
        Integer idTransaccion = transaccionService.getIdTransaccionByIdUsuarios(usuario.getIdUsuario());
		Integer respuestaDeleteTransaccion = transaccionService.deleteId(idTransaccion);
		Integer respuestaDelete = UsuarioRepository.deleteUsuario(usuario);
	
		if(respuestaDelete == 1) {
	    	 response.setCode(1);
	    	 response.setMessage("Se eliminó al usuario");
	     }
		 else {
	    	 response.setCode(0);
	    	 response.setMessage("No se pudo eliminar al usuario, favor de validar");
	     }
		return response;
	}
	
	
	
	/// cosulta id 
	@Override
	public ResponseDto getUsuarioById(Long idUsuario) {
		ResponseDto response = new ResponseDto();
		
		UsuariosDto usuarioRespuesta = UsuarioRepository.getUsuarioById(idUsuario);
		
		if(usuarioRespuesta != null ) {
			response.setCode(1);
			response.setContent(usuarioRespuesta);
			response.setMessage("Usuario obtenido");
		}
		else {
			response.setCode(0);
			response.setMessage("No se pudo obtener al usuario");
		}
		
		return response;
	}


	

	




	

}
