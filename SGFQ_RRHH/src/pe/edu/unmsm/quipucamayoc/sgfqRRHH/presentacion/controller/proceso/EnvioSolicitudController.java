package pe.edu.unmsm.quipucamayoc.sgfqRRHH.presentacion.controller.proceso;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FlowEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.TreeNode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.DependenciaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.RequisitoConvPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServicioConvPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.TipoRequisitoConvPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.ConvocatoriaService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.PlazaService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.RequisitoConvPlazaService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.presentacion.controller.login.LoginController;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.presentacion.listController.ListasController;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.util.Util;

@Controller
@Scope("session")
public class EnvioSolicitudController {

	@Resource
	PlazaService plazaserv;
	@Resource
	ConvocatoriaService convService;
	@Resource
	RequisitoConvPlazaService reqService;
	
	@Resource
	LoginController loginController;
	
	/*********** ATRIBUTOS ***********/
	 private List<PlazaDTO> listPlazasVacantes;
	 private ConvocatoriaDTO convDTO;
	 private TipoRequisitoConvPlazaDTO tipoRequisito;
	 private PlazaDTO plaza;
	 private PlazaDTO plazaSelected;
	 private TreeNode selectedNode;		
	 private DependenciaDTO depSeleccionada;
	 
	 private ConvocatoriaPlazaDTO convPlaza;
	 private List<ConvocatoriaPlazaDTO> listaConvPlaza;
	 private RequisitoConvPlazaDTO requiConvPlaza;
	 private RequisitoConvPlazaDTO requiConvPlazaElim;
	 private List<TipoRequisitoConvPlazaDTO> listTipoRequiSI;
	 private ServicioConvPlazaDTO servConvPlaza;
	 private ServicioConvPlazaDTO servConvPlazaElim;
	 private List<PlazaDTO> listaPlazas;
	 private List<PlazaDTO> listaPlazasSelected;
	 private PlazaDTO[] listaPlazasdtosSelected;
	 private String fechaActual;
	 private boolean skip;
	 private static Logger logger = Logger.getLogger(EnvioSolicitudController.class.getName());
	 private int tabVieWindex;
	 private int tabViewtabLista;
	 private String strAction;
	 private String strButtonAction;
	 private Boolean mostrarDlDep;
		//-----------------
	private String rutaRaiz;
		
		
	 /*********** NAVEGACION ***********/
	
	 public String iraEnvSolConvocatoria(){
			inicializarValores();
			return getStrAction();
		}

	 public void mostrarDependencia(){
		 inicializarValores();
		 setMostrarDlDep(new Boolean(true));
	 }
	 
