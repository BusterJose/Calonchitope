package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto;

import java.io.Serializable;

public class DependenciaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer udId;
	private String udCod;
	private String udDesc;
	private Integer udPad;
	private Integer udCalDep;
	private Integer udNivel;
	public Integer getUdId() {
		return udId;
	}
	public void setUdId(Integer udId) {
		this.udId = udId;
	}
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
	public Integer getUdPad() {
		return udPad;
	}
	public void setUdPad(Integer udPad) {
		this.udPad = udPad;
	}
	public Integer getUdCalDep() {
		return udCalDep;
	}
	public void setUdCalDep(Integer udCalDep) {
		this.udCalDep = udCalDep;
	}
	public Integer getUdNivel() {
		return udNivel;
	}
	public void setUdNivel(Integer udNivel) {
		this.udNivel = udNivel;
	}

}
