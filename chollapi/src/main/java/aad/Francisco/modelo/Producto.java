package aad.Francisco.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="producto")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/*
	 * Atributos de la entidad
	 * id, nombre, fabricante(nullable)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//identificador del producto
	private Long id;
	@Column
	private String nombre;
	
	@Column(name="fabricante", nullable = true)//indica la columna puede ser null
	private Long idFabricante;
	
		//bi-directional many-to-many association to Playlist
		@ManyToMany(mappedBy="productos", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Oferta> ofertas = new ArrayList<Oferta>();
	
	public Producto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(Long idFabricante) {
		this.idFabricante = idFabricante;
	}

	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	public void addOferta(Oferta oferta) {
		ofertas.add(oferta);
	}

	public void removeOferta(Oferta oferta) {
		ofertas.remove(oferta);
	}

	@Override
	public String toString() {
		return "Prodcuto [id=" + id + ", nombre=" + nombre + ", idFabricante=" + idFabricante + ", ofertas=" + ofertas
				+ "]";
	}
	
	
}