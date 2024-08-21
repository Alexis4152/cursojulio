package mx.com.curso.RepositoryImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import mx.com.curso.Dto.InformeProyectoDTO;
import mx.com.curso.Entidades.InformeProyecto;
import mx.com.curso.Entidades.InformeProyectoId;
import mx.com.curso.Repository.InformeProyectoDAO;

@Repository
public class InformeProyectoDAOImpl extends GenericDAO<InformeProyecto, InformeProyectoId>
 implements InformeProyectoDAO{

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<InformeProyecto> consultaRegistro(InformeProyectoDTO datos) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(InformeProyecto.class);
		/*Query query = session.createQuery("SELECT id.anio, id.idProyecto, id.numeroConvocatoria, cveEstatusInforme, esDecimoAnio "  
				            + "FROM InformeProyecto "  
				            + "WHERE id.anio = :anio "  
				            + "AND id.cveTipoInforme = :cveTipoInforme "  
				            + "AND esDecimoAnio = :esDecimoAnio");
		*/
		/*
		Calendar calendar = Calendar.getInstance();		
		calendar.set(Calendar.YEAR, 2014);
		calendar.set(Calendar.MONTH, Calendar.DECEMBER);
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		Date endDate = calendar.getTime();
*/	
		criteria.add(Restrictions.eq("id.anio", datos.getAnio()));
		criteria.add(Restrictions.eq("id.cveTipoInforme", datos.getCveTipoInforme()));
		criteria.add(Restrictions.eq("esDecimoAnio", datos.getEsDecimoAnio()));
		
		
		
		List<InformeProyecto> resultados = criteria.list();
		
		System.out.println(resultados.size());
		

		/*
		List<Map<String, Object>> listaResultados = new ArrayList<>();
		for (InformeProyecto fila : resultados) {
			Map<String, Object> mapeoResultado = new HashMap<>();
			mapeoResultado.put("anio", fila.getId().getAnio());
			mapeoResultado.put("idProyecto", fila.getId().getIdProyecto());
			mapeoResultado.put("numeroConvocatoria", fila.getId().getNumeroConvocatoria());
			mapeoResultado.put("cveEstatusInforme", fila.getCveEstatusInforme());
			mapeoResultado.put("esDecimoAnio", fila.getEsDecimoAnio());
			listaResultados.add(mapeoResultado);
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		
		try {
			json = objectMapper.writeValueAsString(listaResultados);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		System.out.println(criteria);
		System.out.println("Dato enviado: " + datos.getFechaRegistroInforme());
		System.out.println("Dato recibido como year " + year);
		*/
		return resultados;
		//return listaResultados;
	}
	

}
