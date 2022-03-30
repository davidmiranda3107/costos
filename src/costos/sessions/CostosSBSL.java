package costos.sessions;

import costos.entities.Contador;

import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import santamaria.sessions.BusinessSBSL;

/**
 * Session Bean implementation class CostosSBSL
 */
@Stateless
public class CostosSBSL extends BusinessSBSL implements CostosSBSLLocal {

    public CostosSBSL() {
        
    }
    
    public long generarNumero(String cntNombre) {
		Contador num = null;
		em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		try {
			etx.begin();
			String sql = "select * from santamaria.contador where cnt_nombre = '"
					+ cntNombre + "' for update";
			Query q = em.createNativeQuery(sql, Contador.class);
			num = (Contador) q.getSingleResult();
			if (num != null) {
				num.setCntValor(num.getCntValor().add(BigDecimal.ONE));
			}
			em.merge(num);
			em.flush();
			etx.commit();
		} catch (NoResultException e) {
			try {
				num = new Contador();
				Query q1 = em
						.createQuery("select max(c.cntId) from Contador c");
				num.setCntId(Long.valueOf(q1.getSingleResult().toString()) + 1);
				num.setCntNombre(cntNombre);
				num.setCntValor(BigDecimal.ONE);
				num.setCntDescripcion("CONTADOR DE " + cntNombre);
				em.persist(num);
				em.flush();
				etx.commit();
			} catch (Exception e1) {
				if (etx != null) {
					etx.rollback();
				}
				e1.printStackTrace();
			}
		} catch (Exception ex) {
			if (etx != null) {
				etx.rollback();
			}
			ex.printStackTrace();
		} finally {
			em.clear();
			em.close();
		}
		return Long.parseLong(String.valueOf(num.getCntValor()));
	}

}
