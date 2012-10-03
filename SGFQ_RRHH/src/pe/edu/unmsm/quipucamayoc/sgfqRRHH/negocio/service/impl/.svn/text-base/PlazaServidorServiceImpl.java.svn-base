package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.PlazaDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.PlazaServidorDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PlazaServidorEstadoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PlazaServidorDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.VWCargoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.PlazaServidorService;

@Service
public class PlazaServidorServiceImpl implements PlazaServidorService {

	@Resource
	PlazaServidorDAO plazaservdao;
	@Resource
	PlazaDAO plazaDAO;
	@Override
	public void guardarPlazaServidor(PlazaServidorDTO plazaserv) throws DataAccessException {
		plazaservdao.insertPuestoTrab(plazaserv);
		if(plazaserv.getEstPlaza().compareToIgnoreCase("Funcional")==0){
			plazaDAO.updatePlazaFuncional(plazaserv.getIdPlaza());
		}else{
			plazaDAO.updatePlaza(plazaserv.getIdPlaza());
		}
	}

	@Override
	public void actualizarPlazaServidor(PlazaServidorDTO plazaserv)
			throws DataAccessException {
		plazaservdao.updatePuestoTrab(plazaserv);
	}

	@Override
	public void eliminarPlazaServidor(Integer plazaserv)
			throws DataAccessException {
		plazaservdao.deletePuestoTrab(plazaserv);
	}

	@Override
	public PlazaServidorDTO obtenerPlazaServidor(Integer plazaserv)
			throws DataAccessException {
		return plazaservdao.getPuestoTrab(plazaserv);
	}

	@Override
	public boolean comprobExisteServAsig(VWCargoDTO cargoSelected)throws DataAccessException {
		if(cargoSelected.getSerExiste().equals("VACANTE")){
			System.out.println("comproAsignServidor: devuelve verdadero");
			return  true;
		}
		else
			{
			System.out.println("comproAsignServidor: devuelve falso");
			return false;}
		
	}

	@Override
	public void eliminarPlazaServidorxPlaza(Integer idPlaza,String estadoPlaza) throws DataAccessException {
		plazaservdao.delePuestoTrabxPlaza(idPlaza);
		if(estadoPlaza.compareToIgnoreCase("Funcional")==0){
			plazaDAO.updatePlazaaVacanteFunc(idPlaza);
			System.out.println("");
		}else{
			plazaDAO.updatePlazaaVacante(idPlaza);
		}
		
	}

	@Override
	public void editarFechaCaduciSer(Integer idPlaza,
			PlazaServidorDTO puestoTrab) throws DataAccessException {
		// TODO Auto-generated method stub
		plazaservdao.updateFechaFin(idPlaza, puestoTrab);
	}

	@Override
	public List<PlazaServidorEstadoDTO> obtenerEstadosdePlazaServidor(Integer estadoPlaza) {
		return plazaservdao.obtenerEstadosdePlazaServidor(estadoPlaza);
	}

}
