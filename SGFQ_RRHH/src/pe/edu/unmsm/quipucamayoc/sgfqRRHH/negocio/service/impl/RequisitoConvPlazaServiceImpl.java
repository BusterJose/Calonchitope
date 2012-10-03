package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.RequisitoConvPlazaDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.RequisitoConvPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.TipoRequisitoConvPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.RequisitoConvPlazaService;
@Service
public class RequisitoConvPlazaServiceImpl implements RequisitoConvPlazaService{
	@Resource
	RequisitoConvPlazaDAO reqconvplazaDAO;
	
	@Override
	public List<RequisitoConvPlazaDTO> obtenerRequistosConvPlaza(ConvocatoriaPlazaDTO convplaza)
			throws DataAccessException {
		return reqconvplazaDAO.getRequistosConvPlaza(convplaza);
	}
	@Override
	public void insertarRequisito(RequisitoConvPlazaDTO reqconvplaza)
			throws DataAccessException {
		reqconvplazaDAO.insertRequisito(reqconvplaza);
	}

	@Override
	public void eliminarRequisito(RequisitoConvPlazaDTO reqconvplaza)
			throws DataAccessException {
		reqconvplazaDAO.deleteRequisito(reqconvplaza);
	}

	@Override
	public void actualizarRequisito(RequisitoConvPlazaDTO reqconvplaza)
			throws DataAccessException {
		reqconvplazaDAO.updateRequisito(reqconvplaza);
	}

	@Override
	public Integer obtenerIdMaxReq() throws DataAccessException {
		return reqconvplazaDAO.getIdMaxReq();
	}
	@Override
	public List<TipoRequisitoConvPlazaDTO> obtenerTipoRequisitos()
			throws DataAccessException {
		List<TipoRequisitoConvPlazaDTO> listTipos=reqconvplazaDAO.getTipoRequisitos();
		return listTipos; 
	}
}
