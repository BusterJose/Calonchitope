package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.RequisitoConvPlazaDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.RequisitoConvPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.TipoRequisitoConvPlazaDTO;
@Repository
public class RequisitoConvPlazaDAOImpl extends SqlMapClientDaoSupport implements RequisitoConvPlazaDAO {
	@Autowired
	public RequisitoConvPlazaDAOImpl(SqlMapClient sql){
		super.setSqlMapClient(sql);
	}
	
	@Override
	public List<RequisitoConvPlazaDTO> getRequistosConvPlaza(ConvocatoriaPlazaDTO convPlaza) throws DataAccessException {
		// TODO Auto-generated method stub
		return (List<RequisitoConvPlazaDTO>) getSqlMapClientTemplate().queryForList("selectReqConvPlaza",convPlaza);
	}

	@Override
	public void insertRequisito(RequisitoConvPlazaDTO reqconvplaza)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("insertReqConvPlaza",reqconvplaza);
		
	}

	@Override
	public void deleteRequisito(RequisitoConvPlazaDTO reqconvplaza)
			throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteReqConvPlaza",reqconvplaza);
		
	}

	@Override
	public void updateRequisito(RequisitoConvPlazaDTO reqconvplaza)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateReqConvPlaza",reqconvplaza);
		
	}

	@Override
	public Integer getIdMaxReq() throws DataAccessException {
		// TODO Auto-generated method stub
		return (Integer) getSqlMapClientTemplate().queryForObject("obtenerMaxidReq");
	}

	@Override
	public List<TipoRequisitoConvPlazaDTO> getTipoRequisitos()
			throws DataAccessException {
		// TODO Auto-generated method stub
		return (List<TipoRequisitoConvPlazaDTO>) getSqlMapClientTemplate().queryForList("selectTipoRequisito");
	}

}
