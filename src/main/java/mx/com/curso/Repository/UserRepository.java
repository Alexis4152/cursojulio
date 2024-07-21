package mx.com.curso.Repository;

import java.util.List;

import mx.com.curso.Dto.EmpleadoDto;

public interface UserRepository {

	List<EmpleadoDto> getUsers();
	
	Integer insertEmpleado(EmpleadoDto empleado);
	
	Integer updateEmpleado(EmpleadoDto empleado);
	
	Integer deleteEmpleado(EmpleadoDto empleado);

	EmpleadoDto getEmpleadoById(Integer idAlumno);
}