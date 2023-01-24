package aad.Francisco.persistencia.impl;

import javax.persistence.EntityManager;
import java.util.List;
import aad.Francisco.modelo.Oferta;
import aad.Francisco.persistencia.OfertaDAO;
import aad.Francisco.persistencia.jpa.Utilidades;

public class OfertaDAOImpl extends GenericDAOImpl<Oferta, Integer> implements OfertaDAO{

		@SuppressWarnings("uncheked")
		public List<Oferta> ultimosDiez(){
			EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
			List<Oferta> ofertas = em.createQuery("select o from oferta o order "
					+ "by id desc 10", Oferta.class).getResultList();
			return ofertas;
		}
		
}
