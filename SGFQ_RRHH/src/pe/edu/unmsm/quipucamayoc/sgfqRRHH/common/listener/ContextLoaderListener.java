package pe.edu.unmsm.quipucamayoc.sgfqRRHH.common.listener;

import javax.servlet.ServletContextEvent;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ContextLoaderListener extends org.springframework.web.context.ContextLoaderListener {
	public static String DB;
	public static String PATH;
    private static ApplicationContext context;
	
	public static Object getBean(String name){
		return context.getBean(name);
	}
	
	public static Object getBean(Class name){
		Object bean = null;
		String beanName = ClassUtils.getShortName(name);
		if(!StringUtils.isEmpty(beanName) && context != null){
			bean = context.getBean(beanName);
		}		
		return bean;
	}

	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
		context = null;
	}

	public void contextInitialized(ServletContextEvent event) {
   	  super.contextInitialized(event);
	  context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
	  PATH = event.getServletContext().getRealPath("/");
	  DB = "db";
	}

}
