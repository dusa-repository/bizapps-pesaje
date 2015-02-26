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
@Table(name="vehiculo")
@NamedQuery(name="Vehiculo.findAll", query="SELECT t FROM Vehiculo t")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String placa;

	private String descripcion;
	
	private Double peso;

	@OneToMany(mappedBy="balanza")
    private List<Pesaje> pesaje;
	
	public Vehiculo() {
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}




}