package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto;

public class PuntajeJuradoDTO {
	private Integer idPuntajeJurado;
	private Integer idJurado;
	private String nomJurado;
	private Integer idConvocatoria;
	private Integer idPlaza; 
	private String dniCV;
	private double puntajeCV;
	private double puntajeEntrevista;
	
	public Integer getIdPuntajeJurado() {
		return idPuntajeJurado;
	}
	public void setIdPuntajeJurado(Integer idPuntajeJurado) {
		this.idPuntajeJurado = idPuntajeJurado;
	}
	public Integer getIdJurado() {
		return idJurado;
	}
	public void setIdJurado(Integer idJurado) {
		this.idJurado = idJurado;
	}
	public Integer getIdConvocatoria() {
		return idConvocatoria;
	}
	public void setIdConvocatoria(Integer idConvocatoria) {
		this.idConvocatoria = idConvocatoria;
	}
	public Integer getIdPlaza() {
		return idPlaza;
	}
	public void setIdPlaza(Integer idPlaza) {
		this.idPlaza = idPlaza;
	}
	public String getDniCV() {
		return dniCV;
	}
	public void setDniCV(String dniCV) {
		this.dniCV = dniCV;
	}
	public double getPuntajeCV() {
		return puntajeCV;
	}
	public void setPuntajeCV(double puntajeCV) {
		this.puntajeCV = puntajeCV;
	}
	public double getPuntajeEntrevista() {
		return puntajeEntrevista;
	}
	public void setPuntajeEntrevista(double puntajeEntrevista) {
		this.puntajeEntrevista = puntajeEntrevista;
	}
	public String getNomJurado() {
		return nomJurado;
	}
	public void setNomJurado(String nomJurado) {
		this.nomJurado = nomJurado;
	}
}
