package pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao;

import java.util.List;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServidorPAPDTO;

public interface ReportesDAO {
	public List<ServidorPAPDTO>obtenerPAP(int anio,int udid);
}
