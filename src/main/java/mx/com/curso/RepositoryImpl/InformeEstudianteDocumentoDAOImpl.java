package mx.com.curso.RepositoryImpl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
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

/*
 * 		Date fecha = datos.getFechaRegistroInforme();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fechaFormateada = sdf.format(fecha);
		
		
		int year = fecha.getYear();
		LocalDate startDate = LocalDate.of(year, 1, 1);
		
		LocalDate endDate = LocalDate.of(year, 12, 31);
		
		Date start = Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date end = Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	
		
 */