package mx.com.curso.Repository;

import java.util.List;

import mx.com.curso.Dto.StatusUserDto;

public interface StatusUserRepository {

	
	Integer insertstatus(StatusUserDto  Status);
	
	Integer updateStatus(StatusUserDto Status);
	
	Integer deleteStatus(StatusUserDto Status);
	
	StatusUserDto getStatusById(Integer idAStatus);

	Integer getIdStatusByIdUsuarios(Long idUsuario);
	
	Integer deleteStataus(Integer Id);
	List<StatusUserDto> getStatusUsers();
}
