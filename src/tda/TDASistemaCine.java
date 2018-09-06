package tda;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;
import bean.ProductoView;
import bean.VentaView;

public interface TDASistemaCine extends Remote
{
	public VentaView iniciarVenta() throws RemoteException;
	
	public void agregarProducto(ProductoView prod, int cantidad) throws RemoteException;
	
	public float registrarVenta() throws RemoteException;
	
	public float totalVenta() throws RemoteException;
	
	public VentaView actualizarVistaVenta() throws RemoteException;
	
	public Vector<ProductoView> getEntradas() throws RemoteException;
	
	public Vector<ProductoView> getAdicionales() throws RemoteException;
	
	public ProductoView getProducto(int codigo) throws RemoteException;
	
	public Vector<ProductoView> getCombos() throws RemoteException;
	
	public Vector<Vector<String>> getVentasAnteriores() throws RemoteException;
	
	public ProductoView buscarEntrada(String nombre) throws RemoteException;
	
	public ProductoView buscarAdicional(String nombre) throws RemoteException;
		
	public ProductoView buscarCombo(String nombre) throws RemoteException;

}
