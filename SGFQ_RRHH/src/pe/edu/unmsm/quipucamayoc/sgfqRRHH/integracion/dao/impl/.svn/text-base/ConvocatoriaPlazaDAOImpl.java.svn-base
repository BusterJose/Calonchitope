package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.ConvocatoriaPlazaDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaPlazaDTO;
@Repository
public class ConvocatoriaPlazaDAOImpl extends SqlMapClientDaoSupport implements ConvocatoriaPlazaDAO{
    @Autowired
	public ConvocatoriaPlazaDAOImpl(SqlMapClient sql){
		super.setSqlMapClient(sql);
	} 
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ConvocatoriaPlazaDTO> getConvocatoriaxPlazas(ConvocatoriaDTO conv) throws DataAccessException {
		return (List<ConvocatoriaPlazaDTO>)getSqlMapClientTemplate().queryForList("selectConvPlaza",conv);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConvocatoriaPlazaDTO> selectConvPlazaByConv(Integer idConvocatoria) throws DataAccessException {
		return (List<ConvocatoriaPlazaDTO>)getSqlMapClientTemplate().queryForList("selectConvPlazaByConv", idConvocatoria);
	}

	@Override
	public void insertConvocatoriaPlaza(ConvocatoriaPlazaDTO convPlaza)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("insertConvPlaza",convPlaza);
		
	}

	@Override
	public void updateConvocatoriaPlaza(ConvocatoriaPlazaDTO convPlaza)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateConvPlaza",convPlaza);
		
	}

	@Override
	public void deleteConvocatoriaPlaza(ConvocatoriaPlazaDTO convPlaza)
			throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteConvPlaza",convPlaza);
		
	}

	@Override
	public Integer getIdMaxConvPlaza() throws DataAccessException {
		return (Integer) getSqlMapClientTemplate().queryForObject("obtenerMaxidConvPlaza");
	}

}
