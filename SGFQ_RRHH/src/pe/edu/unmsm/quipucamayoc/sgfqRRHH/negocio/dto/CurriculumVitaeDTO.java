package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.util.Constantes;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.util.Util;

public class CurriculumVitaeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String cvDni;
	private Integer cvIdConvocatoria;
	private Integer cvIdPlaza;
	private String cvNombres;
	private String cvApePat;
	private String cvApeMat;
	private Integer cvEdad;
	private Integer cvEstCivil;
	private Date cvFechaNac;
	private String strFechaNac;
	private Integer cvNacionalidad;
	private Integer cvDepartamento;
	private Integer cvProvincia;
	private Integer cvDistrito;
	private String cvDomicilio;
	private String cvTelFijo;
	private String cvTelCel;
	private String cvEmail;
	private String cvRuc;
	private List<CVExpLabDTO> expLabs;
	private List<CVGradosAcadDTO> gradsAcads;
	private Integer cvSexo;
	private double puntajeCv;
	private double puntajeEntrevista;
	private double puntajeTotal;
	private String observacion;
	private String descPlaza;
	private String strEstCivil;
	private String strNacionalidad;
	private String strDepartamento;
	private String strProvincia;
	private String strDistrito;
	private String strSexo;
	public List<CVExpLabDTO> getExpLabs() {
		return expLabs;
	}
	public void setExpLabs(List<CVExpLabDTO> expLabs) {
		this.expLabs = expLabs;
	}
	public List<CVGradosAcadDTO> getGradsAcads() {
		return gradsAcads;
	}
	public void setGradsAcads(List<CVGradosAcadDTO> gradsAcads) {
		this.gradsAcads = gradsAcads;
	}
	public String getCvDni() {
		return cvDni;
	}
	public void setCvDni(String cvDni) {
		this.cvDni = cvDni;
	}
	public String getCvNombres() {
		return cvNombres;
	}
	public void setCvNombres(String cvNombres) {
		this.cvNombres = cvNombres;
	}
	public String getCvApePat() {
		return cvApePat;
	}
	public void setCvApePat(String cvApePat) {
		this.cvApePat = cvApePat;
	}
	public String getCvApeMat() {
		return cvApeMat;
	}
	public void setCvApeMat(String cvApeMat) {
		this.cvApeMat = cvApeMat;
	}
	public Integer getCvEdad() {
		return cvEdad;
	}
	public void setCvEdad(Integer cvEdad) {
		this.cvEdad = cvEdad;
	}
	public Integer getCvEstCivil() {
		return cvEstCivil;
	}
	public void setCvEstCivil(Integer cvEstCivil) {
		this.cvEstCivil = cvEstCivil;
	}
	public Date getCvFechaNac() {
		return cvFechaNac;
	}
	public void setCvFechaNac(Date cvFechaNac) {
		this.cvFechaNac = cvFechaNac;
	}
	public Integer getCvNacionalidad() {
		return cvNacionalidad;
	}
	public void setCvNacionalidad(Integer cvNacionalidad) {
		this.cvNacionalidad = cvNacionalidad;
	}
	public Integer getCvDepartamento() {
		return cvDepartamento;
	}
	public void setCvDepartamento(Integer cvDepartamento) {
		this.cvDepartamento = cvDepartamento;
	}
	public Integer getCvProvincia() {
		return cvProvincia;
	}
	public void setCvProvincia(Integer cvProvincia) {
		this.cvProvincia = cvProvincia;
	}
	public String getCvDomicilio() {
		return cvDomicilio;
	}
	public void setCvDomicilio(String cvDomicilio) {
		this.cvDomicilio = cvDomicilio;
	}
	public String getCvTelFijo() {
		return cvTelFijo;
	}
	public void setCvTelFijo(String cvTelFijo) {
		this.cvTelFijo = cvTelFijo;
	}
	public String getCvTelCel() {
		return cvTelCel;
	}
	public void setCvTelCel(String cvTelCel) {
		this.cvTelCel = cvTelCel;
	}
	public String getCvEmail() {
		return cvEmail;
	}
	public void setCvEmail(String cvEmail) {
		this.cvEmail = cvEmail;
	}
	public String getCvRuc() {
		return cvRuc;
	}
	public void setCvRuc(String cvRuc) {
		this.cvRuc = cvRuc;
	}
	public Integer getCvSexo() {
		return cvSexo;
	}
	public void setCvSexo(Integer cvSexo) {
		this.cvSexo = cvSexo;
	}
	public void setCvDistrito(Integer cvDistrito) {
		this.cvDistrito = cvDistrito;
	}
	public Integer getCvDistrito() {
		return cvDistrito;
	}
	public Integer getCvIdConvocatoria() {
		return cvIdConvocatoria;
	}
	public void setCvIdConvocatoria(Integer cvIdConvocatoria) {
		this.cvIdConvocatoria = cvIdConvocatoria;
	}
	public Integer getCvIdPlaza() {
		return cvIdPlaza;
	}
	public void setCvIdPlaza(Integer cvIdPlaza) {
		this.cvIdPlaza = cvIdPlaza;
	}
	public double getPuntajeCv() {
		return puntajeCv;
	}
	public void setPuntajeCv(double puntajeCv) {
		this.puntajeCv = puntajeCv;
	}
	public double getPuntajeEntrevista() {
		return puntajeEntrevista;
	}
	public void setPuntajeEntrevista(double puntajeEntrevista) {
		this.puntajeEntrevista = puntajeEntrevista;
	}
	public double getPuntajeTotal() {
		return puntajeTotal;
	}
	public void setPuntajeTotal(double puntajeTotal) {
		this.puntajeTotal = puntajeTotal;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public void setDescPlaza(String descPlaza) {
		this.descPlaza = descPlaza;
	}
	public String getDescPlaza() {
		return descPlaza;
	}
	
	public void setStrFechaNac(String strFechaNac) {
		this.strFechaNac = strFechaNac;
	}
	public String getStrFechaNac() {
		if(cvFechaNac!=null){
			strFechaNac=Util.formatearFecha(cvFechaNac, Constantes.FORMATO_FECHA);
		}

		return strFechaNac;
	}
	public void setStrSexo(String strSexo) {
		this.strSexo = strSexo;
	}
	public String getStrSexo() {
		if(cvSexo==0){
			strSexo="Hombre";
		}else{
			if(cvSexo==1){
				strSexo="Mujer";
			}
		}
		return strSexo;
	}
	public String getStrEstCivil() {
		return strEstCivil;
	}
	public void setStrEstCivil(String strEstCivil) {
		this.strEstCivil = strEstCivil;
	}
	public String getStrNacionalidad() {
		return strNacionalidad;
	}
	public void setStrNacionalidad(String strNacionalidad) {
		this.strNacionalidad = strNacionalidad;
	}
	public String getStrDepartamento() {
		return strDepartamento;
	}
	public void setStrDepartamento(String strDepartamento) {
		this.strDepartamento = strDepartamento;
	}
	public String getStrDistrito() {
		return strDistrito;
	}
	public void setStrDistrito(String strDistrito) {
		this.strDistrito = strDistrito;
	}
	public void setStrProvincia(String strProvincia) {
		this.strProvincia = strProvincia;
	}
	public String getStrProvincia() {
		return strProvincia;
	}
	
}
