package mx.com.curso.Dto;

import java.math.BigDecimal;

public class TransaccionesDto {
	private String idTransaccion;
	private String fecha;
	private String moneda;
	private BigDecimal cantidad;
	private String concepto;
	private String idCuentaTransaccion;
	
	public String getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public BigDecimal getCantidad() {
		return cantidad;
	}
	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getIdCuentaTransaccion() {
		return idCuentaTransaccion;
	}
	public void setIdCuentaTransaccion(String idCuentaTransaccion) {
		this.idCuentaTransaccion = idCuentaTransaccion;
	}
	
}
