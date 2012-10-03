package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao;


import java.util.List;

import org.springframework.dao.DataAccessException;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CapUnidad;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServidorAntiguoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.VWCargoDTO;

public interface PlazaDAO {

	public PlazaDTO getPuesto(PlazaDTO puesto) throws DataAccessException;
	public List<PlazaDTO> getPlazasVacantes()throws DataAccessException;
	public List<PlazaDTO> obtenerPlazasxConvocatoria(int idConvocatoria);
	public List<PlazaDTO> getPlazasxDep(Integer udId);
	public void updatePlaza(Integer idPlaza)throws DataAccessException;
	public void updatePlazaFuncional(Integer idPlaza)throws DataAccessException;
	public void updatePlazaaVacante(Integer idPlaza)throws DataAccessException;
	public void updatePlazaaVacanteFunc(Integer idPlaza)throws DataAccessException;
	public List<VWCargoDTO> getPlazaServxDep(Integer anio,String udCod, String filtroClasificacion,String filtroGrupOcupacional)throws DataAccessException;
	public void eliminar_AsigServ(int idplazaserv)throws DataAccessException;
	public List<VWCargoDTO> getPlazaVacsxDep(String udCod,Integer anio,Integer tipo, String filtroClasificacion,String filtroGrupOcupacional);
	public List<ServidorAntiguoDTO> selectServidoresAntiguosActivos(Integer udId);
	public List<ServidorAntiguoDTO> selectServidoresAntiguosxAnio(Integer anio,String udCod,Integer codCargoClasif,String tipTrabCargoClasif);
	public List<ServidorAntiguoDTO> selectServidoresTotales(Integer anio,String udCod);
	public ServidorAntiguoDTO selectServidorAntiguo(ServidorAntiguoDTO servidorAntSelected)throws DataAccessException;
	public CapUnidad obtenerConsolidadoCap(String ud_cod,Integer anio);
	public List<String> obtenerClasificaciones();
	public List<String> obtenerGruposOcupacionales();
}
