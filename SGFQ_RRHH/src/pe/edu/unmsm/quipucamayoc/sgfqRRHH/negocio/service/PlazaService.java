package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CapUnidad;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServidorAntiguoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.VWCargoDTO;

public interface PlazaService {
	public void guardarPlaza(PlazaDTO plaza)throws DataAccessException;
	public void actualizarPlaza(PlazaDTO plaza)throws DataAccessException;
	public void eliminarPlaza(int idplazaser)throws DataAccessException;
	public PlazaDTO obtenerPlaza(PlazaDTO plaza)throws DataAccessException;
	public List<PlazaDTO> listarPlazasVacantes()throws DataAccessException;
	public List<PlazaDTO> obtenerPlazasxConvocatoria(int idConvocatoria);
	public List<VWCargoDTO> listarPlazasVacantesxDep(String udCod,Integer anio,Integer tipo, String filtroClasificacion,String filtroGrupOcupacional);
	public List<VWCargoDTO> listarPlazasServidoresxDep(Integer anio, String udCod, String filtroClasificacion,String filtroGrupOcupacional)throws DataAccessException;
	public List<ServidorAntiguoDTO> listarServidoresAntiguosActivos(Integer anio,Integer udId,String udCod,Integer codCargoClasif,String tipTrabCargoClasif);
	public ServidorAntiguoDTO obtenerServidorAntiguo(ServidorAntiguoDTO servidorAntSelected) throws DataAccessException;
	public List<CapUnidad> obtenerConsolidadoCap(String ud_cod, Integer anio,String udCodElegida);
	public List<String> obtenerClasificaciones();
	public List<String> obtenerGruposOcupacionales();
}
