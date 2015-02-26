package modelo.maestros;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
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
	@Column(name = "id_producto")
	private String idProducto;

	private String descripcion;

	
	@OneToMany(mappedBy="producto")
    private List<Pesaje> pesaje;
	
	public Producto() {
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



}
