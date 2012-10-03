package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.UbigeoDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.UbigeoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.UbigeoService;

@Service
public class UbigeoServiceImpl implements UbigeoService{

	@Resource
	UbigeoDAO ubiDAO;
	
	@Override
	public List<UbigeoDTO> listarUbigeos() throws DataAccessException {
		System.out.println("Service - listarUbigeos");
		return ubiDAO.selectUbigeo();
	}

	@Override
	public List<UbigeoDTO> listarDepartamentos() throws DataAccessException {
		System.out.println("Service - listarDepartamentos");
		return ubiDAO.selectUbigeoDepartamentos();
	}

	@Override
	public List<UbigeoDTO> listarProvinciasPorDepartamento(UbigeoDTO departamento) throws DataAccessException {
		System.out.println("Service - listarProvinciasPorDepartamento");
		return ubiDAO.selectUbigeoProvinciasByIdDep(departamento.getUbiId());
	}

	@Override
	public List<UbigeoDTO> listarDistritosPorProvincia(UbigeoDTO provincia) throws DataAccessException {
		System.out.println("Service - listarDistritosPorDepartamento");
		return ubiDAO.selectUbigeoDistritosByIdProv(provincia.getUbiId());
	}

	

}
