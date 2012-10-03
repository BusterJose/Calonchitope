package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@SuppressWarnings("serial")
@ManagedBean(name="CapUnidad")
@RequestScoped
public class CapUnidad implements Serializable {

	private String udCod;
	private String udDesc;
	private String codClas;
	private int codCargo; 
	private int codCargoClas;
	private String nomClas;
	private String cargoEstructural;
	private String observacion; //docente, no docente, designado, etc
	private int ocupado;
	private int libre;
	private int totalPres;
	
	private int ocupadoFuncional;
	private int libreFuncional;
	private int totalFunc;
	
	private int aprobado;
	private int solicitado;
	private int totalPrev;
	private int total;
	private int codCargoClasifEstruct;
	public String getUdCod() {
		return udCod;
	}
	public void setUdCod(String udCod) {
		this.udCod = udCod;
	}
	public String getUdDesc() {
		return udDesc;
	}
	public void setUdDesc(String udDesc) {
		this.udDesc = udDesc;
	}
	public String getCodClas() {
		return codClas;
	}
	public void setCodClas(String codClas) {
		this.codClas = codClas;
	}
	public int getCodCargo() {
		return codCargo;
	}
	public void setCodCargo(int codCargo) {
		this.codCargo = codCargo;
	}
	public int getCodCargoClas() {
		return codCargoClas;
	}
	public void setCodCargoClas(int codCargoClas) {
		this.codCargoClas = codCargoClas;
	}
	public String getNomClas() {
		return nomClas;
	}
	public void setNomClas(String nomClas) {
		this.nomClas = nomClas;
	}
	public String getCargoEstructural() {
		return cargoEstructural;
	}
	public void setCargoEstructural(String cargoEstructural) {
		this.cargoEstructural = cargoEstructural;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public int getOcupado() {
		return ocupado;
	}
	public void setOcupado(int ocupado) {
		this.ocupado = ocupado;
	}
	public int getLibre() {
		return libre;
	}
	public void setLibre(int libre) {
		this.libre = libre;
	}
	public int getTotalPres() {
		return totalPres;
	}
	public void setTotalPres(int totalPres) {
		this.totalPres = totalPres;
	}
	public int getOcupadoFuncional() {
		return ocupadoFuncional;
	}
	public void setOcupadoFuncional(int ocupadoFuncional) {
		this.ocupadoFuncional = ocupadoFuncional;
	}
	public int getLibreFuncional() {
		return libreFuncional;
	}
	public void setLibreFuncional(int libreFuncional) {
		this.libreFuncional = libreFuncional;
	}
	public int getTotalFunc() {
		return totalFunc;
	}
	public void setTotalFunc(int totalFunc) {
		this.totalFunc = totalFunc;
	}
	public int getAprobado() {
		return aprobado;
	}
	public void setAprobado(int aprobado) {
		this.aprobado = aprobado;
	}
	public int getCodCargoClasifEstruct() {
		return codCargoClasifEstruct;
	}
	public void setCodCargoClasifEstruct(int codCargoClasifEstruct) {
		this.codCargoClasifEstruct = codCargoClasifEstruct;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getSolicitado() {
		return solicitado;
	}
	public void setSolicitado(int solicitado) {
		this.solicitado = solicitado;
	}
	public int getTotalPrev() {
		return totalPrev;
	}
	public void setTotalPrev(int totalPrev) {
		this.totalPrev = totalPrev;
	}
	
	
}
