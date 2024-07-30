package mx.com.curso.Repository;


import mx.com.curso.Dto.TransaccionDto;

public interface TransaccionRepository {

	
	Integer deleteTransaction(Integer Id);
	Integer getIdTransaccionByIdUsuarios(Long idUsuario);
	/*Integer getIdTransaccionByIdStatus(Integer idStatus);*/
}
