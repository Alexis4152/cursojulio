package mx.com.curso.RepositoryImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.curso.Entidades.InformeProyecto;
import mx.com.curso.Repository.InformeProyectoDAO;

@Repository
public class InformeProyectoDAOImpl extends GenericDAO<InformeProyecto, Long> implements InformeProyectoDAO{
	
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<InformeProyecto> obtieneListaInformeProyecto() {
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(InformeProyecto.class);
		
		return (List<InformeProyecto>) criteria.list();
	}
	
	
}
