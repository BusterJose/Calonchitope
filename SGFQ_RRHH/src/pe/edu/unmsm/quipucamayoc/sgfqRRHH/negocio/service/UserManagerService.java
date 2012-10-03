package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service;

import org.springframework.security.userdetails.User;

import pe.edu.unmsm.quipucamayoc.seguridad.negocio.Usuario;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.DependenciaDTO;


public interface UserManagerService {
	public User getUser(String usuario, String pass);
	public Usuario getUsuario(String usuario, String pass);
	public String getPerfil(String usuario, String pass);
	public DependenciaDTO getUdId(String usuario, String pass);
}
