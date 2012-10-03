package pe.edu.unmsm.quipucamayoc.sgfqRRHH.presentacion.controller.proceso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServidorDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.ServidorService;

@Controller
@Scope("session")
public class ConsultaServidorController implements Serializable {

	/*********DECLARACION DE ATRIBUTOS**********/
	private static final long serialVersionUID = 1L;
	private ServidorDTO cargoServidor;
	private ServidorDTO capturServidor;	
	private List<ServidorDTO> listaServidores;
	private List<ServidorDTO> listaHistServidor;
	private Integer tipSearch;
	
	@Resource
	ServidorService servidorService;
	
	/************INICIALIZACION DE LA PAGINA*************/
	@PostConstruct
	public void inicializar(){		
		setTipSearch(0);
		cargoServidor=new ServidorDTO();
		listaServidores = new ArrayList<ServidorDTO>();
		capturServidor = new ServidorDTO();
		listaHistServidor = new ArrayList<ServidorDTO>();
	}
	/*********NAVEGACION*************/		
	public void buscarTrabajador(ActionEvent event){
		try {
			System.out.println("Entro!!.  tipo "+ getTipSearch());
			if(getTipSearch()==1){
				listaServidores=servidorService.buscarServidorXDni(cargoServidor.getDocIdent());
			}else{
				if(getTipSearch()==2){
					listaServidores=servidorService.buscarServidorXApeNomb(cargoServidor.getMaterno(),cargoServidor.getPaterno(),cargoServidor.getNombre());
				}else{
					listaServidores=null;
				}
			}
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}		
	}	
	public void mostrarServidor(SelectEvent event){
		setListaServidores(servidorService.buscarServidorXDni(capturServidor.getDocIdent()));
		setListaHistServidor(servidorService.buscarServidorXApeNomb(capturServidor.getMaterno(), capturServidor.getPaterno(), capturServidor.getNombre()));
	}

	/********************GETTERS Y SETTERS*********************/
	public ServidorDTO getCargoServidor() {return cargoServidor;}
	public void setCargoServidor(ServidorDTO cargoServidor) {this.cargoServidor = cargoServidor;}
	public Integer getTipSearch() {	return tipSearch;}
	public void setTipSearch(Integer tipSearch) {this.tipSearch = tipSearch;}
	public ServidorDTO getCapturServidor() {return capturServidor;}
	public void setCapturServidor(ServidorDTO capturServidor) {	this.capturServidor = capturServidor;	}
	public List<ServidorDTO> getListaServidores() {return listaServidores;}
	public void setListaServidores(List<ServidorDTO> listaServidores) {this.listaServidores = listaServidores;}
	public List<ServidorDTO> getListaHistServidor() {return listaHistServidor;}
	public void setListaHistServidor(List<ServidorDTO> listaHistServidor) {this.listaHistServidor = listaHistServidor;}
}
