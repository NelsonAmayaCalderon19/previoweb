package previo.dao;

import previo.entities.Cliente;
import previo.entities.Seguir;
import previo.util.Conexion;

public class ClienteDao extends Conexion<Cliente> implements GenericDao<Cliente> {

	public ClienteDao(){
		super(Cliente.class);
	}
}
