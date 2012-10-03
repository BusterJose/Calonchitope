package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.CVGradAcadDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CVGradosAcadDTO;

@Repository
public class CVGradAcadDAOImpl extends SqlMapClientDaoSupport implements CVGradAcadDAO {

	@Autowired
	public CVGradAcadDAOImpl(SqlMapClient sql) {
		super.setSqlMapClient(sql);
	}

	@Override
	public void insertGradAcad(CVGradosAcadDTO gradAcad)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("insertCVGradAcad", gradAcad);
	}

	@Override
	public void deleteGradAcad(Integer cvDni) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteCVGradAcad", cvDni);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CVGradosAcadDTO> getGradAcads(Integer cvDni)
			throws DataAccessException {
		return (List<CVGradosAcadDTO>)getSqlMapClientTemplate().queryForList("selectCVGradAcad", cvDni);
	}
}
