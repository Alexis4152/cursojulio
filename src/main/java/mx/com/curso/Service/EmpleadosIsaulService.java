package mx.com.curso.Service;

import mx.com.curso.Dto.EmpleadosIsaulDTO;
import mx.com.curso.Dto.ResponseDto;

public interface EmpleadosIsaulService {

	ResponseDto agregarEmpleado(EmpleadosIsaulDTO datos);

	ResponseDto deleteEmpleados(EmpleadosIsaulDTO datos);

	ResponseDto consultarByM(EmpleadosIsaulDTO datos);

	ResponseDto consultarByFT(EmpleadosIsaulDTO datos);

	ResponseDto consultarRFC(EmpleadosIsaulDTO datos);

}
