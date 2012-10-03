package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.impl;

import java.sql.SQLClientInfoException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.ReportesDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServidorPAPDTO;

@Repository
public class ReportesDAOImpl extends SqlMapClientDaoSupport implements ReportesDAO {

	@Autowired
	public ReportesDAOImpl(SqlMapClient sql) {
		super.setSqlMapClient(sql);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<ServidorPAPDTO> obtenerPAP(int anio, int udid) {
		Map parametros = new HashMap();
		parametros.put("anio", anio);
		parametros.put("udid",udid);
		return getSqlMapClientTemplate().queryForList("reportes.obtenerPAP", parametros);
	}

}
