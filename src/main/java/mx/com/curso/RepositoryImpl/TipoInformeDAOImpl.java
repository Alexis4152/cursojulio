package mx.com.curso.RepositoryImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import mx.com.curso.Entidades.TipoInforme;
import mx.com.curso.Repository.TipoInformeDAO;

@Repository
public class TipoInformeDAOImpl extends GenericDAO<TipoInforme, Long> implements TipoInformeDAO{

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<TipoInforme> getTipoInforme() {
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(TipoInforme.class);
		
		return (List<TipoInforme>) criteria.list();
	}

}
