package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class VWConvocatoriaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idConvocatoria;
	private Integer idEstadoConv;
	private Integer idDep;
	private String descDep;
	private String objetivoConv;
	private Date fechaIniPublicConv;
	private Date fechaFinPublicConv;
	private String descEstadoConv;
	private List<ConvocatoriaPlazaDTO> plazas;
	private Boolean mostrarlinkPostular;
	private Boolean mostrarlinkResultados;
	
	public Integer getIdConvocatoria() {
		return idConvocatoria;
	}
	public void setIdConvocatoria(Integer idConvocatoria) {
		this.idConvocatoria = idConvocatoria;
	}
	public Integer getIdEstadoConv() {
		return idEstadoConv;
	}
	public void setIdEstadoConv(Integer idEstadoConv) {
		this.idEstadoConv = idEstadoConv;
	}
	public Integer getIdDep() {
		return idDep;
	}
	public void setIdDep(Integer idDep) {
		this.idDep = idDep;
	}
	public String getDescDep() {
		return descDep;
	}
	public void setDescDep(String descDep) {
		this.descDep = descDep;
	}
	public String getObjetivoConv() {
		return objetivoConv;
	}
	public void setObjetivoConv(String objetivoConv) {
		this.objetivoConv = objetivoConv;
	}
	public Date getFechaIniPublicConv() {
		return fechaIniPublicConv;
	}
	public void setFechaIniPublicConv(Date fechaIniPublicConv) {
		this.fechaIniPublicConv = fechaIniPublicConv;
	}
	public Date getFechaFinPublicConv() {
		return fechaFinPublicConv;
	}
	public void setFechaFinPublicConv(Date fechaFinPublicConv) {
		this.fechaFinPublicConv = fechaFinPublicConv;
	}
	public String getDescEstadoConv() {
		return descEstadoConv;
	}
	public void setDescEstadoConv(String descEstadoConv) {
		this.descEstadoConv = descEstadoConv;
	}
	public List<ConvocatoriaPlazaDTO> getPlazas() {
		return plazas;
	}
	public void setPlazas(List<ConvocatoriaPlazaDTO> plazas) {
		this.plazas = plazas;
	}
	public Boolean getMostrarlinkPostular() {
		return mostrarlinkPostular;
	}
	public void setMostrarlinkPostular(Boolean mostrarlinkPostular) {
		this.mostrarlinkPostular = mostrarlinkPostular;
	}
	public void setMostrarlinkResultados(Boolean mostrarlinkResultados) {
		this.mostrarlinkResultados = mostrarlinkResultados;
	}
	public Boolean getMostrarlinkResultados() {
		return mostrarlinkResultados;
	}
	
}
