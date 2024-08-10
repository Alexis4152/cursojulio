package mx.com.curso.Dto;

import java.sql.Timestamp;



public class InformeProyectoDto {
	
	private Long idInforme;
	private short idProyecto;
	private short anio;
	private String numeroConvocatoria;
	private String cveInstitucion;
	private String usuario;
	private Timestamp fechaRegistroInforme;
	private String cveTipoInforme;
	private String cveStatusInforme;
	private Timestamp fechaEnvioInforme;
	private char esDecimoAnio;
	
	public InformeProyectoDto(Long idInforme, short idProyecto, short anio, String numeroConvocatoria,
			String cveInstitucion, String usuario, Timestamp fechaRegistroInforme, String cveTipoInforme,
			String cveStatusInforme, Timestamp fechaEnvioInforme, char esDecimoAnio) {
		super();
		this.idInforme = idInforme;
		this.idProyecto = idProyecto;
		this.anio = anio;
		this.numeroConvocatoria = numeroConvocatoria;
		this.cveInstitucion = cveInstitucion;
		this.usuario = usuario;
		this.fechaRegistroInforme = fechaRegistroInforme;
		this.cveTipoInforme = cveTipoInforme;
		this.cveStatusInforme = cveStatusInforme;
		this.fechaEnvioInforme = fechaEnvioInforme;
		this.esDecimoAnio = esDecimoAnio;
	}
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
