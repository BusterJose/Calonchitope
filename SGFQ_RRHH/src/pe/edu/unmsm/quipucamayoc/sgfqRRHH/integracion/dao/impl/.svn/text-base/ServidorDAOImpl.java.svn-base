package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.ServidorDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServidorAntiguoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServidorDTO;

@Repository
public class ServidorDAOImpl extends SqlMapClientDaoSupport implements ServidorDAO, Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	public ServidorDAOImpl(SqlMapClient sql) {
		super.setSqlMapClient(sql);
	}
	
	@Override
	public List<ServidorDTO> selectServidores() {
		return (List<ServidorDTO>)getSqlMapClientTemplate().queryForList("servidor.obtenerServidores");
	}
	
	@Override
	public List<ServidorDTO> buscarServidorXApeNomb(String materno,String paterno,String nombre)throws DataAccessException{
		Map parameters= new HashMap();
		parameters.put("materno", materno);
		parameters.put("paterno", paterno);
		parameters.put("nombre", nombre);
		return (List<ServidorDTO>)getSqlMapClientTemplate().queryForList("servidor.buscarServidorXApeNomb", parameters);		
	}
	@Override
	public List<ServidorDTO> buscarServidorXDni(int dni)throws DataAccessException{
		return(List<ServidorDTO>) getSqlMapClientTemplate().queryForList("servidor.buscarServidorXDni", dni);		
	}
}
