package pe.edu.unmsm.quipucamayoc.sgfqRRHH.presentacion.controller.proceso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.ConvocatoriaPlazaService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.ConvocatoriaService;

@Controller
@Scope("session")
public class ConvocatoriaController {

	@Resource
	ConvocatoriaService convServ;
	
	@Resource
	ConvocatoriaPlazaService convPlaServ;
	
	private List<ConvocatoriaDTO> listConvocatorias;
	private ConvocatoriaDTO convocatoriaSelect;
	//private List<ConvocatoriaPlazaDTO> listPlazasConvoc;
	
	/*********** ATRIBUTOS DE SOPORTE ***********/
	private Integer pagina;// 2 = AprobarPresupuesto | 3 = AprobarEconomia | 4 = AprobarDGA | 7=programacion de base 
	private Integer tabActivo;
	private List<SelectItem> listAnioSI;
	private List<SelectItem> listMesSI;
	private Integer anio;
	private Integer mes;
	private Integer dia;
	
	/*********** NAVEGACION ***********/
	public String iraAprobarPresupuesto(){
		inicializarValores();
		
		listConvocatorias = convServ.listarConvocEnPlanif(anio, mes);
		
		for (int i = 0; i < listConvocatorias.size(); i++) {
			System.out.println("Convocatoria " + i + ": " + listConvocatorias.get(i).getObjetivoConv());
		}
		
		setPagina(2);
		
		return "AprobarPresupuesto";
	}
	
	public String iraAprobarEconomia(){
		inicializarValores();
		
		listConvocatorias = convServ.listarConvocEnEconomia(anio, mes);
		
		for (int i = 0; i < listConvocatorias.size(); i++) {
			System.out.println("Convocatoria " + i + ": " + listConvocatorias.get(i).getObjetivoConv());
		}
		
		setPagina(3);
		
		return "AprobarEconomia";
	}
	
	public String iraAprobarDGA(){
		inicializarValores();
		
		listConvocatorias = convServ.listarConvocEnDGA(anio, mes);
		
		for (int i = 0; i < listConvocatorias.size(); i++) {
			System.out.println("Convocatoria " + i + ": " + listConvocatorias.get(i).getObjetivoConv());
		}
		
		setPagina(4);
		
		return "AprobarDGA";
	}
	
	public String iraAprobarBaseDGA(){
		inicializarValores();
		
		listConvocatorias = convServ.listarConvocEnDGABase(anio, mes);
		
		for (int i = 0; i < listConvocatorias.size(); i++) {
			System.out.println("Convocatoria " + i + ": " + listConvocatorias.get(i).getObjetivoConv());
		}
		
		setPagina(6);
		
		return "AprobarBaseDGA";
	}
	
	public void listarConvocatoriasAnioMes(ActionEvent ev){
		/*listConvocatorias = convServ.listarConvocEnPlanif(anio, mes);
		setConvocatoriaSelect(new ConvocatoriaDTO());
		tabActivo = 0;*/
		iraPrimerTab();
	}
	
	public void iraPrimerTab(){
		
		switch (getPagina()) {
			case 2: listConvocatorias = convServ.listarConvocEnPlanif(anio, mes); break;
			case 3: listConvocatorias = convServ.listarConvocEnEconomia(anio, mes); break;
			case 4: listConvocatorias = convServ.listarConvocEnDGA(anio, mes); break;
			case 6: listConvocatorias = convServ.listarConvocEnDGABase(anio, mes); break;
			case 7: listConvocatorias = convServ.listarConvocEnProgBase(anio, mes); break;
			default: break;
		}
		setConvocatoriaSelect(new ConvocatoriaDTO());
		tabActivo = 0;
	}
	
	public void seleccionarConvocatoria(SelectEvent ev){
		//listPlazasConvoc = convPlaServ.listarPlazasPorConvocatoria(convocatoriaSelect);
		convocatoriaSelect.setListConvPlaza(convPlaServ.listarPlazasPorConvocatoria(convocatoriaSelect));
		tabActivo = 1;
	}
	public void obtenerGeneralidades(){
		
	}
	
	public void aprobarPresupuestoConvocatoria(ActionEvent ev){
		convServ.aprobarPresupuestoConvoc(convocatoriaSelect);
		iraPrimerTab();
	}
	
	public void desaprobarPresupuestoConvocatoria(ActionEvent ev){
		convServ.desaprobarPresupuestoConvoc(convocatoriaSelect);
		iraPrimerTab();
	}
	
	public void aprobarEconomiaConvocatoria(ActionEvent ev){
		convServ.aprobarEconomiaConvoc(convocatoriaSelect);
		iraPrimerTab();
	}
	
