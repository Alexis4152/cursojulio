package mx.com.curso.Service;

import java.util.List;

import mx.com.curso.Dto.EmpleadoDto;
import mx.com.curso.Dto.ResponseDto;

public interface UserService {

	List<EmpleadoDto> getUsers();
	
	ResponseDto insertEmpleado(EmpleadoDto empleado);
	
	ResponseDto updateEmpleado(EmpleadoDto empleado);
	
	ResponseDto deleteEmpleado(EmpleadoDto empleado);

	ResponseDto getEmpleadoById(Integer idAlumno);
}
