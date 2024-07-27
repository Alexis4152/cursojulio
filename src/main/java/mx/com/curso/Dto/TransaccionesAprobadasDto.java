package mx.com.curso.Dto;

import java.math.BigDecimal;
import java.util.Date;

public class TransaccionesAprobadasDto {
	private Integer idTransaccion;
	private Date fecha;
	private BigDecimal cantidad;
	private String moneda;
	private String metodoPago;
	private String detallePago;
	private String concepto;
	private String nombreSucursalEmisor;
	private String nombreSucursalReceptor;
	private Integer idCuentaTransaccion; 
	private String nombreStatusTransaccion;
	
	public Integer getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(Integer idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public String getDetallePago() {
		return detallePago;
	}
	public void setDetallePago(String detallePago) {
		this.detallePago = detallePago;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getNombreSucursalEmisor() {
		return nombreSucursalEmisor;
	}
	public void setNombreSucursalEmisor(String nombreSucursalEmisor) {
		this.nombreSucursalEmisor = nombreSucursalEmisor;
	}
	public String getNombreSucursalReceptor() {
		return nombreSucursalReceptor;
	}
	public void setNombreSucursalReceptor(String nombreSucursalReceptor) {
		this.nombreSucursalReceptor = nombreSucursalReceptor;
	}
	public Integer getIdCuentaTransaccion() {
		return idCuentaTransaccion;
	}
	public void setIdCuentaTransaccion(Integer idCuentaTransaccion) {
		this.idCuentaTransaccion = idCuentaTransaccion;
	}
	public String getNombreStatusTransaccion() {
		return nombreStatusTransaccion;
	}
	public void setNombreStatusTransaccion(String nombreStatusTransaccion) {
		this.nombreStatusTransaccion = nombreStatusTransaccion;
	}
}
