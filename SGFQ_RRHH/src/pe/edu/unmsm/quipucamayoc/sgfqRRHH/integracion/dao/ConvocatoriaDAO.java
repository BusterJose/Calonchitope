package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.VWConvocatoriaDTO;

public interface ConvocatoriaDAO {
public List<ConvocatoriaDTO> selectConvocatoriasByEstadoAnioMes(Integer idEstadoConv, Integer anioConv, Integer mesConv)throws DataAccessException;
public void insertConvocatoria(ConvocatoriaDTO conv)throws DataAccessException;
public void insertSolicitudConvocatoria(ConvocatoriaDTO conv) throws DataAccessException;
public void updateConvocatoria(ConvocatoriaDTO conv)throws DataAccessException;
public void deleteConvocatoria(ConvocatoriaDTO conv)throws DataAccessException;
public Integer getIdMaxConvocatoria()throws DataAccessException;
public List<VWConvocatoriaDTO> getConvocatoriasActuales()throws DataAccessException;
public VWConvocatoriaDTO getVWConvocatoria(
		VWConvocatoriaDTO convocatoriaSelected)throws DataAccessException;
public List<ConvocatoriaDTO> obtenerConvocatoriasCerradas()throws DataAccessException;
public List<ConvocatoriaDTO> selectConvocatoriaFaseEntrevista()throws DataAccessException;
public void updateEstadoConv(int estadoConv, int idConvocatoria);
public void updateJuradosConvocatoria(ConvocatoriaDTO conv);
public ConvocatoriaDTO obtenerJuradoxConvocatoria(int idConvocatoria);
public List<ConvocatoriaDTO> obtenerConvocatoriasPublicadasyCerradas()throws DataAccessException;;
}
