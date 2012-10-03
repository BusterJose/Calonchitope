package pe.edu.unmsm.quipucamayoc.sgfqRRHH.presentacion.controller.publicaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

import org.primefaces.event.DateSelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CVExpLabDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CVGradosAcadDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CurriculumVitaeDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.EstadoCivilDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.NacionalidadDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.UbigeoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.ConvocatoriaPlazaService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.CurriculumVitaeService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.EstadoCivilService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.NacionalidadService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.UbigeoService;

@Controller
@Scope("session")
public class EnviarCVController {
	
	@Resource
	CurriculumVitaeService cvservice;
	@Resource
	UbigeoService ubiservice;
	@Resource
	NacionalidadService nacservice;
	
	@Resource
	EstadoCivilService eCservice;
	
	@Resource
	ConvocatoriaPlazaService convplazaserv;
	
	/************ATRIBUTOS**************/
	private List<NacionalidadDTO> lispaises;
	private List<UbigeoDTO> listDept;
	private List<UbigeoDTO> listProv;
	private List<UbigeoDTO> listDist;
	private List<SelectItem> listSexo;
	private List<EstadoCivilDTO> listaEstadoCivil;
	private EstadoCivilDTO estadoCivil;
	private List<ConvocatoriaPlazaDTO> listPlazas;
	private String strAction;
	private ConvocatoriaDTO convSeleccionada;
	private CurriculumVitaeDTO cv;
	private CVExpLabDTO expLab;
	private List<CVExpLabDTO> listExpLabs;
	private List<CVGradosAcadDTO> listGradAcad;
	private CVGradosAcadDTO gradAcad;
	private Boolean confirmar;
	private String msjVacioEst;
	private String msjVacioTrab;
	private String msjCV;
	/**********NAVEGACION***********/
	
	public String iraEnviarCV(){
		inicializar();
		return getStrAction();
	}
	
	public void obtenerPlazas(ActionEvent ev){

		UIParameter ui=(UIParameter)ev.getComponent().findComponent("paramidConv2");
		setConvSeleccionada(new ConvocatoriaDTO());
		getConvSeleccionada().setIdConvocatoria((Integer)ui.getValue());
		setListPlazas(convplazaserv.listarPlazasPorConvocatoria(getConvSeleccionada()));
	}
	
	private void inicializar() {
		setStrAction("enviarCV");
		listaEstadoCivil = cvservice.obtenerEstadosCiviles();
		setConfirmar(new Boolean(false));
		setCv(new CurriculumVitaeDTO());
		setExpLab(new CVExpLabDTO());
		setGradAcad(new CVGradosAcadDTO());
		getCv().setGradsAcads(new ArrayList<CVGradosAcadDTO>());
		getCv().setExpLabs(new ArrayList<CVExpLabDTO>());
		setMsjVacioEst("");
		setMsjVacioTrab("");
		setMsjCV("");
		setLispaises(nacservice.listarSIPaises());
		setListDept(ubiservice.listarDepartamentos());
		setListProv(new ArrayList<UbigeoDTO>());
		setListDist(new ArrayList<UbigeoDTO>());
		setListSexo(obtenerSexos());
		setListExpLabs(new ArrayList<CVExpLabDTO>());
		setListGradAcad(new ArrayList<CVGradosAcadDTO>());
	}
	
	public void actualizarProvs(AjaxBehaviorEvent ev){
		UbigeoDTO departamento=new UbigeoDTO();
		departamento.setUbiId(getCv().getCvDepartamento());
		setListProv(ubiservice.listarProvinciasPorDepartamento(departamento));
	}
	public void actualizarDistritos(AjaxBehaviorEvent ev){
		UbigeoDTO provincia=new UbigeoDTO();
		provincia.setUbiId(getCv().getCvProvincia());
		setListDist(ubiservice.listarDistritosPorProvincia(provincia));
	}
	
	public ArrayList<SelectItem> obtenerSexos(){
		ArrayList<SelectItem> listemp=new ArrayList<SelectItem>();
		listemp.add(new SelectItem(0, "Hombre"));
		listemp.add(new SelectItem(1, "Mujer"));
		return listemp;
	}
	
