package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaPlazaDTO;

public interface ConvocatoriaPlazaDAO {
	public List<ConvocatoriaPlazaDTO> getConvocatoriaxPlazas(ConvocatoriaDTO conv)throws DataAccessException;
	public List<ConvocatoriaPlazaDTO> selectConvPlazaByConv(Integer idConvocatoria) throws DataAccessException;
	public void insertConvocatoriaPlaza(ConvocatoriaPlazaDTO convPlaza)throws DataAccessException;
	public void updateConvocatoriaPlaza(ConvocatoriaPlazaDTO convPlaza)throws DataAccessException;
	public void deleteConvocatoriaPlaza(ConvocatoriaPlazaDTO convPlaza)throws DataAccessException;
	public Integer getIdMaxConvPlaza()throws DataAccessException;
	
}
