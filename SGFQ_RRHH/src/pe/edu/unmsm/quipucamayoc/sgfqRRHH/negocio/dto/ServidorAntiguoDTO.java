package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto;

import java.io.Serializable;
import java.util.Date;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.util.Util;

public class ServidorAntiguoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String serCod;
	private Integer numSerest;
	private String serApePat;
	private String serApeMat;
	private String serNom;
	private String serTipo;
	private String serEstado;
	private String serCondicion;
	private Integer serCodDepRac;
	private String serDescDepRac;
	private String serDescCargo;
	private Integer serCodPlaza;
	private String serCategoria;
	private Date serFech_in_unmsm;
	private String serFech_in_unmsm_str;
	
	//permite saber si tiene cargo asignado
	private String serColor = null;
	
	public String getSerColor() {
		return serColor;
	}
	public void setSerColor(String serColor) {
		this.serColor = serColor;
	}
	public String getSerCod() {
		return serCod;
	}
	public void setSerCod(String serCod) {
		this.serCod = serCod;
	}
	public Integer getNumSerest() {
		return numSerest;
	}
	public void setNumSerest(Integer numSerest) {
		this.numSerest = numSerest;
	}
	public String getSerApePat() {
		return serApePat;
	}
	public void setSerApePat(String serApePat) {
		this.serApePat = serApePat;
	}
	public String getSerApeMat() {
		return serApeMat;
	}
	public void setSerApeMat(String serApeMat) {
		this.serApeMat = serApeMat;
	}
	public String getSerNom() {
		return serNom;
	}
	public void setSerNom(String serNom) {
		this.serNom = serNom;
	}
	public String getSerTipo() {
		return serTipo;
	}
	public void setSerTipo(String serTipo) {
		this.serTipo = serTipo;
	}
	public String getSerEstado() {
		return serEstado;
	}
	public void setSerEstado(String serEstado) {
		this.serEstado = serEstado;
	}
	public String getSerCondicion() {
		return serCondicion;
	}
	public void setSerCondicion(String serCondicion) {
		this.serCondicion = serCondicion;
	}
	public Integer getSerCodDepRac() {
		return serCodDepRac;
	}
	public void setSerCodDepRac(Integer serCodDepRac) {
		this.serCodDepRac = serCodDepRac;
	}
	public String getSerDescDepRac() {
		return serDescDepRac;
	}
	public void setSerDescDepRac(String serDescDepRac) {
		this.serDescDepRac = serDescDepRac;
	}
	public String getSerDescCargo() {
		return serDescCargo;
	}
	public void setSerDescCargo(String serDescCargo) {
		this.serDescCargo = serDescCargo;
	}
	public Integer getSerCodPlaza() {
		return serCodPlaza;
	}
	public void setSerCodPlaza(Integer serCodPlaza) {
		this.serCodPlaza = serCodPlaza;
	}
	public String getSerCategoria() {
		return serCategoria;
	}
	public void setSerCategoria(String serCategoria) {
		this.serCategoria = serCategoria;
	}
	public Date getSerFech_in_unmsm() {
		return serFech_in_unmsm;
	}
	public void setSerFech_in_unmsm(Date serFech_in_unmsm) {
		this.serFech_in_unmsm = serFech_in_unmsm;
	}
	public String getSerFech_in_unmsm_str() {
		if(serFech_in_unmsm!=null){
			return Util.formatearFecha(serFech_in_unmsm, "dd/MM/yyyy");
		}else{
			return "No registrado";
		}
		
	}
}
