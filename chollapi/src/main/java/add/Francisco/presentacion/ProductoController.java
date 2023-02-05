package add.Francisco.presentacion;

import aad.Francisco.modelo.Producto;
import aad.Francisco.persistencia.ProductoDAO;
import aad.Francisco.persistencia.impl.ProductoDAOImpl;

public class ProductoController {
	
	ProductoDAO productoDAO;
	
	public ProductoController() {
		productoDAO = new ProductoDAOImpl();
	}
	
	public void guardar(Producto producto) {
		productoDAO.persist(producto);
	}
}
