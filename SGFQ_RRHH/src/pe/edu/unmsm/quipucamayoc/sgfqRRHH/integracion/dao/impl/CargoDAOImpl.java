package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.CargoDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CargoDTO;

@Repository
public class CargoDAOImpl extends SqlMapClientDaoSupport implements CargoDAO  {

	@Autowired
	public CargoDAOImpl(SqlMapClient sql) {
		super.setSqlMapClient(sql);
	}

	@Override
	public void insertCargo(CargoDTO cargo) throws DataAccessException {
		getSqlMapClientTemplate().insert("insertCargo",cargo);
	}

	@Override
	public void updateCargo(CargoDTO cargo) throws DataAccessException {
		getSqlMapClientTemplate().update("updateCargo", cargo);
	}

	@Override
	public void deleteCargo(CargoDTO cargo) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteCargo", cargo);
	}

	@Override
	public CargoDTO getCargo(CargoDTO cargo) throws DataAccessException {
		return (CargoDTO)getSqlMapClientTemplate().queryForObject("selectCargo", cargo);
	}
}
