package pe.edu.unmsm.quipucamayoc.sgfqRRHH.presentacion.controller.proceso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.TreeNode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CapUnidad;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.DependenciaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PlazaServidorDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PlazaServidorEstadoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServidorAntiguoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServidorDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.VWCargoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.PlazaService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.PlazaServidorService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.presentacion.controller.login.LoginController;

@Controller
@Scope("session")
public class MantePlazasController implements Serializable {

	/*********DECLARACION DE ATRIBUTOS**********/
	private static final long serialVersionUID = 1L;
	private List<ServidorAntiguoDTO> listServidoresAntiguos;
	private DependenciaDTO depSeleccionada;
	private ServidorAntiguoDTO servidorAntSelected;
	private ServidorAntiguoDTO servidorAntEditable;
	private List<PlazaDTO> plazasVacantesxDep;
	private PlazaServidorDTO plazaServidorEditable;
	private TreeNode selectedNode;
	private Integer udId;
	private String udCod;
	private int nivel;
	private List<VWCargoDTO> listCargos;
	private ServidorDTO cargoServidor;
	private VWCargoDTO cargoSelected;
	private boolean renderFechas;
	private boolean renderServsAntiguos;
	private boolean renderMostrarServ;
	private boolean filtrarVac;
	private Integer filtrarPlazas;
	private Integer tipSearch;
	private Integer anio;
	private List<Integer> listaAnio;
	private List<CapUnidad> consolidadoCAP;
	private String udcodUsuario;
	private boolean listaPlazaVacia;
	private String botonServidores;
	private PlazaServidorEstadoDTO plazaServEstado;
	private List<PlazaServidorEstadoDTO> listPlazaServEstado;
	
	private String filtroClasificacion;
	private String filtroGrupOcupacional;
	private List<String> listClasificaciones;
	private List<String> listGrupoOcupacionales;
	private String tipo_resolucion;
	private String num_resolucion;
	private String anio_resolucion;
	private List<Integer> anios;
	
	/*********SERVICIOS **********/
	@Resource
	PlazaServidorService plazaServidorService;
	@Resource
	PlazaService plazaService;
	
	@Resource
	LoginController loginController;
	
	
	
	
	/************INICIALIZACION DE LA PAGINA*************/
	@SuppressWarnings("deprecation")
	@PostConstruct
	public void inicializar(){
		listClasificaciones = plazaService.obtenerClasificaciones();
		listGrupoOcupacionales = plazaService.obtenerGruposOcupacionales();
		filtroClasificacion="";
		filtroGrupOcupacional="";
		anio = 2012;
		listaAnio = new ArrayList<Integer>();
		setPlazaServidorEditable(new PlazaServidorDTO());
		udId=loginController.getUsuDep().getUdId();
		udCod=loginController.getUsuDep().getUdCod();
		udcodUsuario = udCod; 
		nivel = loginController.getUsuDep().getUdNivel();
		listCargos=plazaService.listarPlazasServidoresxDep(anio,getUdCod(),filtroClasificacion,filtroGrupOcupacional);
		listaPlazaVacia = true;
		consolidadoCAP = plazaService.obtenerConsolidadoCap(udCod, anio, udcodUsuario);
		servidorAntSelected = new ServidorAntiguoDTO();
		filtrarPlazas=1;
		setFiltrarVac(false);
		setTipSearch(0);
		llenarAnios();
		botonServidores="Mostrar todos los servidores";
		anios = new ArrayList<Integer>();
		num_resolucion = "";
		Date diaactual = new Date();
		for (int i = 1950; i <= diaactual.getYear()+1900; i++) {
			anios.add(new Integer(i));
		} 
		plazaServEstado = new PlazaServidorEstadoDTO();
		listPlazaServEstado = plazaServidorService.obtenerEstadosdePlazaServidor(4);		
	}
	
	/*********NAVEGACION*************/
	
