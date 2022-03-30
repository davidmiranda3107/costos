package costos.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import costos.sessions.CostosSBSLLocal;

import santamaria.controller.ReportController;
import santamaria.controller.SuperController;

public class CostosController extends SuperController {

	@EJB(name = "ejb/CostosSBSL")
	protected CostosSBSLLocal costosLocal;

	public static final String SYSTEM_NAME = "COSTOS";
	protected static final String SYSTEM_RESOURCE_BUNDLE = "msg";

	// area de permisos del sistema
	private boolean perGeneral;

	public CostosController() {
		super();
		setJdbcName("jdbc/santamaria");
		setFrmtRepo(ReportController.REPORT_TYPE_PDF);
		setRptURL("WEB-INF/reportes/");
		setSendLogo(true);
		setDestination(REPORT_PDF_DESTINATION_ATTACHMENT);
	}

	@PostConstruct
	public void init() {
		configPermisos();
	}

	public void configPermisos() {

	}
	
	public String generarNumero(String contador) {
		long correlativo = costosLocal.generarNumero(contador);
		String numero = String.format("%02d", correlativo);
		return numero;
	}
	
	public boolean isPerGeneral() {
		return perGeneral;
	}

	public void setPerGeneral(boolean perGeneral) {
		this.perGeneral = perGeneral;
	}
}
