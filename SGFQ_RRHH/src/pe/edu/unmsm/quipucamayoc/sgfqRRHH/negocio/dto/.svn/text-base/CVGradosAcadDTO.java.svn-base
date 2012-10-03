package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto;

import java.io.Serializable;
import java.util.Date;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.util.Constantes;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.util.Util;

public class CVGradosAcadDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String cvDni;
	private String estudiosUnivInst;
	private String nombreUnivInst;
	private Date fechaIni;
	private String fechaIniEstudios;
	private Date fechaFin;
	private String fechaFinEstudios;
	private String nivelAcadLogr;
	
	public String getEstudiosUnivInst() {
		return estudiosUnivInst;
	}
	public void setEstudiosUnivInst(String estudiosUnivInst) {
		this.estudiosUnivInst = estudiosUnivInst;
	}
	public String getNombreUnivInst() {
		return nombreUnivInst;
	}
	public void setNombreUnivInst(String nombreUnivInst) {
		this.nombreUnivInst = nombreUnivInst;
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
	public String getNivelAcadLogr() {
		return nivelAcadLogr;
	}
	public void setNivelAcadLogr(String nivelAcadLogr) {
		this.nivelAcadLogr = nivelAcadLogr;
	}
	public String getCvDni() {
		return cvDni;
	}
	public void setCvDni(String cvDni) {
		this.cvDni = cvDni;
	}
	public String getFechaIniEstudios() {
		if(fechaIni!=null){
			fechaIniEstudios=Util.formatearFecha(fechaIni, Constantes.FORMATO_FECHA);
		}
		return fechaIniEstudios;
	}
	public void setFechaIniEstudios(String fechaIniEstudios) {
		this.fechaIniEstudios = fechaIniEstudios;
	}
	public String getFechaFinEstudios() {
		
		if(fechaFin!=null){
			fechaFinEstudios=Util.formatearFecha(fechaFin, Constantes.FORMATO_FECHA);
		}
		return fechaFinEstudios;
	}
	public void setFechaFinEstudios(String fechaFinEstudios) {
		this.fechaFinEstudios = fechaFinEstudios;
	}
	
}
