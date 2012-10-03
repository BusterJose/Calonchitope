package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.DependenciaDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.DependenciaDTO;


import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class DependenciaDAOImpl extends SqlMapClientDaoSupport implements DependenciaDAO{

	@Autowired
	public DependenciaDAOImpl(SqlMapClient sql){
		super.setSqlMapClient(sql);
	}
	
	@Override
	public List<DependenciaDTO> getDependencia(Integer udId) throws DataAccessException {
		return (List<DependenciaDTO>)getSqlMapClientTemplate().queryForList("Dependencia.getDependencia", udId);
	}

	@Override
	public List<DependenciaDTO> getDependencia2(Integer udId) throws DataAccessException {
		return (List<DependenciaDTO>)getSqlMapClientTemplate().queryForList("Dependencia.getDependencia2", udId);
	}
	
	@Override
	public List<DependenciaDTO> getDependenciaByUdPad(Integer udPad) throws DataAccessException {
		return (List<DependenciaDTO>)getSqlMapClientTemplate().queryForList("Dependencia.getDependenciaByUdPad", udPad);
	}

	@Override
	public DependenciaDTO obtenerud_cod(Integer udid) throws DataAccessException {
		return (DependenciaDTO)getSqlMapClientTemplate().queryForObject("Dependencia.obtenerud_cod",udid);
	}
	
	public DependenciaDTO obtenerDepxUdcod( String udcod ){		
		Map parameters = new HashMap();
        parameters.put("udcod", udcod);        
        List<DependenciaDTO> resultado= getSqlMapClientTemplate().queryForList("Dependencia.depxudcod",parameters);
        if( resultado.size() > 0 ){
        	return resultado.get(0);
        }
        else{
        	return null;
        }
	}
}
