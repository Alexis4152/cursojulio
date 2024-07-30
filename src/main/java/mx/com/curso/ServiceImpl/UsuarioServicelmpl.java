package mx.com.curso.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.UsuariosDto;
import mx.com.curso.Service.StatusUserService;
import mx.com.curso.Service.TransaccionService;
import mx.com.curso.Service.UsuarioService;
import mx.com.curso.util.Util;
import mx.com.curso.Repository.TransaccionRepository;
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
	     Integer respuestaInsercion = UsuarioRepository.insertUsuario(Usuario);
	     
	     if(respuestaInsercion == 1) {
	    	 response.setCode(1);
	    	 response.setMessage("Se insertó correctamente el usuario");
	     }
	     else {
	    	 response.setCode(0);
	    	 response.setMessage("No se insertó el usuario, favor de validar");
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
