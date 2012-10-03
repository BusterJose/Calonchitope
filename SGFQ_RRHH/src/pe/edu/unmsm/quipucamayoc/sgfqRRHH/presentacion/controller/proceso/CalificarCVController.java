package pe.edu.unmsm.quipucamayoc.sgfqRRHH.presentacion.controller.proceso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.CVExpLabDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.CVGradAcadDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.ServidorDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CVExpLabDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CVGradosAcadDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CurriculumVitaeDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PuntajeJuradoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServidorDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.ConvocatoriaPlazaService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.ConvocatoriaService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.CurriculumVitaeService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.PlazaService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.presentacion.controller.login.LoginController;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.util.Util;

@Controller
@Scope("session")
public class CalificarCVController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7613566330177928723L;
	@Resource
	ConvocatoriaPlazaService convocatoriaPlazaService;
	@Resource
	ConvocatoriaService convocatoriaService;
	@Resource
	PlazaService plazaService;
	@Resource
	CurriculumVitaeService cvService;
	@Resource
	CVGradAcadDAO cvGradAcadDAO;
	@Resource
	CVExpLabDAO cvExpLabDAO;
	@Resource
	LoginController loginController;
	@Resource
	ServidorDAO servidorDAO;
	
	private List<ConvocatoriaDTO> listConvocatorias;
	private List<PlazaDTO> listaPlazasDeConvocatoria;
	private List<CurriculumVitaeDTO> listaCVxPlaza;
	private List<CurriculumVitaeDTO> listaCvs;
	private ConvocatoriaDTO convocatoriaSeleccionada, juradosxConvocatoria;
	private CurriculumVitaeDTO postulanteSeleccionado;
	private CurriculumVitaeDTO postulante;
	private List<CVGradosAcadDTO> gradosAcademicoPostulante;
	private List<CVExpLabDTO> expLaboralPostulante;
	private List<PuntajeJuradoDTO> listPuntajexPostulante;	
	private PuntajeJuradoDTO puntajeJurado;
	private PlazaDTO plazaSeleccionada;
	private List<ServidorDTO> listaServidores;
	private ServidorDTO[] servidoresSeleccionados;
	private int tabActivo;
	private boolean fechaCV;
	private boolean fechaEntrevista;
	private boolean juradoPriv;
	private boolean btnJurado;
	private int pagina;
	private String strPublicarPuntaje;
	private double promedioCV, promedioEntrevista;
	
	public CalificarCVController() {
		tabActivo = 0;		
		promedioCV=0.0;
		setPromedioEntrevista(0.0);
		convocatoriaSeleccionada = new ConvocatoriaDTO();
		setListConvocatorias(new ArrayList<ConvocatoriaDTO>());
		setListaPlazasDeConvocatoria(new ArrayList<PlazaDTO>());
		setPostulanteSeleccionado(new CurriculumVitaeDTO());
		setListaCvs(new ArrayList<CurriculumVitaeDTO>());		
		setPostulante(new CurriculumVitaeDTO());
		setPuntajeJurado(new PuntajeJuradoDTO());		
		setFechaCV(true);
		setFechaEntrevista(true);
		setListaServidores(new ArrayList<ServidorDTO>());
		setStrPublicarPuntaje("Publicar Resultados CV");
	}	
	public String iraCalificaEntrevista(){
		setTabActivo(0);
		setFechaCV(false);
		setFechaEntrevista(true);
		setJuradoPriv(false);
		setStrPublicarPuntaje("Publicar Resultados Entrevista");
		pagina=1;
		setListConvocatorias(convocatoriaService.listarConvocatoriasEntrevista());
		listaServidores = servidorDAO.selectServidores();
		return "calificacionEntrevista";
	}
	
	public String iraCalificarCV(){
		setTabActivo(0);
		setFechaEntrevista(false);
		setJuradoPriv(true);
		setFechaCV(true);
		setStrPublicarPuntaje("Publicar Resultados CV");
		pagina=0;
		listConvocatorias = convocatoriaService.listarConvocatoriasPublicadasyCerradas();
		listaServidores = servidorDAO.selectServidores();
		return "calificacionCV";
	}

	public void iniciarCalificaciones(ActionEvent ev){
		getConvocatoriaSeleccionada().setIdEstadoConv(8);
		convocatoriaService.actualizarEstadoConvocatoria(getConvocatoriaSeleccionada());
		setBtnJurado(false);
		setJuradoPriv(true);
	}
	public void elegirConvocatoria(SelectEvent evento){
		tabActivo = 1;
		listaPlazasDeConvocatoria = plazaService.obtenerPlazasxConvocatoria(convocatoriaSeleccionada.getIdConvocatoria());
		if (convocatoriaSeleccionada.getIdEstadoConv().equals(7)) {
			setBtnJurado(true);
			setJuradoPriv(false);
		} else if (convocatoriaSeleccionada.getIdEstadoConv().equals(11)) {
			setBtnJurado(false);
			setJuradoPriv(false);			
		}else{
			setBtnJurado(false);
			setJuradoPriv(true);
		}
	}
	
	public void elegirPlaza(SelectEvent evento){
		if (!isBtnJurado()) {
			tabActivo = 2;
			listaCVxPlaza = cvService.obtenerCVxConvocatoriaPlaza(convocatoriaSeleccionada.getIdConvocatoria(), plazaSeleccionada.getIdPlaza(), convocatoriaSeleccionada.getIdEstadoConv());			
		}
	}
	
	public void obtenerExpLaboralxPostulante(){
		expLaboralPostulante = cvExpLabDAO.getExpLabs(Integer.parseInt(postulanteSeleccionado.getCvDni()));
	}
	
	public void obtenerGradosAcadxPostulante(){
		gradosAcademicoPostulante = cvGradAcadDAO.getGradAcads(Integer.parseInt(postulanteSeleccionado.getCvDni()));
	}
	
	public void elegirJurados() {
		FacesContext context = FacesContext.getCurrentInstance();
		String idComponente = "formCalificarCvs:notificacionCalificacion";
		
		if(servidoresSeleccionados.length <= 3){
			ConvocatoriaDTO conv = new ConvocatoriaDTO();
			conv.setIdConvocatoria(convocatoriaSeleccionada.getIdConvocatoria());
			conv.setIdJurado1(servidoresSeleccionados[0].getIdServidor());
			conv.setIdJurado2(servidoresSeleccionados[1].getIdServidor());
			conv.setIdJurado3(servidoresSeleccionados[2].getIdServidor());
			convocatoriaService.actualizarJuradosConvocatoria(conv);
			Util.agregarMensaje(context, idComponente, "Exito", "Se registraron 3 jurados para esta convocatoria", FacesMessage.SEVERITY_INFO);
		}else{
			Util.agregarMensaje(context, idComponente, "Error", "Seleccione solo 3 jurados", FacesMessage.SEVERITY_ERROR);
		}
	}
	public void guardarPuntajesCurriculums(){
		FacesContext context = FacesContext.getCurrentInstance();
		String idComponente = "formCalificarCvs:notificacionCalificacion";
		promedioCV=0.0;
		promedioEntrevista=0.0;
		boolean exito = true;
		
		for(int i=0; i<listPuntajexPostulante.size();i++){			
			
			PuntajeJuradoDTO puntaje = listPuntajexPostulante.get(i);
			puntaje.setIdJurado(puntaje.getIdJurado());
			puntaje.setIdConvocatoria(convocatoriaSeleccionada.getIdConvocatoria());
			puntaje.setIdPlaza(plazaSeleccionada.getIdPlaza());	
			puntaje.setDniCV(postulanteSeleccionado.getCvDni());
			puntajeJurado=cvService.obtenerPuntajexJurado(puntaje);
			if(pagina==0){
				if(puntajeJurado!=null){
				puntaje.setPuntajeCV(puntaje.getPuntajeCV());
				puntaje.setPuntajeEntrevista(0.0);}	
				puntaje.setPuntajeEntrevista(0.0);		
			}
			else{ //Si viene de la pagina CalificarEntrevista
				if(pagina==1){
					if(puntajeJurado!=null){
						puntaje.setPuntajeCV(puntajeJurado.getPuntajeCV());
						puntaje.setPuntajeEntrevista(puntaje.getPuntajeEntrevista());	
					}			
				}	
			}			
			if(puntaje.getPuntajeCV() > 40){
				exito = false;
			}else{
				promedioCV=promedioCV + puntaje.getPuntajeCV();
				promedioEntrevista=promedioEntrevista+puntaje.getPuntajeEntrevista();				
				cvService.ingresarPuntajeJuradoCV(puntaje);
			}
		}
		
	    promedioCV=promedioCV/3;
	    promedioEntrevista=promedioEntrevista/3;
	    
		if(exito) {
									
		    promedioCV=Util.redondearNumero(promedioCV,2);
		    promedioEntrevista=Util.redondearNumero(promedioEntrevista, 2);
			System.out.println("Promedio redondeado CV:"+promedioCV);
		    System.out.println("Promedio redondeado Entrevista:"+promedioEntrevista);
		    guardarPromediosCVyEntrevista();
			Util.agregarMensaje(context, idComponente, "Exito", "Se guardaron las calificaciones de CV de la convocatoria: "+convocatoriaSeleccionada.getObjetivoConv(), FacesMessage.SEVERITY_INFO);
		}else{
			Util.agregarMensaje(context, idComponente, "Error" , "La calificacion CV no puede ser mayor a 40", FacesMessage.SEVERITY_ERROR);
		}

		
		
	}
  
