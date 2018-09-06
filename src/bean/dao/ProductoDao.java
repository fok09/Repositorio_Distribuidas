package bean.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bean.Adicional;
import bean.ComboPromocional;
import bean.Entrada;
import bean.Producto;
import hbt.HibernateUtil;

public class ProductoDao {
	private static ProductoDao instancia = null;
	private static SessionFactory sf = null;

	public static ProductoDao getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new ProductoDao();
		}
		return instancia;
	}

	public Producto get(int id) {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Producto result = (Producto) session.get(Producto.class, id);
		session.getTransaction().commit();
		return result;
	}
	
	public Entrada getEntrada(int id) {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Entrada result = (Entrada) session.get(Entrada.class, id);
		session.getTransaction().commit();
		return result;
	}
	
	public Adicional getAdicional(int id) {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Adicional result = (Adicional) session.get(Adicional.class, id);
		session.getTransaction().commit();
		return result;
	}
	
	public ComboPromocional getCombo(int id) {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		ComboPromocional result = (ComboPromocional) session.get(ComboPromocional.class, id);
		session.getTransaction().commit();
		return result;
	}

	public void grabarProducto(Producto producto) {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.merge(producto);
		session.flush();
		session.getTransaction().commit();
	}
	
	public void grabarCombo(ComboPromocional combo){
		Session session = sf.openSession();
		session.beginTransaction();
		for(Producto producto:combo.getProductos())
			session.merge(producto);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Producto> leerProductos(){
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Producto> list = session.createQuery("from Producto").list();
		session.close();
		return list;
	}
	
	public List<Entrada> leerEntradas(){
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Entrada> list = session.createQuery("from Entrada").list();
		session.close();
		return list;
	}
	
	public List<Adicional> leerAdicional(){
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Adicional> list = session.createQuery("from Adicional").list();
		session.close();
		return list;
	}
	
	public List<ComboPromocional> leerCombos(){
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<ComboPromocional> list = session.createQuery("from ComboPromocional").list();
		session.close();
		return list;
	}
}
