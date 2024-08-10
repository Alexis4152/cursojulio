package mx.com.curso.RepositoryImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.com.curso.Entidades.InformeEstudianteDocumento;
import mx.com.curso.Entidades.InformeEstudianteDocumentoPrimaryKey;
import mx.com.curso.Repository.InformeEstudianteDocumentoDAO;

@Repository
public class InformeEstudianteDocumentoDAOImpl extends GenericDAO<InformeEstudianteDocumento, InformeEstudianteDocumentoPrimaryKey> implements InformeEstudianteDocumentoDAO{

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<InformeEstudianteDocumento> getListInformeEstudianteDocumento() {
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(InformeEstudianteDocumento.class);
		
		return (List<InformeEstudianteDocumento>) criteria.list();
	}
}
