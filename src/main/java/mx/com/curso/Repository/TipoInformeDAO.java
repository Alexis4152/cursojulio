package mx.com.curso.Repository;

import java.util.List;

import mx.com.curso.Entidades.TipoInforme;

public interface TipoInformeDAO extends DAO<TipoInforme, Long> {
	
	List<TipoInforme> getTipoInforme();
	
}
