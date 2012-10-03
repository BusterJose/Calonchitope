package pe.edu.unmsm.quipucamayoc.sgfqRRHH.presentacion.listController;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.MethodExpressionActionListener;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.MenuModel;
import org.primefaces.model.TreeNode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.dto.DependenciaDTO;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.negocio.service.DependenciaService;
import pe.edu.unmsm.quipucamayoc.sgfqRRHH.presentacion.controller.login.LoginController;

@Controller
@Scope("session")
public class ListasController {
	
	@Resource
	DependenciaService depServ;
	@Resource
	LoginController loginController;
	/*********ATRIBUTOS************/
	private TreeNode root;
	private TreeNode root2;
	private Boolean mostrarDependencia;
	private List<DependenciaDTO> listDep;
	private List<DependenciaDTO> listDep2;
	private MenuModel menuSGRRHH;
	private Integer udId;

	
	@PostConstruct
	public void inicializar() {
		//cargarArbol();
		/*******creando menu*******/
		menuSGRRHH=new DefaultMenuModel();
			/*******creando submenu mantenimiento*************/

			if(loginController.getRol().equals("ROLE_ADMIN")){
				menuRolAdmin();	
			}else if(loginController.getRol().equals("ROLE_ADMIN_DEP")){
				menuRolAdminDep();
			}
			cargarArbolIni();
	}
	private void menuRolAdminDep() {
		/*******creando submenu procesos*************/
		Submenu subMenuMant=new Submenu();
		subMenuMant.setLabel("Mantenimiento");
		menuSGRRHH.addSubmenu(subMenuMant);
		Submenu subMenuProc=new Submenu();
		subMenuProc.setLabel("Procesos");
		menuSGRRHH.addSubmenu(subMenuProc);
			Submenu subMenuGestion=new Submenu();
			subMenuGestion.setLabel("Gestion y Escalafon");
			Submenu subMenuRemun=new Submenu();
			subMenuRemun.setLabel("Remuneraciones");
			subMenuProc.getChildren().add(subMenuGestion);
			subMenuProc.getChildren().add(subMenuRemun);			
				/*MenuItem menuItem9=new MenuItem();
				ExpressionFactory factory9 = FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
				MethodExpression methodsexpression9 = factory9.createMethodExpression(FacesContext.getCurrentInstance().getELContext(),
						"#{loginController.iraConsulServidor}", Void.TYPE, new Class[0]);
				menuItem9.setActionExpression(methodsexpression9);
				menuItem9.setValue("Servidores");
				menuItem9.setId("idmenuItem10");	
				menuItem9.setAjax(false);
				subMenuGestion.getChildren().add(menuItem9);*/
			
				MenuItem menuItem8=new MenuItem();
				ExpressionFactory factory8 = FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
				MethodExpression methodsexpression8 = factory8.createMethodExpression(FacesContext.getCurrentInstance().getELContext(),
						"#{loginController.iraMantePlazas}", Void.TYPE, new Class[0]);
				menuItem8.setActionExpression(methodsexpression8);
				menuItem8.setValue("Cuadro Nominativo");
				menuItem8.setId("idmenuItem9");			
				menuItem8.setAjax(false);
				subMenuGestion.getChildren().add(menuItem8);
	
				/*MenuItem menuItem=new MenuItem();
				ExpressionFactory factory =   FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
				MethodExpression methodsexpression = factory.createMethodExpression(FacesContext.getCurrentInstance().getELContext(),
						"#{envioSolicitudController.iraEnvSolConvocatoria}", Void.TYPE, new Class[0]);
				menuItem.setActionExpression(methodsexpression);
				menuItem.setValue("Solicitud de Convocatorias");
				menuItem.setId("idmenuItem");
				menuItem.setAjax(false);
				subMenuGestion.getChildren().add(menuItem);	*/	
				
			Submenu subMenuReport=new Submenu();
			subMenuReport.setLabel("Reportes");
			menuSGRRHH.addSubmenu(subMenuReport);
				Submenu subMenuGestionReport=new Submenu();
				subMenuGestionReport.setLabel("Gestion y Escalafon");
				subMenuReport.getChildren().add(subMenuGestionReport);
				
				MenuItem menuItem9=new MenuItem();
				ExpressionFactory factory9 = FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
				MethodExpression methodsexpression9 = factory9.createMethodExpression(FacesContext.getCurrentInstance().getELContext(),
						"#{loginController.iraPAP}", Void.TYPE, new Class[0]);
				menuItem9.setActionExpression(methodsexpression9);
				menuItem9.setValue("Cuadro Nominativo");
				menuItem9.setId("idmenuItem10");			
				menuItem9.setAjax(false);
				subMenuGestionReport.getChildren().add(menuItem9);
	}
	