	public void editarCargo(SelectEvent ev){
		
		setRenderServsAntiguos(plazaServidorService.comprobExisteServAsig(cargoSelected));
		System.out.println("Id Cargo Estructural: "+cargoSelected.getIdCargoEstr());
		System.out.println("Id Cargo Estructural: "+cargoSelected.getTipTrabCargoClasif());
		if (isRenderServsAntiguos()==true) {
			setRenderMostrarServ(false);
		} else {
			setRenderMostrarServ(true);
		}
		if(nivel >=2){
			System.out.println("entro");
			listServidoresAntiguos=plazaService.listarServidoresAntiguosActivos(anio,udId,udCod,cargoSelected.getIdCargoEstr(),cargoSelected.getTipTrabCargoClasif());
			System.out.println("despues del llenado");
			for (ServidorAntiguoDTO servAnt : listServidoresAntiguos) {
				String full_ser_sel = servAnt.getSerApePat()
						+ servAnt.getSerApeMat()
						+ servAnt.getSerNom();
				for (VWCargoDTO cargoT : listCargos) {
					String full_ser_car = cargoT.getSerApePat() + cargoT.getSerApeMat()
							+ cargoT.getSerNom();
					if (full_ser_car.equals(full_ser_sel)) {
						servAnt.setSerColor("old");
						break;
					}
				}
			}
			System.out.println("despues del for");
			listaPlazaVacia = listavacia(listServidoresAntiguos);
		}else{
			listServidoresAntiguos = null;
		}
		
		System.out.println("despues del for");
	}
	
	public void onNodeSelect(NodeSelectEvent event) { 
        setDepSeleccionada((DependenciaDTO)event.getTreeNode().getData());
        setUdId(getDepSeleccionada().getUdId());
        setUdCod(getDepSeleccionada().getUdCod());
        setNivel(getDepSeleccionada().getUdNivel());
        if(filtrarPlazas==1){
        	listCargos=plazaService.listarPlazasServidoresxDep(anio,getUdCod(),filtroClasificacion,filtroGrupOcupacional);
        }else{
        	if(filtrarPlazas==2 || filtrarPlazas==3){
        		listCargos=plazaService.listarPlazasVacantesxDep(getUdCod(),anio,filtrarPlazas,filtroClasificacion,filtroGrupOcupacional);
        	}else{
        		listCargos=null;
        	}
        }
        consolidadoCAP = plazaService.obtenerConsolidadoCap(udCod, anio, udcodUsuario);
        System.out.println("nivel"+nivel);
    } 