public void guardarPromediosCVyEntrevista(){
	postulante=new CurriculumVitaeDTO();
	postulante.setCvDni(postulanteSeleccionado.getCvDni());
	postulante.setCvIdConvocatoria(postulanteSeleccionado.getCvIdConvocatoria());
	postulante.setCvIdPlaza(postulanteSeleccionado.getCvIdPlaza());
	postulante.setPuntajeCv(promedioCV);
	postulante.setPuntajeEntrevista(promedioEntrevista);
	cvService.guardarPuntajeCV(postulante);	
	
}
public void cambiarEstadoConvaResultados(Integer idEstadoConv){
	FacesContext context = FacesContext.getCurrentInstance();
	String idComponente = "formCalificarCvs:notificacionCalificacion";
	if(convocatoriaSeleccionada == null)
		Util.agregarMensaje(context, idComponente, "Error", "Seleccione una convocatoria", FacesMessage.SEVERITY_ERROR);
	else{
		convocatoriaSeleccionada.setIdEstadoConv(idEstadoConv); 
		convocatoriaService.actualizarEstadoConvocatoria(convocatoriaSeleccionada);
		if(idEstadoConv==11){
			listConvocatorias = convocatoriaService.listarConvocatoriasCerradas();
		}else{
			if(idEstadoConv==12){
			listConvocatorias = convocatoriaService.listarConvocatoriasEntrevista();
			}
		}		
	}
}   
   public void publicarGanadoresxConcxPlaza(){
		Integer idConv=convocatoriaSeleccionada.getIdConvocatoria();
		listaCvs=cvService.obtenerGanadoresxConvxPlaza(idConv);
		for(int i=0;i<listaCvs.size();i++){
			CurriculumVitaeDTO cv=new CurriculumVitaeDTO();
			cv=listaCvs.get(i);
			cv.setObservacion("Alcanzo Vacante");
			cvService.actualizarPuntajeCV(cv);
		}
		setListaCvs(new ArrayList<CurriculumVitaeDTO>());
		listaCvs=cvService.obtenerPerdedoresxConvxPlaza(idConv);
		
		for(int i=0;i<listaCvs.size();i++){
		CurriculumVitaeDTO cvPerdedor=new CurriculumVitaeDTO();
		cvPerdedor=listaCvs.get(i);
		cvPerdedor.setObservacion("No Alcanzo Vacante");
		cvService.actualizarPuntajeCV(cvPerdedor);
		}
		listaCvs=new ArrayList<CurriculumVitaeDTO>();
	}
   public void publicarGanadoresPrimeraFase(){
	   Integer idConv=convocatoriaSeleccionada.getIdConvocatoria();
		listaCvs=cvService.obtenerGanadoresPrimeraFase(idConv);
		
		for(int i=0;i<listaCvs.size();i++){
			CurriculumVitaeDTO cv=new CurriculumVitaeDTO();
			cv=listaCvs.get(i);
			cv.setObservacion("Procede");
			cvService.actualizarPuntajeCV(cv);
		}
		setListaCvs(new ArrayList<CurriculumVitaeDTO>());
		listaCvs=cvService.obtenerPerdedoresPrimeraFase(idConv);
		
		for(int i=0;i<listaCvs.size();i++){
		CurriculumVitaeDTO cvPerdedor=new CurriculumVitaeDTO();
		cvPerdedor=listaCvs.get(i);
		cvPerdedor.setObservacion("No Procede");
		cvService.actualizarPuntajeCV(cvPerdedor);
		}
		listaCvs=new ArrayList<CurriculumVitaeDTO>();
   }
	//Accion que sera visible cuando el Jefe de comite se logee
	public void publicarResultados(){
		FacesContext context = FacesContext.getCurrentInstance();
		String idComponente = "formCalificarCvs:notificacionCalificacion";
		if(strPublicarPuntaje=="Publicar Resultados CV"){
			cambiarEstadoConvaResultados(11);
			publicarGanadoresPrimeraFase();
		}else{
			if(strPublicarPuntaje=="Publicar Resultados Entrevista"){				
				cambiarEstadoConvaResultados(12);
				publicarGanadoresxConcxPlaza();
		}
		}
		Util.agregarMensaje(context, idComponente, "Exito" , "Datos Publicados Exitosamente", FacesMessage.SEVERITY_INFO);
	}	
	public void cargarJuradosxConvocatoria(){
		juradosxConvocatoria = convocatoriaService.obtenerJuradoxConvocatoria(convocatoriaSeleccionada.getIdConvocatoria());
				
		PuntajeJuradoDTO jurado1 = new PuntajeJuradoDTO();
		jurado1.setIdConvocatoria(juradosxConvocatoria.getIdConvocatoria());
		jurado1.setIdPlaza(plazaSeleccionada.getIdPlaza());
		jurado1.setIdJurado(juradosxConvocatoria.getIdJurado1());
		jurado1.setNomJurado(juradosxConvocatoria.getNomJurado1());
		jurado1.setDniCV(postulanteSeleccionado.getCvDni());
		PuntajeJuradoDTO jurado=new PuntajeJuradoDTO();
		jurado=cvService.obtenerPuntajexJurado(jurado1);
		if(jurado==null){
			jurado1.setPuntajeCV(0.0);
			jurado1.setPuntajeEntrevista(0.0);
		}else{
			jurado1.setPuntajeCV(jurado.getPuntajeCV());
			jurado1.setPuntajeEntrevista(jurado.getPuntajeEntrevista());
		}
		jurado=new PuntajeJuradoDTO();		
		PuntajeJuradoDTO jurado2 = new PuntajeJuradoDTO();
		jurado2.setIdConvocatoria(juradosxConvocatoria.getIdConvocatoria());
		jurado2.setIdPlaza(plazaSeleccionada.getIdPlaza());
		jurado2.setIdJurado(juradosxConvocatoria.getIdJurado2());
		jurado2.setNomJurado(juradosxConvocatoria.getNomJurado2());
		jurado2.setDniCV(postulanteSeleccionado.getCvDni());
		jurado=cvService.obtenerPuntajexJurado(jurado2);
		if(jurado==null){
			jurado2.setPuntajeCV(0);
			jurado2.setPuntajeEntrevista(0.0);

		}else{
			jurado2.setPuntajeCV(jurado.getPuntajeCV());
			jurado2.setPuntajeEntrevista(jurado.getPuntajeEntrevista());
		}
		jurado=new PuntajeJuradoDTO();		
		
		PuntajeJuradoDTO jurado3 = new PuntajeJuradoDTO();
		jurado3.setIdConvocatoria(juradosxConvocatoria.getIdConvocatoria());
		jurado3.setIdPlaza(plazaSeleccionada.getIdPlaza());
		jurado3.setIdJurado(juradosxConvocatoria.getIdJurado3());
		jurado3.setNomJurado(juradosxConvocatoria.getNomJurado3());
		jurado3.setDniCV(postulanteSeleccionado.getCvDni());

		jurado=cvService.obtenerPuntajexJurado(jurado3);
		if(jurado==null){
			jurado3.setPuntajeCV(0.0);
			jurado3.setPuntajeEntrevista(0.0);
		}else{
			jurado3.setPuntajeCV(jurado.getPuntajeCV());
			jurado3.setPuntajeEntrevista(jurado.getPuntajeEntrevista());
		}

		promedioCV=(jurado1.getPuntajeCV()+jurado2.getPuntajeCV()+jurado3.getPuntajeCV())/3;
		promedioCV=Util.redondearNumero(promedioCV,2);
		promedioEntrevista=(jurado1.getPuntajeEntrevista()+jurado2.getPuntajeEntrevista()+jurado3.getPuntajeEntrevista())/3;
		promedioEntrevista=Util.redondearNumero(promedioEntrevista, 2);
		
		listPuntajexPostulante = new ArrayList<PuntajeJuradoDTO>();
		listPuntajexPostulante.add(jurado1);
		listPuntajexPostulante.add(jurado2);
		listPuntajexPostulante.add(jurado3);
	}
	
	public List<PlazaDTO> getListaPlazasDeConvocatoria() {return listaPlazasDeConvocatoria;}
	public void setListaPlazasDeConvocatoria(List<PlazaDTO> listaPlazasDeConvocatoria) {
		this.listaPlazasDeConvocatoria = listaPlazasDeConvocatoria;}
	public List<CurriculumVitaeDTO> getListaCVxPlaza() {return listaCVxPlaza;}
	public void setListaCVxPlaza(List<CurriculumVitaeDTO> listaCVxPlaza) {this.listaCVxPlaza = listaCVxPlaza;}
	public ConvocatoriaDTO getConvocatoriaSeleccionada() {	return convocatoriaSeleccionada;	}
	public void setConvocatoriaSeleccionada(ConvocatoriaDTO convocatoriaSeleccionada) {
		this.convocatoriaSeleccionada = convocatoriaSeleccionada;}
	public int getTabActivo() {	return tabActivo;}
	public void setTabActivo(int tabActivo) {this.tabActivo = tabActivo;}
	public PlazaDTO getPlazaSeleccionada() {return plazaSeleccionada;	}
	public void setPlazaSeleccionada(PlazaDTO plazaSeleccionada) {this.plazaSeleccionada = plazaSeleccionada;	}
	public CurriculumVitaeDTO getPostulanteSeleccionado() {	return postulanteSeleccionado;	}
	public void setPostulanteSeleccionado(CurriculumVitaeDTO postulanteSeleccionado) {
		this.postulanteSeleccionado = postulanteSeleccionado;	}
	public List<CVGradosAcadDTO> getGradosAcademicoPostulante() {return gradosAcademicoPostulante;}
	public void setGradosAcademicoPostulante(List<CVGradosAcadDTO> gradosAcademicoPostulante) {
		this.gradosAcademicoPostulante = gradosAcademicoPostulante;	}
	public List<CVExpLabDTO> getExpLaboralPostulante() {return expLaboralPostulante;	}
	public void setExpLaboralPostulante(List<CVExpLabDTO> expLaboralPostulante) {
		this.expLaboralPostulante = expLaboralPostulante;} 
	public void setListConvocatorias(List<ConvocatoriaDTO> listConvocatorias) {
		this.listConvocatorias = listConvocatorias;	}
	public List<ConvocatoriaDTO> getListConvocatorias() {return listConvocatorias;	}
	public void setFechaCV(boolean fechaCV) {this.fechaCV = fechaCV;}
	public boolean isFechaCV() {return fechaCV;	}
	public void setFechaEntrevista(boolean fechaEntrevista) {
		this.fechaEntrevista = fechaEntrevista;	}
	public boolean isFechaEntrevista() {return fechaEntrevista;	}
	public void setListPuntajexPostulante(List<PuntajeJuradoDTO> listPuntajexPostulante) {
		this.listPuntajexPostulante = listPuntajexPostulante;	}
	public List<PuntajeJuradoDTO> getListPuntajexPostulante() {	return listPuntajexPostulante;	}
	public void setStrPublicarPuntaje(String strPublicarPuntaje) {
		this.strPublicarPuntaje = strPublicarPuntaje;	}
	public String getStrPublicarPuntaje() {	return strPublicarPuntaje;}	
	public boolean isJuradoPriv() {	return juradoPriv;	}
	public void setJuradoPriv(boolean juradoPriv) {	this.juradoPriv = juradoPriv;	}
	public void setPostulante(CurriculumVitaeDTO postulante) {
		this.postulante = postulante;	}
	public void setPuntajeJurado(PuntajeJuradoDTO puntajeJurado) {this.puntajeJurado = puntajeJurado;}
	public PuntajeJuradoDTO getPuntajeJurado() {return puntajeJurado;	}
	public void setPagina(int pagina) {	this.pagina = pagina;	}
	public int getPagina() {return pagina;	}
	public List<ServidorDTO> getListaServidores() {	return listaServidores;	}
	public void setListaServidores(List<ServidorDTO> listaServidores) {
		this.listaServidores = listaServidores;	}
	public CurriculumVitaeDTO getPostulante() {	return postulante;	}
	public void setListaCvs(List<CurriculumVitaeDTO> listaCvs) {	this.listaCvs = listaCvs;	}
	public List<CurriculumVitaeDTO> getListaCvs() {
		return listaCvs;	}	
	public ServidorDTO[] getServidoresSeleccionados() {	return servidoresSeleccionados;	}
	public void setServidoresSeleccionados(ServidorDTO[] servidoresSeleccionados) {
		this.servidoresSeleccionados = servidoresSeleccionados;	}
	public ConvocatoriaDTO getJuradosxConvocatoria() {
		return juradosxConvocatoria;	}
	public void setJuradosxConvocatoria(ConvocatoriaDTO juradosxConvocatoria) {
		this.juradosxConvocatoria = juradosxConvocatoria;	}
	
	public void setPromedioCV(double promedioCV) {
		this.promedioCV = promedioCV;
	}
	public double getPromedioCV() {
		return promedioCV;
	}
	public void setPromedioEntrevista(double promedioEntrevista) {
		this.promedioEntrevista = promedioEntrevista;
	}
	public double getPromedioEntrevista() {
		return promedioEntrevista;
	}
	public boolean isBtnJurado() {
		return btnJurado;
	}
	public void setBtnJurado(boolean btnJurado) {
		this.btnJurado = btnJurado;
	}	
	
	
}
