package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.PlazaServidorDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PlazaServidorEstadoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PlazaServidorDTO;

@Repository
public class PlazaServidorDAOImpl extends SqlMapClientDaoSupport implements PlazaServidorDAO {

	@Autowired
	public PlazaServidorDAOImpl(SqlMapClient sql) {
		super.setSqlMapClient(sql);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertPuestoTrab(PlazaServidorDTO puestoTrab)
			throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("PuestoTrabajador.insertPuestoTrab", puestoTrab);
	}

	@Override
	public void updatePuestoTrab(PlazaServidorDTO puestoTrab)
			throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("PuestoTrabajador.updatePuestoTrab", puestoTrab);
	}

	@Override
	public void deletePuestoTrab(Integer idPlazaServidor)
			throws DataAccessException {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().delete("PuestoTrabajador.deletePuestoTrab", idPlazaServidor);
	}

	@Override
	public PlazaServidorDTO getPuestoTrab(Integer idPlazaServidor)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return (PlazaServidorDTO)getSqlMapClientTemplate().queryForObject("PuestoTrabajador.selectPuestoTrab", idPlazaServidor);
	}

	@Override
	public void delePuestoTrabxPlaza(Integer idPlaza)
			throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("Eliminado el delePuestoTrabxPlaza: " + idPlaza);
		getSqlMapClientTemplate().delete("PuestoTrabajador.deletePuestoTrabxPlaza", idPlaza);
	}

	@Override
	public void updateFechaFin(Integer idPlaza,PlazaServidorDTO puestoTrab) throws DataAccessException {
		// TODO Auto-generated method stub
		Map parameters = new HashMap();
        parameters.put("idPlaza", idPlaza);
        parameters.put("fechaFin", puestoTrab.getFechaFin());
		System.out.println("CAmbiando la fecha de FIn: " + idPlaza +"     " + puestoTrab.getFechaFin());
		getSqlMapClientTemplate().update("PuestoTrabajador.updateFechaFin",parameters);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlazaServidorEstadoDTO> obtenerEstadosdePlazaServidor(Integer estadoPlaza) {
		return getSqlMapClientTemplate().queryForList("PuestoTrabajador.obtenerEstadosdePlazaServidor",estadoPlaza);
		
	}
	
	

}
