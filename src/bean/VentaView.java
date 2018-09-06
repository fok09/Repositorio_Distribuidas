package bean;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public class VentaView implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int numero;
	private String fecha;
	private Vector<Vector<String>> items;
	
	public VentaView(int nu,String fe,List<ItemVenta> it)
	{
		numero = nu;
		fecha = fe;
		items = new Vector<Vector<String>>();
		for(ItemVenta item : it)
			items.add(item.getView().getDetalle());
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Vector<Vector<String>> getItems() {
		return items;
	}

	public void setItems(Vector<Vector<String>> items) {
		this.items = items;
	}
}
