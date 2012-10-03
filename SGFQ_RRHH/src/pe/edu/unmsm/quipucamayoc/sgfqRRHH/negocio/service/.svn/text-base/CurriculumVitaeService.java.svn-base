package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CurriculumVitaeDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.EstadoCivilDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PuntajeJuradoDTO;


public interface CurriculumVitaeService {

	public void guardarCV(CurriculumVitaeDTO cv) throws DataAccessException;
	public Boolean existeCV(String cvDni) throws DataAccessException;
	public List<EstadoCivilDTO> obtenerEstadosCiviles() throws DataAccessException;
	public List<CurriculumVitaeDTO> obtenerCVxConvocatoriaPlaza(int idConv, int idPlaza, int estado) throws DataAccessException;
	public void actualizarPuntajeCV(CurriculumVitaeDTO cv) throws DataAccessException;
	public List<CurriculumVitaeDTO> obtenerCVxConvocatoria(Integer idConv) throws DataAccessException;
	public boolean ingresarPuntajeJuradoCV(PuntajeJuradoDTO puntaje) throws DataAccessException;
	public void guardarPuntajeCV(CurriculumVitaeDTO postulanteSeleccionado) throws DataAccessException;
	public List<PuntajeJuradoDTO> obtenerPuntajeJuradoxPostulante(Integer idConv, String dniCV) throws DataAccessException; 
	public List<PuntajeJuradoDTO> obtenerPromedioCVxConvocatoria(Integer idConv) throws DataAccessException;
	public PuntajeJuradoDTO obtenerPuntajexJurado(PuntajeJuradoDTO puntaje) throws DataAccessException;
	public List<CurriculumVitaeDTO> obtenerGanadoresxConvxPlaza(Integer idConv);
	public List<CurriculumVitaeDTO> obtenerPerdedoresxConvxPlaza(Integer idConv);
	public List<CurriculumVitaeDTO> obtenerGanadoresPrimeraFase(Integer idConv);
	public List<CurriculumVitaeDTO> obtenerPerdedoresPrimeraFase(Integer idConv);
	public CurriculumVitaeDTO obtenerCVxDNI(String cvDni);
}
