package mx.com.curso.Repository;

import java.util.List;
import mx.com.curso.Entidades.UsuariosAdmin;
import mx.com.curso.Dto.UsuariosAdminDto;

// IMPORTANTE: HIBERNATE TRABAJA CON UNA TABLA A LA QUE VA REFERENCIADA
//                                 DAO<T = tipo = ENTIDAD, PK = primary key => Id de la entidad> 
public interface UsuariosAdminDAO extends DAO<UsuariosAdmin, Long> {
	
	
	List<UsuariosAdmin> obtieneListaUsuarios();

}
