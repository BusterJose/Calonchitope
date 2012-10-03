package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.RequisitoConvPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.TipoRequisitoConvPlazaDTO;

public interface RequisitoConvPlazaDAO {
	
public List<RequisitoConvPlazaDTO> getRequistosConvPlaza(ConvocatoriaPlazaDTO convplaza)throws DataAccessException;
public void insertRequisito(RequisitoConvPlazaDTO reqconvplaza) throws DataAccessException;
public void deleteRequisito(RequisitoConvPlazaDTO reqconvplaza) throws DataAccessException;
public void updateRequisito(RequisitoConvPlazaDTO reqconvplaza) throws DataAccessException;
public Integer getIdMaxReq()throws DataAccessException;
public List<TipoRequisitoConvPlazaDTO> getTipoRequisitos()throws DataAccessException; 
}
