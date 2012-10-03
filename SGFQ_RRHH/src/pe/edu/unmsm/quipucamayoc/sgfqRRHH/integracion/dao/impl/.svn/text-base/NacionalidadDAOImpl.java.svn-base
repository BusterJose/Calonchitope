package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.NacionalidadDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.NacionalidadDTO;

@Repository
public class NacionalidadDAOImpl extends SqlMapClientDaoSupport implements NacionalidadDAO {

	
	@Autowired
	public NacionalidadDAOImpl(SqlMapClient sql) {
		super.setSqlMapClient(sql);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<NacionalidadDTO> getPaises() throws DataAccessException {
		// TODO Auto-generated method stub
		return (List<NacionalidadDTO>)getSqlMapClientTemplate().queryForList("selectNacionalidad");
	}

}
