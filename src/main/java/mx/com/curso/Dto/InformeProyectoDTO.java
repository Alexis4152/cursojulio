package mx.com.curso.Dto;

import java.util.Calendar;
import java.util.Date;

public class InformeProyectoDTO {
	
	   private String usuario;
	   private Date fechaRegistroInforme;
	   private Date fechaEnvioInforme;
	   private Integer cveEstatusInforme;
	   private String cveInstitucion;
	   private Integer esDecimoAnio;
	   private Integer idInforme;
	   private Integer idProyecto;
	   private Short anio;
	   private String numeroConvocatoria;
	  private Integer cveTipoInforme;
	  
	  
	  
	  
	public InformeProyectoDTO(String usuario, Date fechaRegistroInforme, Date fechaEnvioInforme,
			Integer cveEstatusInforme, String cveInstitucion, Integer esDecimoAnio, Integer idInforme,
			Integer idProyecto, Short anio, String numeroConvocatoria, Integer cveTipoInforme) {
		super();
		this.usuario = usuario;
		this.fechaRegistroInforme = fechaRegistroInforme;
		this.fechaEnvioInforme = fechaEnvioInforme;
		this.cveEstatusInforme = cveEstatusInforme;
		this.cveInstitucion = cveInstitucion;
		this.esDecimoAnio = esDecimoAnio;
		this.idInforme = idInforme;
		this.idProyecto = idProyecto;
		this.anio = anio;
		this.numeroConvocatoria = numeroConvocatoria;
		this.cveTipoInforme = cveTipoInforme;
	}
	
	
	
	
	public InformeProyectoDTO() {
		super();
	}

	

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getFechaRegistroInforme() {
		return fechaRegistroInforme;
	}
	public void setFechaRegistroInforme(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		
		this.fechaRegistroInforme = calendar.getTime();
	}
	public Date getFechaEnvioInforme() {
		return fechaEnvioInforme;
	}
	public void setFechaEnvioInforme(Date fechaEnvioInforme) {
		this.fechaEnvioInforme = fechaEnvioInforme;
	}
	public Integer getCveEstatusInforme() {
		return cveEstatusInforme;
	}
	public void setCveEstatusInforme(Integer cveEstatusInforme) {
		this.cveEstatusInforme = cveEstatusInforme;
	}
	public String getCveInstitucion() {
		return cveInstitucion;
	}
	public void setCveInstitucion(String cveInstitucion) {
		this.cveInstitucion = cveInstitucion;
	}
	public Integer getEsDecimoAnio() {
		return esDecimoAnio;
	}
	public void setEsDecimoAnio(Integer esDecimoAnio) {
		this.esDecimoAnio = esDecimoAnio;
	}
	public Integer getIdInforme() {
		return idInforme;
	}
	public void setIdInforme(Integer idInforme) {
		this.idInforme = idInforme;
	}
	public Integer getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}
	public Short getAnio() {
		return anio;
	}
	public void setAnio(Short anio) {
		this.anio = anio;
	}
	public String getNumeroConvocatoria() {
		return numeroConvocatoria;
	}
	public void setNumeroConvocatoria(String numeroConvocatoria) {
		this.numeroConvocatoria = numeroConvocatoria;
	}
	public Integer getCveTipoInforme() {
		return cveTipoInforme;
	}
	public void setCveTipoInforme(Integer cveTipoInforme) {
		this.cveTipoInforme = cveTipoInforme;
	}
	   

}
