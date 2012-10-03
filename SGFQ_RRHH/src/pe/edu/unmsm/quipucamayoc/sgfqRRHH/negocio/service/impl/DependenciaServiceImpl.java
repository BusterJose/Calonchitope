package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.DependenciaDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.DependenciaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.DependenciaService;


@Service
public class DependenciaServiceImpl implements DependenciaService{

	@Resource
	DependenciaDAO depDAO;
	
	@Override
	public List<DependenciaDTO> listarDependencias(Integer udId, Integer nivel) throws DataAccessException {
		try {
			if(nivel==2){
				return depDAO.getDependencia2(udId);
			}else{
				return depDAO.getDependencia(udId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public List<DependenciaDTO> listarDependenciasHijas(Integer udPad) throws DataAccessException {
		return depDAO.getDependenciaByUdPad(udPad);
	}

	@Override
	public DependenciaDTO obtenerud_cod(Integer udid) throws DataAccessException {
		return depDAO.obtenerud_cod(udid);
	}

	public DependenciaDTO obtenerDepxUdcod( String udcod ){
		return depDAO.obtenerDepxUdcod(udcod);		
	}
	
}
