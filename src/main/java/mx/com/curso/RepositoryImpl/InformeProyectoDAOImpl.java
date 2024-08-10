package mx.com.curso.RepositoryImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.curso.Dto.InformeProyectoDto;
import mx.com.curso.Entidades.InformeProyecto;
import mx.com.curso.Entidades.InformeProyectoPrimaryKey;
import mx.com.curso.Repository.InformeProyectoDAO;

@Repository
public class InformeProyectoDAOImpl extends GenericDAO<InformeProyecto, InformeProyectoPrimaryKey> implements InformeProyectoDAO{
	
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<InformeProyecto> obtieneListaInformeProyecto() {
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(InformeProyecto.class);
		
		return (List<InformeProyecto>) criteria.list();
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public InformeProyecto getInformeProyectoById(InformeProyectoDto datos) {
		InformeProyectoPrimaryKey primaryKey = new InformeProyectoPrimaryKey();
		/*
		primaryKey.setIdInforme(datos.getIdInforme());
		primaryKey.setIdProyecto(datos.getIdProyecto());
		primaryKey.setAnio(datos.getAnio());
		primaryKey.setNumeroConvocatoria(datos.getNumeroConvocatoria());
		primaryKey.setCveTipoInforme(datos.getCveTipoInforme());
		*/
		try {
			Session session = sessionFactory.getCurrentSession();
			
			//InformeProyecto informeProyecto = (InformeProyecto) session.get(InformeProyecto.class, primaryKey);
			
			return (InformeProyecto) session.get(InformeProyecto.class, primaryKey);
			//final Criteria criteria = session.createCriteria(InformeProyecto.class);
			//criteria.add(Restrictions.eq("id", datos.getIdInforme()));
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		//return (InformeProyecto) criteria.uniqueResult();
		//return informeProyecto;
	}
	
	
}
