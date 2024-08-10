package mx.com.curso.Entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InformeProyectoPrimaryKey implements Serializable {
	
	private static final long serialVersionUID = -5888467166111333123L;

	@Column(name = "ID_INFORME")
	private Long idInforme;
	
	@Column(name = "ID_PROYECTO")
	private short idProyecto;
	
	@Column(name = "ANIO")
	private short anio;
	
	@Column(name = "NUMERO_CONVOCATORIA", length = 20)
	private String numeroConvocatoria;
	
	@Column(name = "CVE_TIPO_INFORME")
	private String cveTipoInforme;
	
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
	
	public String getCveTipoInforme() {
		return cveTipoInforme;
	}

	public void setCveTipoInforme(String cveTipoInforme) {
		this.cveTipoInforme = cveTipoInforme;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idInforme,cveTipoInforme,idProyecto,anio, numeroConvocatoria);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		InformeProyectoPrimaryKey that = (InformeProyectoPrimaryKey) obj;
		
		return idInforme.equals(that.idInforme) &&
			   cveTipoInforme == that.cveTipoInforme &&
			   idProyecto == that.idProyecto &&
			   anio == that.anio &&
	           numeroConvocatoria.equals(that.numeroConvocatoria);
	}

}