	private void inicializarValores() {
		//listacont.cargarArbol();
		setListPlazasVacantes(plazaserv.listarPlazasVacantes());
		setConvDTO(new ConvocatoriaDTO());
		setPlaza(new PlazaDTO());
	    setPlazaSelected(new PlazaDTO());  
		setConvPlaza(new ConvocatoriaPlazaDTO());
		getConvPlaza().setListReqConvPlaza(new ArrayList<RequisitoConvPlazaDTO>());
		getConvPlaza().setListServConvPlaza(new ArrayList<ServicioConvPlazaDTO>());
		setRequiConvPlaza(new RequisitoConvPlazaDTO());
		setServConvPlaza(new ServicioConvPlazaDTO());
		setListaConvPlaza(new ArrayList<ConvocatoriaPlazaDTO>());
		getConvDTO().setListConvPlaza(new ArrayList<ConvocatoriaPlazaDTO>());
		setListTipoRequiSI(reqService.obtenerTipoRequisitos());
		setDepSeleccionada(loginController.getUsuDep());
		setTabVieWindex(0);
		setTabViewtabLista(0);
	    setStrButtonAction("Guardar");
		setStrAction("EnvioSolicitudConvocatoria");
	}	
	public void agregarServiciosConvPlaza(ActionEvent ev){
		System.out.println("Agregando Servicios:");	
		servConvPlaza.setIdConvocatoria(0);
		servConvPlaza.setIdPlaza(plaza.getIdPlaza());
		servConvPlaza.setIdServicio(convPlaza.getListServConvPlaza().size()+1);
		servConvPlaza.setDescServicio(servConvPlaza.getDescServicio());
		convPlaza.getListServConvPlaza().add(servConvPlaza);
		setServConvPlaza(new ServicioConvPlazaDTO());
	}
	public void agregarRequisitosConvPlaza(ActionEvent ev){
		System.out.println("Agregando Requisitos:");	
		requiConvPlaza.setIdConvocatoria(0);
		requiConvPlaza.setIdPlaza(plaza.getIdPlaza());
		requiConvPlaza.setIdRequisito(convPlaza.getListReqConvPlaza().size()+1);
		requiConvPlaza.setDescRequisito(requiConvPlaza.getDescRequisito());
		requiConvPlaza.setIdTipoRequisito(requiConvPlaza.getIdTipoRequisito());
		convPlaza.getListReqConvPlaza().add(requiConvPlaza);
		System.out.println("Listado Requistos"+convPlaza.getListReqConvPlaza().size());
		setRequiConvPlaza(new RequisitoConvPlazaDTO());
	}
	public void seleccionarPlaza(SelectEvent ev){
	   try {
		    plaza.setDescCargo(plazaSelected.getDescCargo());
			//plaza.setDescDep(plazaSelected.getDescDep());
			//plaza.setIdCargo(plazaSelected.getIdCargo());
			plaza.setIdDep(plazaSelected.getIdDep());
			plaza.setIdPlaza(plazaSelected.getIdPlaza());
			//plaza.setMonto(plazaSelected.getMonto());
			for (int i = 0; i < convDTO.getListConvPlaza().size(); i++) {
				if(convDTO.getListConvPlaza().get(i).getIdPlaza().equals(plaza.getIdPlaza())){
					convPlaza=convDTO.getListConvPlaza().get(i);
					i=convDTO.getListConvPlaza().size();
					setStrButtonAction("Modificar");
				}else{
					setStrButtonAction("Guardar");
					setConvPlaza(new ConvocatoriaPlazaDTO());
					getConvPlaza().setListReqConvPlaza(new ArrayList<RequisitoConvPlazaDTO>());
					getConvPlaza().setListServConvPlaza(new ArrayList<ServicioConvPlazaDTO>());
				}
			}			
			setTabVieWindex(1);
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		
	}
	public void limpiarDatos(ActionEvent ev){
		 /*********** LIMPIANDO DATOS ***********/
		setConvPlaza(new ConvocatoriaPlazaDTO());
		getConvPlaza().setListReqConvPlaza(new ArrayList<RequisitoConvPlazaDTO>());
		getConvPlaza().setListServConvPlaza(new ArrayList<ServicioConvPlazaDTO>());
		setRequiConvPlaza(new RequisitoConvPlazaDTO());
		setServConvPlaza(new ServicioConvPlazaDTO());
	}
	public void guardarPlazaConv(ActionEvent ev){
		System.out.println("Guardando Plazas");
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("FechaIni:" +formatter.format(getConvPlaza().getFechaIni()));
		System.out.println("FechaFin:" +formatter.format(getConvPlaza().getFechaFin()));
	
		if (strButtonAction=="Modificar") {
			for(int i=0; i<convDTO.getListConvPlaza().size();i++){
				if(convDTO.getListConvPlaza().get(i).getIdPlaza()==plaza.getIdPlaza()){
					convDTO.getListConvPlaza().remove(i);
					System.out.println("Modificando valores");
					convPlaza.setDescCargo(plaza.getDescCargo());
					//convDTO.setDescDep(plaza.getDescDep());		
					convPlaza.setIdPlaza(plaza.getIdPlaza());
					//convPlaza.setMonto(plaza.getMonto());
					System.out.println("Monto de la Plaza:" +convPlaza.getMonto());
					convPlaza.setFechaIni(convPlaza.getFechaIni());
					convPlaza.setFechaFin(convPlaza.getFechaFin());					
					convPlaza.setListReqConvPlaza(convPlaza.getListReqConvPlaza());
					convPlaza.setListServConvPlaza(convPlaza.getListServConvPlaza());
					convDTO.getListConvPlaza().add(convPlaza);
				}
			}
			
		}else{
			System.out.println("ID Plaza Selecta:" +plaza.getIdPlaza());
			convPlaza.setDescCargo(plaza.getDescCargo());
			//convDTO.setDescDep(plaza.getDescDep());		
			convPlaza.setIdPlaza(plaza.getIdPlaza());
			//convPlaza.setMonto(plaza.getMonto());
			System.out.println("Monto de la Plaza:" +convPlaza.getMonto());
			convPlaza.setFechaIni(convPlaza.getFechaIni());
			convPlaza.setFechaFin(convPlaza.getFechaFin());	
			convPlaza.setPeriodo(formatter.format(getConvPlaza().getFechaIni())+ " - "+formatter.format(getConvPlaza().getFechaFin()));
			convPlaza.setListReqConvPlaza(convPlaza.getListReqConvPlaza());
			convPlaza.setListServConvPlaza(convPlaza.getListServConvPlaza());
			
			convDTO.getListConvPlaza().add(convPlaza);
		}		
		setConvPlaza(new ConvocatoriaPlazaDTO());
		getConvPlaza().setListReqConvPlaza(new ArrayList<RequisitoConvPlazaDTO>());
		getConvPlaza().setListServConvPlaza(new ArrayList<ServicioConvPlazaDTO>());
		setPlazaSelected(new PlazaDTO());		
		setTabVieWindex(0);
		
	}
	public void guardarConvocatoria(ActionEvent ev){
		System.out.println("Guardando Convocatoria");
		convDTO.setIdEstadoConv(1);		
		convDTO.setObjetivoConv(convDTO.getObjetivoConv());
		convService.insertarSolicitudConvocatoria(convDTO);
	    plaza.setEstadoPlaza(1);
		plazaserv.actualizarPlaza(plaza);		
	}
	public void enviarSolicitudConv(){
		convDTO.setIdEstadoConv(2);
		convService.enviarSolicitud(convDTO);
		setConvDTO(new ConvocatoriaDTO());
		convDTO.setListConvPlaza(new ArrayList<ConvocatoriaPlazaDTO>());
		setListPlazasVacantes(plazaserv.listarPlazasVacantes());
		setTabViewtabLista(0);
			
	}
	public void cancelarDatosPlaza(ActionEvent ev){		
		setConvPlaza(new ConvocatoriaPlazaDTO());
	}
	public void crearSolicitud(ActionEvent ev){
		System.out.println("metodo crear solicitud");
		setListaPlazasdtosSelected(listaPlazasdtosSelected);
		if(depSeleccionada.getUdId()!=null){
			convDTO.setIdDep(depSeleccionada.getUdId());
			convDTO.setDescDep(depSeleccionada.getUdDesc());
			setTabViewtabLista(1);		
		}
		
		
	}
	public void confirmacionPlazasGuardadas(ActionEvent ev){
		
		setConvPlaza(new ConvocatoriaPlazaDTO());
		getConvPlaza().setListReqConvPlaza(new ArrayList<RequisitoConvPlazaDTO>());
		getConvPlaza().setListServConvPlaza(new ArrayList<ServicioConvPlazaDTO>());
		setRequiConvPlaza(new RequisitoConvPlazaDTO());
		setServConvPlaza(new ServicioConvPlazaDTO());
		setTabVieWindex(0);
	}	
	public void confirmacionEnvioSolicitud(ActionEvent ev){
		
		setConvDTO(new ConvocatoriaDTO());
		getConvDTO().setListConvPlaza(new ArrayList<ConvocatoriaPlazaDTO>());
		setTabViewtabLista(0);
	}
	
	public void eliminarServicios(){
	
		System.out.println("Eliminando: " + servConvPlazaElim.getIdServicio());
		System.out.println("Eliminando: " + servConvPlazaElim.getDescServicio());
				
		for (int i = 0; i <convPlaza.getListServConvPlaza().size() ; i++) {
			if (servConvPlazaElim.getIdServicio() == convPlaza.getListServConvPlaza().get(i).getIdServicio()) {
				convPlaza.getListServConvPlaza().remove(i);
			}
		}
		getConvPlaza().setListServConvPlaza(convPlaza.getListServConvPlaza());
		//setConvPlaza(convPlaza);		
	}
	public void eliminarRequisitos(){
		System.out.println("Eliminando: " + requiConvPlazaElim.getIdRequisito());
		System.out.println("Eliminando: " + requiConvPlazaElim.getIdRequisito());
		
		
		for (int i = 0; i <convPlaza.getListReqConvPlaza().size() ; i++) {
			if (requiConvPlazaElim.getIdRequisito() == convPlaza.getListReqConvPlaza().get(i).getIdRequisito()) {
				convPlaza.getListReqConvPlaza().remove(i);
			}
		}
		getConvPlaza().setListReqConvPlaza(convPlaza.getListReqConvPlaza());
		//setConvPlaza(convPlaza);	
		
	}
	
	public String onFlowProcess(FlowEvent event) {  
	    logger.info("Current wizard step:" + event.getOldStep());  
	    logger.info("Next step:" + event.getNewStep());  
	      
	    if(skip) {  
	        skip = false;   //reset in case user goes back  
	        return "confirm";  
	    }  
	    else {  
	        return event.getNewStep();  
	    } 
	}
    public void onNodeSelect(NodeSelectEvent event) { 
    	System.out.println("entro al onnodeselect");
        setDepSeleccionada((DependenciaDTO)event.getTreeNode().getData());
        System.out.println("dependencia seleccionada :"+getDepSeleccionada().getUdDesc());
    } 
	/*********** GETTERS AND SETTERS ***********/
	
	public List<PlazaDTO> getListPlazasVacantes() {
		return listPlazasVacantes;
	}
	public void setListPlazasVacantes(List<PlazaDTO> listPlazasVacantes) {
		this.listPlazasVacantes = listPlazasVacantes;
	}
	public ConvocatoriaDTO getConvDTO() {
		return convDTO;
	}
	public void setConvDTO(ConvocatoriaDTO convDTO) {
		this.convDTO = convDTO;
	}
	public boolean isSkip() {  
	    return skip;  
	}  
	
	public void setSkip(boolean skip) {  
	    this.skip = skip;  
	}
	public ConvocatoriaPlazaDTO getConvPlaza() {
		return convPlaza;
	}
	public void setConvPlaza(ConvocatoriaPlazaDTO convPlaza) {
		this.convPlaza = convPlaza;
	}
	public RequisitoConvPlazaDTO getRequiConvPlaza() {
		return requiConvPlaza;
	}
	public void setRequiConvPlaza(RequisitoConvPlazaDTO requiConvPlaza) {
		this.requiConvPlaza = requiConvPlaza;
	}
	public ServicioConvPlazaDTO getServConvPlaza() {
		return servConvPlaza;
	}
	public void setServConvPlaza(ServicioConvPlazaDTO servConvPlaza) {
		this.servConvPlaza = servConvPlaza;
	}
	
	public PlazaDTO getPlaza() {
		return plaza;
	}
	public void setPlaza(PlazaDTO plaza) {
		this.plaza = plaza;
	}
	public void setListaPlazas(List<PlazaDTO> listaPlazas) {
		this.listaPlazas = listaPlazas;
	}
	public List<PlazaDTO> getListaPlazas() {
		return listaPlazas;
	}
	public void setListaPlazasdtosSelected(PlazaDTO[] listaPlazasdtosSelected) {
		this.listaPlazasdtosSelected = listaPlazasdtosSelected;
	}
	public PlazaDTO[] getListaPlazasdtosSelected() {
		return listaPlazasdtosSelected;
	}
	public void setPlazaSelected(PlazaDTO plazaSelected) {
		this.plazaSelected = plazaSelected;
	}
	public PlazaDTO getPlazaSelected() {
		return plazaSelected;
	}
	public void setTabVieWindex(int tabVieWindex) {
		this.tabVieWindex = tabVieWindex;
	}
	public int getTabVieWindex() {
		return tabVieWindex;
	}
	
	public String getStrAction() {
		return strAction;
	}
	
	public void setStrAction(String strAction) {
		this.strAction = strAction;
	}

	public void setTabViewtabLista(int tabViewtabLista) {
		this.tabViewtabLista = tabViewtabLista;
	}

	public int getTabViewtabLista() {
		return tabViewtabLista;
	}
	public void setListaConvPlaza(List<ConvocatoriaPlazaDTO> listaConvPlaza) {
		this.listaConvPlaza = listaConvPlaza;
	}

	public List<ConvocatoriaPlazaDTO> getListaConvPlaza() {
		return listaConvPlaza;
	}

	public void setRequiConvPlazaElim(RequisitoConvPlazaDTO requiConvPlazaElim) {
		this.requiConvPlazaElim = requiConvPlazaElim;
	}

	public RequisitoConvPlazaDTO getRequiConvPlazaElim() {
		return requiConvPlazaElim;
	}

	public void setServConvPlazaElim(ServicioConvPlazaDTO servConvPlazaElim) {
		this.servConvPlazaElim = servConvPlazaElim;
	}

	public ServicioConvPlazaDTO getServConvPlazaElim() {
		return servConvPlazaElim;
	}

	public void setStrButtonAction(String strButtonAction) {
		this.strButtonAction = strButtonAction;
	}

	public String getStrButtonAction() {
		return strButtonAction;
	}

	public void setListaPlazasSelected(List<PlazaDTO> listaPlazasSelected) {
		this.listaPlazasSelected = listaPlazasSelected;
	}

	public List<PlazaDTO> getListaPlazasSelected() {
		return listaPlazasSelected;
	}

	

	public List<TipoRequisitoConvPlazaDTO> getListTipoRequiSI() {
		return listTipoRequiSI;
	}

	public void setListTipoRequiSI(List<TipoRequisitoConvPlazaDTO> listTipoRequiSI) {
		this.listTipoRequiSI = listTipoRequiSI;
	}

	public void setTipoRequisito(TipoRequisitoConvPlazaDTO tipoRequisito) {
		this.tipoRequisito = tipoRequisito;
	}

	public TipoRequisitoConvPlazaDTO getTipoRequisito() {
		return tipoRequisito;
	}

	public String getRutaRaiz() {
		return rutaRaiz;
	}

	public void setRutaRaiz(String rutaRaiz) {
		this.rutaRaiz = rutaRaiz;
	}

	public String getFechaActual() {
		return Util.fechaActual();
	}

	public void setFechaActual(String fechaActual) {
		this.fechaActual = fechaActual;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public Boolean getMostrarDlDep() {
		return mostrarDlDep;
	}

	public void setMostrarDlDep(Boolean mostrarDlDep) {
		this.mostrarDlDep = mostrarDlDep;
	}

	public DependenciaDTO getDepSeleccionada() {
		return depSeleccionada;
	}

	public void setDepSeleccionada(DependenciaDTO depSeleccionada) {
		this.depSeleccionada = depSeleccionada;
	}

}