	private void menuRolAdmin() {
		/*******creando submenu procesos*************/
		Submenu subMenuMant=new Submenu();
		subMenuMant.setLabel("Mantenimiento");
		menuSGRRHH.addSubmenu(subMenuMant);
		Submenu subMenuProc=new Submenu();
		subMenuProc.setLabel("Procesos");
		menuSGRRHH.addSubmenu(subMenuProc);
			Submenu subMenuGestion=new Submenu();
			subMenuGestion.setLabel("Gestion y Escalafon");
			Submenu subMenuRemun=new Submenu();
			subMenuRemun.setLabel("Remuneraciones");
			subMenuProc.getChildren().add(subMenuGestion);
			subMenuProc.getChildren().add(subMenuRemun);
				/*MenuItem menuItem9=new MenuItem();
				ExpressionFactory factory9 = FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
				MethodExpression methodsexpression9 = factory9.createMethodExpression(FacesContext.getCurrentInstance().getELContext(),
						"#{loginController.iraConsulServidor}", Void.TYPE, new Class[0]);
				menuItem9.setActionExpression(methodsexpression9);
				menuItem9.setValue("Servidores");
				menuItem9.setId("idmenuItem10");	
				menuItem9.setAjax(false);
				subMenuGestion.getChildren().add(menuItem9);*/
			
				MenuItem menuItem8=new MenuItem();
				ExpressionFactory factory8 = FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
				MethodExpression methodsexpression8 = factory8.createMethodExpression(FacesContext.getCurrentInstance().getELContext(),
						"#{loginController.iraMantePlazas}", Void.TYPE, new Class[0]);
				menuItem8.setActionExpression(methodsexpression8);
				menuItem8.setValue("Cuadro Nominativo");
				menuItem8.setId("idmenuItem9");
				menuItem8.setAjax(false);
				subMenuGestion.getChildren().add(menuItem8);		
				
				MenuItem menuItem1=new MenuItem();
				ExpressionFactory factory1 =   FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
				MethodExpression methodsexpression1 = factory1.createMethodExpression(FacesContext.getCurrentInstance().getELContext(),
						"#{convocatoriaController.iraAprobarPresupuesto}", Void.TYPE, new Class[0]);
				menuItem1.setActionExpression(methodsexpression1);
				menuItem1.setValue("Autorizacion de presupuesto");
				menuItem1.setId("idmenuItem2");
				menuItem1.setAjax(false);
				subMenuGestion.getChildren().add(menuItem1);
				
				MenuItem menuItem2=new MenuItem();
				ExpressionFactory factory2 =   FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
				MethodExpression methodsexpression2 = factory2.createMethodExpression(FacesContext.getCurrentInstance().getELContext(),
						"#{convocatoriaController.iraAprobarEconomia}", Void.TYPE, new Class[0]);
				menuItem2.setActionExpression(methodsexpression2);
				menuItem2.setValue("Autorizacion Economica");
				menuItem2.setId("idmenuItem3");
				menuItem2.setAjax(false);
				subMenuGestion.getChildren().add(menuItem2);
				
				MenuItem menuItem3=new MenuItem();
				ExpressionFactory factory3 =   FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
				MethodExpression methodsexpression3 = factory3.createMethodExpression(FacesContext.getCurrentInstance().getELContext(),
						"#{convocatoriaController.iraAprobarDGA}", Void.TYPE, new Class[0]);
				menuItem3.setActionExpression(methodsexpression3);
				menuItem3.setValue("Autorizacion de gasto");
				menuItem3.setId("idmenuItem4");
				menuItem3.setAjax(false);
				subMenuGestion.getChildren().add(menuItem3);
				
				MenuItem menuItem4=new MenuItem();
				ExpressionFactory factory4 =   FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
				MethodExpression methodsexpression4 = factory4.createMethodExpression(FacesContext.getCurrentInstance().getELContext(),
						"#{programacionBaseController.iraProgramarBase}", Void.TYPE, new Class[0]);
				menuItem4.setActionExpression(methodsexpression4);
				menuItem4.setValue("Programacion de Bases");
				menuItem4.setId("idmenuItem5");
				menuItem4.setAjax(false);
				subMenuGestion.getChildren().add(menuItem4);
				
				MenuItem menuItem5=new MenuItem();
				ExpressionFactory factory5 =   FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
				MethodExpression methodsexpression5 = factory5.createMethodExpression(FacesContext.getCurrentInstance().getELContext(),
						"#{convocatoriaController.iraAprobarBaseDGA}", Void.TYPE, new Class[0]);
				menuItem5.setActionExpression(methodsexpression5);
				menuItem5.setValue("Aprobacion de Bases de Convocatorias(DGA)");
				menuItem5.setId("idmenuItem6");
				menuItem5.setAjax(false);
				subMenuGestion.getChildren().add(menuItem5);
				
				MenuItem menuItem6=new MenuItem();
				ExpressionFactory factory6 =   FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
				MethodExpression methodsexpression6 = factory6.createMethodExpression(FacesContext.getCurrentInstance().getELContext(),
						"#{calificarCVController.iraCalificarCV}", Void.TYPE, new Class[0]);
				menuItem6.setActionExpression(methodsexpression6);
				menuItem6.setValue("Calificaciones CVs");
				menuItem6.setId("idmenuItem7");
				menuItem6.setAjax(false);
				subMenuGestion.getChildren().add(menuItem6);
				
				MenuItem menuItem7=new MenuItem();
				ExpressionFactory factory7 = FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
				MethodExpression methodsexpression7 = factory7.createMethodExpression(FacesContext.getCurrentInstance().getELContext(),
						"#{calificarCVController.iraCalificaEntrevista}", Void.TYPE, new Class[0]);
				menuItem7.setActionExpression(methodsexpression7);
				menuItem7.setValue("Calificaciones Entrevista");
				menuItem7.setId("idmenuItem8");
				menuItem7.setAjax(false);
				subMenuGestion.getChildren().add(menuItem7);
				
				
				
				Submenu subMenuReport=new Submenu();
				subMenuReport.setLabel("Reportes");
				menuSGRRHH.addSubmenu(subMenuReport);
					Submenu subMenuGestionReport=new Submenu();
					subMenuGestionReport.setLabel("Gestion y Escalafon");
					subMenuReport.getChildren().add(subMenuGestionReport);
					
					MenuItem menuItem9=new MenuItem();
					ExpressionFactory factory9 = FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
					MethodExpression methodsexpression9 = factory9.createMethodExpression(FacesContext.getCurrentInstance().getELContext(),
							"#{loginController.iraPAP}", Void.TYPE, new Class[0]);
					menuItem9.setActionExpression(methodsexpression9);
					menuItem9.setValue("Cuadro Nominativo");
					menuItem9.setId("idmenuItem10");			
					menuItem9.setAjax(false);
					subMenuGestionReport.getChildren().add(menuItem9);
	}
	
