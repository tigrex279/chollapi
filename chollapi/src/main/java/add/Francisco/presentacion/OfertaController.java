package add.Francisco.presentacion;

import java.util.List;

import aad.Francisco.modelo.Oferta;
import aad.Francisco.persistencia.OfertaDAO;
import aad.Francisco.persistencia.impl.OfertaDAOImpl;

public class OfertaController {
	
	OfertaDAO ofertaDAO;
	
	public OfertaController() {
		ofertaDAO = new OfertaDAOImpl();
	}
	
	public void guardar(Oferta oferta) {
		if(ofertaDAO.ofertaRepetida(oferta, oferta.getPrecio()))
			ofertaDAO.persist(oferta);
	}
	
	public void ultimosDiez() {
		List<Oferta> resultados = ofertaDAO.ultimosDiez();
		for(Oferta oferta: resultados)
			System.out.println(oferta.toString());
	}
	
	public void cincoUltimasOfertasProducto(String nombre) {
		List<Oferta> resultados = ofertaDAO.cincoUltimasOfertasProducto(nombre);
		for(Oferta oferta: resultados)
			System.out.println(oferta.toString());
	}
}
