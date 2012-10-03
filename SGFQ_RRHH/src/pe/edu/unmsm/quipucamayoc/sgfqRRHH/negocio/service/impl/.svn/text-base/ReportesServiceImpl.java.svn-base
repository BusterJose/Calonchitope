package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.ReportesDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServidorPAPDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.ReportesService;

@Service
public class ReportesServiceImpl implements ReportesService {

	@Resource
	private ReportesDAO reporteDAO; 
	
	public ReportesServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ServidorPAPDTO> obtenerPAP(int anio, int udid) {
		// TODO Auto-generated method stub
		return reporteDAO.obtenerPAP(anio, udid);
	}

}
