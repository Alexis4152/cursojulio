package mx.com.curso.Entidades;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INFORME_ESTUDIANTES_DOCUMENTO", schema = "JONATHAN")
public class InformeEstudianteDocumento {
	
	@Id
	@Column(name = "ID_INFORME")
	private Long idInforme;
	
	@Id
	@Column(name = "CVE_TIPO_INFORME", unique = true)
	private char cveTipoInforme;
	
	@Id
	@Column(name = "ID_PROYECTO")
	private short idProyecto;
	
	@Id
	@Column(name = "ANIO")
	private short anio;

	@Id
	@Column(name = "NUMERO_CONVOCATORIA", length = 20)
	private String numeroConvocatoria;

	@Id
	@Column(name = "CVE_INSTITUCION", length = 20)
	private String cveInstitucion;
	
	@Id
	@Column(name = "NUMERO_CATEDRA")
	private short numeroCatedra;
	
	@Id
	@Column(name = "CVE_TIPO_DOCUMENTO", length = 6)
	private String cveTipoDocumento;
	
	@Id
	@Column(name = "NOMBRE_DOCUMENTO", length = 50)
	private String nombreDocumento;
	
	@Id
	@Column(name = "FECHA_REGISTRO")
	private Timestamp fechaRegistro;

	
	public Long getIdInforme() {
		return idInforme;
	}

	public void setIdInforme(Long idInforme) {
		this.idInforme = idInforme;
	}

	public char getCveTipoInforme() {
		return cveTipoInforme;
	}

	public void setCveTipoInforme(char cveTipoInforme) {
		this.cveTipoInforme = cveTipoInforme;
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

	public short getNumeroCatedra() {
		return numeroCatedra;
	}

	public void setNumeroCatedra(short numeroCatedra) {
		this.numeroCatedra = numeroCatedra;
	}

	public String getCveTipoDocumento() {
		return cveTipoDocumento;
	}

	public void setCveTipoDocumento(String cveTipoDocumento) {
		this.cveTipoDocumento = cveTipoDocumento;
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
