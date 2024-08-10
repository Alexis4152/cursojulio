package mx.com.curso.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.curso.Entidades.TipoInforme;
import mx.com.curso.Repository.TipoInformeDAO;
import mx.com.curso.Service.TipoInformeService;

@Service
public class TipoInformeServiceImpl implements TipoInformeService{
	
	@Autowired
	private TipoInformeDAO tipoInformeDAO; 
	
	@Override
	public List<TipoInforme> getListTipoInforme() {
		List<TipoInforme> listaTipoInforme = tipoInformeDAO.getTipoInforme();
		return listaTipoInforme;
	}
	
}
