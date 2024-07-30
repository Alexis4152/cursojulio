package mx.com.curso.Service;

import java.util.List;


import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.StatusUserDto;

public interface StatusUserService {

	List<StatusUserDto> getUsers();
	
    ResponseDto insertstatus(StatusUserDto status);
	
	ResponseDto updatestatus(StatusUserDto status);
	
	ResponseDto deletestatus(StatusUserDto status);

	ResponseDto getstatusById(Integer idstatus);
	
/* Integer getIdTransaccionByIdStatus(Integer idStatus); */
   
	/*Integer getIdStatusByIdUsuarios(Integer idStatus);*/

	Integer getIdStatusByIdUsuarios(Long idUsuario);
	
	Integer deleteId(Integer Id);
}
