package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto;

import java.io.Serializable;
import java.util.Date;

public class PlazaServidorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idPlaza;
	private Integer idServidor;
	private Date fechaIni;
	private Date fechaFin;
	private Integer idPlazaServidor;
	private String serCod;
	private Integer numSerest;
	private String estPlaza;
	private String n_resol_ing;
	private String tipo_ingreso;
	private Integer n_id_pla_serv_est;
	public PlazaServidorDTO(){
	}
	
	public Integer getIdPlaza() {
		return idPlaza;
	}
	public void setIdPlaza(Integer idPlaza) {
		this.idPlaza = idPlaza;
	}
	public Integer getIdServidor() {
		return idServidor;
	}
	public void setIdServidor(Integer idServidor) {
		this.idServidor = idServidor;
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
	public Integer getIdPlazaServidor() {
		return idPlazaServidor;
	}
	public void setIdPlazaServidor(Integer idPlazaServidor) {
		this.idPlazaServidor = idPlazaServidor;
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
	public String getEstPlaza() {
		return estPlaza;
	}
	public void setEstPlaza(String estPlaza) {
		this.estPlaza = estPlaza;
	}
	public String getN_resol_ing() {
		return n_resol_ing;
	}
	public void setN_resol_ing(String n_resol_ing) {
		this.n_resol_ing = n_resol_ing;
	}

	public String getTipo_ingreso() {
		return tipo_ingreso;
	}

	public void setTipo_ingreso(String tipo_ingreso) {
		this.tipo_ingreso = tipo_ingreso;
	}

	public Integer getN_id_pla_serv_est() {
		return n_id_pla_serv_est;
	}

	public void setN_id_pla_serv_est(Integer n_id_pla_serv_est) {
		this.n_id_pla_serv_est = n_id_pla_serv_est;
	}
	
}
