package mx.com.curso.Entidades;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "INFORME_PROYECTO", schema = "JONATHAN")
public class InformeProyecto {
	
	@EmbeddedId
	private InformeProyectoPrimaryKey id;
	
	@Column(name = "CVE_INSTITUCION", length = 20)
	private String cveInstitucion;
	
	@Column(name = "USUARIO", length = 30)
	private String usuario;
	
	@Column(name = "FECHA_REGISTRO_INFORME")
	private Timestamp fechaRegistroInforme;
	
	@Column(name = "CVE_ESTATUS_INFORME")
	private String cveStatusInforme;
	
	@Column(name = "FECHA_ENVIO_INFORME")
	private Timestamp fechaEnvioInforme;
	
	@Column(name = "ES_DECIMO_ANIO")
	private char esDecimoAnio;

	
	public InformeProyectoPrimaryKey getId() {
		return id;
	}

	public void setId(InformeProyectoPrimaryKey id) {
		this.id = id;
	}

	public String getCveInstitucion() {
		return cveInstitucion;
	}

	public void setCveInstitucion(String cveInstitucion) {
		this.cveInstitucion = cveInstitucion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Timestamp getFechaRegistroInforme() {
		return fechaRegistroInforme;
	}

	public void setFechaRegistroInforme(Timestamp fechaRegistroInforme) {
		this.fechaRegistroInforme = fechaRegistroInforme;
	}

	public String getCveStatusInforme() {
		return cveStatusInforme;
	}

	public void setCveStatusInforme(String cveStatusInforme) {
		this.cveStatusInforme = cveStatusInforme;
	}

	public Timestamp getFechaEnvioInforme() {
		return fechaEnvioInforme;
	}

	public void setFechaEnvioInforme(Timestamp fechaEnvioInforme) {
		this.fechaEnvioInforme = fechaEnvioInforme;
	}

	public char getEsDecimoAnio() {
		return esDecimoAnio;
	}

	public void setEsDecimoAnio(char esDecimoAnio) {
		this.esDecimoAnio = esDecimoAnio;
	}
	
}
