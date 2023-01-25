package aad.Francisco.persistencia.impl;

import jakarta.persistence.EntityManager;
import java.util.List;
import aad.Francisco.modelo.Oferta;
import aad.Francisco.modelo.Producto;
import aad.Francisco.persistencia.OfertaDAO;
import aad.Francisco.persistencia.jpa.Utilidades;

public class OfertaDAOImpl extends GenericDAOImpl<Oferta, Integer> implements OfertaDAO{

		@SuppressWarnings("uncheked")
		public List<Oferta> ultimosDiez(){
			EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
			List<Oferta> ofertas = em.createQuery("select o from Oferta o order "
					+ "by o.id desc 10", Oferta.class).getResultList();
			return ofertas;
		}
		
		public List<Oferta> ultimosCincoDeProducto(Producto producto){
			EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
			List<Oferta> ofertas = em.createQuery("select o from Oferta o join Producto", Oferta.class).getResultList();
			return ofertas;
		}
		
}
