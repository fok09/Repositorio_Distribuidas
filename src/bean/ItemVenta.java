package bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="itemventa")
public class ItemVenta implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iditem;
	private int cantidad;
	@OneToOne
	@JoinColumn(name="producto")
	private Producto producto;
	
	public ItemVenta(Producto producto, int cantidad)
	{
		super();
		this.cantidad = cantidad;
		this.producto = producto;
	}

	public ItemVenta()
	{
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public float getSubtotal()
	{
		return producto.getPrecio() * cantidad;
	}
	
	public ItemVentaView getView()
	{
		return new ItemVentaView(producto.getCodigo(),producto.getNombre(),producto.getPrecio(),cantidad);
	}
}
