package ec.edu.ups.factura.vista;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.factura.modelo.Detalle;
import ec.edu.ups.factura.modelo.Factura;
import ec.edu.ups.factura.modelo.Productos;
import ec.edu.ups.factura.negocio.FacturaON;

@ManagedBean
@ViewScoped
public class facturaControllerBEAN {

	@Inject
	private FacturaON on;
	
	private Factura newfactura;
	private Detalle newdetalle;
	private Productos newproductos;
	private String filtro;
	private int cantidad=1;
	private int filtroID;
	private List<Factura> listFactura = new ArrayList<Factura>();
	private List<Productos> listPro = new ArrayList<Productos>();
	private double sumatotal=0.0;
	private double subtotal=0.0;
	
	@PostConstruct
	public void init() {
		newfactura = new Factura();
		//newdetalle = new Detalle();
		newproductos= new Productos();
		//cantidad =1;
	}
	
	public Factura getNewfactura() {
		return newfactura;
	}
	public void setNewfactura(Factura newfactura) {
		this.newfactura = newfactura;
	}
	public Detalle getNewdetalle() {
		return newdetalle;
	}
	public void setNewdetalle(Detalle newdetalle) {
		this.newdetalle = newdetalle;
	}
	public List<Factura> getListFactura() {
		return listFactura;
	}
	public void setListFactura(List<Factura> listFactura) {
		this.listFactura = listFactura;
	}
	public Productos getNewproductos() {
		return newproductos;
	}

	public void setNewproductos(Productos newproductos) {
		this.newproductos = newproductos;
	}
	
	public List<Productos> getListPro() {
		return listPro;
	}


	public void setListPro(List<Productos> listPro) {
		this.listPro = listPro;
	}
	

	public String getFiltro() {
		return filtro;
	}


	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getFiltroID() {
		return filtroID;
	}

	public void setFiltroID(int filtroID) {
		this.filtroID = filtroID;
	}

	
	public double getSumatotal() {
		return sumatotal;
	}

	public void setSumatotal(double sumatotal) {
		this.sumatotal = sumatotal;
	}
	
	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	///on
	public  String busquedaProductos() {
		System.out.println("--> "+filtro);
		//on.getProductosbyID(filtroID);
		listPro=on.getProductosByFiltro(filtro);
		for (Productos prod : listPro) {
			System.out.println("es: -> "+ prod.getDescripcion());
		}
		return null;
	}
	
	public String addDetalle(Productos idProducto) {
		newdetalle = new Detalle();
		subtotal=0.0;
		//System.out.println(">>>>>>>>> llega cantidad: "+ canti);
		System.out.println(">>>>>>>>> llega cantidad>> : "+ cantidad);
		newdetalle.setCantidad(cantidad);
		newdetalle.setFactura(newfactura);
		newdetalle.setProductos(idProducto);
		sumatotal = sumatotal + calculaTotal(idProducto.getPrecioUnitario());
		newfactura.getListaDetalle().add(newdetalle);
		newfactura.setValorTotal(sumatotal);
		return null;
	}
	
	public String guardarFactura() {
		try {
			on.guardarFactura(newfactura);
			System.out.println("Factura Guardada!!!!! ");
		} catch (Exception e) {
		}
		
		
		return null;
	}
	
	
	
	public Double calculaTotal(Double preunit) {
		Double aux=0.0;
		aux=preunit* cantidad;
		System.out.println(">>>>>>>>> total es: "+ aux);
		return aux;
	}
	
	
	
	
	public String buscarByID(int filtro) {
		newproductos = on.getProductosbyID(filtroID);
		return null;
	}
}
