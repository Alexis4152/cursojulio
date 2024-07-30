package mx.com.curso.Repository;

import java.util.List;

import mx.com.curso.Dto.UsuariosDto;

public interface UsuarioRepository {
	
List<UsuariosDto> getUsers();
	
	Integer insertUsuario(UsuariosDto usuario);
	
	Integer updateUsuario(UsuariosDto usuario);
	
	Integer deleteUsuario(UsuariosDto usuario);

	UsuariosDto  getUsuarioById (Long idUsuario);
	
	
	

}
