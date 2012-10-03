package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto;

import java.io.Serializable;

public class PlazaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idPlaza;
	private Integer idDep;
	private String descCargo;
	private Integer estadoPlaza;
	
	public Integer getIdPlaza() {
		return idPlaza;
	}
	public void setIdPlaza(Integer idPuesto) {
		this.idPlaza = idPuesto;
	}
	public Integer getIdDep() {
		return idDep;
	}
	public void setIdDep(Integer idDep) {
		this.idDep = idDep;
	}
	public String getDescCargo() {
		return descCargo;
	}
	public void setDescCargo(String descCargo) {
		this.descCargo = descCargo;
	}
	public void setEstadoPlaza(Integer estadoPlaza) {
		this.estadoPlaza = estadoPlaza;
	}
	public Integer getEstadoPlaza() {
		return estadoPlaza;
	}
	
}
