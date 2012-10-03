package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServidorAntiguoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServidorDTO;

public interface ServidorDAO {
	public List<ServidorDTO> selectServidores()throws DataAccessException;	
	public List<ServidorDTO> buscarServidorXApeNomb(String materno,String paterno,String nombre)throws DataAccessException;
	public List<ServidorDTO> buscarServidorXDni(int dni)throws DataAccessException;
}
