package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service;

import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.dao.DataAccessException;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.UbigeoDTO;

public interface UbigeoService {

	public List<UbigeoDTO> listarUbigeos() throws DataAccessException;
	public List<UbigeoDTO> listarDepartamentos() throws DataAccessException;
	public List<UbigeoDTO> listarProvinciasPorDepartamento(UbigeoDTO departamento) throws DataAccessException;
	public List<UbigeoDTO> listarDistritosPorProvincia(UbigeoDTO provincia) throws DataAccessException;
	
}
