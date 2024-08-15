package mx.com.curso.Entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "REGISTRO_INFORMACION_STATUS", schema = "XXX")
public class RegistroInformacion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INFORME_USUARIO_STATUS")
	@SequenceGenerator(name = "SEQ_INFORME_USUARIO_STATUS", sequenceName = "SEQ_INFORME_USUARIO_STATUS", allocationSize = 1)
	@Column(name = "ID_INFORME_USUARIO")
	private Long id;

	@Column(name = "USUARIO")
	private String usuario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_ACTUAL")
	private Date fechaActual;

	@Column(name = "NUMERO_PROYECTO")
	private Integer numeroProyecto;

	@Column(name = "STATUS")
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}

	public Integer getNumeroProyecto() {
		return numeroProyecto;
	}

	public void setNumeroProyecto(Integer numeroProyecto) {
		this.numeroProyecto = numeroProyecto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
