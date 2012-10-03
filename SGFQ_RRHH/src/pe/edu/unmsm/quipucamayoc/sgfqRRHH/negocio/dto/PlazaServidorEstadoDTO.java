package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto;

import java.io.Serializable;
import java.util.Date;

public class PlazaServidorEstadoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer c_pla_serv_est;
	private String t_descripcion;
	private Integer n_est_plaza;
	private Integer fk_pla_serv_est;
	
	public Integer getC_pla_serv_est() {
		return c_pla_serv_est;
	}
	public void setC_pla_serv_est(Integer c_pla_serv_est) {
		this.c_pla_serv_est = c_pla_serv_est;
	}
	public String getT_descripcion() {
		return t_descripcion;
	}
	public void setT_descripcion(String t_descripcion) {
		this.t_descripcion = t_descripcion;
	}
	public Integer getN_est_plaza() {
		return n_est_plaza;
	}
	public void setN_est_plaza(Integer n_est_plaza) {
		this.n_est_plaza = n_est_plaza;
	}
	public Integer getFk_pla_serv_est() {
		return fk_pla_serv_est;
	}
	public void setFk_pla_serv_est(Integer fk_pla_serv_est) {
		this.fk_pla_serv_est = fk_pla_serv_est;
	}
	
	
}
