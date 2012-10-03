package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.CVExpLabDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CVExpLabDTO;

@Repository
public class CVExpLabDAOImpl extends SqlMapClientDaoSupport implements CVExpLabDAO {

	
	@Autowired
	public CVExpLabDAOImpl(SqlMapClient sql) {
		super.setSqlMapClient(sql);
	}

	@Override
	public void insertExpLab(CVExpLabDTO expLab) throws DataAccessException {
		getSqlMapClientTemplate().insert("insertCVExpLab", expLab);
	}

	@Override
	public void deleteExpLab(Integer cvDni) throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().delete("deleteCVExpLab", cvDni);
	}

	@Override
	public List<CVExpLabDTO> getExpLabs(Integer cvDni)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return (List<CVExpLabDTO>)getSqlMapClientTemplate().queryForList("selectCVExpLab", cvDni);
	}

}
