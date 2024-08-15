package mx.com.curso.RepositoryImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.curso.Dto.InformeProyectoDTO;
import mx.com.curso.Dto.UsuariosAdminDto;
import mx.com.curso.Entidades.InformeProyecto;
import mx.com.curso.Entidades.InformeProyectoId;
import mx.com.curso.Entidades.UsuariosAdmin;
import mx.com.curso.Repository.InformeProyectoDAO;

@Repository
public class InformeProyectoDAOImpl extends GenericDAO<InformeProyecto, InformeProyectoId>
 implements InformeProyectoDAO{
	
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<InformeProyecto> procesoBatchProyectoInforme(InformeProyectoDTO datos) {
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(InformeProyecto.class);
		
		criteria.add(Restrictions.eq("id.anio", datos.getAnio()));
		criteria.add(Restrictions.eq("id.cveTipoInforme", datos.getCveTipoInforme()));
		criteria.add(Restrictions.eq("esDecimoAnio", datos.getEsDecimoAnio()));
		
		return (List<InformeProyecto>) criteria.list();
	}
	
	

}
