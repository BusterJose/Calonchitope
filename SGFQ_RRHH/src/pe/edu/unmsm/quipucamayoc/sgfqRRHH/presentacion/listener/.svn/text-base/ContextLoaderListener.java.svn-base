/*
 * @(#)ContextLoaderListener.java		1.00 29/10/09
 * 
 * Copyright 
 */

package pe.edu.unmsm.quipucamayoc.sgfqRRHH.presentacion.listener;
import javax.servlet.ServletContextEvent;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * La descripción de la clase va aquí.
 *
 * @version 1.00 29 Oct 2009
 * @author 	Jose Mori
 */
public class ContextLoaderListener extends org.springframework.web.context.ContextLoaderListener {	
	public static String PATH;
    private static ApplicationContext context;
	
    /**
	 * 
	 * Metodo que retorna el bean del contexto segun el nombre de la clase
	 *  
     * @param name el objeto Class que contiene el nombre de la clase a retornar
     * @return bean un Object que referencia al bean buscado   
     */
	public static Object getBean(String name){
		return context.getBean(name);
	}
	
	/**
	 * 
	 * Metodo que retorna el bean del contexto segun el nombre completo de la clase
	 *  
     * @param name el objeto Class que contiene el nombre de la clase a retornar
     * @return bean un Object que referencia al bean buscado   
     */
	public static Object getBean(Class name){
		Object bean = null;
		String beanName = ClassUtils.getShortName(name);
		if(!StringUtils.isEmpty(beanName) && context != null){
			bean = context.getBean(beanName);
		}		
		return bean;
	}

	/**
	 * 
	 * Metodo que destruye el contexto
	 *  
     * @param event el objeto ServletContextEvent del request  
     */
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
		context = null;
	}

	/**
	 * 
	 * Metodo que inicializa el conteto
	 *  
     * @param event el objeto ServletContextEvent del request  
     */
	public void contextInitialized(ServletContextEvent event) {
   	  	super.contextInitialized(event);
   	  	context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());	  
   	  	PATH = event.getServletContext().getRealPath("/");	  
	}
	
	public static void setAttribute(String bean,Object object){
		RequestContextHolder.currentRequestAttributes().setAttribute(bean, object, RequestAttributes.SCOPE_REQUEST);
	}
	
}
