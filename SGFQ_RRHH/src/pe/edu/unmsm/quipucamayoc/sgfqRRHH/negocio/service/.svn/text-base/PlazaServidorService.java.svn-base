package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PlazaServidorDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.VWCargoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PlazaServidorEstadoDTO;

public interface PlazaServidorService {
	public void guardarPlazaServidor(PlazaServidorDTO plazaserv)throws DataAccessException;
	public void actualizarPlazaServidor(PlazaServidorDTO plazaserv)throws DataAccessException;
	public void eliminarPlazaServidor(Integer plazaserv)throws DataAccessException;
	public PlazaServidorDTO obtenerPlazaServidor(Integer plazaserv)	throws DataAccessException;
	public boolean comprobExisteServAsig(VWCargoDTO cargoSelected)throws DataAccessException;
	public void eliminarPlazaServidorxPlaza(Integer idPlaza,String estadoPlaza)throws DataAccessException;
	public void editarFechaCaduciSer(Integer idPlaza,PlazaServidorDTO puestoTrab) throws DataAccessException;
	public List<PlazaServidorEstadoDTO> obtenerEstadosdePlazaServidor(Integer estadoPlaza);
}
