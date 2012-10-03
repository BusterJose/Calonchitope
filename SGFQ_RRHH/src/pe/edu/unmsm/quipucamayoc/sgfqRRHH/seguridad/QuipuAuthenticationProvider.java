/*
 * @(#)QuipuAuthenticationProvider.java		1.00 29/10/09
 * 
 * Copyright 
 */

package pe.edu.unmsm.quipucamayoc.sgfqRRHH.seguridad;

import javax.annotation.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.security.AuthenticationException;
import org.springframework.security.AuthenticationServiceException;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;
import org.springframework.security.providers.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.userdetails.UserDetails;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.UserManagerService;

public class QuipuAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	
	@Resource
	private UserManagerService userDetailsService;
	
	public UserManagerService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(UserManagerService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub
	}

	/**
     * Establece el objeto <code>Locale</code> con el respectivo
     * lenguaje y region geografica del usuario.
     * 
     * @param username nombre de Usurio que desea iniciar sesion
     * @param authentication instancia de la solicitud del inicio de sesion
     * 
     * @return loadedUser instancia de <code>UserDetails</code> que contiene la informacion del usuario
     */
	
	@Override
	protected UserDetails retrieveUser(String username,UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		 UserDetails loadedUser;

	        try {
	            loadedUser = this.getUserDetailsService().getUser(username,authentication.getCredentials().toString());
	        }catch (DataAccessException repositoryProblem) {
	            throw new AuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
	        }

	        if (loadedUser == null) {
	            throw new AuthenticationServiceException(
	                    "UserDetailsService returned null, which is an interface contract violation");
	        }
	        return loadedUser;
	}

}
