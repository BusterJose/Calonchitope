package pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.CVExpLabDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.CVGradAcadDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.integracion.dao.CurriculumVitaeDAO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.ConvocatoriaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.CurriculumVitaeDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.EstadoCivilDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.PuntajeJuradoDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.CurriculumVitaeService;

@Service
public class CurriculumVitaeServiceImpl implements CurriculumVitaeService {

	@Resource
	CurriculumVitaeDAO cvdao;
	@Resource
	CVExpLabDAO cvExpLavdao;
	@Resource
	CVGradAcadDAO cvGradAcaddao;
	
	@Transactional
	@Override
	public void guardarCV(CurriculumVitaeDTO cv) throws DataAccessException {
		cvdao.insertCV(cv);
		System.out.println("guardo CV");

		for (int i = 0; i < cv.getExpLabs().size(); i++) {
			cv.getExpLabs().get(i).setCvDni(cv.getCvDni());
			cvExpLavdao.insertExpLab(cv.getExpLabs().get(i));
		}
		for (int i = 0; i < cv.getGradsAcads().size(); i++) {
			cv.getGradsAcads().get(i).setCvDni(cv.getCvDni());
			cvGradAcaddao.insertGradAcad(cv.getGradsAcads().get(i));
		}
	}

	@Override
	public Boolean existeCV(String cvDni) throws DataAccessException {
		CurriculumVitaeDTO cv=cvdao.getCV(cvDni);
		Boolean existe=new Boolean(false);
		if (cv!=null) {
			existe=new Boolean(true);
		}
		return existe;
	}

	@Override
	public List<EstadoCivilDTO> obtenerEstadosCiviles() {
		return cvdao.obtenerEstadosCiviles();
	}

	@Override
	public List<CurriculumVitaeDTO> obtenerCVxConvocatoriaPlaza(int idConv,	int idPlaza, int estado) {
		return cvdao.obtenerCVxConvPlaza(idConv,idPlaza, estado);
	}

	@Override
	public void actualizarPuntajeCV(CurriculumVitaeDTO cv) {
		cvdao.actualizarPuntajeCV(cv);
	}

	@Override
	public List<CurriculumVitaeDTO> obtenerCVxConvocatoria(Integer idConv) {
		return cvdao.selectCVxConvEstadoResultados(idConv);		
	}

	@Override
	public boolean ingresarPuntajeJuradoCV(PuntajeJuradoDTO puntaje) {
		PuntajeJuradoDTO p = cvdao.selectPuntajexJurado(puntaje);
		List<PuntajeJuradoDTO> listaPuntajes = obtenerPuntajeJuradoxPostulante(puntaje.getIdConvocatoria(), puntaje.getDniCV());
		if(p!=null){ //existe --> update 
			System.out.println("update");
			cvdao.updatePuntajeCVxJurado(puntaje);			
		}
		else{ 
			if(listaPuntajes.size() < 3){
				//no existe --> insert
				System.out.println("insert");
				cvdao.ingresarPuntajeCV(puntaje);
			}else{
				return false;
			}
		}
		return true;
	}

	@Override
	public void guardarPuntajeCV(CurriculumVitaeDTO postulante) {
		CurriculumVitaeDTO cv=postulante;
		double ptotal=cv.getPuntajeCv()+cv.getPuntajeEntrevista();
		cv.setPuntajeTotal(ptotal);
		cvdao.actualizarPuntajeCV(cv);
		
	}
	public PuntajeJuradoDTO obtenerPuntajexJurado(PuntajeJuradoDTO puntaje){
		return cvdao.selectPuntajexJurado(puntaje);
	}

	@Override
	public List<PuntajeJuradoDTO> obtenerPuntajeJuradoxPostulante(Integer idConv, String dniCV) {
		return cvdao.selectPuntajeJuradoxPostulante(idConv,dniCV);
		
	}

	@Override
	public List<PuntajeJuradoDTO> obtenerPromedioCVxConvocatoria(Integer idConv)
			throws DataAccessException {
	
		return cvdao.selectPromedioCVxConvocatoria(idConv);
	}

	@Override
	public List<CurriculumVitaeDTO> obtenerGanadoresxConvxPlaza(Integer idConv) {
		
		return cvdao.selectGanadoresCvxConvxPlaza(idConv);
	}

	@Override
	public List<CurriculumVitaeDTO> obtenerPerdedoresxConvxPlaza(Integer idConv) {
		
		return cvdao.selectPerdedoresxConvxPlaza(idConv);
	}

	@Override
	public List<CurriculumVitaeDTO> obtenerGanadoresPrimeraFase(Integer idConv) {
		// TODO Auto-generated method stub
		return cvdao.selectGanadoresPrimeraFase(idConv);
	}

	@Override
	public List<CurriculumVitaeDTO> obtenerPerdedoresPrimeraFase(Integer idConv) {
		// TODO Auto-generated method stub
		return cvdao.selectPerdedoresPrimeraFase(idConv);
	}

	@Override
	public CurriculumVitaeDTO obtenerCVxDNI(String cvDni) {
		// TODO Auto-generated method stub
		return cvdao.getCV(cvDni);
	}
}
