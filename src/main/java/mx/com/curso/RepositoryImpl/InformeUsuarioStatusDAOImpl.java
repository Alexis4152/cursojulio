package mx.com.curso.RepositoryImpl;

import org.springframework.stereotype.Repository;

import mx.com.curso.Entidades.InformeUsuarioStatus;
import mx.com.curso.Repository.InformeUsuariosStatusDAO;


@Repository
public class InformeUsuarioStatusDAOImpl extends GenericDAO<InformeUsuarioStatus, Long>
implements InformeUsuariosStatusDAO {

}
