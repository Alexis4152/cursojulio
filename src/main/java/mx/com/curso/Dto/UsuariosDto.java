package mx.com.curso.Dto;

import java.math.BigDecimal;

public class UsuariosDto {
	
    private Long idUsuario;
	private String nombre;
	private String Apellido;
	private Integer Edad;
	private BigDecimal numerocuenta;
	private String banco;
	private Long telefono;
	private String direccionCorreoElectronico;
	private String estadoUsuario;


	  
	 
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Long getTelefono() {
		return telefono;
	}
	public BigDecimal getNumerocuenta() {
		return numerocuenta;
	}
	public void setNumerocuenta(BigDecimal numerocuenta) {
		this.numerocuenta = numerocuenta;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	public Integer getEdad() {
		return Edad;
	}
	public void setEdad(Integer edad) {
		Edad = edad;
	}

	public String getEstadoUsuario() {
		return estadoUsuario;
	}
	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}
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

	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getDireccionCorreoElectronico() {
		return direccionCorreoElectronico;
	}
	public void setDireccionCorreoElectronico(String direccionCorreoElectronico) {
		this.direccionCorreoElectronico = direccionCorreoElectronico;
	}
	
	
	
	

}