	public void guardarPlaza(ActionEvent ev) {
		FacesMessage message;
		plazaServidorEditable.setIdPlaza(cargoSelected.getNumPlaza());
		if(servidorAntSelected!=null){
			plazaServidorEditable.setSerCod(servidorAntSelected.getSerCod());
			plazaServidorEditable.setNumSerest(servidorAntSelected.getNumSerest());
			plazaServidorEditable.setEstPlaza(cargoSelected.getEstado_plaza());
			if (plazaServidorEditable.getFechaIni() != null) {
				String mensajeFechas;
				if(plazaServidorEditable.getFechaFin()!=null){
					mensajeFechas= validarFechas(plazaServidorEditable.getFechaIni(), plazaServidorEditable.getFechaFin());
				}else{
					mensajeFechas = "";
				}
				if(mensajeFechas.compareToIgnoreCase("")==0){
					if(plazaServidorEditable.getN_resol_ing().compareToIgnoreCase("")!=0){
						if(num_resolucion.compareToIgnoreCase("")!=0){
							if(plazaServEstado.getC_pla_serv_est()!=0){
								plazaServidorEditable.setN_id_pla_serv_est(plazaServEstado.getC_pla_serv_est());
								plazaServidorService.guardarPlazaServidor(plazaServidorEditable);
								String full_name = servidorAntSelected.getSerApePat() + " "
										+ servidorAntSelected.getSerApeMat() + ", "	+ servidorAntSelected.getSerNom();
								String menssage = "ha sido asignado a "	+ cargoSelected.getDescCargoClasif();
								message = new FacesMessage(FacesMessage.SEVERITY_INFO,	full_name, menssage);
								listCargos = plazaService.listarPlazasServidoresxDep(anio,getUdCod(),filtroClasificacion,filtroGrupOcupacional);	
								consolidadoCAP = plazaService.obtenerConsolidadoCap(udCod, anio, udcodUsuario);
							}else{
								message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrecto", "Debe ingresar el tipo de ingreso del servidor asignado");
							}
						}else{
							message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrecto", "Debe ingresar el numero de la resolución del servidor asignado");
						}
					}else{
						/*FacesContext context = FacesContext.getCurrentInstance();
						context.addMessage(null, new FacesMessage("Second Message","Debe ingresar el numero de la resolución del servidor asignado"));*/
						message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrecto", "Debe ingresar el numero de la resolución del servidor asignado");
					}
				}else{
					message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrecto", mensajeFechas);
				}
			} else {
				/*FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Second Message","Debe ingresar las fechas de inicio y de fin."));*/
				message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrecto", "Debe ingresar las fechas de inicio y de fin");
			}
		}else{
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrecto", "Debe seleccionar un servidor");
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
		setPlazaServidorEditable(new PlazaServidorDTO());
	}
	
    public void desasignarPlaza(ActionEvent ev){
    	plazaServidorService.eliminarPlazaServidorxPlaza(cargoSelected.getNumPlaza(),cargoSelected.getEstado_plaza());
    	listCargos=plazaService.listarPlazasServidoresxDep(anio,getUdCod(),filtroClasificacion,filtroGrupOcupacional);
    	consolidadoCAP = plazaService.obtenerConsolidadoCap(udCod, anio, udcodUsuario);
    	setPlazaServidorEditable(new PlazaServidorDTO());
    }
	public void caducarServPlaza(ActionEvent ev){
		plazaServidorService.editarFechaCaduciSer(cargoSelected.getNumPlaza(),plazaServidorEditable);
	}
	
	public void actualizarListCargos(AjaxBehaviorEvent ev){
		if (isFiltrarVac())
			listCargos=plazaService.listarPlazasVacantesxDep(getUdCod(),anio,2,filtroClasificacion,filtroGrupOcupacional);	
		else
			listCargos=plazaService.listarPlazasServidoresxDep(anio,getUdCod(),filtroClasificacion,filtroGrupOcupacional);	
		
	}
	
	public void actualizarListCargos2(ActionEvent e){
		if(filtrarPlazas==1){
			listCargos=plazaService.listarPlazasServidoresxDep(anio,getUdCod(),filtroClasificacion,filtroGrupOcupacional);
		}else{
			if(filtrarPlazas==2 || filtrarPlazas==3){
				listCargos=plazaService.listarPlazasVacantesxDep(getUdCod(),anio,filtrarPlazas,filtroClasificacion,filtroGrupOcupacional);
			}else{
				listCargos = null;
				
			}
		}
	}
	
	public void obtenerAnio(ActionEvent e){
		System.out.println("Anio Seleccionado: "+anio);
		if(filtrarPlazas==1){
			listCargos=plazaService.listarPlazasServidoresxDep(anio,getUdCod(),filtroClasificacion,filtroGrupOcupacional);
		}else{
			if(filtrarPlazas==2 || filtrarPlazas==3){
				listCargos=plazaService.listarPlazasVacantesxDep(getUdCod(),anio,filtrarPlazas,filtroClasificacion,filtroGrupOcupacional);
			}else{
				listCargos = null;
				
			}
		}
		consolidadoCAP = plazaService.obtenerConsolidadoCap(udCod, anio, udcodUsuario);
	}
	
	public void observacion(SelectEvent actionEvent) {
		String menssage = "";
		String full_ser_sel = servidorAntSelected.getSerApePat()
				+ servidorAntSelected.getSerApeMat()
				+ servidorAntSelected.getSerNom();

		for (VWCargoDTO cargoT : listCargos) {
			String full_ser_car = cargoT.getSerApePat() + cargoT.getSerApeMat()
					+ cargoT.getSerNom();
			if (full_ser_car.equals(full_ser_sel)) {
				if (menssage == "")
					menssage = menssage + " " + cargoT.getDescCargoClasif();
				else
					menssage = menssage + ", " + cargoT.getDescCargoClasif();
			}
		}
		if (menssage != "") {
			full_ser_sel = servidorAntSelected.getSerApePat() + " "
					+ servidorAntSelected.getSerApeMat() + ", "
					+ servidorAntSelected.getSerNom();
			FacesMessage message = null;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN,
					full_ser_sel, menssage);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		plazaServidorEditable.setFechaIni(servidorAntSelected.getSerFech_in_unmsm());
	}
	
	public void todosServidores(ActionEvent e){
		listServidoresAntiguos=new ArrayList<ServidorAntiguoDTO>();
		if(botonServidores.compareToIgnoreCase("Mostrar todos los servidores")==0){
			botonServidores="Mostrar los servidores filtrados";
			listServidoresAntiguos=plazaService.listarServidoresAntiguosActivos(anio,udId,udCod,0,"");
		}else{
			listServidoresAntiguos=plazaService.listarServidoresAntiguosActivos(anio,udId,udCod,cargoSelected.getIdCargoEstr(),cargoSelected.getTipTrabCargoClasif());
			botonServidores="Mostrar todos los servidores";
		}
		//ponerle el color
		for (ServidorAntiguoDTO servAnt : listServidoresAntiguos) {
			String full_ser_sel = servAnt.getSerApePat()
					+ servAnt.getSerApeMat()
					+ servAnt.getSerNom();
			for (VWCargoDTO cargoT : listCargos) {
				String full_ser_car = cargoT.getSerApePat() + cargoT.getSerApeMat()
						+ cargoT.getSerNom();
				if (full_ser_car.equals(full_ser_sel)) {
					servAnt.setSerColor("old");
					break;
				}
			}
		}
		listaPlazaVacia = listavacia(listServidoresAntiguos);
	}
	
	public void filtrarClasificacionMethod(ActionEvent ev) {
		System.out.println(" " + filtroClasificacion + " "
				+ filtroGrupOcupacional);
		if (filtrarPlazas == 1) {
			listCargos = plazaService.listarPlazasServidoresxDep(anio,
					getUdCod(), filtroClasificacion, filtroGrupOcupacional);
		} else {
			if (filtrarPlazas == 2 || filtrarPlazas == 3) {
				listCargos = plazaService.listarPlazasVacantesxDep(getUdCod(),
						anio, filtrarPlazas, filtroClasificacion,
						filtroGrupOcupacional);
			} else {
				System.out.println("se lo pasa");
				listCargos = null;

			}
		}
	}
	
	public void filtrarGrupoOcupacionalMethod(ActionEvent ev) {
		System.out.println(" " + filtroClasificacion + " "
				+ filtroGrupOcupacional);
		if (filtrarPlazas == 1) {
			listCargos = plazaService.listarPlazasServidoresxDep(anio,
					getUdCod(), filtroClasificacion, filtroGrupOcupacional);
		} else {
			if (filtrarPlazas == 2 || filtrarPlazas == 3) {
				listCargos = plazaService.listarPlazasVacantesxDep(getUdCod(),
						anio, filtrarPlazas, filtroClasificacion,
						filtroGrupOcupacional);
			} else {
				System.out.println("se lo pasa");
				listCargos = null;

			}
		}
	}
	
	
	/********************OTROS METODOS*********************/
	
	@SuppressWarnings("deprecation")
	public String validarFechas(Date d1,Date d2){
		String mensajeFecha="";
		System.out.println("D1 y D2: "+d1.getDate()+" : "+d2.getDate());
		//validacion de la fecha final
		if(d1.getYear()>d2.getYear()){
			mensajeFecha="Año Final menor al Año Inicial";
		}else{
			if(d1.getYear()==d2.getYear()){
				if(d1.getMonth()>d2.getMonth()){
					mensajeFecha="Mes Final menor al Mes Inicial";
				}else{
					if(d1.getMonth()==d2.getMonth()){
						if(d1.getDate()>d2.getDate()){
							mensajeFecha="Dia Final menor al Dia Inicial";
						}else{
							//correcto
							mensajeFecha="";
						}
					}else{
						//correcto
						mensajeFecha="";
					}
				}
			}else{
				//correcto
				mensajeFecha="";
			}
		}
		System.out.println("mesnaje fechas: "+mensajeFecha);
		return mensajeFecha;
	}
	
	@SuppressWarnings("deprecation")
	public void llenarAnios(){
		Date fecha=new Date();
		int anioActual=fecha.getYear()+1900;
		System.out.println("anio: "+anioActual);
		for(int i=0; i<=anioActual-2010;i++){
			listaAnio.add(2010+i);
		}
	}
	@SuppressWarnings("rawtypes")
	public boolean listavacia(List plazas){
		if(plazas.size()==0){
			return true;
		}else{
			return false;
		}
	}	
	
	/********************GETTERS Y SETTERS*********************/
	public List<ServidorAntiguoDTO> getListServidoresAntiguos() {return listServidoresAntiguos;}
	public void setListServidoresAntiguos(List<ServidorAntiguoDTO> listServidoresAntiguos) {this.listServidoresAntiguos = listServidoresAntiguos;}
	public DependenciaDTO getDepSeleccionada() {return depSeleccionada;}
	public void setDepSeleccionada(DependenciaDTO depSeleccionada) {this.depSeleccionada = depSeleccionada;}
	public TreeNode getSelectedNode() {return selectedNode;}
	public void setSelectedNode(TreeNode selectedNode) {this.selectedNode = selectedNode;}
	public ServidorAntiguoDTO getServidorAntSelected() {return servidorAntSelected;}
	public void setServidorAntSelected(ServidorAntiguoDTO servidorAntSelected) {this.servidorAntSelected = servidorAntSelected;}
	public ServidorAntiguoDTO getServidorAntEditable() {return servidorAntEditable;}
	public void setServidorAntEditable(ServidorAntiguoDTO servidorAntEditable) {this.servidorAntEditable = servidorAntEditable;}
	public List<PlazaDTO> getPlazasVacantesxDep() {return plazasVacantesxDep;}
	public void setPlazasVacantesxDep(List<PlazaDTO> plazasVacantesxDep) {this.plazasVacantesxDep = plazasVacantesxDep;}
	public PlazaServidorDTO getPlazaServidorEditable() {return plazaServidorEditable;}
	public void setPlazaServidorEditable(PlazaServidorDTO plazaServidorEditable) {this.plazaServidorEditable = plazaServidorEditable;}
	public List<VWCargoDTO> getListCargos() {return listCargos;}
	public void setListCargos(List<VWCargoDTO> listCargos) {this.listCargos = listCargos;}
	public VWCargoDTO getCargoSelected() {return cargoSelected;}
	public void setCargoSelected(VWCargoDTO cargoSelected) {this.cargoSelected = cargoSelected;}
	public Integer getUdId() {return udId;}
	public void setUdId(Integer udId) {this.udId = udId;}
	public boolean isRenderFechas() {return renderFechas;}
	public void setRenderFechas(boolean renderFechas) {this.renderFechas = renderFechas;}
	public boolean isRenderServsAntiguos() {return renderServsAntiguos;}
	public void setRenderServsAntiguos(boolean renderServsAntiguos) {this.renderServsAntiguos = renderServsAntiguos;}
	public boolean isRenderMostrarServ() {return renderMostrarServ;}
	public void setRenderMostrarServ(boolean renderMostrarServ) {this.renderMostrarServ = renderMostrarServ;}
	public boolean isFiltrarVac() {	return filtrarVac;}
	public void setFiltrarVac(boolean filtrarVac) {	this.filtrarVac = filtrarVac;}
	public ServidorDTO getCargoServidor() {	return cargoServidor;}
	public void setCargoServidor(ServidorDTO cargoServidor) {this.cargoServidor = cargoServidor;}
	public Integer getTipSearch() {	return tipSearch;}
	public void setTipSearch(Integer tipSearch) {this.tipSearch = tipSearch;}
	public Integer getAnio() {return anio;}
	public void setAnio(Integer anio) {this.anio = anio;}
	public String getUdCod() {return udCod;}
	public void setUdCod(String udCod) {this.udCod = udCod;}
	public int getNivel() {return nivel;}
	public void setNivel(int nivel) {this.nivel = nivel;}
	public List<Integer> getListaAnio() {return listaAnio;}
	public void setListaAnio(List<Integer> listaAnio) {this.listaAnio = listaAnio;}
	public List<CapUnidad> getConsolidadoCAP() {return consolidadoCAP;}
	public void setConsolidadoCAP(List<CapUnidad> consolidadoCAP) {	this.consolidadoCAP = consolidadoCAP;}
	public Integer getFiltrarPlazas() {return filtrarPlazas;}
	public void setFiltrarPlazas(Integer filtrarPlazas) {this.filtrarPlazas = filtrarPlazas;}
	public boolean isListaPlazaVacia() {return listaPlazaVacia;}
	public void setListaPlazaVacia(boolean listaPlazaVacia) {this.listaPlazaVacia = listaPlazaVacia;}	
	public String getBotonServidores() {return botonServidores;}
	public void setBotonServidores(String botonServidores) {this.botonServidores = botonServidores;}
	public PlazaServidorEstadoDTO getPlazaServEstado() {return plazaServEstado;}
	public void setPlazaServEstado(PlazaServidorEstadoDTO plazaServEstado) {this.plazaServEstado = plazaServEstado;}	
	public List<PlazaServidorEstadoDTO> getListPlazaServEstado() {return listPlazaServEstado;}
	public void setListPlazaServEstado(List<PlazaServidorEstadoDTO> listPlazaServEstado) {this.listPlazaServEstado = listPlazaServEstado;}
	public String getFiltroClasificacion() {return filtroClasificacion;}
	public void setFiltroClasificacion(String filtroClasificacion) {this.filtroClasificacion = filtroClasificacion;}
	public String getFiltroGrupOcupacional() {return filtroGrupOcupacional;}
	public void setFiltroGrupOcupacional(String filtroGrupOcupacional) {this.filtroGrupOcupacional = filtroGrupOcupacional;}
	public List<String> getListClasificaciones() {return listClasificaciones;}
	public void setListClasificaciones(List<String> listClasificaciones) {this.listClasificaciones = listClasificaciones;}
	public List<String> getListGrupoOcupacionales() {return listGrupoOcupacionales;}
	public void setListGrupoOcupacionales(List<String> listGrupoOcupacionales) {this.listGrupoOcupacionales = listGrupoOcupacionales;}
	public List<Integer> getAnios() {return anios;}
	public void setAnios(List<Integer> anios) {this.anios = anios;}
	public String getTipo_resolucion() {return tipo_resolucion;}
	public void setTipo_resolucion(String tipo_resolucion) {this.tipo_resolucion = tipo_resolucion;}
	public String getNum_resolucion() {return num_resolucion;}
	public void setNum_resolucion(String num_resolucion) {this.num_resolucion = num_resolucion;}
	public String getAnio_resolucion() {return anio_resolucion;}
	public void setAnio_resolucion(String anio_resolucion) {
		this.anio_resolucion = anio_resolucion;		
		plazaServidorEditable.setN_resol_ing(this.tipo_resolucion+"-"+this.num_resolucion+"-"+this.anio_resolucion); 
	}
}
