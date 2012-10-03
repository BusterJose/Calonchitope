package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PlazaServidorDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PlazaServidorEstadoDTO;

public interface PlazaServidorDAO {

	public void insertPuestoTrab(PlazaServidorDTO puestoTrab)throws DataAccessException;
	public void updatePuestoTrab(PlazaServidorDTO puestoTrab) throws DataAccessException;
	public void deletePuestoTrab(Integer puestoTrab) throws DataAccessException;
	public PlazaServidorDTO getPuestoTrab(Integer puestoTrab)throws DataAccessException;
	public void delePuestoTrabxPlaza(Integer idPlaza) throws DataAccessException;
	public void updateFechaFin(Integer idPlaza,PlazaServidorDTO puestoTrab) throws DataAccessException;
	public List<PlazaServidorEstadoDTO> obtenerEstadosdePlazaServidor(Integer estadoPlaza);
}
