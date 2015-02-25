package modelo.maestros;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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
	private int id;

	private String descripcion;
	
	@OneToMany(mappedBy="almacen")
	private List<Pesaje> pesaje;

	public Almacen() {
	}

	public int getCodigo() {
		return this.id;
	}

	public void setCodigo(int codigo) {
		this.id = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Pesaje> getPesaje() {
		return pesaje;
	}

	public void setPesaje(List<Pesaje> pesaje) {
		this.pesaje = pesaje;
	}

}
