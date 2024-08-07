package mx.com.curso.RepositoryImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import mx.com.curso.Entidades.InformeEstudianteDocumento;
import mx.com.curso.Repository.InformeEstudianteDocumentoDAO;

public class InformeEstudianteDocumentoDAOImpl extends GenericDAO<InformeEstudianteDocumento, Long> implements InformeEstudianteDocumentoDAO {

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<InformeEstudianteDocumento> obtieneListaInformeEstudianteDocumento() {
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(InformeEstudianteDocumento.class);
		
		return (List<InformeEstudianteDocumento>) criteria.list();
	}
	
	
	
}
