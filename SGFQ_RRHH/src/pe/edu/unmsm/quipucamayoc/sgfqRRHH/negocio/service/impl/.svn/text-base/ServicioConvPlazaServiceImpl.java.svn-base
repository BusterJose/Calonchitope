package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.ServicioConvPlazaDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServicioConvPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.ServicioConvPlazaService;
@Service
public class ServicioConvPlazaServiceImpl implements ServicioConvPlazaService {
	@Resource
	ServicioConvPlazaDAO servicioplazaDAO;
	@Override
	public List<ServicioConvPlazaDTO> obtenerServiciosConvPlaza(
			ConvocatoriaPlazaDTO convplaza) throws DataAccessException {
		return servicioplazaDAO.getServiciosConvPlaza(convplaza);
	}

	@Override
	public void insertarServicios(ServicioConvPlazaDTO servconvplaza)
			throws DataAccessException {
		servicioplazaDAO.insertServicios(servconvplaza);
		
	}

	@Override
	public void eliminarServicios(ServicioConvPlazaDTO servconvplaza)
			throws DataAccessException {
		servicioplazaDAO.deleteServicios(servconvplaza);
	}

	@Override
	public void actualizarServicios(ServicioConvPlazaDTO servconvplaza)
			throws DataAccessException {
		servicioplazaDAO.updateServicios(servconvplaza);
	}

	@Override
	public Integer obtenerIdMaxServicios() throws DataAccessException {
		return servicioplazaDAO.getIdMaxServicios();
	}

}
