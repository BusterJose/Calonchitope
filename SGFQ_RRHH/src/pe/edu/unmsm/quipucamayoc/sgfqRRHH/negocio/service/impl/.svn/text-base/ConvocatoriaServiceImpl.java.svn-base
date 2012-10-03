package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.ConvocatoriaDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.ConvocatoriaPlazaDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaPlazaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.VWConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.ConvocatoriaPlazaService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.ConvocatoriaService;

@Service
public class ConvocatoriaServiceImpl implements ConvocatoriaService {

	@Resource
	ConvocatoriaDAO convDAO;
    @Resource
    ConvocatoriaPlazaDAO convPlazaDAO;
    @Resource
    ConvocatoriaPlazaService convPlazaService;
    
	@Override
	public List<ConvocatoriaDTO> listarConvocatoriasPorEstadoAnioMes(Integer idEstadoConv, Integer anioConv, Integer mesConv) throws DataAccessException {
		return convDAO.selectConvocatoriasByEstadoAnioMes(idEstadoConv, anioConv, mesConv);
	}

	@Override
	public List<ConvocatoriaDTO> listarConvocEnPlanif(Integer anioConv, Integer mesConv) throws DataAccessException {
		System.out.println("Service: listarConvocEnPlanif(" + anioConv + ", " + mesConv + ")");
		//return convDAO.selectConvocatoriasByEstadoAnioMes(2, anioConv, mesConv);
		return listarConvocatoriasPorEstadoAnioMes(2, anioConv, mesConv);
	}

	@Override
	public List<ConvocatoriaDTO> listarConvocEnEconomia(Integer anioConv, Integer mesConv) throws DataAccessException {
		System.out.println("Service: listarConvocEnEconomia(" + anioConv + ", " + mesConv + ")");
		return listarConvocatoriasPorEstadoAnioMes(3, anioConv, mesConv);
	}

	@Override
	public List<ConvocatoriaDTO> listarConvocEnDGA(Integer anioConv, Integer mesConv) throws DataAccessException {
		System.out.println("Service: listarConvocEnDGA(" + anioConv + ", " + mesConv + ")");
		return listarConvocatoriasPorEstadoAnioMes(4, anioConv, mesConv);
	}

	@Override
	public List<ConvocatoriaDTO> listarConvocEnDGABase(Integer anioConv, Integer mesConv) throws DataAccessException {
		System.out.println("Service: listarConvocEnDGABase(" + anioConv + ", " + mesConv + ")");
		return listarConvocatoriasPorEstadoAnioMes(6, anioConv, mesConv);
	}
	
	@Override
	public List<ConvocatoriaDTO> listarConvocEnProgBase(Integer anioConv,
			Integer mesConv) throws DataAccessException {
		return listarConvocatoriasPorEstadoAnioMes(5, anioConv, mesConv);
	}
	
	@Override
	public void insertarConvocatoria(ConvocatoriaDTO conv) throws DataAccessException {
		convDAO.insertConvocatoria(conv);		
	}

	@Override
	public void actualizarConvocatoria(ConvocatoriaDTO conv) throws DataAccessException {
		System.out.println("Service :actualizarConvocatoria(" + conv.getObjetivoConv() + ")");
		convDAO.updateConvocatoria(conv);
	}

	@Override
	public void aprobarPresupuestoConvoc(ConvocatoriaDTO conv) throws DataAccessException {
		System.out.println("Service :aprobarPresupuestoConvoc(" + conv.getObjetivoConv() + ")");
		conv.setIdEstadoConv(3);
		actualizarConvocatoria(conv);
	}

	@Override
	public void desaprobarPresupuestoConvoc(ConvocatoriaDTO conv) throws DataAccessException {
		System.out.println("Service :desaprobarPresupuestoConvoc(" + conv.getObjetivoConv() + ")");
		conv.setIdEstadoConv(1);
		actualizarConvocatoria(conv);
	}

	@Override
	public void aprobarEconomiaConvoc(ConvocatoriaDTO conv) throws DataAccessException {
		System.out.println("Service :aprobarEconomiaConvoc(" + conv.getObjetivoConv() + ")");
		conv.setIdEstadoConv(4);
		actualizarConvocatoria(conv);
	}

	@Override
	public void desaprobarEconomiaConvoc(ConvocatoriaDTO conv) throws DataAccessException {
		System.out.println("Service :desaprobarEconomiaConvoc(" + conv.getObjetivoConv() + ")");
		conv.setIdEstadoConv(2);
		actualizarConvocatoria(conv);
	}

	@Override
	public void aprobarDGAConvoc(ConvocatoriaDTO conv) throws DataAccessException {
		System.out.println("Service :aprobarDGAConvoc(" + conv.getObjetivoConv() + ")");
		conv.setIdEstadoConv(5);
		actualizarConvocatoria(conv);
	}