	/**********SOPORTE************/
	public void cargarArbol(ActionEvent ev){
		cargarArbolIni();
	}
	private void cargarArbolIni() {
		setMostrarDependencia(new Boolean(true));
		System.out.println("Controlador cargarArbol en listaController");
		Integer numDep;
		Integer numDep2;
		DependenciaDTO depPad=new DependenciaDTO();
		
		depPad.setUdCod("root");
		depPad.setUdDesc("ROOT");
		depPad.setUdId(1);
		
		udId=loginController.getUsuDep().getUdId();
		System.out.println("el udid es:" + udId);
		listDep=depServ.listarDependencias(getUdId(),7);
		listDep2=depServ.listarDependencias(getUdId(),2);
		numDep = listDep.size();
		numDep2 = listDep2.size();
		listDep.get(0).setUdPad(1);
		listDep2.get(0).setUdPad(1);
		listDep.add(depPad);
		listDep2.add(depPad);
		
		numDep = listDep.size();
		numDep2 = listDep2.size();
		root=new DefaultTreeNode(listDep.get(numDep-1), null);
		agregarHijosArbol(listDep.get(numDep-1),root);
		root2=new DefaultTreeNode(listDep2.get(numDep2-1), null);
		agregarHijosArbol2(listDep2.get(numDep2-1),root2);
	}

