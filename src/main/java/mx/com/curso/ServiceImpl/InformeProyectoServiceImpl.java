package mx.com.curso.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.curso.Entidades.InformeProyecto;
import mx.com.curso.Repository.InformeProyectoDAO;
import mx.com.curso.Service.InformeProyectoService;

@Service
public class InformeProyectoServiceImpl implements InformeProyectoService{

	@Autowired
	private InformeProyectoDAO informeProyectoDAO;
	
	@Override
	public List<InformeProyecto> obtieneListaInformeProyecto() {
		
		List<InformeProyecto> listaInformeProyecto = informeProyectoDAO.obtieneListaInformeProyecto();
		
		return listaInformeProyecto;
	}

}
