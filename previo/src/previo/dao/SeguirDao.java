package previo.dao;

import previo.entities.Seguir;
import previo.util.Conexion;

public class SeguirDao extends Conexion<Seguir> implements GenericDao<Seguir> {

	public SeguirDao(){
		super(Seguir.class);
	}
}
