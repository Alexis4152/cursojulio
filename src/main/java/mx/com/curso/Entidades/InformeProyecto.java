package mx.com.curso.Entidades;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INFORME_PROYECTO", schema = "JONATHAN")
public class InformeProyecto {
	
	@Id
	@Column(name = "ID_INFORME")
	private Long idInforme;
	
	@Id
	@Column(name = "ID_PROYECTO")
	private short idProyecto;
	
	@Id
	@Column(name = "ANIO")
	private short anio;
	
	@Id
	@Column(name = "NUMERO_CONVOCATORIA", length = 20)
	private String numeroConvocatoria;
	
	@Column(name = "CVE_INSTITUCION", length = 20)
	private String cveInstitucion;
	
	@Column(name = "USUARIO", length = 30)
	private String usuario;
	
	@Column(name = "FECHA_REGISTRO_INFORME")
	private Timestamp fechaRegistroInforme;
	
	@Id
	@Column(name = "CVE_TIPO_INFORME")
	private String cveTipoInforme;
	
	@Column(name = "CVE_ESTATUS_INFORME")
	private String cveStatusInforme;
	
	@Column(name = "FECHA_ENVIO_INFORME")
	private Timestamp fechaEnvioInforme;
	
	@Column(name = "ES_DECIMO_ANIO")
	private char esDecimoAnio;

	public Long getIdInforme() {
		return idInforme;
	}

	public void setIdInforme(Long idInforme) {
		this.idInforme = idInforme;
	}

	public short getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(short idProyecto) {
		this.idProyecto = idProyecto;
	}

	public short getAnio() {
		return anio;
	}

	public void setAnio(short anio) {
		this.anio = anio;
	}

	public String getNumeroConvocatoria() {
		return numeroConvocatoria;
	}

	public void setNumeroConvocatoria(String numeroConvocatoria) {
		this.numeroConvocatoria = numeroConvocatoria;
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

	public String getCveTipoInforme() {
		return cveTipoInforme;
	}

	public void setCveTipoInforme(String cveTipoInforme) {
		this.cveTipoInforme = cveTipoInforme;
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
}