	public void agregarHijosArbol(DependenciaDTO depPadre, TreeNode nodoPadre){
		List<DependenciaDTO> hijos = new ArrayList<DependenciaDTO>();
		
		for (int i = 0; i < listDep.size()-1; i++) {
			DependenciaDTO dep = listDep.get(i);	
			if(dep.getUdPad().equals(depPadre.getUdId())) {
				hijos.add(dep);
			}
		}
		if (hijos.size()!=0) { 
			for (int i = 0; i < hijos.size(); i++) {
				TreeNode nodoDep = new DefaultTreeNode(hijos.get(i), nodoPadre);
				agregarHijosArbol(hijos.get(i),nodoDep);
			}
		}
	}
	
	public void agregarHijosArbol2(DependenciaDTO depPadre, TreeNode nodoPadre){
		List<DependenciaDTO> hijos = new ArrayList<DependenciaDTO>();
		
		for (int i = 0; i < listDep2.size()-1; i++) {
			DependenciaDTO dep = listDep2.get(i);	
			if(dep.getUdPad().equals(depPadre.getUdId())) {
				hijos.add(dep);
			}
		}
		if (hijos.size()!=0) { 
			for (int i = 0; i < hijos.size(); i++) {
				TreeNode nodoDep = new DefaultTreeNode(hijos.get(i), nodoPadre);
				agregarHijosArbol2(hijos.get(i),nodoDep);
			}
		}
	}
	
	/*********GETTERS Y SETTERS**************/
	public TreeNode getRoot() {
		return root;
	}
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public TreeNode getRoot2() {
		return root2;
	}
	public void setRoot2(TreeNode root2) {
		this.root2 = root2;
	}
	public List<DependenciaDTO> getListDep() {
		return listDep;
	}

	public void setListDep(List<DependenciaDTO> listDep) {
		this.listDep = listDep;
	}

	public List<DependenciaDTO> getListDep2() {
		return listDep2;
	}
	public void setListDep2(List<DependenciaDTO> listDep2) {
		this.listDep2 = listDep2;
	}
	public Boolean getMostrarDependencia() {
		return mostrarDependencia;
	}

	public void setMostrarDependencia(Boolean mostrarDependencia) {
		this.mostrarDependencia = mostrarDependencia;
	}

	public MenuModel getMenuSGRRHH() {
		return menuSGRRHH;
	}

	public void setMenuSGRRHH(MenuModel menuSGRRHH) {
		this.menuSGRRHH = menuSGRRHH;
	}
	public Integer getUdId() {
		return udId;
	}
	public void setUdId(Integer udId) {
		this.udId = udId;
	}
	
}
