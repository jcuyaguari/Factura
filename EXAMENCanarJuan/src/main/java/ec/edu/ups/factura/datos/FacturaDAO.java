package ec.edu.ups.factura.datos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.factura.modelo.Factura;

@Stateless
public class FacturaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insertarFactura(Factura factura) {
		em.persist(factura);
	}
	
}
