package mx.com.curso.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.UsuariosAdminDto;
import mx.com.curso.Entidades.UsuariosAdmin;

public interface UsuariosAdminService {
	
	List<UsuariosAdmin> obtieneListaUsuariosAdmin();
	
	UsuariosAdmin obtieneUsuariosAdminById(UsuariosAdminDto datos);

	ResponseDto getUsuariosByIdRead(UsuariosAdminDto datos);
	
	ResponseDto insertUsuarioAdmin(UsuariosAdminDto datos);
	ResponseDto insertUsuarioAdmin2(UsuariosAdminDto datos);

	ResponseDto eliminarUsuario(UsuariosAdminDto datos);

	ResponseDto updateUsuarioAdmin(UsuariosAdminDto datos);

}
