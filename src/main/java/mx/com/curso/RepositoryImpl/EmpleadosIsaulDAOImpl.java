package mx.com.curso.RepositoryImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import mx.com.curso.Entidades.EmpleadosIsaul;
import mx.com.curso.Repository.EmpleadosIsaulDAO;


@Repository
public class EmpleadosIsaulDAOImpl extends GenericDAO<EmpleadosIsaul, Long> implements EmpleadosIsaulDAO{
	
	// DAO = Data Access Objetc       -> Patron de diseño
	// MVC (Modelo Vista controlador) -> Patron de diseño
	
	
	@Override
	@Transactional
	public EmpleadosIsaul buscarPorCurpRfcNss(String curp, String rfc, String nss) {
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(EmpleadosIsaul.class);// -> select * from EMPLEADOS
		
		criteria.add(Restrictions.eq("curp",curp));// -> WHERE curp = 'BHJBSDH3YUGE6732'
		criteria.add(Restrictions.eq("rfc",rfc));  // -> WHERE rfc = ?
		criteria.add(Restrictions.eq("nss",nss));  // -> WHERE nss = ?
		
		return (EmpleadosIsaul) criteria.uniqueResult();
	}

	
	
	@Override
	@Transactional
	public List<EmpleadosIsaul> consultaEmpeladosMasculino(String sexo) {
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(EmpleadosIsaul.class);// -> select * from EMPLEADOS
		
		criteria.add(Restrictions.eq("sexo",sexo));// -> WHERE sexo = ?
		
		return (List<EmpleadosIsaul>) criteria.list();
		
	}



	@Override
	@Transactional
	public List<EmpleadosIsaul> consultaEmpeladosFEdad(String sexo, Long edad) {
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(EmpleadosIsaul.class);// -> select * from EMPLEADOS
		
		criteria.add(Restrictions.eq("sexo",sexo));// -> WHERE sexo = ?
		criteria.add(Restrictions.eq("edad",edad));// -> WHERE edad = ?
		
		return (List<EmpleadosIsaul>) criteria.list();
	}



	@Override
	@Transactional
	public EmpleadosIsaul consultaEmpeladoRFC(String rfc) {
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(EmpleadosIsaul.class);// -> select * from EMPLEADOS
		
		criteria.add(Restrictions.eq("rfc",rfc));  // -> WHERE rfc = ?
		
		return (EmpleadosIsaul) criteria.uniqueResult();
	}
 
	
	
	
	
}
