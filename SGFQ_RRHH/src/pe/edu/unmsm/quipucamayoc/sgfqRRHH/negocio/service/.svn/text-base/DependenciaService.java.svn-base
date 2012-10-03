package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.DependenciaDTO;


public interface DependenciaService {

	public List<DependenciaDTO> listarDependencias(Integer udId, Integer nivel) throws DataAccessException;
	public List<DependenciaDTO> listarDependenciasHijas(Integer udPad) throws DataAccessException;
	public DependenciaDTO obtenerud_cod(Integer udid) throws DataAccessException;
	public DependenciaDTO obtenerDepxUdcod( String udcod )throws DataAccessException;
}

