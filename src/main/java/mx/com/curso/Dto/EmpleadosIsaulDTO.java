package mx.com.curso.Dto;

public class EmpleadosIsaulDTO {
	
	private Long idEmpleados;
	private String nombreCompleto;
	private String rfc;
	private String curp;
	private Long edad;
	private String sexo;
	private String direccion;
	private String nss;
	private Long telefono;
	private int activo;
	
	
	public Long getIdEmpleados() {
		return idEmpleados;
	}
	public void setIdEmpleados(Long idEmpleados) {
		this.idEmpleados = idEmpleados;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public Long getEdad() {
		return edad;
	}
	public void setEdad(Long edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNss() {
		return nss;
	}
	public void setNss(String nss) {
		this.nss = nss;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
}
