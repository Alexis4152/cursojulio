package mx.com.curso.Dto;



public class UsuariosDto {

	private String nombre;
	private String Apellido;
	private Integer numerocuenta;
	private String banco;
	private Integer telefono;
	private String direccionCorreoElectronico;
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public Integer getNumerocuenta() {
		return numerocuenta;
	}
	public void setNumerocuenta(Integer numerocuenta) {
		this.numerocuenta = numerocuenta;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getDireccionCorreoElectronico() {
		return direccionCorreoElectronico;
	}
	public void setDireccionCorreoElectronico(String direccionCorreoElectronico) {
		this.direccionCorreoElectronico = direccionCorreoElectronico;
	}
	
	
	
	
	

}
