package mx.com.curso.Dto;

public class StatusUserDto {

	private Integer IdStatus;
	private String NombreStatus;
	private String Descripcion;
	
	public Integer getIdStatus() {
		return IdStatus;
	}
	public void setIdStatus(Integer idStatus) {
		IdStatus = idStatus;
	}
	public String getNombreStatus() {
		return NombreStatus;
	}
	public void setNombreStatus(String nombreStatus) {
		NombreStatus = nombreStatus;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	
	
}