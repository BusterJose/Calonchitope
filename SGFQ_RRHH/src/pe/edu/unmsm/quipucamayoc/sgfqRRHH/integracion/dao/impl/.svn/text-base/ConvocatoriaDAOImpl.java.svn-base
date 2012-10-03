package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.VWConvocatoriaDTO;

@Repository
public class ConvocatoriaDAOImpl extends SqlMapClientDaoSupport implements pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.ConvocatoriaDAO{

	@Autowired
	public ConvocatoriaDAOImpl(SqlMapClient sql) {
		super.setSqlMapClient(sql);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ConvocatoriaDTO> selectConvocatoriasByEstadoAnioMes(Integer idEstadoConv, Integer anioConv, Integer mesConv) throws DataAccessException {
		System.out.println("DAO: selectConvocatoriasByEstadoAnioMes(" + idEstadoConv + ", " + anioConv + ", " + mesConv + ")");
		Map parameteres = new HashMap<String, Integer>();
		parameteres.put("idEstadoConv", idEstadoConv);
		parameteres.put("anioConv", anioConv);
		parameteres.put("mesConv", mesConv);
		return (List<ConvocatoriaDTO>)getSqlMapClientTemplate().queryForList("selectConvocatoriasByEstadoAnioMes",parameteres);
	}

	@Override
	public void insertConvocatoria(ConvocatoriaDTO conv)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("insertConvocatoria",conv);
		
	}

	@Override
	public void updateConvocatoria(ConvocatoriaDTO conv) throws DataAccessException {
		System.out.println("DAO: updateConvocatoria(" + conv.getObjetivoConv() + ")");
		getSqlMapClientTemplate().update("updateConvocatoria", conv);
	}

	@Override
	public void deleteConvocatoria(ConvocatoriaDTO conv)
			throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteConvocatoria", conv);
		
	}

	@Override
	public Integer getIdMaxConvocatoria() throws DataAccessException {
		return (Integer)getSqlMapClientTemplate().queryForObject("getMaxidConvocatoria");
	}

	@Override
	public void insertSolicitudConvocatoria(ConvocatoriaDTO conv)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("insertSolicitudConvocatoria",conv);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VWConvocatoriaDTO> getConvocatoriasActuales()
			throws DataAccessException {
		return (List<VWConvocatoriaDTO>)getSqlMapClientTemplate().queryForList("getConvocatoriasActuales");
	}

	@Override
	public VWConvocatoriaDTO getVWConvocatoria(
			VWConvocatoriaDTO convocatoriaSelected) throws DataAccessException {
		return (VWConvocatoriaDTO)getSqlMapClientTemplate().queryForObject("getVWConvocatoria", convocatoriaSelected.getIdConvocatoria());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConvocatoriaDTO> obtenerConvocatoriasCerradas() {
		return (List<ConvocatoriaDTO>)getSqlMapClientTemplate().queryForList("obtenerConvocatoriasCerradas");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConvocatoriaDTO> selectConvocatoriaFaseEntrevista()
			throws DataAccessException {
		return (List<ConvocatoriaDTO>) getSqlMapClientTemplate().queryForList("selectConvFaseEntrevista");
	}

	@Override
	public void updateEstadoConv(int estadoConv, int idConvocatoria) {
		HashMap<String, Integer> parametros = new HashMap<String, Integer>();
		parametros.put("idConvocatoria", idConvocatoria);
		parametros.put("estadoConv", estadoConv);
		getSqlMapClientTemplate().update("updateEstadoConvocatoria",parametros);
	}

	@Override
	public void updateJuradosConvocatoria(ConvocatoriaDTO conv) {
		getSqlMapClientTemplate().update("updateJuradosConvocatoria", conv);
	}

	@Override
	public ConvocatoriaDTO obtenerJuradoxConvocatoria(int idConvocatoria) {
		return (ConvocatoriaDTO) getSqlMapClientTemplate().queryForObject("obtenerJuradosxConvocatoria", idConvocatoria);
	}

	@Override
	public List<ConvocatoriaDTO> obtenerConvocatoriasPublicadasyCerradas()
			throws DataAccessException {
		return (List<ConvocatoriaDTO>)getSqlMapClientTemplate().queryForList("obtenerConvocatoriasPublicadasCerradas");
	}
}
