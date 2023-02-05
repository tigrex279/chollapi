package aad.Francisco.persistencia.impl;

import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;
import aad.Francisco.modelo.Oferta;
import aad.Francisco.persistencia.OfertaDAO;
import aad.Francisco.persistencia.jpa.Utilidades;

public class OfertaDAOImpl extends GenericDAOImpl<Oferta, Long> implements OfertaDAO{

		@SuppressWarnings("uncheked")
		public List<Oferta> ultimosDiez(){
			EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
			List<Oferta> ofertas = em.createQuery("select o from Oferta o "
					+ "order by o.fechaHora ASC limit 10", Oferta.class).getResultList();
			return ofertas;
		}
		
		public List<Oferta> cincoUltimasOfertasProducto(String nombre) {
			EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
			List<Oferta> ofertas = em.createQuery("select o from Oferta o join Producto p "
					+ "where p.nombre = :nombre order by o.fechaHora ASC limit 5")
					.setParameter("nombre", nombre).getResultList();
			return ofertas;
		}
		
		public Boolean ofertaRepetida(Oferta oferta, float precio) {
			boolean duplicado = false;
			EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
			LocalDate fecha = LocalDate.now();
			List<Oferta> ofertasIguales = em.createQuery("SELECT o FROM Oferta o JOIN o.productos op WHERE"
					+ " date(o.fechaHora) = :fecha and o.precio = :precio and disponible = true").setParameter("fecha", fecha).getResultList();
			if(ofertasIguales.size() != 0)
				duplicado = true;
			return duplicado;
		}
		
}
