package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CurriculumVitaeDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.EstadoCivilDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PuntajeJuradoDTO;

public interface CurriculumVitaeDAO {

	public void insertCV(CurriculumVitaeDTO cv) throws DataAccessException;
	public void deleteCV(Integer cvDni) throws DataAccessException;
	public CurriculumVitaeDTO getCV(String cvDni) throws DataAccessException;
	public List<EstadoCivilDTO> obtenerEstadosCiviles() throws DataAccessException;
	public List<CurriculumVitaeDTO> obtenerCVxConvPlaza(int idConv,int idPlaza, int estado) throws DataAccessException;
	public void actualizarPuntajeCV(CurriculumVitaeDTO cv) throws DataAccessException;
	public List<CurriculumVitaeDTO> selectCVxConvEstadoResultados(Integer idConv) throws DataAccessException;
	public void ingresarPuntajeCV(PuntajeJuradoDTO cv) throws DataAccessException;
	public void updatePuntajeCVxJurado(PuntajeJuradoDTO p) throws DataAccessException;
	public PuntajeJuradoDTO selectPuntajexJurado(PuntajeJuradoDTO puntajeJurado) throws DataAccessException;
	public List<PuntajeJuradoDTO> selectPuntajeJuradoxPostulante(Integer idConv, String dniCV) throws DataAccessException;
	public List<PuntajeJuradoDTO> selectPromedioCVxConvocatoria(Integer idConv)throws DataAccessException;
	public List<CurriculumVitaeDTO> selectGanadoresCvxConvxPlaza(Integer idConv);
	public List<CurriculumVitaeDTO> selectPerdedoresxConvxPlaza(Integer idConv);
	public List<CurriculumVitaeDTO> selectGanadoresPrimeraFase(Integer idConv);
	public List<CurriculumVitaeDTO> selectPerdedoresPrimeraFase(Integer idConv);

}
