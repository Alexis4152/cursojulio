package mx.com.curso.RepositoryImpl;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import mx.com.curso.Dto.UsuariosAdminDto;
import mx.com.curso.Entidades.UsuariosAdmin;
import mx.com.curso.Repository.UsuariosAdminDAO;


@Repository
public class UsuariosAdminDAOImpl extends GenericDAO<UsuariosAdmin, Long> implements UsuariosAdminDAO{

	/**
	 * Consulta por hibernate
	 */
	@Override
	@SuppressWarnings("unchecked")// Quitar las advertencias (son las lineas amarillas)
	@Transactional // transacciones, es como el commit en oracle -> create, update, delete -> Es lo equivalente a un commit en oracle (Confirmar los cambios)
	public List<UsuariosAdmin> obtieneListaUsuarios() {
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UsuariosAdmin.class);// --> select * from +UsuariosAdmin
		
		return (List<UsuariosAdmin>) criteria.list(); // --> retorna una lista de usuarios
	}


	/* 
	 * JDBCTEMPLATE
	 * 1.- simple, sencillo, eficiente, y funcional
	 * 2.- SELECT NOMBRE, EDAD, SEXO -> TABLA QUE TIENES 200 CAMPOS
	 * 
	 * 
	 * HIBERNATE
	 * 1.- Si se puede, pero tienes que mapear con otras entidades. -> MuchosAMuchos, etc.
	 * 2.-  SELECT * FROM TABLA -> es decir te te traes obligatorio los 200 campos a pesar que tu solo ocupes 3
	 * 
	 */
	
	
	
	@Override
	@SuppressWarnings("unchecked")// Quitar las advertencias (son las lineas amarillas)
	@Transactional // transacciones, es como el commit en oracle -> create, update, delete -> Es lo equivalente a un commit en oracle (Confirmar los cambios)
	public UsuariosAdmin obtieneUsuarioPorId(UsuariosAdminDto datos) {
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UsuariosAdmin.class);// --> select * from +UsuariosAdmin
		
		criteria.add(Restrictions.eq("idUser", datos.getIdUser())); // -> where id_user = ?;
		
//		criteria.add(Restrictions.eq("estado", datos.getIdUser())); // -> where estado = 5;
//		criteria.add(Restrictions.eq("rol", datos.getIdUser())); // -> where rol = 5;
//		criteria.add(Restrictions.eq("edad", datos.getIdUser())); // -> where edad = 5;
		
		// select * from tabla where id_user = ?;
		
		return (UsuariosAdmin) criteria.uniqueResult(); // --> retorna una lista de usuarios
	}
	
	
	

}
