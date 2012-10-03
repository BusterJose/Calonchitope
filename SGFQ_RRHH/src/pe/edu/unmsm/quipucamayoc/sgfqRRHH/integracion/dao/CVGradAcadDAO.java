package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CVGradosAcadDTO;

public interface CVGradAcadDAO {
	public void insertGradAcad(CVGradosAcadDTO gradAcad) throws DataAccessException;
	public void deleteGradAcad(Integer cvDni) throws DataAccessException;
	public List<CVGradosAcadDTO> getGradAcads(Integer cvDni) throws DataAccessException;

}
