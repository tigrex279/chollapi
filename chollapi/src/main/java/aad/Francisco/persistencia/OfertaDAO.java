package aad.Francisco.persistencia;

import java.util.List;

import aad.Francisco.modelo.Oferta;

public interface OfertaDAO extends GenericDAO<Oferta, Long>{
	public List<Oferta> ultimosDiez();
	public List<Oferta>  cincoUltimasOfertasProducto(String nombre);
	public Boolean ofertaRepetida(Oferta oferta, float precio);
}
