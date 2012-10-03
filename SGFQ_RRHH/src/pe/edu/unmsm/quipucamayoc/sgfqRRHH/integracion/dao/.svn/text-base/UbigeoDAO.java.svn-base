package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.UbigeoDTO;

public interface UbigeoDAO {

	public List<UbigeoDTO> selectUbigeo() throws DataAccessException;
	public List<UbigeoDTO> selectUbigeoDepartamentos() throws DataAccessException;
	public List<UbigeoDTO> selectUbigeoProvinciasByIdDep(Integer ubiIdNiv1) throws DataAccessException;
	public List<UbigeoDTO> selectUbigeoDistritosByIdProv(Integer ubiIdNiv2) throws DataAccessException;
}
