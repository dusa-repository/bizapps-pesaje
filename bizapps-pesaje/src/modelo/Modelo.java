package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="modelo")
public class Modelo implements Serializable {

	private static final long serialVersionUID = -8414588565831959522L;
	
	@Id
	@Column(length=500)
	private String nombre;
	
	public Modelo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Modelo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
