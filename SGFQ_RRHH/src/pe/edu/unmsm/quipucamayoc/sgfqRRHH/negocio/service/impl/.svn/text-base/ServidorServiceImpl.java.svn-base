package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.ServidorDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServidorAntiguoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServidorDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.ServidorService;

@Service
public class ServidorServiceImpl implements ServidorService, Serializable {
	private static final long serialVersionUID = 1L;
	@Resource
	ServidorDAO servidorDAO;	
		@Override
	public List<ServidorDTO> buscarServidorXApeNomb(String materno,String paterno,String nombre)throws DataAccessException{
		return servidorDAO.buscarServidorXApeNomb(materno, paterno, nombre);
	}
	@Override
	public List<ServidorDTO> buscarServidorXDni(int dni)throws DataAccessException{
		return servidorDAO.buscarServidorXDni(dni);
	}
}
