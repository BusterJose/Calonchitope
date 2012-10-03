package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto;

import java.util.Date;

public class PostulanteDTO {
private String nombres;
private String apepat;
private String apemat;
private String estadoCivil;
private Date fechanac;
private String nacionalidad;
private String departamento;
private String provincia;
private String dni;
private String numruc;
private String domicilio;
private String email;
private String teleffijo;
private String telefCel;

public PostulanteDTO() {
}

public String getNombres() {
	return nombres;
}
public void setNombres(String nombres) {
	this.nombres = nombres;
}
public String getApepat() {
	return apepat;
}
public void setApepat(String apepat) {
	this.apepat = apepat;
}
public String getApemat() {
	return apemat;
}
public void setApemat(String apemat) {
	this.apemat = apemat;
}
public String getEstadoCivil() {
	return estadoCivil;
}
public void setEstadoCivil(String estadoCivil) {
	this.estadoCivil = estadoCivil;
}
public Date getFechanac() {
	return fechanac;
}
public void setFechanac(Date fechanac) {
	this.fechanac = fechanac;
}
public String getNacionalidad() {
	return nacionalidad;
}
public void setNacionalidad(String nacionalidad) {
	this.nacionalidad = nacionalidad;
}
public String getDepartamento() {
	return departamento;
}
public void setDepartamento(String departamento) {
	this.departamento = departamento;
}
public String getProvincia() {
	return provincia;
}
public void setProvincia(String provincia) {
	this.provincia = provincia;
}
public String getDni() {
	return dni;
}
public void setDni(String dni) {
	this.dni = dni;
}
public String getNumruc() {
	return numruc;
}
public void setNumruc(String numruc) {
	this.numruc = numruc;
}
public String getDomicilio() {
	return domicilio;
}
public void setDomicilio(String domicilio) {
	this.domicilio = domicilio;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getTeleffijo() {
	return teleffijo;
}

public void setTeleffijo(String teleffijo) {
	this.teleffijo = teleffijo;
}

public String getTelefCel() {
	return telefCel;
}

public void setTelefCel(String telefCel) {
	this.telefCel = telefCel;
}


}