	@Override
	public void desaprobarDGAConvoc(ConvocatoriaDTO conv) throws DataAccessException {
		System.out.println("Service :desaprobarDGAConvoc(" + conv.getObjetivoConv() + ")");
		conv.setIdEstadoConv(3);
		actualizarConvocatoria(conv);
	}

	@Override
	public void aprobarDGABaseConvoc(ConvocatoriaDTO conv) throws DataAccessException {
		System.out.println("Service :aprobarDGABaseConvoc(" + conv.getObjetivoConv() + ")");
		conv.setIdEstadoConv(7);
		actualizarConvocatoria(conv);
	}

	@Override
	public void desaprobarDGABaseConvoc(ConvocatoriaDTO conv) throws DataAccessException {
		System.out.println("Service :desaprobarDGABaseConvoc(" + conv.getObjetivoConv() + ")");
		conv.setIdEstadoConv(5);
		actualizarConvocatoria(conv);
	}

	@Override
	public void eliminarConvocatoria(ConvocatoriaDTO conv) throws DataAccessException {
		convDAO.deleteConvocatoria(conv);
	}

	@Override
	public Integer obtenerIdMaxConvocatoria() throws DataAccessException {
		return convDAO.getIdMaxConvocatoria();
	}

	@Transactional
	@Override
	public void insertarSolicitudConvocatoria(ConvocatoriaDTO conv) throws DataAccessException {
		
		ConvocatoriaPlazaDTO convPlaza;
		Integer idConv=convDAO.getIdMaxConvocatoria()+1;
		conv.setIdConvocatoria(idConv);
		convDAO.insertSolicitudConvocatoria(conv);
		for (int i = 0; i < conv.getListConvPlaza().size(); i++) {
			convPlaza=conv.getListConvPlaza().get(i);
			convPlaza.setIdConvocatoria(idConv);			
			convPlazaService.insertarConvocatoriaPlaza(convPlaza);
			convPlaza=new ConvocatoriaPlazaDTO();
			
		}
		
		
		
	}

	@Override
	public void enviarSolicitud(ConvocatoriaDTO convDTO) throws DataAccessException {
		actualizarConvocatoria(convDTO);
	}
	@Override
	public List<VWConvocatoriaDTO> listarConvocatoriasActuales()
			throws DataAccessException {
		List<VWConvocatoriaDTO> convs=convDAO.getConvocatoriasActuales();
		for (int i = 0; i < convs.size(); i++) {
			if (convs.get(i).getIdEstadoConv().equals(7)) {
				convs.get(i).setMostrarlinkPostular(new Boolean(true));
			}
			if(convs.get(i).getIdEstadoConv().equals(11)){
				convs.get(i).setMostrarlinkResultados(new Boolean(true));
			}
			if(convs.get(i).getIdEstadoConv().equals(12)){
				convs.get(i).setMostrarlinkResultados(new Boolean(true));
			}
		}
		return convs;
	}
    @Override
	public VWConvocatoriaDTO obtenerVWConvocatoria(
			VWConvocatoriaDTO convocatoriaSelected) throws DataAccessException {
		VWConvocatoriaDTO vwconv=convDAO.getVWConvocatoria(convocatoriaSelected);
		ConvocatoriaDTO conv=new ConvocatoriaDTO();
		conv.setIdConvocatoria(convocatoriaSelected.getIdConvocatoria());
		vwconv.setPlazas(convPlazaService.listarPlazasPorConvocatoria(conv));
		return vwconv;
	}

	@Override
	public List<ConvocatoriaDTO> listarConvocatoriasCerradas() {
		return convDAO.obtenerConvocatoriasCerradas();
	}

	@Override
	public List<ConvocatoriaDTO> listarConvocatoriasEntrevista()
			throws DataAccessException {
		
		return convDAO.selectConvocatoriaFaseEntrevista();
	}

	@Override
	public void actualizarEstadoConvocatoria(ConvocatoriaDTO convocatoriaSeleccionada) {
		convDAO.updateEstadoConv(convocatoriaSeleccionada.getIdEstadoConv(),convocatoriaSeleccionada.getIdConvocatoria());
	}

	@Override
	public void actualizarJuradosConvocatoria(ConvocatoriaDTO conv) {
		convDAO.updateJuradosConvocatoria(conv);
	}

	@Override
	public ConvocatoriaDTO obtenerJuradoxConvocatoria(int idConvocatoria) {
		return convDAO.obtenerJuradoxConvocatoria(idConvocatoria);
	}

	@Override
	public List<ConvocatoriaDTO> listarConvocatoriasPublicadasyCerradas()
			throws DataAccessException {
		// TODO Auto-generated method stub
		return convDAO.obtenerConvocatoriasPublicadasyCerradas() ;
	}

}
