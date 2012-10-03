package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.PlazaDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CapUnidad;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ServidorAntiguoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.VWCargoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.PlazaService;

@Service
public class PlazaServiceImpl implements PlazaService {

	@Resource
	PlazaDAO plazadao;
	
	@Override
	public void guardarPlaza(PlazaDTO plaza) throws DataAccessException {
		//plazadao.insertPuesto(plaza);
	}

	@Override
	public void actualizarPlaza(PlazaDTO plaza) throws DataAccessException {
		//plazadao.updatePuesto(plaza);
	}

	@Override
	public void eliminarPlaza(int idplazaser) throws DataAccessException {
		//plazadao.deletePuesto(plaza);
		plazadao.eliminar_AsigServ(idplazaser);
	}

	@Override
	public PlazaDTO obtenerPlaza(PlazaDTO plaza) throws DataAccessException {
		return plazadao.getPuesto(plaza);
	}

	@Override
	public List<PlazaDTO> listarPlazasVacantes() throws DataAccessException {
		return plazadao.getPlazasVacantes();
	}

	@Override
	public List<PlazaDTO> obtenerPlazasxConvocatoria(int idConvocatoria) {
		return plazadao.obtenerPlazasxConvocatoria(idConvocatoria);
	}

	@Override
	public List<VWCargoDTO> listarPlazasVacantesxDep(String udCod,Integer anio, Integer tipo, String filtroClasificacion,String filtroGrupOcupacional) {
		System.out.println("plaza service");
		return plazadao.getPlazaVacsxDep(udCod,anio,tipo,filtroClasificacion,filtroGrupOcupacional);
	}

	@Override
	public List<VWCargoDTO> listarPlazasServidoresxDep(Integer anio,String udCod, String filtroClasificacion,String filtroGrupOcupacional) throws DataAccessException {
		System.out.println("plaza service");
		return plazadao.getPlazaServxDep(anio,udCod,filtroClasificacion,filtroGrupOcupacional);
	}
	@Override
	public List<ServidorAntiguoDTO> listarServidoresAntiguosActivos(Integer anio,Integer udId,String udCod,Integer codCargoClasif,String tipTrabCargoClasif){
		
		if(anio>=2010 && anio<=2013){
			if(codCargoClasif==0 && tipTrabCargoClasif.compareToIgnoreCase("")==0){
				return plazadao.selectServidoresTotales(anio, udCod);
			}else{
				return plazadao.selectServidoresAntiguosxAnio(anio, udCod, codCargoClasif, tipTrabCargoClasif);
			}
		}else{
			return plazadao.selectServidoresAntiguosActivos(udId);
		}
	}
	@Override
	public ServidorAntiguoDTO obtenerServidorAntiguo(ServidorAntiguoDTO servidorAntSelected) throws DataAccessException {
		return plazadao.selectServidorAntiguo(servidorAntSelected);
	}

	@Override
	public List<CapUnidad> obtenerConsolidadoCap(String ud_cod, Integer anio,String udCodElegida) {
		List<CapUnidad> consolidado = new ArrayList<CapUnidad>();
		consolidado.add(plazadao.obtenerConsolidadoCap(udCodElegida, anio));
		consolidado.add(plazadao.obtenerConsolidadoCap(ud_cod, anio));
		System.out.println("consolidado: "+consolidado.get(0).getTotal());
		return consolidado;
	}

	@Override
	public List<String> obtenerClasificaciones() {
		return plazadao.obtenerClasificaciones();
	}

	@Override
	public List<String> obtenerGruposOcupacionales() {
		return plazadao.obtenerGruposOcupacionales();
	}
}
