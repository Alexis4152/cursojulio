package mx.com.curso.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.curso.Dto.UsuariosAdminDto;
import mx.com.curso.Entidades.UsuariosAdmin;
import mx.com.curso.Repository.UsuariosAdminDAO;
import mx.com.curso.Service.UsuariosAdminService;


@Service
public class UsuariosAdminServiceImpl implements UsuariosAdminService{
	
	@Autowired
	private UsuariosAdminDAO usuariosAdminDAO;

	
	
	@Override
	public List<UsuariosAdmin> obtieneListaUsuariosAdmin() {

		
		List<UsuariosAdmin> listaUsuarios = usuariosAdminDAO.obtieneListaUsuarios();
		
		
		return listaUsuarios;
	}
	
	
	
	

}
