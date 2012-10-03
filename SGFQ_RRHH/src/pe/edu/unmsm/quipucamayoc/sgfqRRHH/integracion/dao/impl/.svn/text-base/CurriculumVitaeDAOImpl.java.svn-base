package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.CurriculumVitaeDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CurriculumVitaeDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.EstadoCivilDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PuntajeJuradoDTO;

@Repository
public class CurriculumVitaeDAOImpl extends SqlMapClientDaoSupport implements CurriculumVitaeDAO {

	@Autowired
	public CurriculumVitaeDAOImpl(SqlMapClient sql) {
		super.setSqlMapClient(sql);
	}

	@Override
	public void insertCV(CurriculumVitaeDTO cv) throws DataAccessException {
		getSqlMapClientTemplate().insert("insertCV", cv);
	}

	@Override
	public void deleteCV(Integer cvDni) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteCV", cvDni);
	}

	@Override
	public CurriculumVitaeDTO getCV(String cvDni) throws DataAccessException {
		return (CurriculumVitaeDTO)getSqlMapClientTemplate().queryForObject("selectCV", cvDni);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoCivilDTO> obtenerEstadosCiviles() {
		return (List<EstadoCivilDTO>)getSqlMapClientTemplate().queryForList("obtenerEstadosCiviles");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CurriculumVitaeDTO> obtenerCVxConvPlaza(int idConv, int idPlaza, int estado) {
		HashMap<String, Integer> parametros = new HashMap<String, Integer>();
		List<CurriculumVitaeDTO> list=new ArrayList<CurriculumVitaeDTO>();
		parametros.put("idConvocatoria", idConv);
		parametros.put("idPlaza", idPlaza);
		
		if (estado==7 || estado==8) {
			list= (List<CurriculumVitaeDTO>)getSqlMapClientTemplate().queryForList("obtenerCVxConvPLaza", parametros);	
		}else if (estado==11) {
			list= (List<CurriculumVitaeDTO>)getSqlMapClientTemplate().queryForList("obtenerCVxConvPLazaEntrevista", parametros);
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CurriculumVitaeDTO> selectCVxConvEstadoResultados(Integer idConv)
			throws DataAccessException {
		return (List<CurriculumVitaeDTO>)getSqlMapClientTemplate().queryForList("selectCVestadoResultados", idConv);
	}

	@Override
	public void actualizarPuntajeCV(CurriculumVitaeDTO cv) {
		getSqlMapClientTemplate().update("actualizarPuntajeCV", cv);
	}

	@Override
	public void ingresarPuntajeCV(PuntajeJuradoDTO cv) {
		getSqlMapClientTemplate().insert("insertarPuntajeCV",cv);
	}

	@Override
	public void updatePuntajeCVxJurado(PuntajeJuradoDTO p) {
		getSqlMapClientTemplate().update("updatePuntajeCVxJurado",p);
	}

	@Override
	public PuntajeJuradoDTO selectPuntajexJurado(PuntajeJuradoDTO puntajeJurado) {
		return (PuntajeJuradoDTO)getSqlMapClientTemplate().queryForObject("selectPuntajeJurado", puntajeJurado);
	}

	@Override
	public List<PuntajeJuradoDTO> selectPuntajeJuradoxPostulante(
			Integer idConv, String dniCV) {
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idConvocatoria",idConv );
		parametros.put("dniCV", dniCV);
		return (List<PuntajeJuradoDTO>) getSqlMapClientTemplate().queryForList("selectPuntajeJuradoxPostulante",parametros);
	}

	@Override
	public List<PuntajeJuradoDTO> selectPromedioCVxConvocatoria(Integer idConv)
			throws DataAccessException {
		
		return (List<PuntajeJuradoDTO>) getSqlMapClientTemplate().queryForList("selectPuntajePromCVxConvocatoria",idConv);
	}

	@Override
	public List<CurriculumVitaeDTO> selectGanadoresCvxConvxPlaza(Integer idConv) {
		// TODO Auto-generated method stub
		return (List<CurriculumVitaeDTO>) getSqlMapClientTemplate().queryForList("selectGanadorxConvocatoriaxPlaza", idConv);
	}

	@Override
	public List<CurriculumVitaeDTO> selectPerdedoresxConvxPlaza(Integer idConv) {
		
		return (List<CurriculumVitaeDTO>) getSqlMapClientTemplate().queryForList("selectPerdedorexConvocatoriaxPlaza", idConv);
	}

	@Override
	public List<CurriculumVitaeDTO> selectGanadoresPrimeraFase(Integer idConv) {
		// TODO Auto-generated method stub
		return (List<CurriculumVitaeDTO>) getSqlMapClientTemplate().queryForList("selectGanadoresPrimeraFase", idConv);
	}

	@Override
	public List<CurriculumVitaeDTO> selectPerdedoresPrimeraFase(Integer idConv) {
		// TODO Auto-generated method stub
		return (List<CurriculumVitaeDTO>) getSqlMapClientTemplate().queryForList("selectPerdedoresPrimeraFase", idConv);
	}

}
