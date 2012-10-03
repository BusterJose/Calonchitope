package pe.edu.unmsm.quipucamayoc.sgfqRRHH.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class Util {
	
	public static String obtenerRutaRaiz(HttpServletRequest request){
		String rutaRaiz;
		rutaRaiz=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		//System.out.println("rutaRaiz -->" +rutaRaiz);
		return rutaRaiz;
	}
	
	public static String formatearFecha(Date fecha, String formato){
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat(formato);
		String rs=formatoDeFecha.format(fecha);
		return rs;
	}
	
	public static String fechaActual(){
		java.util.Date fecha = new Date();
		String fechaActual= Util.formatearFecha(fecha,"dd/MM/yyyy");
		return fechaActual;
	}
	
	public static void agregarMensaje(FacesContext context,String idComponente,String summary,String detail,Severity severidad){
		 FacesMessage msg;
		 msg=new FacesMessage(summary,detail);
		 msg.setSeverity(severidad);
		 context.addMessage(idComponente,msg); 	
	}
	
	public static double redondearNumero(double numero,int numeroDecimales) {
		long mult=(long)Math.pow(10,numeroDecimales);
		double resultado=(Math.round(numero*mult))/(double)mult;
		return resultado;
	}
}