	public void anadirEstUnivTecn(ActionEvent ev) {
		if (!verificarCamposVaciosEstudios()) {
			listGradAcad.add(getGradAcad());
			getCv().getGradsAcads().add(getGradAcad());
			setGradAcad(new CVGradosAcadDTO());
			setMsjVacioEst("");
		}else {
			setMsjVacioEst("Debe llenar todos los campos.");
		}
	}

	private boolean verificarCamposVaciosEstudios() {
		boolean vacio=false;
		if (getGradAcad().getEstudiosUnivInst().equals("")){
			vacio=true;
		}else if (getGradAcad().getFechaFin()==null) {
			vacio=true;
		} else if (getGradAcad().getFechaIni()==null){
			vacio=true;
		}else if (getGradAcad().getNivelAcadLogr().equals("")) {
			vacio=true;
		}else if (getGradAcad().getNombreUnivInst().equals("")) {
			vacio=true;
		}
		return vacio;
	}
	
	public void anadirExpLab(ActionEvent ev) {
		if (!verificarCamposVaciosTrabs()) {
			listExpLabs.add(getExpLab());
			getCv().getExpLabs().add(getExpLab());
			setExpLab(new CVExpLabDTO());
			setMsjVacioTrab("");
		}else {
			setMsjVacioTrab("Debe llenar todos los campos.");
		}
		
	}
	
	private boolean verificarCamposVaciosTrabs() {
		boolean vacio=false;
		if (getExpLab().getActividadEmpresa().equals("")) {
			vacio=true;
		} else if (getExpLab().getFechaFin()==null) {
			vacio=true;
		} else if (getExpLab().getFechaIni()==null) {
			vacio=true;
		} else if (getExpLab().getNomEmpresa().equals("")) {
			vacio=true;
		} else if (getExpLab().getSueldo()==0) {
			vacio=true;
		} 
		return vacio;
	}

