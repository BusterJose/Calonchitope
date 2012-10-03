package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto;

public class ServicioConvPlazaDTO {
	private Integer idConvocatoria;
	private Integer idPlaza;
	private Integer idServicio;
	private String descServicio;
	
	public Integer getIdConvocatoria() {
		return idConvocatoria;
	}
	public void setIdConvocatoria(Integer idConvocatoria) {
		this.idConvocatoria = idConvocatoria;
	}
	public Integer getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}
	public String getDescServicio() {
		return descServicio;
	}
	public void setDescServicio(String descServicio) {
		this.descServicio = descServicio;
	}
	public void setIdPlaza(Integer idPlaza) {
		this.idPlaza = idPlaza;
	}
	public Integer getIdPlaza() {
		return idPlaza;
	}
	
	
	
}