	public void desaprobarEconomiaConvocatoria(ActionEvent ev){
		convServ.desaprobarEconomiaConvoc(convocatoriaSelect);
		iraPrimerTab();
	}
	
	public void aprobarDGAConvocatoria(ActionEvent ev){
		convServ.aprobarDGAConvoc(convocatoriaSelect);
		iraPrimerTab();
	}
	
	public void desaprobarDGAConvocatoria(ActionEvent ev){
		convServ.desaprobarDGAConvoc(convocatoriaSelect);
		iraPrimerTab();
	}
	
	public void aprobarDGABaseConvocatoria(ActionEvent ev){
		convServ.aprobarDGABaseConvoc(convocatoriaSelect);
		iraPrimerTab();
	}
	
	public void desaprobarDGABaseConvocatoria(ActionEvent ev){
		convServ.desaprobarDGABaseConvoc(convocatoriaSelect);
		iraPrimerTab();
	}
	
	/*********** METODOS DE SOPORTE ***********/
	
	public void inicializarValores(){
		System.out.println("Controller: inicializarValores");
		tabActivo = 0;
		Calendar c = Calendar.getInstance();
		listAnioSI = listarAniosSI();
		listMesSI = listarMesesSI();
		anio = c.get(Calendar.YEAR);
		mes = c.get(Calendar.MONTH) + 1;
		setDia(c.get(Calendar.DATE));
	}
	
	private List<SelectItem> listarAniosSI() {
		System.out.println("Controller: listarAniosSI");
		List<SelectItem> anioSelItem = new ArrayList<SelectItem>();
		anioSelItem.add(new SelectItem(-1, "Seleccione un Año"));
		for (int i = 2011; i <= 2025; i++) {
			SelectItem item=new SelectItem(i, Integer.toString(i));
			anioSelItem.add(item);
		}
		return anioSelItem;
	}
	
	private List<SelectItem> listarMesesSI() {
		System.out.println("Controller: listarMesesSI");
		List<SelectItem> mesSelItem = new ArrayList<SelectItem>();
		
		mesSelItem.add(new SelectItem(-1, "Seleccione un Mes"));
		mesSelItem.add(new SelectItem(1, "Enero"));
		mesSelItem.add(new SelectItem(2, "Febrero"));
		mesSelItem.add(new SelectItem(3, "Marzo"));
		mesSelItem.add(new SelectItem(4, "Abril"));
		mesSelItem.add(new SelectItem(5, "Mayo"));
		mesSelItem.add(new SelectItem(6, "Junio"));
		mesSelItem.add(new SelectItem(7, "Julio"));
		mesSelItem.add(new SelectItem(8, "Agosto"));
		mesSelItem.add(new SelectItem(9, "Setiembre"));
		mesSelItem.add(new SelectItem(10, "Octubre"));
		mesSelItem.add(new SelectItem(11, "Noviembre"));
		mesSelItem.add(new SelectItem(12, "Diciembre"));
		
		return mesSelItem;
	}
	
	/*********** GETTERS AND SETTERS ***********/
	
	public List<ConvocatoriaDTO> getListConvocatorias() {
		return listConvocatorias;
	}
	public void setListConvocatorias(List<ConvocatoriaDTO> listConvocatorias) {
		this.listConvocatorias = listConvocatorias;
	}
	public ConvocatoriaDTO getConvocatoriaSelect() {
		return convocatoriaSelect;
	}
	public void setConvocatoriaSelect(ConvocatoriaDTO convocatoriaSelect) {
		this.convocatoriaSelect = convocatoriaSelect;
	}/*
	public List<ConvocatoriaPlazaDTO> getListPlazasConvoc() {
		return listPlazasConvoc;
	}
	public void setListPlazasConvoc(List<ConvocatoriaPlazaDTO> listPlazasConvoc) {
		this.listPlazasConvoc = listPlazasConvoc;
	}*/
	public Integer getTabActivo() {
		return tabActivo;
	}
	public void setTabActivo(Integer tabActivo) {
		this.tabActivo = tabActivo;
	}

	public Integer getPagina() {
		return pagina;
	}

	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}

	public List<SelectItem> getListAnioSI() {
		return listAnioSI;
	}

	public void setListAnioSI(List<SelectItem> listAnioSI) {
		this.listAnioSI = listAnioSI;
	}

	public List<SelectItem> getListMesSI() {
		return listMesSI;
	}

	public void setListMesSI(List<SelectItem> listMesSI) {
		this.listMesSI = listMesSI;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}
}
