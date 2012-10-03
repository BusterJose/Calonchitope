package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.VWConvocatoriaDTO;

public interface ConvocatoriaService {

	public List<ConvocatoriaDTO> listarConvocatoriasPorEstadoAnioMes(Integer idEstadoConv, Integer anioConv, Integer mesConv) throws DataAccessException;
	public List<ConvocatoriaDTO> listarConvocEnPlanif(Integer anioConv, Integer mesConv) throws DataAccessException;
	public List<ConvocatoriaDTO> listarConvocEnEconomia(Integer anioConv, Integer mesConv) throws DataAccessException;
	public List<ConvocatoriaDTO> listarConvocEnDGA(Integer anioConv, Integer mesConv) throws DataAccessException;
	public List<ConvocatoriaDTO> listarConvocEnDGABase(Integer anioConv, Integer mesConv) throws DataAccessException;
	public List<ConvocatoriaDTO> listarConvocEnProgBase(Integer anioConv, Integer mesConv) throws DataAccessException;
    public void insertarConvocatoria(ConvocatoriaDTO conv) throws DataAccessException;
	public void actualizarConvocatoria(ConvocatoriaDTO conv) throws DataAccessException;
	public void aprobarPresupuestoConvoc(ConvocatoriaDTO conv) throws DataAccessException;
	public void desaprobarPresupuestoConvoc(ConvocatoriaDTO conv) throws DataAccessException;
	public void aprobarEconomiaConvoc(ConvocatoriaDTO conv) throws DataAccessException;
	public void desaprobarEconomiaConvoc(ConvocatoriaDTO conv) throws DataAccessException;
	public void aprobarDGAConvoc(ConvocatoriaDTO conv) throws DataAccessException;
	public void desaprobarDGAConvoc(ConvocatoriaDTO conv) throws DataAccessException;
	public void aprobarDGABaseConvoc(ConvocatoriaDTO conv) throws DataAccessException;
	public void desaprobarDGABaseConvoc(ConvocatoriaDTO conv) throws DataAccessException;
	public void eliminarConvocatoria(ConvocatoriaDTO conv) throws DataAccessException;
	public Integer obtenerIdMaxConvocatoria() throws DataAccessException;
	public void insertarSolicitudConvocatoria(ConvocatoriaDTO conv)throws DataAccessException;
	public void enviarSolicitud(ConvocatoriaDTO convDTO) throws DataAccessException;
	public List<VWConvocatoriaDTO> listarConvocatoriasActuales() throws DataAccessException;
	public VWConvocatoriaDTO obtenerVWConvocatoria(
			VWConvocatoriaDTO convocatoriaSelected) throws DataAccessException;
	public List<ConvocatoriaDTO> listarConvocatoriasPublicadasyCerradas() throws DataAccessException;
	public List<ConvocatoriaDTO> listarConvocatoriasCerradas() throws DataAccessException;
	public List<ConvocatoriaDTO> listarConvocatoriasEntrevista() throws DataAccessException;
	public void actualizarEstadoConvocatoria(ConvocatoriaDTO convocatoriaSeleccionada);
	public void actualizarJuradosConvocatoria(ConvocatoriaDTO conv);
	public ConvocatoriaDTO obtenerJuradoxConvocatoria(int idConvocatoria);	
}
