package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.impl;

import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.User;
import org.springframework.stereotype.Service;

//import pe.edu.unmsm.quipu.infopersonal.presentacion.controller.LoginController;
import pe.edu.unmsm.quipucamayoc.seguridad.negocio.Perfil;
import pe.edu.unmsm.quipucamayoc.seguridad.negocio.Usuario;
import pe.edu.unmsm.quipucamayoc.seguridad.util.ModulosDesarrollo;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.DependenciaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.UserManagerService;
import quipucamayoc.seguridad.remote.locator.ServiceLocator;

@Service
public class UserManagerServiceImpl implements UserManagerService {

	public User getUser(String usuario, String pass){	
		/*
		 * Logueo original
		 */
		/*ServiceLocator serviceLocator = new ServiceLocator();
		String res= serviceLocator.getUsuariosService().validarUsuario(usuario, pass) ;
		String res="A";
		if(res.equals("A")){
			
			List<Perfil> lista=serviceLocator.getUsuariosService().perfilesPorModulo(usuario, pass,"14");
			
			GrantedAuthority[] grantedAuthorities;
			GrantedAuthority authority ;
			grantedAuthorities = new GrantedAuthority[lista.size()];
			String rol=null;
			for(int i=0;i<lista.size();i++){
				//admin
				if(lista.get(i).getGrupoCod()==152){
					rol="ROLE_USER";
				}else if(lista.get(i).getGrupoCod()==150){
					rol="ROLE_ADMIN";
				}
				authority = new GrantedAuthorityImpl(rol);
				grantedAuthorities[i] = authority;
			}
			boolean enabled=true;
			
			GrantedAuthority[] grantedAuthorities = new GrantedAuthority[1];
			grantedAuthorities[0]=new GrantedAuthorityImpl("ROLE_USER");
			User user=new User(usuario,pass,enabled, true,true,true, grantedAuthorities);
			return user;
		}
		return null;*/
		/*
		 * Logueo nuevo
		 */
		HttpServletRequest request=getRequest();
		String ipaddress = request.getHeader("HTTP_X_FORWARDED_FOR");
		String ipCustom = request.getRemoteAddr();
		String hostName = request.getRemoteHost();
		ServiceLocator serviceLocator = new ServiceLocator();
		String res= serviceLocator.getUsuariosService().validarUsuario(usuario, pass,ModulosDesarrollo.COD_ASIGNACIONPERSONAL,ipCustom,hostName);
		GrantedAuthority[] grantedAuthorities;		
		GrantedAuthority authority ;
		User user=null;
		if(res.equals("A")){
			
			List<Perfil> listaP=serviceLocator.getUsuariosService().perfilesPorModulo(usuario, pass,"8");//codigo del modulo de gestion
			Usuario us=serviceLocator.getUsuariosService().obtenerUsuario(usuario);
			grantedAuthorities = new GrantedAuthority[listaP.size()];
			String rol=null;
			for(int i=0;i<listaP.size();i++){
				if(listaP.get(i).getGrupoCod()==130){
					rol="ROLE_ADMIN_DEP";
					
				}
				if(listaP.get(i).getGrupoCod()==129){
					rol="ROLE_ADMIN";
					
				}
				if(listaP.get(i).getGrupoCod()==201){
					rol="ROLE_JURADO";
					
				}
				authority = new GrantedAuthorityImpl(rol);
				grantedAuthorities[i] = authority;
			}
			
			user=new User(usuario,pass,true, true,true, true, grantedAuthorities);
			return user;
		}
		else if(res.equals("B")){
			grantedAuthorities = new GrantedAuthority[1];
			authority = new GrantedAuthorityImpl("IS_AUTHENTICATED_ANONYMOUSLY");
			grantedAuthorities[0] = authority;
			user=new User(usuario,pass,false, true,true,false, grantedAuthorities);			
		}
	return user;
	}
	
	public Usuario getUsuario(String usuario, String pass){	
		ServiceLocator serviceLocator = new ServiceLocator();
		Usuario user=null;
		user=serviceLocator.getUsuariosService().obtenerUsuario(usuario);
		return user;
	}

	@Override
	public String getPerfil(String usuario, String pass) {
		ServiceLocator serviceLocator = new ServiceLocator();
		List<Perfil> listaP=serviceLocator.getUsuariosService().perfilesPorModulo(usuario, pass,"8");//codigo del modulo de gestion
		Usuario us=serviceLocator.getUsuariosService().obtenerUsuario(usuario);
		String rol="";
		for(int i=0;i<listaP.size();i++){
			if(listaP.get(i).getGrupoCod()==130){
				rol="ROLE_ADMIN_DEP";
				
			}
			if(listaP.get(i).getGrupoCod()==129){
				rol="ROLE_ADMIN";
				
			}
			if(listaP.get(i).getGrupoCod()==201){
				rol="ROLE_JURADO";
				
			}
		}
		return rol;
	}

	@Override
	public DependenciaDTO getUdId(String usuario, String pass) {
		ServiceLocator serviceLocator = new ServiceLocator();
		DependenciaDTO unidep=new DependenciaDTO();
		List<Perfil> listaP=serviceLocator.getUsuariosService().perfilesPorModulo(usuario, pass,"8");//codigo del modulo de gestion
		Usuario us=serviceLocator.getUsuariosService().obtenerUsuario(usuario);
		for(int i=0;i<listaP.size();i++){
			unidep.setUdId(listaP.get(i).getUnidepId().intValue());
			unidep.setUdDesc(listaP.get(i).getUnidepDesc());
		}		
		return unidep;
	}
	
	protected HttpServletRequest getRequest() {
		ExternalContext context = 
			FacesContext.getCurrentInstance().getExternalContext();
	    HttpServletRequest request = 
	    	(HttpServletRequest) context.getRequest();	    
	    return request;
	}
}
