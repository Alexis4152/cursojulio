package mx.com.curso.ServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.curso.Dto.ResponseDto;
import mx.com.curso.Dto.UsuariosAdminDto;
import mx.com.curso.Entidades.UsuariosAdmin;
import mx.com.curso.Repository.UsuariosAdminDAO;
import mx.com.curso.Service.UsuariosAdminService;


@Service
public class UsuariosAdminServiceImpl implements UsuariosAdminService{
	
	@Autowired
	private UsuariosAdminDAO usuariosAdminDAO;

	
	
	@Override
	public List<UsuariosAdmin> obtieneListaUsuariosAdmin() {

		List<UsuariosAdmin> listaUsuarios = usuariosAdminDAO.obtieneListaUsuarios();
		
		return listaUsuarios;
	}



	@Override
	public UsuariosAdmin obtieneUsuariosAdminById(UsuariosAdminDto datos) {
		
		UsuariosAdmin datoDelUsuario = usuariosAdminDAO.obtieneUsuarioPorId(datos);

		return datoDelUsuario;
	}


	
	
	/**
	 * CODIGO: 
	 * 1.- HTTP: 200 -> OK
	 * 2.-       404 -> NOT FOUNT  no encontrado
	 * 3.-       500 -> error en el server
	 * 4.-       201 -> create -> CREADO por lo regular se cuando se registra inf en la DB
	 * 5.-       401 -> privilegios
	 * 
	 */
	
	
	
	/**
	 * ------------   CRUD - HIBERNATE -------------
	 */

/**
 * Cuando se necesites consultar por el ID = PK => primary key = llave primaria
 */
	@Override
	public ResponseDto getUsuariosByIdRead(UsuariosAdminDto datos) {
		ResponseDto response = new ResponseDto();
		
		UsuariosAdmin resultado = usuariosAdminDAO.read(datos.getIdUser()); // -> select * from tabla where idUser = ?
		
		if(resultado != null) { // que no sea null
			response.setCode(200);
			response.setContent(resultado);
			response.setMessage("Usuario encontrado");
		} else {
			response.setCode(100);
			response.setMessage("Usuario NO encontrado");
		}
		
		return response;
	}



	@Override
	public ResponseDto insertUsuarioAdmin(UsuariosAdminDto datos) {
		ResponseDto response = new ResponseDto(); // se inicializa el obj -> responde

/** LO QUE USTEDES MANDAN EN POSTMAN: datos = {
	 idUser: "10",
	 nombreCompleto: "ISAUL.....",
	 edad: "25",
	 direccion: "CDMX",
	 estado: "15",
	 rol: "ROL_ADMIN",
 }
*/
		UsuariosAdmin datosAInsertar = new UsuariosAdmin();
		datosAInsertar.setIdUser(datos.getIdUser());
		datosAInsertar.setNombreCompleto(datos.getNombreCompleto());
		datosAInsertar.setEdad(datos.getEdad());
		datosAInsertar.setDireccion(datos.getDireccion());
		datosAInsertar.setEstado(datos.getEstado());
		datosAInsertar.setRol(datos.getRol());
		
		usuariosAdminDAO.create(datosAInsertar); // insert into......
		response.setCode(200);
		response.setMessage("Datos insertados correctamente..!");
		
		return response;
	}
		
	/* 1.- que todos los datos sean obligatorios
	 * 2.- El idUser no debe ser 0
	 */
	
	@Override
	public ResponseDto insertUsuarioAdmin2(UsuariosAdminDto datos) {
		ResponseDto response = new ResponseDto();

		try {
			
			if(datos != null) { // #1
				
				if(datos.getIdUser() != null && datos.getIdUser() != 0) { // #2
					
					UsuariosAdmin datosAInsertar = new UsuariosAdmin();
					datosAInsertar.setIdUser(datos.getIdUser());
					datosAInsertar.setNombreCompleto(datos.getNombreCompleto());
					datosAInsertar.setEdad(datos.getEdad());
					datosAInsertar.setDireccion(datos.getDireccion());
					datosAInsertar.setEstado(datos.getEstado());
					datosAInsertar.setRol(datos.getRol());

					usuariosAdminDAO.create(datosAInsertar);
					response.setCode(200);
					response.setMessage("Datos insertados correctamente..!");
					
				} else {
					response.setCode(400);
					response.setMessage("El idUser no debe de ser igual a 0 (cero)");
				}
			} else {
				response.setCode(100);
				response.setMessage("Hay datos que estan vacios");
			}
		} catch (Exception e) {
			response.setCode(500);
			response.setMessage("Ocurrio un error en el metodo de insertar usuarios admin.");
		}

		return response;
	}



	@Override
	public ResponseDto eliminarUsuario(UsuariosAdminDto datos) {
		ResponseDto response = new ResponseDto();
		
		try {
			if(datos.getIdUser() != null && datos.getIdUser() != 0) {
				
				usuariosAdminDAO.delete(datos.getIdUser());
				response.setCode(200);
				response.setMessage("El registro se elimino correctamente");
				
			} else {
				response.setCode(100);
				response.setMessage("Para eliminar el usuario su idUser no debe ser vacio o igual a 0");
			}
			
		} catch (Exception e) {
			response.setCode(500);
			response.setMessage("Ocurrio un error en el metodo de eliminar usuarios admin.");
		}
		
		return response;
	}



	@Override
	public ResponseDto updateUsuarioAdmin(UsuariosAdminDto datos) {
		ResponseDto response = new ResponseDto();
		
		try {
			
			UsuariosAdmin datosUpdate = new UsuariosAdmin();
			datosUpdate.setIdUser(datos.getIdUser());
			datosUpdate.setNombreCompleto(datos.getNombreCompleto());
			datosUpdate.setEdad(datos.getEdad());
			datosUpdate.setDireccion(datos.getDireccion());
			datosUpdate.setEstado(datos.getEstado());
			datosUpdate.setRol(datos.getRol());
			
			usuariosAdminDAO.update(datosUpdate);
			response.setCode(200);
			response.setMessage("El registro se actualizo correctamente");
			
		} catch (Exception e) {
			response.setCode(500);
			response.setMessage("Ocurrio un error en el metodo de update usuarios admin.");
		}

		return response;
	}
		
	
/** --> Estos caso son HIBERNATE -> INFORME_PROYECTO

1.--> Un servicio para consultar todos los registros del año 2024
2.--> Un servicio que consulte solo los registro del Informe trienal del 2024
3.--> Un servicio que consulte solo los registro del año 2024 de la convocatoria: CATEDRAS-2014-01
4.--> Un servicio que consulte solo los registro del año 2024 de la convocatoria: CATEDRAS-2014-01 pero del informe anual
5.--> Un servicio que consulte solo los registro con estatus enviados del año 2022 
		campo-> CVE_ESTATUS_INFORME --> 1 = en captura y 2 = Enviado

*/
	
	
	

}
