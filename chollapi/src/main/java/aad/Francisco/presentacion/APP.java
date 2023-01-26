package aad.Francisco.presentacion;

import java.time.LocalDateTime;

import aad.Francisco.modelo.Oferta;
import aad.Francisco.modelo.Producto;
import aad.Francisco.persistencia.jpa.Utilidades;
import jakarta.persistence.EntityManager;

public class APP {
	public static void main(String[] args) {
		EntityManager em = null;
		
		try {
			em = Utilidades.getEntityManagerFactory().createEntityManager();			

			Producto producto = new Producto();
			producto.setIdFabricante(null);
			producto.setNombre("PlayStation");
			
			Oferta oferta = new Oferta();
			oferta.setUrl("www.Game");
			oferta.setFechaHora(LocalDateTime.now());
			oferta.setPrecio(98.65f);
			oferta.setDisponible(true);
			
			oferta.addProducto(producto);
			
			em.getTransaction().begin();
			em.persist(oferta);
			em.getTransaction().commit();
//			Playlist plh = new Play();
//			plh.persist(play);
//			System.out.println(">>>Canciones añadidas:");
//			System.out.println(">>>Canción:" + cancion1.toString());
//			System.out.println(">>>Canción:" + cancion2.toString());
//			System.out.println(">>>Total canciones:");
//			for (Cancion cancion: play.getCancions()) {
//				System.out.println(">>>Cancion: " + cancion.toString());
//			}
//			
//			List<Cancion> canciones = em.createQuery(
//					"select c " +
//					"from Cancion c " +
//					"where c.artista like :artista" )
//				.setParameter( "artista", "The%")
//				.getResultList();
//			for (Cancion cancion: canciones) {
//				System.out.println(">>>Cancion: " + cancion.toString());
//			}
		
			
		} catch (Exception e ) {
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
