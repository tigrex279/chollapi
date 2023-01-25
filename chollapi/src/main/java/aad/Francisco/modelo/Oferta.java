package aad.Francisco.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "oferta")
@NamedQuery(name="Oferta.findAll", query="SELECT o FROM oferta o")
public class Oferta implements Serializable{
	private static final Long serialVersionUID = 1L;
	
	/*
	 * Atributos de la entidad:
	 * id,url,fecha y hora,precio,disponible
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//identificador de la entidad
	private Long id;
	
	private String url;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_hora")//nombre de la columa en la tabla
	private LocalDateTime fechaHora;
	
	private Float precio;
	
	private Boolean disponible;
	
	//mapeado creado en producto
	@ManyToMany(mappedBy ="ofertas", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Producto> productos = new ArrayList<Producto>();
	
	public Oferta() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public void addProducto(Producto producto) {
		productos.add(producto);
	}

	public void removeProducto(Producto producto) {
		productos.remove(producto);
	}

	@Override
	public String toString() {
		return "Oferta [id=" + id + ", url=" + url + ", fechaHora=" + fechaHora + ", precio=" + precio + ", disponible="
				+ disponible + "]";
	}
	
	
	
	
}
