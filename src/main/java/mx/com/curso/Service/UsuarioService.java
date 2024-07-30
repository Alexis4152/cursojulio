package mx.com.curso.Service;

import java.util.List;

import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.UsuariosDto;

public interface UsuarioService {

List<UsuariosDto> getUsers();
	
	ResponseDto insertUsuario(UsuariosDto usuario);
	
	ResponseDto updateUsuario(UsuariosDto usuario);
	
	ResponseDto deleteUsuario(UsuariosDto usuario);

	ResponseDto getUsuarioById(Long idUsuario);
	
	
}
