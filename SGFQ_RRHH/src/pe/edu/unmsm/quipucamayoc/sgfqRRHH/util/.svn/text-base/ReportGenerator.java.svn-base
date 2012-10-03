package pe.edu.unmsm.quipucamayoc.sgfqRRHH.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class ReportGenerator{
	
	/** 
	 * Nombre de la carpeta donde se encuentra el fichero jasper 
	 * desde la raiz del contexto web  , ejm : /WEB-INF/reportes/ con el '/' al final
	 */
	private String ubicacionJasper; 
	
	/**
	 * Nombre del Fichero Jasper
	 */
	private String nombreJasper;
	
	/**
	 * Nombre del reporte en pdf
	 */
	private String nombreReportePDF;
	
	/**
	 * Parametros del reporte
	 */
	private Map<String, Object> parametrosReporte;
	
	/**
	 * Coleccion de datos para el dataSource
	 */
	private List<? extends Object> camposReporte;
	
	public void generarPDF(FacesContext context,ServletContext srvcontext,HttpServletResponse response){
		JRBeanCollectionDataSource dataSource;
		File file;
		JasperPrint jasperPrint;
		byte[] pdf;
		try{
			dataSource = new JRBeanCollectionDataSource(camposReporte);
			file = new File(srvcontext.getRealPath(ubicacionJasper+nombreJasper));
			jasperPrint = JasperFillManager.fillReport(new FileInputStream(file),parametrosReporte,dataSource); 
			pdf = JasperExportManager.exportReportToPdf(jasperPrint);
			//para mostrar sin imprimir
			//response.addHeader("Content-disposition", "filename="+nombreReportePDF);
			//automaticamente para descargar
			//response.addHeader("Content-disposition", "inline;filename="+nombreReportePDF);
			response.addHeader("Content-disposition", "attachment;filename="+nombreReportePDF);
			response.setContentLength(pdf.length); 
			response.getOutputStream().write(pdf); 
			response.setContentType("application/pdf"); 
			context.responseComplete();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}	
	}		
	
	public void generarHTML(FacesContext context,ServletContext srvcontext,HttpServletResponse response){
		JRBeanCollectionDataSource dataSource;
		File file;
		JasperPrint jasperPrint;
		JRExporter exporter = null;
		byte[] html;
		try{
			dataSource = new JRBeanCollectionDataSource(camposReporte);
			file = new File(srvcontext.getRealPath(ubicacionJasper+nombreJasper));
			jasperPrint = JasperFillManager.fillReport(new FileInputStream(file),parametrosReporte,dataSource); 
			html = JasperExportManager.exportReportToPdf(jasperPrint);
			exporter = new JRHtmlExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, response.getWriter());
            //exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, request.getContextPath() + "/image?image=");
			response.addHeader("Content-disposition", "attachment;filename="+nombreReportePDF);
			response.setContentLength(html.length); 
			response.getOutputStream().write(html); 
			response.setContentType("text/html"); 
			context.responseComplete();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}	
	}		

	public String getUbicacionJasper() {
		return ubicacionJasper;
	}

	public void setUbicacionJasper(String ubicacionJasper) {
		this.ubicacionJasper = ubicacionJasper;
	}

	public String getNombreJasper() {
		return nombreJasper;
	}

	public void setNombreJasper(String nombreJasper) {
		this.nombreJasper = nombreJasper;
	}

	public String getNombreReportePDF() {
		return nombreReportePDF;
	}

	public void setNombreReportePDF(String nombreReportePDF) {
		this.nombreReportePDF = nombreReportePDF;
	}

	public Map<String, Object> getParametrosReporte() {
		return parametrosReporte;
	}

	public void setParametrosReporte(Map<String, Object> parametrosReporte) {
		this.parametrosReporte = parametrosReporte;
	}

	public List<? extends Object> getCamposReporte() {
		return camposReporte;
	}

	public void setCamposReporte(List<? extends Object> camposReporte) {
		this.camposReporte = camposReporte;
	}
	
 
}