package mx.com.curso.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_INFORME", schema = "JONATHAN")
public class TipoInforme {
	
	@Id
	@Column(name = "CVE_TIPO_INFORME")
	private char cveTipoInforme;
	
	@Column(name = "DESCRIPCION", length = 20)
	private String descripcion;

	
	public char getCveTipoInforme() {
		return cveTipoInforme;
	}

	public void setCveTipoInforme(char cveTipoInforme) {
		this.cveTipoInforme = cveTipoInforme;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	} 
}
