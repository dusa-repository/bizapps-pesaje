package modelo.maestros;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import modelo.transacciones.Pesaje;

/**
 * The persistent class for the tipo_cliente database table.
 * 
 */
@Entity
@Table(name="producto")
@NamedQuery(name="Producto.findAll", query="SELECT t FROM Producto t")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String descripcion;
	
	@OneToMany(mappedBy="producto")
	private List<Pesaje> pesaje;

	public Producto() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Pesaje> getPesaje() {
		return pesaje;
	}

	public void setPesaje(List<Pesaje> pesaje) {
		this.pesaje = pesaje;
	}


}
