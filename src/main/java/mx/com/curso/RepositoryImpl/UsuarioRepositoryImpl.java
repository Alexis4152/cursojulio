package mx.com.curso.RepositoryImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.com.curso.Dto.UsuariosDto;
import mx.com.curso.Repository.UsuarioRepository;
import mx.com.curso.mapper.UsuariosMapper;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

	// JDBC TEMPLATE - NECESITA UNA CONEXIÓN A BASE DE DATOS

		@Autowired
		private DataSource dataSource;

		private JdbcTemplate jdbcTemplate = new JdbcTemplate();

		
		
		@Override
		public List<UsuariosDto> getUsers() {
			jdbcTemplate.setDataSource(getDataSource());
			return jdbcTemplate.query("SELECT  * FROM USUARIOS", new UsuariosMapper<UsuariosDto>());
		}

		
		/// insertar 
		@Override
		public Integer insertUsuario(UsuariosDto usuario) {
			jdbcTemplate.setDataSource(getDataSource());
			return jdbcTemplate.update("INSERT INTO USUARIOS(ID_USUARIO, NOMBRE, APELLIDO, EDAD, NUMERO_CUENTA, BANCO,"
					+ "TELEFONO,CORREO_ELECTRONICO,ESTADO_USUARIO) VALUES (?,?,?,?,?,?,?,?,?)",
					new Object[] { usuario.getIdUsuario(), usuario.getNombre(), usuario.getApellido(),
							usuario.getEdad(),usuario.getNumerocuenta(),usuario.getBanco(),
							usuario.getTelefono(),usuario.getDireccionCorreoElectronico(),usuario.getEstadoUsuario()  });
		}
/// actualizar 
		@Override
		 public Integer updateUsuario(UsuariosDto usuario) {
			jdbcTemplate.setDataSource(getDataSource());
			return jdbcTemplate.update("UPDATE USUARIOS SET NOMBRE =?,  APELLIDO  =? , EDAD  =? , NUMERO_CUENTA  =?, BANCO =?, TELEFONO  =? , CORREO_ELECTRONICO  =? ,ESTADO_USUARIO =?  WHERE ID_USUARIO = ?",
					new Object[] {usuario.getNombre(),usuario.getApellido(),
							usuario.getEdad(),usuario.getNumerocuenta(),usuario.getBanco(),
							usuario.getTelefono(),usuario.getDireccionCorreoElectronico(),usuario.getEstadoUsuario(),
							usuario.getIdUsuario() });
		}

		/// eliminar 
		@Override
		public Integer deleteUsuario(UsuariosDto usuario) {
			jdbcTemplate.setDataSource(getDataSource());
			return jdbcTemplate.update("DELETE FROM USUARIOS WHERE ID_USUARIO = ? ",
					new Object[] { usuario.getIdUsuario() });
		}
		
		/// consultar Id
		@Override
		public UsuariosDto getUsuarioById(Long idUsuario) {
			UsuariosDto result = new UsuariosDto();

			try {
				jdbcTemplate.setDataSource(getDataSource());

				result = jdbcTemplate.queryForObject("SELECT  FROM USUARIOS WHERE ID_USUARIO = ? ",
						new Object[] { idUsuario }, new UsuariosMapper<UsuariosDto>());

			} catch (EmptyResultDataAccessException e) {
				result = null;
				System.out.println("Sucedio una excepcion: " + e.getMessage() + " no se obtuvieron resultados");
			} catch (NullPointerException npe) {
				result = null;
				System.out.println("Sucedio una excepcion: " + npe.getMessage() + " algun valor se encuentra como nulo");
			} catch (Exception e) {
				System.out.println("Sucedio una excepcion: " + e.getMessage());
			}

			return result;
		}
		


		
		public DataSource getDataSource() {
			return dataSource;
		}

		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
		}

		public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}

		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}




		
	
		

	

}
