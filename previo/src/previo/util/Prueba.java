package previo.util;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import previo.dao.ClienteDao;
import previo.dao.ServicioDao;
import previo.dao.TiendaDao;
import previo.entities.Cliente;
import previo.entities.Servicio;
import previo.entities.Tienda;


public class Prueba {

	public static void main(String[] args) {
		ServicioDao udao = new ServicioDao();
		List<Servicio> carreras = udao.list();
		
		System.out.println(carreras.size());
		ClienteDao estdao = new ClienteDao();
		Cliente est = new Cliente();
		Tienda t = new Tienda();
		
		est.setNombre("Eduardo");
		est.setEmail("nelson@gmail.com");
		est.setClave("12345");
		estdao.insertar(est);
		t.setNombre("tienda1");
		t.setLema("Lema");
		t.setDescripcion("Desc1");
		t.setEmail("email1");
		t.setClave("12345");
		t.setPropietario("Amaya");
		t.setFacebook("https://facebook.com");
		t.setWeb("www.tienda.com");
		t.setImagen("img.com");
		TiendaDao tDao = new TiendaDao();
		tDao.insertar(t);
		Servicio c = new Servicio();
		ServicioDao cDao = new ServicioDao();
		c.setNombre("Service1");
		c.setDescripcion("desc1");
		 Tienda tBean = tDao.find(1);
		c.setTiendaBean(tBean);
		cDao.insertar(c);
	
		
 

	}

}
