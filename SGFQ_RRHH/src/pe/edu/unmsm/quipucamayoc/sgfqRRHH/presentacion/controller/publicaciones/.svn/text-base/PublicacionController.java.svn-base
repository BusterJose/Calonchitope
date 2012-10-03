package pe.edu.unmsm.quipucamayoc.sgfqRRHH.presentacion.controller.publicaciones;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.CustomScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import oracle.sql.ARRAY;

import org.springframework.context.annotation.Scope;
import org.springframework.security.AuthenticationException;
import org.springframework.stereotype.Controller;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CurriculumVitaeDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.VWConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.ConvocatoriaPlazaService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.ConvocatoriaService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.CurriculumVitaeService;

@Controller
@Scope("session")
public class PublicacionController {
	
	
	@Resource
	ConvocatoriaService convocatoriaServ;
	@Resource
	ConvocatoriaPlazaService convocplazaServ;
	@Resource
	CurriculumVitaeService curriculumVService;
	/*********** ATRIBUTOS ***********/
	private List<VWConvocatoriaDTO> listconv;
	private VWConvocatoriaDTO convocatoriaSelected;
	private List<CurriculumVitaeDTO> listResultadosConv;
	private Boolean mostrardlgBase;
	
	
	/************* NAVEGACION *************/
	public String cerrarSesionGeneric() {
		try{
		HttpSession se2=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    	se2.invalidate();
		}catch(AuthenticationException e){e.printStackTrace();}
		return "error";
	}
	
	public String iraPublicaciones(){
		inicializar();
		return "publicaciones";
	}
	public String irVerResultadosConvocatoria(){
		return "publicarResultados";
	}
	public String iraLogin(){
		inicializar();
		return cerrarSesionGeneric();
	}	
	public void mostrarResultados(ActionEvent ev){
		Integer idConv,idEstadoConv;
		UIParameter p=(UIParameter)ev.getComponent().findComponent("paramIdConvResult");
		idConv=(Integer)p.getValue();
		UIParameter p1=(UIParameter)ev.getComponent().findComponent("paramIdEstadoConv");
		idEstadoConv=(Integer) p1.getValue();
		System.out.println("Convocatoria Seleccionada en ver Resultados:" + idConv);
		System.out.println("Estado Convocatoria:" + idEstadoConv);		
		setListResultadosConv(curriculumVService.obtenerCVxConvocatoria(idConv));
		System.out.println("Tamaño de la lista:" + listResultadosConv.size());
		
	}	
	public void mostrarBase(ActionEvent ev){
		setMostrardlgBase(new Boolean(true));
		Integer idconvocatoria;
		UIParameter p=(UIParameter)ev.getComponent().findComponent("paramidConv");
		idconvocatoria=(Integer)p.getValue();
		getConvocatoriaSelected().setIdConvocatoria(idconvocatoria);
		setConvocatoriaSelected(convocatoriaServ.obtenerVWConvocatoria(getConvocatoriaSelected()));
		
	}
	
	/*************METODO DE INICIALIZACION**************/
	public void inicializar() {
		setListconv(convocatoriaServ.listarConvocatoriasActuales());
		setMostrardlgBase(new Boolean(false));
		setConvocatoriaSelected(new VWConvocatoriaDTO());
		setListResultadosConv(new ArrayList<CurriculumVitaeDTO>());
	}
	
	/*********** GETTERS AND SETTERS ***********/
	public List<VWConvocatoriaDTO> getListconv() {
		return listconv;
	}

	public void setListconv(List<VWConvocatoriaDTO> listconv) {
		this.listconv = listconv;
	}
	public VWConvocatoriaDTO getConvocatoriaSelected() {
		return convocatoriaSelected;
	}
	public void setConvocatoriaSelected(VWConvocatoriaDTO convocatoriaSelected) {
		this.convocatoriaSelected = convocatoriaSelected;
	}
	public Boolean getMostrardlgBase() {
		return mostrardlgBase;
	}
	public void setMostrardlgBase(Boolean mostrardlgBase) {
		this.mostrardlgBase = mostrardlgBase;
	}

	public List<CurriculumVitaeDTO> getListResultadosConv() {
		return listResultadosConv;
	}

	public void setListResultadosConv(List<CurriculumVitaeDTO> listResultadosConv) {
		this.listResultadosConv = listResultadosConv;
	}	
}
