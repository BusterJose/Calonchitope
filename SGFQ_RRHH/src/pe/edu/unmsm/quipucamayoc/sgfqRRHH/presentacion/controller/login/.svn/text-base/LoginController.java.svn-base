package pe.edu.unmsm.quipucamayoc.sgfqRRHH.presentacion.controller.login;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;
import org.springframework.security.Authentication;
import org.springframework.security.AuthenticationException;
import org.springframework.security.AuthenticationManager;
import org.springframework.security.context.HttpSessionContextIntegrationFilter;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;
import org.springframework.security.ui.AbstractProcessingFilter;
import org.springframework.security.ui.WebAuthenticationDetails;
import org.springframework.security.ui.webapp.AuthenticationProcessingFilter;
import org.springframework.stereotype.Controller;

import pe.edu.unmsm.quipucamayoc.seguridad.negocio.Perfil;
import pe.edu.unmsm.quipucamayoc.seguridad.negocio.Usuario;
import pe.edu.unmsm.quipucamayoc.seguridad.util.ModulosDesarrollo;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.DependenciaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.DependenciaService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.UserManagerService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.util.Util;
import quipucamayoc.seguridad.remote.locator.ServiceLocator;

@Controller
@Scope("session")
public class LoginController {
	
	@Resource
	UserManagerService ususerv;
	
	@Resource(name="QuipuAuthenticationManager")
	private AuthenticationManager authenticationManager;
	
	@Resource
	private DependenciaService dependenciaServcio;
	
	/**************** ATRIBUTOS DE LA CLASE *******************/
	private String ErrorLogueo;
	private Usuario usuario;
	private DependenciaDTO usuDep;
	private String strAction;
	private String usu;
	private String psw;
	private FacesContext context;
	private HttpServletRequest request;
	private String rutaRaiz;
	private boolean btnGuardar;
	private boolean btnEliminar;
	static final String ROL_ADMIN_DEP="ROLE_ADMIN_DEP";
	static final String ROL_ADMIN="ROLE_ADMIN";
	static final String ROL_JURADO="ROLE_JURADO";
	private String rol;
	private boolean ayax;
	private int diasDeBlokeo;
	private List<DependenciaDTO> listaDependencias;
	private boolean verLista;
	private String codDep;
	private int idDep;	
	private String dependencia;
	private DependenciaDTO oficina;
	
	/************inicializacion****************/
	public LoginController() {
		inicializarRutaRaiz();
		diasDeBlokeo=0;
		ayax=true;
		
		listaDependencias= new ArrayList();
		verLista=false;
	}
	/**************** NAVEGACION ********************************/
	public String login(){
		return validacionUsuario(usu, psw);
			
	}
		 
