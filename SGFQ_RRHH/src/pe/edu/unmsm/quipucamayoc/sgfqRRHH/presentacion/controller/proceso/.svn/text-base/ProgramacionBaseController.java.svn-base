package pe.edu.unmsm.quipucamayoc.sgfqRRHH.presentacion.controller.proceso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.RequisitoConvPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServicioConvPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.ConvocatoriaPlazaService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.ConvocatoriaService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.RequisitoConvPlazaService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.ServicioConvPlazaService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.util.Util;

@Controller
@Scope("session")
public class ProgramacionBaseController {

	@Resource
	ConvocatoriaController convController;

	@Resource
	private ConvocatoriaService convService;
	@Resource
	private RequisitoConvPlazaService requisitoPlazaService;
	@Resource
	private ServicioConvPlazaService servPlazaService;
	@Resource
	private ConvocatoriaPlazaService convPlazaService;

	private Integer anio;
private Integer mes;
private Integer dia;
private ConvocatoriaDTO convDTO;
private ConvocatoriaDTO convDTOSelected;
private ConvocatoriaPlazaDTO convPlaza;
private ConvocatoriaPlazaDTO convPlazaSelected;
private List<SelectItem> listAnioSI;
private List<SelectItem> listMesSI;
private List<ConvocatoriaDTO> listConvocatorias;
private List<ConvocatoriaPlazaDTO> listPlazasPorConv;
private List<RequisitoConvPlazaDTO> listRequisitosPlaza;
private List<ServicioConvPlazaDTO> listServiciosPlaza;
private String strAction;
private String strActionEvButton;
private String fechaActual;
private int tvProgBases;
private int tvEditarPlaza;
private int tvDetallePlaza;
private boolean dlgSave;

	public String iraProgramarBase() {
		inicializarValores();
		return getStrAction();
	}
public void inicializarValores(){
	
	Calendar c = Calendar.getInstance();	
	anio = c.get(Calendar.YEAR);
	mes = c.get(Calendar.MONTH) + 1;
	dia = c.get(Calendar.DATE);		
	listAnioSI=listarAniosSI();
	listMesSI=listarMesesSI();	
	setListAnioSI(listAnioSI);
	setListMesSI(listMesSI);
	convController.setListConvocatorias(convService.listarConvocEnProgBase(anio,mes));//nancy porfavor debes refactorizar :S yo carlos
	setListConvocatorias(convController.getListConvocatorias());
	setListPlazasPorConv(new ArrayList<ConvocatoriaPlazaDTO>());
	setConvDTO(new ConvocatoriaDTO());
	getConvDTO().setListConvPlaza(new ArrayList<ConvocatoriaPlazaDTO>());
	setConvDTOSelected(new ConvocatoriaDTO());
	setConvPlaza(new ConvocatoriaPlazaDTO());
	setConvPlazaSelected(new ConvocatoriaPlazaDTO());
	setListRequisitosPlaza(new ArrayList<RequisitoConvPlazaDTO>());
	setListServiciosPlaza(new ArrayList<ServicioConvPlazaDTO>());	
	setTvEditarPlaza(0);
	setTvProgBases(0);
	setTvDetallePlaza(0);		
	setDlgSave(true);	
	setStrAction("programarBase");
	
}
	public void listarSolicitudConvAnioMes(ActionEvent ev) {
		setListConvocatorias(convService.listarConvocEnProgBase(anio, mes));

	}

	public void listarPlazasConvAnioMes(ActionEvent ev) {
		listPlazasPorConv = convPlazaService.listarPlazasPorConvocatoria(convDTOSelected);
	}

