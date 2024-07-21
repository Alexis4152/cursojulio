package mx.com.curso.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.curso.Dto.EmpleadoDto;
import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Repository.UserRepository;
import mx.com.curso.Service.UserService;
import mx.com.curso.util.Util;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	Util objeo = new Util();

	@Override
	public List<EmpleadoDto> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.getUsers();
	}

	@Override
	public ResponseDto insertEmpleado(EmpleadoDto empleado) {
		ResponseDto response = new ResponseDto();

		Integer respuestaInsercion = userRepository.insertEmpleado(empleado);

		if (respuestaInsercion == 1) {
			response.setCode(1);
			response.setMessage("Se insertó correctamente el empleado");
		} else {
			response.setCode(0);
			response.setMessage("No se insertó el empleado, favor de validar");
		}

		return response;
	}

	@Override
	public ResponseDto updateEmpleado(EmpleadoDto empleado) {
		ResponseDto response = new ResponseDto();
		Integer respuestInsert = userRepository.updateEmpleado(empleado);

		if (respuestInsert == 1) {
			response.setCode(1);// esto es un comentario
			response.setMessage("Se actualizo el empleado");
		} else {
			response.setCode(0);
			response.setMessage("No se actualizo el empleado, favor de validar");
		}
		return response;
	}

	@Override
	public ResponseDto deleteEmpleado(EmpleadoDto empleado) {
		ResponseDto response = new ResponseDto();
		Integer respuestaDelete = userRepository.deleteEmpleado(empleado);

		if (respuestaDelete == 1) {
			response.setCode(1);// esto es un comentario
			response.setMessage("Se eliminó al empleado");
		} else {
			response.setCode(0);
			response.setMessage("No se pudo eliminar al empleado, favor de validar");
		}
		return response;
	}

	@Override
	public ResponseDto getEmpleadoById(Integer idAlumno) {
		ResponseDto response = new ResponseDto();

		EmpleadoDto empleadoRespuesta = userRepository.getEmpleadoById(idAlumno);

		if (empleadoRespuesta != null) {
			response.setCode(1);
			response.setContent(empleadoRespuesta);
			response.setMessage("Empleado obtenido");
		} else {
			response.setCode(0);
			response.setMessage("No se pudo obtener al empleado");
		}

		return response;
	}

}
