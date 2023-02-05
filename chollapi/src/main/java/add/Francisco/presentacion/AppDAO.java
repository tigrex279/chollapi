package add.Francisco.presentacion;

import java.time.LocalDateTime;

import aad.Francisco.modelo.Oferta;
import aad.Francisco.modelo.Producto;
import aad.Francisco.persistencia.jpa.Utilidades;
import jakarta.persistence.EntityManager;

public class AppDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = Utilidades.getEntityManagerFactory().createEntityManager();
			
			Producto producto = new Producto();
			producto.setNombre("PlayStation");
			producto.setIdFabricante(null);
			
			Oferta oferta = new Oferta();
			oferta.setUrl("www.GAME/consolas");
			oferta.setFechaHora(LocalDateTime.now());
			oferta.setPrecio(23.32f);
			oferta.setDisponible(true);
			
			oferta.addProducto(producto);
			OfertaController ofertaController  = new OfertaController();
			//ofertaController.guardar(oferta);
			ofertaController.cincoUltimasOfertasProducto("PlayStation");
		}catch (Exception e ) {
			if (em != null) {
				e.printStackTrace();
				System.out.println("Se va a hacer rollback de la transacción");
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		Utilidades.closeEntityManagerFactory();
	}

}
