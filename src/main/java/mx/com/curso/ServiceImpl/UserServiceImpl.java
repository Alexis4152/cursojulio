package mx.com.curso.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.curso.Dto.EmpleadoDto;
import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Repository.UserRepository;
import mx.com.curso.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<EmpleadoDto> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.getUsers();
	}

	@Override
	public ResponseDto insertEmpleado(EmpleadoDto empleado) {
		ResponseDto response = new ResponseDto();
	     Integer respuestaInsercion = userRepository.insertEmpleado(empleado);
	     
	     if(respuestaInsercion == 1) {
	    	 response.setCode(1);
	    	 response.setMessage("Se insert� correctamente el empleado");
	     }
	     else {
	    	 response.setCode(0);
	    	 response.setMessage("No se insert� el empleado, favor de validar");
	     }
	    
		return response;
	}

}