	 public void validarCaducidad(){
			
			Map<String,String> datos=new HashMap<String, String>();
			datos.put("cuenta",usu);
			datos.put("pass",psw);
			boolean resultado=false;
			RequestContext context = RequestContext.getCurrentInstance();
			//ingresar(cuenta , 2);	
			
			int codigo = validacion_usuario(usu);
		//	System.out.println("cuenta: "+cuenta);
			String mensaje="";
			
			if(codigo>0){
				
				   switch(codigo){
				     case 1:
				    	 
				    	 if(  validacionUsuario( usu, psw ).compareToIgnoreCase("logueoCorrecto")==0){
				    		 
				    		 int perfil = verificar_perfil(usu,psw);
				    		 if(perfil>0){
				    			//----------ingreso al sistema
				    			pe.edu.unmsm.quipucamayoc.seguridad.negocio.Usuario usuario;
							 	ServiceLocator serviceLocator = new ServiceLocator();
							 	usuario = serviceLocator.getUsuariosService().obtenerUsuario(usu) ;
							 	String datosFecha[] = usuario.getFecPass().split("/");
							 	/*for(int i=0;i<datosFecha.length;i++){
							 		System.out.println("usuFecPass Datos Año: "+datosFecha[i]);
								}*/
							 		
							 	Calendar fechaCaducidad = new GregorianCalendar();
							 	Calendar fechaActual = Calendar.getInstance();
							 	fechaCaducidad.set(Integer.parseInt(datosFecha[2]),Integer.parseInt(datosFecha[1].toString())-1,Integer.parseInt(datosFecha[0]));
							 //	System.out.println("fecha de caducidad0  : "+fechaCaducidad.getTime());
							 	fechaCaducidad.add(Calendar.DATE, 183);
							 //	System.out.println("fecha de caducidad1  : "+fechaCaducidad.getTime());
							 //	System.out.println("fecha Actual0        : "+fechaActual.getTime());
							 		
							 	//if(fechaActual.getTime().compareTo(fechaCaducidad.getTime())>0){
							 		for(int i=1;i<=183;i++){
							 			fechaActual=Calendar.getInstance();
							 			fechaActual.add(Calendar.DATE,i);
							 			int dia = fechaActual.get(Calendar.DATE);
							 			int mes = fechaActual.get(Calendar.MONTH);
							 			int annio = fechaActual.get(Calendar.YEAR);
							 			//System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx   : "+fechaActual.getTime());
							 			if(fechaCaducidad.get(Calendar.DATE)==dia && fechaCaducidad.get(Calendar.MONTH)==mes && fechaCaducidad.get(Calendar.YEAR)==annio){
							 				diasDeBlokeo=i;
							 				i=183;
							 			}
							 			
							 		}
							 		//System.out.println("resta: "+diasDeBlokeo);
							 	//}
							 	if(diasDeBlokeo<=7){
							 		resultado=true;
							 		ayax=true;
							 	}else{
							 		ingresar(usu , perfil);
							 		resultado=false;
							 		ayax=false;
							 	}
							 	
							 	
				    		 }
				    		 else{
				    			 ayax=true;
				    			 mensaje = "Usuario no tiene perfil para este modulo";
				    		 }
				    		 
				    	 }else{
				    		 ayax=true;
				    		 mensaje = "Contraseña incorrecta";
				    	 }
				    	 
				    	 break;
				     
				     case 2:
				    	 ayax=true;
				    	 mensaje = "Usuario bloqueado";
					     break;
					     				     
				     case 3:
				    	 ayax=true;
				    	 mensaje = "Usuario inactivo";
					     break;
					     
				     case 4:
				    	 //usuario nuevo, debe actualizar sus datos
				    	String direccion;
						HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
						direccion = getSoporteURL()+"pages/backLogin.jsf?user="+usu+"@unmsm.edu.pe&pass="+psw+"&url="+"http://"+request.getServerName()+":"+request.getLocalPort()+"cap/";
								
						 FacesContext facesContext = FacesContext.getCurrentInstance();
						 ExternalContext ec = facesContext.getExternalContext();
						 try{
						 ec.redirect(direccion);
						 }
						 catch(Exception e){
							 e.printStackTrace();
						 }
						 ayax=true;
					     break;
				   }
			}
			else{
				mensaje = "usuario no registrado";
				
			}
			
			if(mensaje != ""){
				FacesContext.getCurrentInstance().
				addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,  mensaje,"" ));
				
			}
			//System.out.println("Resultado: "+resultado);
			try{
				context.addCallbackParam("resultado", resultado);
			}catch (Exception e) {
				//System.out.println("mensaje de error: "+e.getMessage());
			}
			
		}
	
	 private void ingresar(String cuenta, int perfil){
			
			String direccion="";
			
			/*if(perfil==1){
				direccion = getCapURL()+"/pages/procesos/pModificar.jsf" ;
			}
			else{
				direccion = getCapURL()+"/pages/procesos/pModificarAdmin.jsf" ;
			}*/
			direccion = rutaRaiz+"/pages/pagePrincipal.jsf" ;
			
			/*usuario = new Usuario();
			usuario.setIdusuario(cuenta);
			usuario.setUdId(dependencia);
			
			usuario.setId( obtenerDatoId() );
			
			
			RequestContextHolder.currentRequestAttributes().setAttribute("usuario", usuario, RequestAttributes.SCOPE_SESSION);
			RequestContextHolder.currentRequestAttributes().setAttribute("perfil", perfil, RequestAttributes.SCOPE_SESSION);*/
			
			
			
			//carga la lista de años para el combo en el menu
					//mostrarAnio();
					//Util.ingresarObjetoSession("anioGlobal",anioEstado);
			//RequestContextHolder.currentRequestAttributes().setAttribute("anioGlobal", anioEstado, RequestAttributes.SCOPE_SESSION);
			
			
			try {
				//menuModel = menuServicio.cargarMenus(perfil);
				FacesContext.getCurrentInstance().getExternalContext().redirect(direccion);
				//System.out.println("ENTRANDO A LA PAGINA PRINCIPAL");
				//mostrarAnio();
				
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		} 
	 
	public String validacionUsuario(String usu,String pwd) throws AuthenticationException{			        	
    	
    	try {
    		Authentication auth =validarContextSecurity(usu,pwd);
	    	if(auth.isAuthenticated()){
	    		usuario=ususerv.getUsuario(usu, pwd);
	    		setUsuDep(ususerv.getUdId(usu, pwd));
	    		setRol(ususerv.getPerfil(usu, pwd));
	    		if (getRol().equals("ROLE_ADMIN")) {
					getUsuDep().setUdId(10000);
				}
	    		System.out.println("perfil: "+getRol());
	    		if(rol.equals(ROL_JURADO)){
	    			btnGuardar=true;
	    		}else {
	    			btnGuardar=false;
				}
	    		ayax=false;
	    		setStrAction("logueoCorrecto");
	    	}
	    	else {
	    		ayax=true;
	    		setStrAction("error");
			}
	    	DependenciaDTO dep=dependenciaServcio.obtenerud_cod(usuDep.getUdId());
	    	usuDep.setUdNivel(dep.getUdNivel());
	    	usuDep.setUdCod(dep.getUdCod());
	    	//setStrAction("logueoCorrecto");
	    	return getStrAction();
    	} catch (Exception e) {
    		ayax=true;
    		return "error";
		}
    	
	}
	
private int verificar_perfil(String usu,String pwd){
		
		int perfil = 0;
		ServiceLocator serviceLocator = new ServiceLocator();
		List<Perfil> lista=serviceLocator.getUsuariosService().perfilesPorModulo(usu, pwd, ModulosDesarrollo.COD_GESTION );
		
		List<String> dependencias= new ArrayList();
		
		listaDependencias= new ArrayList();
		dependencias= new ArrayList();
		verLista=false;
		
		//List<Perfil> lista2=serviceLocator.getUsuariosService().perfilesPorModulo(usu, pwd, ModulosDesarrollo.COD_PLANIFICACION );
		
		for(int i=0;i<lista.size();i++){
			
			long grupoGen = lista.get(i).getGrupoGenCod(); 
			long grupo = lista.get(i).getGrupoCod(); 
			
			codDep=lista.get(i).getUnidepCod();
			idDep=lista.get(i).getUnidepId().intValue();
			
		//	System.out.println("getGrupoGenCod: "+grupoGen);
		//	System.out.println("getGrupoCod: "+grupo);
			
			if(grupoGen == 1){
				
				if(grupo == 129 ){
					perfil = 1 ;
				}
				dependencia = lista.get(i).getUnidepCod() ;
				
			}else {
				if(grupo == 130){
				perfil = 2 ;
				dependencia = lista.get(i).getUnidepCod() ;
								
				dependencias.add(dependencia); 
				
				
				}
			}//System.out.println("usu_dep: "+dependencia);
				oficina = dependenciaServcio.obtenerDepxUdcod(dependencia);			
		}
		
		
		if( dependencias.size() > 1 ){
			verLista=true;
			for(int i=dependencias.size()-1; i>=0 ;i--){
				listaDependencias.add(  dependenciaServcio.obtenerDepxUdcod( dependencias.get(i) )  )  ;
			}
				
		}
		
		return perfil;
		
	}

	public Authentication validarContextSecurity(String usu, String pas)
	{
		HttpServletRequest request= getRequest();
		UsernamePasswordAuthenticationToken authReq=new UsernamePasswordAuthenticationToken(usu, pas);
    	authReq.setDetails(new WebAuthenticationDetails(request));			    	
    	HttpSession session = request.getSession();

    	session.setAttribute(AuthenticationProcessingFilter.SPRING_SECURITY_LAST_USERNAME_KEY, usu);
    	Authentication auth = getAuthenticationManager().authenticate(authReq);
        
    	SecurityContext secCtx = SecurityContextHolder.getContext();	    	
    	secCtx.setAuthentication(auth);
    	session.setAttribute(HttpSessionContextIntegrationFilter.SPRING_SECURITY_CONTEXT_KEY, secCtx);   			    	

    	String urlKey = AbstractProcessingFilter.SPRING_SECURITY_SAVED_REQUEST_KEY;	   
    	//SavedRequest savedRequest = (SavedRequest)session.getAttribute(urlKey);
    	session.removeAttribute(urlKey);
    	return auth ;
	}

	protected HttpServletRequest getRequest() {
		ExternalContext context = 
			FacesContext.getCurrentInstance().getExternalContext();
	    HttpServletRequest request = 
	    	(HttpServletRequest) context.getRequest();	    
	    return request;
	}
	public void cerrarSesion(ActionEvent event)throws Exception{
		String out=cerrarSesionGeneric();
	}

	public String cerrarSesionGeneric() {
		try{
		HttpSession se2=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    	se2.invalidate();
		}catch(AuthenticationException e){e.printStackTrace();}
		return "error";
	}
	
	public void addMessage(FacesMessage message) {  
        FacesContext.getCurrentInstance().addMessage("formLoginRRHH:growl", message);  
    }
	
	public String getSoporteURL() {
		
		String direccion;

		HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();			        	
 		direccion = "http://"+request.getServerName()+":"+request.getLocalPort()+"/SoporteUsuarios/";
 		//direccion = "http://172.16.156.43/SoporteUsuarios/";
 		
		return direccion ;
	}
	
	public int validacion_usuario(String alumno)
	{
		pe.edu.unmsm.quipucamayoc.seguridad.negocio.Usuario usu;
		int estado=0;
		ServiceLocator serviceLocator = new ServiceLocator();
		usu = serviceLocator.getUsuariosService().obtenerUsuario(alumno) ;
		try{
		//System.out.println("Nombre_Usuario: ???="+usu.getUsuDesc());		
		if(usu!=null){
			
			if(usu.getUsuEst().equals("A") ){
				estado=1;
			}
			
			if(usu.getUsuEst().equals("N") ){
				estado=4;
			}
			
			if(usu.getUsuEst().equals("B") ){
				estado=2;
			}
			
			if(usu.getUsuEst().equals("I") ){
				estado=3;
			}
		}
		}catch (Exception e) {
			System.out.println("usu null + "+e.getMessage());
		}
		
		return estado;
	}
	

	 private void inicializarRutaRaiz(){
			context=FacesContext.getCurrentInstance();
			request=(HttpServletRequest)context.getExternalContext().getRequest();
			rutaRaiz=Util.obtenerRutaRaiz(request);
			System.out.println(rutaRaiz);
	}
	
	 private String obtenerDatoId(){
			
			pe.edu.unmsm.quipucamayoc.seguridad.negocio.Usuario usuario;
			ServiceLocator serviceLocator = new ServiceLocator();
			usuario = serviceLocator.getUsuariosService().obtenerUsuario(usu) ;
			long usuid = usuario.getUsuId();
			return String.valueOf(usuid);
		} 
	 
	/*************AQUI DEBE IR TODOS LOS ACTION DE DIRECCIONAMIENTO DE LA BARRA DE MENU PRINCIPAL(refactorizar todos los metodos
	 ira... de todos los controladores y pasarlos aqui)****************/
	public String iraMantePlazas(){
		return "mantePlazas";
	}
	
	public String iraConsulServidor(){
		return "consulServidor";
	}
	
	public String iraPAP(){
		return "reportePAP";
	}
	
	/************ GETTERS Y SETTERS ***********/
	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public String getErrorLogueo() {
		return ErrorLogueo;
	}

	public void setErrorLogueo(String errorLogueo) {
		ErrorLogueo = errorLogueo;
	}

	public String getStrAction() {
		return strAction;
	}

	public void setStrAction(String strAction) {
		this.strAction = strAction;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getUsu() {
		return usu;
	}

	public void setUsu(String usu) {
		this.usu = usu;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public FacesContext getContext() {
		return context;
	}

	public void setContext(FacesContext context) {
		this.context = context;
	}

	public String getRutaRaiz() {
		return rutaRaiz;
	}

	public void setRutaRaiz(String rutaRaiz) {
		this.rutaRaiz = rutaRaiz;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public boolean isBtnGuardar() {
		return btnGuardar;
	}
	public void setBtnGuardar(boolean btnGuardar) {
		this.btnGuardar = btnGuardar;
	}
	public boolean isBtnEliminar() {
		return btnEliminar;
	}
	public void setBtnEliminar(boolean btnEliminar) {
		this.btnEliminar = btnEliminar;
	}
	public DependenciaDTO getUsuDep() {
		return usuDep;
	}
	public void setUsuDep(DependenciaDTO usuDep) {
		this.usuDep = usuDep;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public boolean isAyax() {
		return ayax;
	}
	public void setAyax(boolean ayax) {
		this.ayax = ayax;
	}
	public int getDiasDeBlokeo() {
		return diasDeBlokeo;
	}
	public void setDiasDeBlokeo(int diasDeBlokeo) {
		this.diasDeBlokeo = diasDeBlokeo;
	}
	public boolean isVerLista() {
		return verLista;
	}
	public void setVerLista(boolean verLista) {
		this.verLista = verLista;
	}
	public String getCodDep() {
		return codDep;
	}
	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}
	public int getIdDep() {
		return idDep;
	}
	public void setIdDep(int idDep) {
		this.idDep = idDep;
	}
	public String getDependencia() {
		return dependencia;
	}
	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}
	public DependenciaDTO getOficina() {
		return oficina;
	}
	public void setOficina(DependenciaDTO oficina) {
		this.oficina = oficina;
	}
	
}
