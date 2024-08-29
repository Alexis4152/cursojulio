package mx.com.curso.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name= "EMPLEADOS", schema="ISAUL")
public class EmpleadosIsaul {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPLEADOS_SECUENCIA")
	@SequenceGenerator(name = "SEQ_EMPLEADOS_SECUENCIA", sequenceName = "SEQ_EMPLEADOS_SECUENCIA", allocationSize = 1)
	@Column(name= "ID_EMPLEADO", length = 11)
	private Long idEmpleados;
	@Column(name = "NOMBRE_COMPLETO", length = 100)
	private String nombreCompleto;
	@Column(name = "RFC", length = 13)
	private String rfc;
	@Column(name = "CURP")
	private String curp;
	@Column(name = "EDAD", length = 3)
	private Long edad;
	@Column(name = "SEXO", length = 1)
	private String sexo;
	@Column(name = "DIRECCION", length = 100)
	private String direccion;
	@Column(name = "NSS", length = 15)
	private String nss;
	@Column(name = "TELEFONO", length = 10)
	private Long telefono;
	@Column(name = "ACTIVO", length = 1)
	private int activo;
	
	
	
	public EmpleadosIsaul(Long idEmpleados, String nombreCompleto, String rfc, String curp, Long edad, String sexo,String direccion, String nss, Long telefono, int activo) {
		this.idEmpleados = idEmpleados;
		this.nombreCompleto = nombreCompleto;
		this.rfc = rfc;
		this.curp = curp;
		this.edad = edad;
		this.sexo = sexo;
		this.direccion = direccion;
		this.nss = nss;
		this.telefono = telefono;
		this.activo = activo;
	}
	
	public EmpleadosIsaul() {
	}



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
