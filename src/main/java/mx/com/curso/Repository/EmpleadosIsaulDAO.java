package mx.com.curso.Repository;

import java.util.List;

import mx.com.curso.Entidades.EmpleadosIsaul;

public interface EmpleadosIsaulDAO extends DAO<EmpleadosIsaul, Long>{

	EmpleadosIsaul buscarPorCurpRfcNss(String curp, String rfc, String nss);

	List<EmpleadosIsaul> consultaEmpeladosMasculino(String sexo);

	List<EmpleadosIsaul> consultaEmpeladosFEdad(String sexo, Long edad);

	EmpleadosIsaul consultaEmpeladoRFC(String rfc);
	
}
