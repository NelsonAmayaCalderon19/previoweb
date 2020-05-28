package previo.dao;

import previo.entities.Seguir;
import previo.entities.Servicio;
import previo.util.Conexion;

public class ServicioDao extends Conexion<Servicio> implements GenericDao<Servicio> {
	public ServicioDao(){
		super(Servicio.class);
	}
}
