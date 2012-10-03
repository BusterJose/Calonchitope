package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao;


import org.springframework.dao.DataAccessException;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CargoDTO;

public interface CargoDAO {
	
	public void insertCargo(CargoDTO cargo) throws DataAccessException;
	public void updateCargo(CargoDTO cargo) throws DataAccessException;
	public void deleteCargo(CargoDTO cargo) throws DataAccessException;
	public CargoDTO getCargo(CargoDTO cargo) throws DataAccessException;

}
