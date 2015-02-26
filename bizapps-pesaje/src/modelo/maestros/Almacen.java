package modelo.maestros;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="almacen")
@NamedQuery(name="Almacen.findAll", query="SELECT t FROM Almacen t")
public class Almacen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_almacen")
	private long idAlmacen;

	private String descripcion;

	@OneToMany(mappedBy="almacen")
    private List<Pesaje> pesaje;
	
	public Almacen() {
	}

	public long getIdAlmacen() {
		return idAlmacen;
	}

	public void setIdAlmacen(long idAlmacen) {
		this.idAlmacen = idAlmacen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}
