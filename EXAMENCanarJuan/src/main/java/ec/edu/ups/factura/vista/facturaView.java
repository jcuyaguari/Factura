package ec.edu.ups.factura.vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.factura.modelo.Detalle;
import ec.edu.ups.factura.modelo.Factura;
import ec.edu.ups.factura.modelo.Productos;
import ec.edu.ups.factura.negocio.FacturaON;

@WebServlet("/view")
public class facturaView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FacturaON facturaOn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//try {
			
			response.getWriter().println("Bienvenido");
			
			Factura f = new Factura();
			f.setNumero(125);
			f.setFecha("12/02/2020");
			f.setValorTotal(2.40);
			f.setCedula("0606");
			f.setNombreCliente("Juan");
			
			Detalle d = new Detalle();
			d.setCantidad(2);
			f.getListaDetalle().add(d);
			
			//facturaOn.guardarFactura(f);	
			
			List<Productos> lisPro = new ArrayList<Productos>();
			lisPro=facturaOn.getProductosByFiltro("mani");
			
			for (Productos productos : lisPro) {
				System.out.print("---->"+productos.getDescripcion());
				response.getWriter().println("Produto es : "+ productos.getDescripcion());
			}
			
			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	
	}
	
}
