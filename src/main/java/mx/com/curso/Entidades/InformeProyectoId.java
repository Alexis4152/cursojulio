package mx.com.curso.Entidades;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InformeProyectoId implements java.io.Serializable {

   private Integer idInforme;
   private Integer idProyecto;
   private Short anio;
   private String numeroConvocatoria;
  private Integer cveTipoInforme;

   public InformeProyectoId() {

   }

   public InformeProyectoId(Integer idInforme, Integer idProyecto, String numeroConvocatoria, Short anio, Integer cveTipoInforme) {
      this.idInforme = idInforme;
      this.idProyecto = idProyecto;
      this.numeroConvocatoria = numeroConvocatoria;
      this.anio = anio;
      this.cveTipoInforme = cveTipoInforme;
   }

   @Column(name = "ID_INFORME", nullable = false, precision = 10, scale = 0)
   public Integer getIdInforme() {
      return this.idInforme;
   }

   public void setIdInforme(Integer idInforme) {
      this.idInforme = idInforme;
   }
   
   @Column(name = "ID_PROYECTO", nullable = false, precision = 6, scale = 0)
   public Integer getIdProyecto() {
      return this.idProyecto;
   }

   public void setIdProyecto(Integer idProyecto) {
      this.idProyecto = idProyecto;
   }

   @Column(name = "NUMERO_CONVOCATORIA", nullable = false, length = 20)
   public String getNumeroConvocatoria() {
      return this.numeroConvocatoria;
   }

   public void setNumeroConvocatoria(String numeroConvocatoria) {
      this.numeroConvocatoria = numeroConvocatoria;
   }

   @Column(name = "ANIO", nullable = false, precision = 4, scale = 0)
   public Short getAnio() {
      return this.anio;
   }

   public void setAnio(Short anio) {
      this.anio = anio;
   }

   @Column(name = "CVE_TIPO_INFORME", nullable = false)
   public Integer getCveTipoInforme() {
      return this.cveTipoInforme;
   }

   public void setCveTipoInforme(Integer cveTipoInforme) {
      this.cveTipoInforme = cveTipoInforme;
   }

}
