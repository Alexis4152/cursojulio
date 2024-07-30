package mx.com.curso.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.TransaccionDto;
import mx.com.curso.Repository.TransaccionRepository;
import mx.com.curso.Service.TransaccionService;

@Service
public class TransaccionServiceImpl implements TransaccionService  {

	@Autowired
	private TransaccionRepository transactionRepository;
	

	@Override
	public Integer deleteId(Integer id) {
		ResponseDto response = new ResponseDto();
		Integer respuestaDelete = transactionRepository.deleteTransaction(id);
		
		 if(respuestaDelete == 1) {
	    	 response.setCode(1);
	    	 response.setMessage("Se eliminó la transaccion");
	     }
		 else {
	    	 response.setCode(0);
	    	 response.setMessage("No se pudo eliminar la transsaccion, favor de validar");
	     }
		return response.getCode();
	}


	@Override
	public Integer getIdTransaccionByIdUsuarios(Long idUsuario) {
		Integer idTransaccion =  transactionRepository.getIdTransaccionByIdUsuarios(idUsuario);
		
		if(idTransaccion!=null) {
			return idTransaccion;
		}
		
		else {
			return 0;
		}
	}


}
