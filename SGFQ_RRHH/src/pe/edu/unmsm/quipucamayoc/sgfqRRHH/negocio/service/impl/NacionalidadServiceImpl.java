package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.NacionalidadDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.NacionalidadDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.NacionalidadService;

@Service
public class NacionalidadServiceImpl implements NacionalidadService {

	@Resource
	NacionalidadDAO nacdao;
	@Override
	public List<NacionalidadDTO> listarSIPaises() throws DataAccessException {
		List<NacionalidadDTO> listpais=nacdao.getPaises();
		return listpais;
	}

}
