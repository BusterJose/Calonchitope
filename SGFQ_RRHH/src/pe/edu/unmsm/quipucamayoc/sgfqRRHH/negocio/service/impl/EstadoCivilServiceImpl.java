package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.EstadoCivilService;

@Service
public  class EstadoCivilServiceImpl implements EstadoCivilService {

	@Override
	public List<SelectItem> listarEstadosCiviles() throws DataAccessException {
		List<SelectItem> lisEC=new ArrayList<SelectItem>();
		lisEC.add(new SelectItem(1, "SOLTERO"));
		lisEC.add(new SelectItem(2, "CASADO"));
		lisEC.add(new SelectItem(3, "DIVORCIADO"));
		lisEC.add(new SelectItem(4, "VIUDO"));
		lisEC.add(new SelectItem(5, "CONVIVIENTE"));
		return lisEC;
	}

}