	public void cambiarTabPlazas(SelectEvent se) {

		try {
			setConvDTO(convDTOSelected);
			listPlazasPorConv = convPlazaService
					.listarPlazasPorConvocatoria(getConvDTO());
			getConvDTO().setListConvPlaza(listPlazasPorConv);
			System.out.println("Numero de Plazas por Convocatoria"
					+ listPlazasPorConv.size());
			for (int i = 0; i < getConvDTO().getListConvPlaza().size(); i++) {
				System.out
						.println("Plaza:"
								+ getConvDTO().getListConvPlaza().get(i)
										.getDescCargo());
			}
			setTvProgBases(1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actualizarFechaContratos() {
		FacesContext context = FacesContext.getCurrentInstance();
		String idComponente="formProgramarBase:notificacionProgBase";
		ConvocatoriaPlazaDTO convocatoriaPlaza = new ConvocatoriaPlazaDTO();
		convocatoriaPlaza.setIdConvocatoria(convPlaza.getIdConvocatoria());
		convocatoriaPlaza.setIdPlaza(convPlaza.getIdPlaza());
		convocatoriaPlaza.setFechaIni(convPlaza.getFechaIni());
		convocatoriaPlaza.setFechaFin(convPlaza.getFechaFin());
		convPlazaService.actualizarConvocatoriaPlaza(convocatoriaPlaza);
		Util.agregarMensaje(context, idComponente, "Accion correcta", "Se actualizaron las fechas Contratacion" , FacesMessage.SEVERITY_INFO);
	}

	public void editarPlazas(SelectEvent ev) {
		try {
			setConvPlaza(convPlazaSelected);
			listRequisitosPlaza = requisitoPlazaService.obtenerRequistosConvPlaza(getConvPlaza());
			listServiciosPlaza = servPlazaService.obtenerServiciosConvPlaza(getConvPlaza());
			for (int i = 0; i < getConvDTO().getListConvPlaza().size(); i++) {
				if (getConvDTO().getListConvPlaza().get(i).getIdPlaza() == getConvPlaza()
						.getIdPlaza()) {
					getConvDTO().getListConvPlaza().get(i)
							.setListReqConvPlaza(listRequisitosPlaza);
					getConvDTO().getListConvPlaza().get(i)
							.setListServConvPlaza(listServiciosPlaza);
				}
			}
			setTvDetallePlaza(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void guardarFechasEtapasProcesoConv(ActionEvent ev) {
		System.out.println("Guardando Datos");
		convService.actualizarConvocatoria(convDTO);
	}

	public void enviarConvaDGA(ActionEvent ev) {

		try {
			if (convDTO.getFechaIniCV() != null
					&& convDTO.getFechaFinCV() != null
					&& convDTO.getFechaFinPublicConv() != null
					&& convDTO.getFechaIniPublicConv() != null
					&& convDTO.getFechaIniEntrevista() != null
					&& convDTO.getFechaFinEntrevista() != null
					&& convDTO.getFechaIniEvalCV() != null
					&& convDTO.getFechaFinEvalCV() != null
					&& convDTO.getFechaIniPublicResult() != null
					&& convDTO.getFechaFinPublicResult() != null
					&& convDTO.getFechaIniSuscripContrato() != null
					&& convDTO.getFechaFinSuscripContrato() != null) {
				convDTO.setIdEstadoConv(6);
				convService.actualizarConvocatoria(convDTO);
				setListConvocatorias(convService
						.listarConvocatoriasPorEstadoAnioMes(5, anio, mes));
				setTvProgBases(0);
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error de Guardado",
								"Debe Llenar todos las fechas"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void devolverConvaGestion(ActionEvent ev) {
		convDTO.setIdEstadoConv(4);
		convService.actualizarConvocatoria(convDTO);
		setListConvocatorias(convService.listarConvocatoriasPorEstadoAnioMes(5,
				anio, mes));
		setTvProgBases(0);
	}

	public void eliminarFechasEtapasProcesoConv(ActionEvent ev) {
		System.out.println("Limpiando Fechas");
		convDTO.setFechaIniCV(null);
		convDTO.setFechaFinCV(null);
		convDTO.setFechaIniPublicConv(null);
		convDTO.setFechaFinPublicConv(null);
		convDTO.setFechaIniEntrevista(null);
		convDTO.setFechaFinEntrevista(null);
		convDTO.setFechaIniEvalCV(null);
		convDTO.setFechaFinEvalCV(null);
		convDTO.setFechaIniPublicResult(null);
		convDTO.setFechaFinPublicResult(null);
		convDTO.setFechaIniSuscripContrato(null);
		convDTO.setFechaFinSuscripContrato(null);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Datos eliminados", "Se limpiaron las Fechas"));

	}

	public void validarFechaIniPublicConv(DateSelectEvent ev) {

		if (convDTO.getFechaFinPublicResult() != null) {
			compararFechas(ev.getDate(), convDTO.getFechaFinPublicConv());
		}
	}

	public void validarFechaFinPublicConv(DateSelectEvent ev) {
		if (convDTO.getFechaIniPublicConv() != null) {
			compararFechas(convDTO.getFechaIniPublicConv(), ev.getDate());
		}
	}

	public void validarFechaIniCV(DateSelectEvent ev) {

		if (ev.getDate().after(convDTO.getFechaFinPublicConv())) {
			if (convDTO.getFechaFinCV() != null) {
				compararFechas(ev.getDate(), convDTO.getFechaFinCV());
			}
		} else {
			mensajeError();
		}
	}

	public void validarFechaFinCV(DateSelectEvent ev) {
		if (ev.getDate().after(convDTO.getFechaFinPublicConv())) {
			if (convDTO.getFechaIniCV() != null) {
				compararFechas(convDTO.getFechaIniCV(), ev.getDate());
			}
		} else {
			mensajeError();
		}
	}

	public void validarFechaIniEvalCV(DateSelectEvent ev) {
		if (ev.getDate().after(convDTO.getFechaFinCV())) {
			if (convDTO.getFechaFinEvalCV() != null) {
				compararFechas(ev.getDate(), convDTO.getFechaFinEvalCV());
			}
		} else {
			mensajeError();
		}

	}

	public void validarFechaFinEvalCV(DateSelectEvent ev) {
		if (ev.getDate().after(convDTO.getFechaFinCV())) {
			if (convDTO.getFechaIniEvalCV() != null) {
				compararFechas(convDTO.getFechaIniEvalCV(), ev.getDate());
			}
		} else {
			mensajeError();
		}
	}

	public void validarFechaIniEntrevista(DateSelectEvent ev) {

		if (ev.getDate().after(convDTO.getFechaFinEvalCV())) {
			if (convDTO.getFechaFinEntrevista() != null) {
				compararFechas(ev.getDate(), convDTO.getFechaFinEntrevista());
			}
		} else {
			mensajeError();
		}

	}

	public void validarFechaFinEntrevista(DateSelectEvent ev) {
		if (ev.getDate().after(convDTO.getFechaFinEvalCV())) {
			if (convDTO.getFechaIniEntrevista() != null) {
				compararFechas(convDTO.getFechaIniEntrevista(), ev.getDate());
			}
		} else {
			mensajeError();
		}
	}

	public void validarFechaIniPublicResult(DateSelectEvent ev) {
		if (ev.getDate().after(convDTO.getFechaFinEntrevista())) {
			if (convDTO.getFechaFinPublicResult() != null) {
				compararFechas(ev.getDate(), convDTO.getFechaFinPublicResult());
			}
		} else {
			mensajeError();
		}

	}

	public void validarFechaFinPublicResult(DateSelectEvent ev) {
		if (ev.getDate().after(convDTO.getFechaFinEntrevista())) {
			if (convDTO.getFechaIniPublicResult() != null) {
				compararFechas(convDTO.getFechaIniPublicResult(), ev.getDate());
			}
		} else {
			mensajeError();
		}
	}

	public void validarFechaIniSuscripcion(DateSelectEvent ev) {
		if (ev.getDate().after(convDTO.getFechaFinPublicResult())) {
			if (convDTO.getFechaFinSuscripContrato() != null) {
				compararFechas(ev.getDate(),
						convDTO.getFechaFinSuscripContrato());
			}
		} else {
			mensajeError();
		}
	}

	public void validarFechaFinSuscripcion(DateSelectEvent ev) {
		if (ev.getDate().after(convDTO.getFechaFinPublicResult())) {
			if (convDTO.getFechaIniSuscripContrato() != null) {
				compararFechas(convDTO.getFechaIniSuscripContrato(),
						ev.getDate());
			}
		} else {
			mensajeError();
		}
	}

	public void compararFechas(Date fecha1, Date fecha2) {
		if (fecha1.after(fecha2)) {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Error de fechas",
									"La fecha Inicio debe ser menor a la Fecha fin!! Intentelo de Nuevo"));
		}
	}

	public void mensajeError() {
		FacesContext
				.getCurrentInstance()
				.addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error de fechas",
								"La fecha Inicio debe ser menor a la Fecha fin!! Intentelo de Nuevo"));
	}

	public void irAtras(ActionEvent ev) {
		tvEditarPlaza--;
		setTvEditarPlaza(tvEditarPlaza);
	}

	public void irSiguiente(ActionEvent ev) {
		tvEditarPlaza++;
		setTvEditarPlaza(tvEditarPlaza);
	}

	public void irProgramarFechasConv(ActionEvent ev) {
		setTvProgBases(2);
	}

	public void iraTabBasesPrincipal(ActionEvent ev) {
		try {
			setTvProgBases(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void tabViewEditarPlazas(ActionEvent ev) {
		setTvEditarPlaza(1);
	}

	public List<SelectItem> listarAniosSI() {

		List<SelectItem> anioSelItem = new ArrayList<SelectItem>();
		anioSelItem.add(new SelectItem(-1, "Seleccione un Año"));
		for (int i = 2011; i <= 2025; i++) {
			SelectItem item = new SelectItem(i, Integer.toString(i));
			anioSelItem.add(item);
		}
		return anioSelItem;
	}

	public List<SelectItem> listarMesesSI() {
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

	public void setStrAction(String strAction) {
		this.strAction = strAction;
	}
public String getStrAction() {
	return strAction;
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
public void setConvDTO(ConvocatoriaDTO convDTO) {
	this.convDTO = convDTO;
}
public ConvocatoriaDTO getConvDTO() {
	return convDTO;
}
public void setConvDTOSelected(ConvocatoriaDTO convDTOSelected) {
	this.convDTOSelected = convDTOSelected;
}
public ConvocatoriaDTO getConvDTOSelected() {
	return convDTOSelected;
}
public void setListConvocatorias(List<ConvocatoriaDTO> listConvocatorias) {
	this.listConvocatorias = listConvocatorias;
}
public List<ConvocatoriaDTO> getListConvocatorias() {
	return listConvocatorias;
}
public void setListPlazasPorConv(List<ConvocatoriaPlazaDTO> listPlazasPorConv) {
	this.listPlazasPorConv = listPlazasPorConv;
}
public List<ConvocatoriaPlazaDTO> getListPlazasPorConv() {
	return listPlazasPorConv;
}
public void setTvProgBases(int tvProgBases) {
	this.tvProgBases = tvProgBases;
}
public int getTvProgBases() {
	return tvProgBases;
}
public void setConvPlaza(ConvocatoriaPlazaDTO convPlaza) {
	this.convPlaza = convPlaza;
}
public ConvocatoriaPlazaDTO getConvPlaza() {
	return convPlaza;
}
public void setConvPlazaSelected(ConvocatoriaPlazaDTO convPlazaSelected) {
	this.convPlazaSelected = convPlazaSelected;
}
public ConvocatoriaPlazaDTO getConvPlazaSelected() {
	return convPlazaSelected;
}
public List<RequisitoConvPlazaDTO> getListRequisitosPlaza() {
	return listRequisitosPlaza;
}
public void setListRequisitosPlaza(
		List<RequisitoConvPlazaDTO> listRequisitosPlaza) {
	this.listRequisitosPlaza = listRequisitosPlaza;
}
public List<ServicioConvPlazaDTO> getListServiciosPlaza() {
	return listServiciosPlaza;
}
public void setListServiciosPlaza(List<ServicioConvPlazaDTO> listServiciosPlaza) {
	this.listServiciosPlaza = listServiciosPlaza;
}
public void setTvEditarPlaza(int tvEditarPlaza) {
	this.tvEditarPlaza = tvEditarPlaza;
}
public int getTvEditarPlaza() {
	return tvEditarPlaza;
}
public void setTvDetallePlaza(int tvDetallePlaza) {
	this.tvDetallePlaza = tvDetallePlaza;
}
public int getTvDetallePlaza() {
	return tvDetallePlaza;
}
public void setStrActionEvButton(String strActionEvButton) {
	this.strActionEvButton = strActionEvButton;
}
public String getStrActionEvButton() {
	return strActionEvButton;
}
public void setDlgSave(boolean dlgSave) {
	this.dlgSave = dlgSave;
}
public boolean isDlgSave() {
	return dlgSave;
}

public void setFechaActual(String fechaActual) {
	this.fechaActual = fechaActual;
}

public String getFechaActual() {
	return Util.fechaActual();
}

}
