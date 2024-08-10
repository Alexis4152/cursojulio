package mx.com.curso.Entidades;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INFORME_ESTUDIANTE_DOCUMENTO", schema = "JONATHAN")
public class InformeEstudianteDocumento {
	
	@EmbeddedId
	private InformeEstudianteDocumentoPrimaryKey id;
	
	@Column(name = "NOMBRE_DOCUMENTO", length = 50)
	private String nombreDocumento;
	
	@Column(name = "FECHA_REGISTRO")
	private Timestamp fechaRegistro;

		
	public InformeEstudianteDocumentoPrimaryKey getId() {
		return id;
	}

	public void setId(InformeEstudianteDocumentoPrimaryKey id) {
		this.id = id;
	}

	public String getNombreDocumento() {
		return nombreDocumento;
	}

	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}

	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
}
