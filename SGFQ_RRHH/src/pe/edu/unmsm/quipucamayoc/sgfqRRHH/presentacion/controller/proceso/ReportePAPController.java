package pe.edu.unmsm.quipucamayoc.sgfqRRHH.presentacion.controller.proceso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.TreeNode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.DependenciaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServidorPAPDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.ReportesService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.presentacion.controller.login.LoginController;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.util.ReportGenerator;

@Controller
@Scope("session")
public class ReportePAPController{
	FacesContext context;
	private TreeNode selectedNode;
	private String nodoElegido;
	private String udCodElegido;
	private DependenciaDTO depSeleccionada;
	private Integer udId;
	private String udCod;
	private int nivel;
	private int perfil;
	private Integer anio;
	private List<Integer> listaAnio;
	
	@Resource
	private ReportesService reporteServicio;
	@Resource
	LoginController loginController;
	
	@PostConstruct
	private void init(){
		if(loginController.getRol().compareToIgnoreCase("ROLE_ADMIN")==0){
			perfil=1;
		}else{
			perfil=0;
		}
		nodoElegido="Seleccione una dependencia";
		listaAnio = new ArrayList<Integer>();
		llenarAnios();
	}
	
	public void llenarAnios(){
		Date fecha=new Date();
		int anioActual=fecha.getYear()+1900;
		System.out.println("anio: "+anioActual);
		anio=anioActual;
		for(int i=0; i<=anioActual-2010;i++){
			listaAnio.add(2010+i);
		}
	}
	
	public void onNodeSelect(NodeSelectEvent event) { 
        setDepSeleccionada((DependenciaDTO)event.getTreeNode().getData());
        setUdId(getDepSeleccionada().getUdId());
        setUdCod(getDepSeleccionada().getUdCod());
        setNivel(getDepSeleccionada().getUdNivel());
        System.out.println("nivel"+nivel);
    } 
	
	public void mostrarDep(ActionEvent event) {
		System.out.println("selected node: "+((DependenciaDTO)selectedNode.getData()).getUdId());
		nodoElegido = ((DependenciaDTO)selectedNode.getData()).getUdCod()+" - "+((DependenciaDTO)selectedNode.getData()).getUdDesc();
		/*System.out.println("mostrarDep");
		String ud = "";
		ud = obtenerUnidad();
		udCodElegido= ud ; 
		udIdElegido = dependenciaService.obtenerUdId(ud)  ;*/
	}
	
	public void mostrarPAP(){
		FacesMessage message=null;
		if(selectedNode==null && perfil==1){
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje","Debe seleccionar la unidad");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}else{
			context = FacesContext.getCurrentInstance();
			ServletContext srvcontext = (ServletContext)context.getExternalContext().getContext();  
			HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();	
			List<ServidorPAPDTO> lista = new ArrayList<ServidorPAPDTO>();
			if(perfil==1){
				lista = reporteServicio.obtenerPAP(anio,  ((DependenciaDTO)selectedNode.getData()).getUdId());
			}else{
				lista = reporteServicio.obtenerPAP(anio,  loginController.getUsuDep().getUdId());
			}
			
			
			HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.clear();
			System.out.println("Tamanio Lista = "+lista.size());
			Date fecha = new Date();
			parametros.put("anio",anio);

			FacesContext context = FacesContext.getCurrentInstance (); 
			System.out.println("context"+context);
			ServletContext sc = (ServletContext) context.getExternalContext ().getContext();
			System.out.println("sc = "+sc.getRealPath ("escudo.jpg"));
			String imagen=sc.getRealPath ("/pages/images/escudo.jpg");
		    parametros.put("logo", imagen);
		    //parametros.put("logo", this.getClass().getResourceAsStream( imagen ));
			parametros.put("usuario", loginController.getUsu());
			System.out.println("Tamanio = "+parametros.size());
			ReportGenerator generadorFrontal = new ReportGenerator();
			generadorFrontal.setUbicacionJasper("/reportes/");
			generadorFrontal.setNombreJasper("PAP.jasper");
			generadorFrontal.setNombreReportePDF("Cuadro Nominativo PAP.pdf");
			generadorFrontal.setParametrosReporte(parametros);
			generadorFrontal.setCamposReporte(lista);
			generadorFrontal.generarPDF(context, srvcontext, response);	
		}
	}


	public TreeNode getSelectedNode() {return selectedNode;}
	public void setSelectedNode(TreeNode selectedNode) {this.selectedNode = selectedNode;}
	public String getNodoElegido() {return nodoElegido;}
	public void setNodoElegido(String nodoElegido) {this.nodoElegido = nodoElegido;}
	public String getUdCodElegido() {return udCodElegido;}
	public void setUdCodElegido(String udCodElegido) {this.udCodElegido = udCodElegido;}
	public DependenciaDTO getDepSeleccionada() {return depSeleccionada;}
	public void setDepSeleccionada(DependenciaDTO depSeleccionada) {this.depSeleccionada = depSeleccionada;}
	public Integer getUdId() {return udId;}
	public void setUdId(Integer udId) {this.udId = udId;}
	public String getUdCod() {return udCod;}
	public void setUdCod(String udCod) {this.udCod = udCod;}
	public int getNivel() {return nivel;}
	public void setNivel(int nivel) {this.nivel = nivel;}
	public int getPerfil() {return perfil;}
	public void setPerfil(int perfil) {this.perfil = perfil;}
	public Integer getAnio() {return anio;}
	public void setAnio(Integer anio) {this.anio = anio;}
	public List<Integer> getListaAnio() {return listaAnio;}
	public void setListaAnio(List<Integer> listaAnio) {this.listaAnio = listaAnio;}	
}
