package aad.Francisco.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="producto")
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
	
	private String nombre;
	
	@Column(name="fabricante", nullable = true)//indica la columna puede ser null
	private Long idFabricante;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name="producto_oferta"
			, joinColumns = {
					@JoinColumn(name="producto_id")
			}
			, inverseJoinColumns = {
					@JoinColumn(name="oferta_id")
			}
		)
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