	public void confirmarCV(ActionEvent ev) {
		setConfirmar(new Boolean(true));
	}
	
	
	public String enviarCV() {
		try {
			System.out.println("entro al boton enviar cv");
			if(!verificarCamposVaciosCV()){
				if (!cvservice.existeCV(getCv().getCvDni().trim())) {
					getCv().setCvIdConvocatoria(getConvSeleccionada().getIdConvocatoria());
					cvservice.guardarCV(getCv());
					setMsjCV("Se envió correctamente.");					
					setConfirmar(new Boolean(true));
				    setCv(cvservice.obtenerCVxDNI(cv.getCvDni()));
				    getCv().setExpLabs(listExpLabs);
				    getCv().setGradsAcads(listGradAcad);
				    setStrAction("vistaPreviaCV");
				}else {
					setMsjCV("El Curriculum Vitae con ese DNI ya existe.");
					setStrAction("enviarCV");
					setConfirmar(new Boolean(false));
				}					
			}else {
				setMsjCV("Debe llenar todos los campos");
				setStrAction("enviarCV");
				setConfirmar(new Boolean(false));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			setStrAction("publicaciones");
			setMsjCV("Hubo un error al enviar el Curriculum Vitae.");
			setConfirmar(new Boolean(false));
		}
		
		return getStrAction();
	}
	public void imprimirVistaPrevia(){
		iraPublicaciones();		
	}	
	public String iraPublicaciones(){
		inicializar();
		return "publicaciones";
	}
	
	private boolean verificarCamposVaciosCV() {
		boolean vacio=false;
		if (getCv().getCvTelCel().equals("")) {
			vacio=true;
		} else if (getCv().getCvApeMat().equals("")) {
			vacio=true;
		} else if (getCv().getCvApePat().equals("")) {
			vacio=true;
		} else if (getCv().getCvNombres().equals("")) {
			vacio=true;
		} else if (getCv().getCvDepartamento().equals(0)) {
			vacio=true;
		} else if (getCv().getCvDni().equals("")) {
			vacio=true;
		} else if (getCv().getCvDomicilio().equals("")) {
			vacio=true;
		} else if (getCv().getCvEdad().equals(0)) {
			vacio=true;
		} else if (getCv().getCvEmail().equals("")) {
			vacio=true;
		} else if (getCv().getCvEstCivil().equals(0)) {
			vacio=true;
		}else if (getCv().getCvFechaNac()==null) {
			vacio=true;
		} else if (getCv().getCvNacionalidad().equals(0)) {
			vacio=true;
		} else if (getCv().getCvProvincia().equals(0)) {
			vacio=true;
		} else if (getCv().getCvRuc().equals("")) {
			vacio=true;
		} else if (getCv().getCvTelCel().equals("")) {
			vacio=true;
		} else if (getCv().getCvTelFijo().equals("")) {
			vacio=true;
		}
		return vacio;
	}

	/*********GETTERS Y SETTERS************/
	public String getStrAction() {
		return strAction;
	}

	public void setStrAction(String strAction) {
		this.strAction = strAction;
	}

	public CurriculumVitaeDTO getCv() {
		return cv;
	}

	public void setCv(CurriculumVitaeDTO cv) {
		this.cv = cv;
	}

	public CVExpLabDTO getExpLab() {
		return expLab;
	}

	public void setExpLab(CVExpLabDTO expLab) {
		this.expLab = expLab;
	}

	public CVGradosAcadDTO getGradAcad() {
		return gradAcad;
	}

	public void setGradAcad(CVGradosAcadDTO gradAcad) {
		this.gradAcad = gradAcad;
	}

	public Boolean getConfirmar() {
		return confirmar;
	}

	public void setConfirmar(Boolean confirmar) {
		this.confirmar = confirmar;
	}

	public String getMsjVacioEst() {
		return msjVacioEst;
	}

	public void setMsjVacioEst(String msjVacioEst) {
		this.msjVacioEst = msjVacioEst;
	}

	public String getMsjVacioTrab() {
		return msjVacioTrab;
	}

	public void setMsjVacioTrab(String msjVacioTrab) {
		this.msjVacioTrab = msjVacioTrab;
	}

	public String getMsjCV() {
		return msjCV;
	}

	public void setMsjCV(String msjCV) {
		this.msjCV = msjCV;
	}

	
	public List<UbigeoDTO> getListDept() {
		return listDept;
	}

	public void setListDept(List<UbigeoDTO> listDept) {
		this.listDept = listDept;
	}

	public List<UbigeoDTO> getListProv() {
		return listProv;
	}

	public void setListProv(List<UbigeoDTO> listProv) {
		this.listProv = listProv;
	}

	public List<UbigeoDTO> getListDist() {
		return listDist;
	}
	public void setListDist(List<UbigeoDTO> listDist) {
		this.listDist = listDist;
	}
	public List<NacionalidadDTO> getLispaises() {
		return lispaises;
	}
	public void setLispaises(List<NacionalidadDTO> lispaises) {
		this.lispaises = lispaises;
	}	
	public List<SelectItem> getListSexo() {	return listSexo;	}
	public void setListSexo(List<SelectItem> listSexo) {	this.listSexo = listSexo;	}
	public List<EstadoCivilDTO> getListaEstadoCivil() {	return listaEstadoCivil;	}
	public void setListaEstadoCivil(List<EstadoCivilDTO> listaEstadoCivil) {
		this.listaEstadoCivil = listaEstadoCivil; }

	public List<ConvocatoriaPlazaDTO> getListPlazas() {
		return listPlazas;
	}

	public void setListPlazas(List<ConvocatoriaPlazaDTO> listPlazas) {
		this.listPlazas = listPlazas;
	}

	public ConvocatoriaDTO getConvSeleccionada() {
		return convSeleccionada;
	}

	public void setConvSeleccionada(ConvocatoriaDTO convSeleccionada) {
		this.convSeleccionada = convSeleccionada;
	}

	public void setEstadoCivil(EstadoCivilDTO estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public EstadoCivilDTO getEstadoCivil() {
		return estadoCivil;
	}

	public void setListExpLabs(List<CVExpLabDTO> listExpLabs) {
		this.listExpLabs = listExpLabs;
	}

	public List<CVExpLabDTO> getListExpLabs() {
		return listExpLabs;
	}

	public void setListGradAcad(List<CVGradosAcadDTO> listGradAcad) {
		this.listGradAcad = listGradAcad;
	}

	public List<CVGradosAcadDTO> getListGradAcad() {
		return listGradAcad;
	}
}
