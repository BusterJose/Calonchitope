package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.PlazaDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CapUnidad;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServidorAntiguoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.VWCargoDTO;

@Repository
public class PlazaDAOImpl extends SqlMapClientDaoSupport implements PlazaDAO {

	@Autowired
	public PlazaDAOImpl(SqlMapClient sql) {
		super.setSqlMapClient(sql);
	}

	@Override
	public PlazaDTO getPuesto(PlazaDTO puesto)
			throws DataAccessException {
		return (PlazaDTO)getSqlMapClientTemplate().queryForObject("Plaza.selectPuesto", puesto);
	}

	@Override
	public List<PlazaDTO> getPlazasVacantes() throws DataAccessException {
		return (List<PlazaDTO>)getSqlMapClientTemplate().queryForList("Plaza.selectPuestoVacantes");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlazaDTO> obtenerPlazasxConvocatoria(int idConvocatoria) {
		return (List<PlazaDTO>)getSqlMapClientTemplate().queryForList("Plaza.obtenerPlazasxConvocatoria", idConvocatoria);
	}

	@Override
	public List<PlazaDTO> getPlazasxDep(Integer udId) {
		System.out.println("plazaDao udId: "+udId);
		return (List<PlazaDTO>)getSqlMapClientTemplate().queryForList("Plaza.listarPlazasxEstadoxDep", udId);
	}

	@Override
	public void updatePlaza(Integer idPlaza) throws DataAccessException {
		getSqlMapClientTemplate().update("Plaza.updatePlaza", idPlaza);
	}

	@Override
	public void updatePlazaFuncional(Integer idPlaza) throws DataAccessException {
		getSqlMapClientTemplate().update("Plaza.updatePlazaFuncional", idPlaza);
	}
	
	@Override
	public List<VWCargoDTO> getPlazaServxDep(Integer anio,String udCod, String filtroClasificacion,String filtroGrupOcupacional)throws DataAccessException {
		System.out.println("udid en la dao"+udCod);
		Map parameters = new HashMap();
		parameters.put("udCod", udCod);
		parameters.put("anio", anio);
		parameters.put("filtroClasificacion", filtroClasificacion.toUpperCase());
		parameters.put("filtroGrupOcupacional", filtroGrupOcupacional.toUpperCase());
		return (List<VWCargoDTO>)getSqlMapClientTemplate().queryForList("Plaza.listarPlazaServxDep", parameters);
	}
	
	//updatePlazaaVacante		
	@SuppressWarnings("rawtypes")
	public void eliminar_AsigServ(int idplazaser)throws DataAccessException {
			Map parameters = new HashMap();
			parameters.put("cargo", idplazaser);
			getSqlMapClientTemplate().delete("Plaza.eliminarPlaza", parameters);
	}

	@Override
	public void updatePlazaaVacante(Integer idPlaza) throws DataAccessException {
		getSqlMapClientTemplate().update("Plaza.updatePlazaaVacante", idPlaza);
		
	}
	
	@Override
	public void updatePlazaaVacanteFunc(Integer idPlaza) throws DataAccessException {
		getSqlMapClientTemplate().update("Plaza.updatePlazaaVacanteFunc", idPlaza);
		
	}

	@Override
	public List<VWCargoDTO> getPlazaVacsxDep(String udCod,Integer anio,Integer tipo, String filtroClasificacion,String filtroGrupOcupacional) {
		Map parameters = new HashMap();
		parameters.put("udCod", udCod);
		parameters.put("anio", anio);
		parameters.put("tipo", tipo);
		parameters.put("filtroClasificacion", filtroClasificacion.toUpperCase());
		parameters.put("filtroGrupOcupacional", filtroGrupOcupacional.toUpperCase());
		return (List<VWCargoDTO>)getSqlMapClientTemplate().queryForList("Plaza.listarPlazaVacxDep", parameters);
	}
	
	@Override
	public List<ServidorAntiguoDTO> selectServidoresAntiguosActivos(Integer udId){
		/*try {
			System.out.println("entro al dao udId:"+udId);*/
			return (List<ServidorAntiguoDTO>)getSqlMapClientTemplate().queryForList("Plaza.listarServidoresAntiguos", udId);	
		/*} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}	*/	
	}
	@Override
	public ServidorAntiguoDTO selectServidorAntiguo(ServidorAntiguoDTO servidorAntSelected) throws DataAccessException {
		return (ServidorAntiguoDTO)getSqlMapClientTemplate().queryForObject("Plaza.obtenerServidorAntiguo", servidorAntSelected);
	}

	@Override
	public List<ServidorAntiguoDTO> selectServidoresAntiguosxAnio(Integer anio,	String udCod, Integer idCargoEstruc,String tipTrabCargoClasif){
		Map parameters = new HashMap();
		parameters.put("anio", anio);
		if(udCod.length()<5){
			parameters.put("udCod", udCod);
		}else{
			parameters.put("udCod", udCod.substring(0, 5));
		}
		parameters.put("idCargoEstruc", idCargoEstruc);
		parameters.put("tipTrabCargoClasif", tipTrabCargoClasif);
		/*try {
			System.out.println("entro al dao udCod:"+udCod);*/
			return (List<ServidorAntiguoDTO>)getSqlMapClientTemplate().queryForList("Plaza.listarServidoresxAnio", parameters);	
		/*} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}*/
	}

	@Override
	public CapUnidad obtenerConsolidadoCap(String ud_cod, Integer anio) {
		Map parameters = new HashMap();
		parameters.put("anio", anio);
		parameters.put("ud_cod", ud_cod);
		return (CapUnidad)getSqlMapClientTemplate().queryForObject("Plaza.consolidadoCap",parameters);
	}

	@Override
	public List<ServidorAntiguoDTO> selectServidoresTotales(Integer anio,String udCod){
		Map parameters = new HashMap();
		parameters.put("anio", anio);
		if(udCod.length()<5){
			parameters.put("udCod", udCod);
		}else{
			parameters.put("udCod", udCod.substring(0, 5));
		}
		/*try {
			System.out.println("entro al dao udCod:"+udCod);*/
			return (List<ServidorAntiguoDTO>)getSqlMapClientTemplate().queryForList("Plaza.listarServidoresTotales", parameters);	
		/*} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}*/
	}

	@Override
	public List<String> obtenerClasificaciones() {
		return getSqlMapClientTemplate().queryForList("Plaza.obtenerClasificaciones");
	}

	@Override
	public List<String> obtenerGruposOcupacionales() {
		return getSqlMapClientTemplate().queryForList("Plaza.obtenerGruposOcupacionales");
	}
}
