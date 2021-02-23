package ec.edu.ups.factura.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.factura.modelo.Productos;

@Stateless
public class ProductoDAO {

	@PersistenceContext
	private EntityManager em;
	
	public List<Productos> getProductos(String filtro){
		String jpql = "SELECT p FROM Productos p " 
				+ "WHERE descripcion LIKE:filtro";
		Query q = em.createQuery(jpql, Productos.class);
		q.setParameter("filtro", filtro+"%");
		return q.getResultList();

	}
	
	
	public Productos getProductosbyID(int filtro){
            return em.find(Productos.class, filtro);
	}
	
	
}
