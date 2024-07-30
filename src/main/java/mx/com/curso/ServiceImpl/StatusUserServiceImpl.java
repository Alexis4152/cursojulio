package mx.com.curso.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.StatusUserDto;
import mx.com.curso.Dto.UsuariosDto;
import mx.com.curso.Repository.StatusUserRepository;
import mx.com.curso.Repository.UsuarioRepository;
import mx.com.curso.Service.StatusUserService;
import mx.com.curso.Service.TransaccionService;
import mx.com.curso.util.Util;
import org.springframework.stereotype.Service;

@Service

public class StatusUserServiceImpl implements StatusUserService {

	@Autowired
	private StatusUserRepository StatusUserRepository;
	@Autowired
	private TransaccionService transaccionService;
	
	@Autowired
	private UsuarioRepository UsuarioRepository;
	
	Util objeo = new Util();

	@Override
	public List<StatusUserDto> getUsers() {
		return StatusUserRepository.getStatusUsers();
	}

	

	/// insertar 

	@Override
	public ResponseDto insertstatus( StatusUserDto status) {
		ResponseDto response = new ResponseDto();
	     Integer respuestaInsercion = StatusUserRepository.insertstatus(status);
	     
	     if(respuestaInsercion == 1) {
	    	 response.setCode(1);
	    	 response.setMessage("Se insertó correctamente ");
	     }
	     else {
	    	 response.setCode(0);
	    	 response.setMessage("No se insertó , favor de validar");
	     }
	    
		return response;
	}

	
	//// actualizar 
	@Override
	public ResponseDto updatestatus(StatusUserDto status) {
		ResponseDto response = new ResponseDto();
		Integer respuestInsert = StatusUserRepository.updateStatus(status);
		
		 if(respuestInsert == 1) {
	    	 response.setCode(1);
	    	 response.setMessage("Se actualizo ");
	     }
		 else {
	    	 response.setCode(0);
	    	 response.setMessage("No se actualizo, favor de validar");
	     }
		return response;
	}

	////eliminar 
	@Override
	public ResponseDto deletestatus(StatusUserDto status) {
		ResponseDto response = new ResponseDto();
	
		Integer respuestaDelete = StatusUserRepository.deleteStatus(status);
		 if(respuestaDelete == 1) {
			 System.out.println("hola");
	    	 response.setCode(1);
	    	 response.setMessage("Se eliminó ");
	     }
		 else {
	    	 response.setCode(0);
	    	 response.setMessage("No se pudo eliminar, favor de validar");
	     }
		return response;
	}

	/// cosulta id 
	@Override
	public ResponseDto getstatusById(Integer idstatus) {
		ResponseDto response = new ResponseDto();
		
		StatusUserDto usuarioRespuesta = StatusUserRepository.getStatusById(idstatus);
		
		if(usuarioRespuesta != null ) {
			response.setCode(1);
			response.setContent(usuarioRespuesta);
			response.setMessage("Status obtenido");
		}
		else {
			response.setCode(0);
			response.setMessage("No se pudo obtener el status");
		}
		
		return response;
		
	
		
	}
	
	@Override
	public Integer getIdStatusByIdUsuarios(Long idUsuario) {
    Integer idStatus=  StatusUserRepository.getIdStatusByIdUsuarios(idUsuario);
		
		if( idStatus!=null) {
			return  idStatus;
		}
		
		else {
			return 0;
		}
	}



	@Override
	public Integer deleteId(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}



	/*

	@Override
	public Integer deleteId(Integer Id) {
		ResponseDto response = new ResponseDto();
		Integer respuestaDelete = StatusUserRepository.deleteStatus(Id);
		
		 if(respuestaDelete == 1) {
	    	 response.setCode(1);
	    	 response.setMessage("Se eliminó la transaccion");
	     }
		 else {
	    	 response.setCode(0);
	    	 response.setMessage("No se pudo eliminar la transsaccion, favor de validar");
	     }
		return response.getCode();
	}

*/

}



	
