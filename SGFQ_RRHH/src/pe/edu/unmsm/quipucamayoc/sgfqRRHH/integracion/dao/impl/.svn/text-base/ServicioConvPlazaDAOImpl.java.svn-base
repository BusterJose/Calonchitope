package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.ServicioConvPlazaDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServicioConvPlazaDTO;
@Repository
public class ServicioConvPlazaDAOImpl extends SqlMapClientDaoSupport implements ServicioConvPlazaDAO{
	@Autowired
	public ServicioConvPlazaDAOImpl(SqlMapClient sql){
		super.setSqlMapClient(sql);
	}
	
	@Override
	public List<ServicioConvPlazaDTO> getServiciosConvPlaza(ConvocatoriaPlazaDTO convplaza) throws DataAccessException {
		// TODO Auto-generated method stub
		return (List<ServicioConvPlazaDTO>) getSqlMapClientTemplate().queryForList("selectServicioConvPlaza",convplaza);
	}

	@Override
	public void insertServicios(ServicioConvPlazaDTO servconvplaza)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("insertServConvPlaza",servconvplaza);
		
	}

	@Override
	public void deleteServicios(ServicioConvPlazaDTO servconvplaza)
			throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteServConvPlaza",servconvplaza);
		
	}

	@Override
	public void updateServicios(ServicioConvPlazaDTO servconvplaza)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateServConvPlaza",servconvplaza);
		
	}

	@Override
	public Integer getIdMaxServicios() throws DataAccessException {
		return (Integer) getSqlMapClientTemplate().queryForObject("obtenerMaxidServConvPlaza");
	}

}
