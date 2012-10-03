package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaPlazaDTO;

public interface ConvocatoriaPlazaService {
	
	public List<ConvocatoriaPlazaDTO> listarConvocatoriaxPlazas(ConvocatoriaDTO conv)throws DataAccessException;
	public List<ConvocatoriaPlazaDTO> listarPlazasPorConvocatoria(ConvocatoriaDTO conv) throws DataAccessException;
	public ConvocatoriaDTO listarConvocatoriaById(ConvocatoriaDTO convPlaza)throws DataAccessException;
	public void insertarConvocatoriaPlaza(ConvocatoriaPlazaDTO convPlaza)throws DataAccessException;
	public void actualizarConvocatoriaPlaza(ConvocatoriaPlazaDTO convPlaza)throws DataAccessException;
	public void eliminarConvocatoriaPlaza(ConvocatoriaPlazaDTO convPlaza)throws DataAccessException;
	public Integer obtenerIdMaxConvPlaza()throws DataAccessException;
}
