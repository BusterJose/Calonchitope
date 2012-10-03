package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto;

import java.io.Serializable;
import java.util.Date;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.util.Constantes;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.util.Util;

public class CVExpLabDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String cvDni;
	private String nomEmpresa;
	private String actividadEmpresa;
	private Double sueldo;
	private Date fechaIni;
	private String cvfechaIni;
	private String cvfechaFin;
	private Date fechaFin;
	
	public String getNomEmpresa() {
		return nomEmpresa;
	}
	public void setNomEmpresa(String nomEmpresa) {
		this.nomEmpresa = nomEmpresa;
	}
	public String getActividadEmpresa() {
		return actividadEmpresa;
	}
	public void setActividadEmpresa(String actividadEmpresa) {
		this.actividadEmpresa = actividadEmpresa;
	}
	public Double getSueldo() {
		return sueldo;
	}
	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}
	public Date getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getCvDni() {
		return cvDni;
	}
	public void setCvDni(String cvDni) {
		this.cvDni = cvDni;
	}
	public String getCvfechaIni() {
		
		if(fechaIni!=null){
			cvfechaIni= Util.formatearFecha(fechaIni, Constantes.FORMATO_FECHA);
		}
			return cvfechaIni;				
	}
	public void setCvfechaIni(String cvfechaIni) {
		this.cvfechaIni = cvfechaIni;
	}
	public String getCvfechaFin() {
		if(fechaFin!=null){
			cvfechaFin=Util.formatearFecha(fechaFin, Constantes.FORMATO_FECHA);
		}
		return cvfechaFin;
	}
	public void setCvfechaFin(String cvfechaFin) {
		this.cvfechaFin = cvfechaFin;
	}

}
