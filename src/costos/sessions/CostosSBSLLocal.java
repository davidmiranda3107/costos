package costos.sessions;

import javax.ejb.Local;

import santamaria.sessions.BusinessSBSLLocal;

@Local
public interface CostosSBSLLocal extends BusinessSBSLLocal {

	public long generarNumero(String cntNombre);
}
