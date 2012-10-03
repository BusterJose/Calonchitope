package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.UbigeoDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CargoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.UbigeoDTO;

@Repository
public class UbigeoDAOImpl extends SqlMapClientDaoSupport implements UbigeoDAO{

	@Autowired
	public UbigeoDAOImpl(SqlMapClient sql) {
		super.setSqlMapClient(sql);
	}
	
	@Override
	public List<UbigeoDTO> selectUbigeo() throws DataAccessException {
		System.out.println("DAO - selectUbigeo");
		return (List<UbigeoDTO>)getSqlMapClientTemplate().queryForList("selectUbigeo");
	}

	@Override
	public List<UbigeoDTO> selectUbigeoDepartamentos() throws DataAccessException {
		System.out.println("DAO - selectUbigeoDepartamentos");
		return (List<UbigeoDTO>)getSqlMapClientTemplate().queryForList("selectUbigeoDepartamentos");
	}

	@Override
	public List<UbigeoDTO> selectUbigeoProvinciasByIdDep(Integer ubiIdNiv1) throws DataAccessException {
		System.out.println("DAO - selectUbigeoProvinciasByIdDep");
		return (List<UbigeoDTO>)getSqlMapClientTemplate().queryForList("selectUbigeoProvinciasByIdDep", ubiIdNiv1);
	}

	@Override
	public List<UbigeoDTO> selectUbigeoDistritosByIdProv(Integer ubiIdNiv2) throws DataAccessException {
		System.out.println("DAO - selectUbigeoDistritosByIdProv");
		return (List<UbigeoDTO>)getSqlMapClientTemplate().queryForList("selectUbigeoDistritosByIdProv", ubiIdNiv2);
	}

}
