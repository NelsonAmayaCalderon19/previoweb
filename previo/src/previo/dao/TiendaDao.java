package previo.dao;

import previo.entities.Seguir;
import previo.entities.Tienda;
import previo.util.Conexion;

public class TiendaDao extends Conexion<Tienda> implements GenericDao<Tienda> {
	public TiendaDao(){
		super(Tienda.class);
	}
}
