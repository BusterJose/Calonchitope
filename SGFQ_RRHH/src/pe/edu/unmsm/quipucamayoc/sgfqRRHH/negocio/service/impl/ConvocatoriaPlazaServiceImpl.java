package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.ConvocatoriaPlazaDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.RequisitoConvPlazaDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.ServicioConvPlazaDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.RequisitoConvPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServicioConvPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.ConvocatoriaPlazaService;
@Service
public class ConvocatoriaPlazaServiceImpl implements ConvocatoriaPlazaService{

	@Resource
	ConvocatoriaPlazaDAO convplazaDAO;
	@Resource
	RequisitoConvPlazaDAO requiConvPlazaDAO;
	@Resource
	ServicioConvPlazaDAO servConvPlazaDAO;
	
	@Override
	public List<ConvocatoriaPlazaDTO> listarConvocatoriaxPlazas(ConvocatoriaDTO conv) throws DataAccessException {
		return convplazaDAO.getConvocatoriaxPlazas(conv);
	}
	
	@Override
	public List<ConvocatoriaPlazaDTO> listarPlazasPorConvocatoria(ConvocatoriaDTO conv) throws DataAccessException {
		List<ConvocatoriaPlazaDTO> plazas=convplazaDAO.selectConvPlazaByConv(conv.getIdConvocatoria());
		for (int i = 0; i < plazas.size(); i++) {
			plazas.get(i).setListReqConvPlaza(requiConvPlazaDAO.getRequistosConvPlaza(plazas.get(i)));
			plazas.get(i).setListServConvPlaza(servConvPlazaDAO.getServiciosConvPlaza(plazas.get(i)));
		}
		return plazas;
	}

	@Override
	public ConvocatoriaDTO listarConvocatoriaById(ConvocatoriaDTO convPlaza)
			throws DataAccessException {
		return null;
	}

	@Transactional
	@Override
	public void insertarConvocatoriaPlaza(ConvocatoriaPlazaDTO convPlaza)
			throws DataAccessException {
		List<RequisitoConvPlazaDTO> listrequisitos=convPlaza.getListReqConvPlaza();
		List<ServicioConvPlazaDTO> listservicios=convPlaza.getListServConvPlaza();
		convplazaDAO.insertConvocatoriaPlaza(convPlaza);
		RequisitoConvPlazaDTO requisito=new RequisitoConvPlazaDTO();
		ServicioConvPlazaDTO servicio=new ServicioConvPlazaDTO();
		
		for (int i = 0; i < listrequisitos.size(); i++) {
			requisito=listrequisitos.get(i);
			requisito.setIdConvocatoria(convPlaza.getIdConvocatoria());
			requisito.setIdPlaza(convPlaza.getIdPlaza());
			requiConvPlazaDAO.insertRequisito(requisito);
			requisito=new RequisitoConvPlazaDTO();
		}
		for (int i = 0; i < listservicios.size(); i++) {
			servicio=listservicios.get(i);
			servicio.setIdConvocatoria(convPlaza.getIdConvocatoria());
			servicio.setIdPlaza(convPlaza.getIdPlaza());
			servConvPlazaDAO.insertServicios(servicio);
			servicio=new ServicioConvPlazaDTO();
		}		
	}

	@Override
	public void actualizarConvocatoriaPlaza(ConvocatoriaPlazaDTO convPlaza)
			throws DataAccessException {
		convplazaDAO.updateConvocatoriaPlaza(convPlaza);
		
	}

	@Override
	public void eliminarConvocatoriaPlaza(ConvocatoriaPlazaDTO convPlaza)
			throws DataAccessException {
		convplazaDAO.deleteConvocatoriaPlaza(convPlaza);
		
	}

	@Override
	public Integer obtenerIdMaxConvPlaza() throws DataAccessException {
		return convplazaDAO.getIdMaxConvPlaza();
	}

}
