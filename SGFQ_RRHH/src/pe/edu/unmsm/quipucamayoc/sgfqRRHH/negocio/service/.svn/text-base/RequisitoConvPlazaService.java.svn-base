package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service;

import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.dao.DataAccessException;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.RequisitoConvPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.TipoRequisitoConvPlazaDTO;

public interface RequisitoConvPlazaService {
	public List<RequisitoConvPlazaDTO> obtenerRequistosConvPlaza(ConvocatoriaPlazaDTO convplaza)throws DataAccessException;
	public void insertarRequisito(RequisitoConvPlazaDTO reqconvplaza) throws DataAccessException;
	public void eliminarRequisito(RequisitoConvPlazaDTO reqconvplaza) throws DataAccessException;
	public void actualizarRequisito(RequisitoConvPlazaDTO reqconvplaza) throws DataAccessException;
	public Integer obtenerIdMaxReq()throws DataAccessException;
	public List<TipoRequisitoConvPlazaDTO> obtenerTipoRequisitos()throws DataAccessException;
}
