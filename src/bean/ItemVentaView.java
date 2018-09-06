package bean;

import java.io.Serializable;
import java.util.Vector;

public class ItemVentaView implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Vector<String> detalle;
	
	public ItemVentaView(int codigo,String nombre,float precio, int cantidad)
	{
		detalle = new Vector<String>();
		detalle.add(String.valueOf(codigo));
		detalle.add(nombre);
		detalle.add(String.valueOf(cantidad));
		detalle.add(String.valueOf(precio*cantidad));
	}
	public Vector<String> getDetalle() {
		return detalle;
	}
	public void setDetalle(Vector<String> detalle) {
		this.detalle = detalle;
	}
}
