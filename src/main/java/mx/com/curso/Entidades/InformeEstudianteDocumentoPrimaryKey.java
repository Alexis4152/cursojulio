package mx.com.curso.Entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InformeEstudianteDocumentoPrimaryKey implements Serializable{
	
	private static final long serialVersionUID = 2625884815949895291L;


	@Column(name = "ID_INFORME")
	private Long idInforme;
	
	
	@Column(name = "CVE_TIPO_INFORME", unique = true)
	private char cveTipoInforme;
	
	
	@Column(name = "ID_PROYECTO")
	private short idProyecto;
	
	@Column(name = "ANIO")
	private short anio;

	@Column(name = "NUMERO_CONVOCATORIA", length = 20)
	private String numeroConvocatoria;

	@Column(name = "CVE_INSTITUCION", length = 20)
	private String cveInstitucion;
	

	@Column(name = "NUMERO_CATEDRA")
	private short numeroCatedra;
	

	@Column(name = "CVE_TIPO_DOCUMENTO", length = 6)
	private String cveTipoDocumento;


	public InformeEstudianteDocumentoPrimaryKey(Long idInforme, char cveTipoInforme, short idProyecto, short anio,
			String numeroConvocatoria, String cveInstitucion, short numeroCatedra, String cveTipoDocumento) {
		super();
		this.idInforme = idInforme;
		this.cveTipoInforme = cveTipoInforme;
		this.idProyecto = idProyecto;
		this.anio = anio;
		this.numeroConvocatoria = numeroConvocatoria;
		this.cveInstitucion = cveInstitucion;
		this.numeroCatedra = numeroCatedra;
		this.cveTipoDocumento = cveTipoDocumento;
	}

	public InformeEstudianteDocumentoPrimaryKey() {
		
	}
	
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


	@Override
	public int hashCode() {
		return Objects.hash(anio, cveInstitucion, cveTipoDocumento, cveTipoInforme, idInforme, idProyecto,
				numeroCatedra, numeroConvocatoria);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		InformeEstudianteDocumentoPrimaryKey that = (InformeEstudianteDocumentoPrimaryKey) obj;
		return idInforme.equals(that.idInforme) &&
			   cveTipoDocumento == that.cveTipoDocumento &&
			   idProyecto == that.idProyecto &&
			   anio == that.anio &&
			   numeroConvocatoria.equals(that.numeroConvocatoria) &&
			   cveInstitucion.equals(that.cveInstitucion) &&
			   numeroCatedra == that.numeroCatedra &&
			   cveTipoDocumento.equals(that.cveTipoDocumento);
		/*return anio == that.anio && Objects.equals(cveInstitucion, that.cveInstitucion)
				&& Objects.equals(cveTipoDocumento, that.cveTipoDocumento) && cveTipoInforme == that.cveTipoInforme
				&& Objects.equals(idInforme, that.idInforme) && idProyecto == that.idProyecto
				&& numeroCatedra == that.numeroCatedra && Objects.equals(numeroConvocatoria, that.numeroConvocatoria);
	*/}


	
	
	
}
