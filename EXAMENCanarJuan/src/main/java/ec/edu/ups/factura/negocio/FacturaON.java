package ec.edu.ups.factura.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.factura.datos.FacturaDAO;
import ec.edu.ups.factura.datos.ProductoDAO;
import ec.edu.ups.factura.modelo.Factura;
import ec.edu.ups.factura.modelo.Productos;

@Stateless
public class FacturaON {

	@Inject
	FacturaDAO facturadao;
	
	@Inject
	ProductoDAO producdao;
	
	public void guardarFactura(Factura fac) {
		facturadao.insertarFactura(fac);
	}
	
	public List<Productos> getProductosByFiltro(String filtro){
		return producdao.getProductos(filtro);
		
	}
	
	public Productos getProductosbyID(int filtro){
        return producdao.getProductosbyID(filtro);
}

	
}
