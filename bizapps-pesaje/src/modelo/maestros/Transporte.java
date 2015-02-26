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
@Table(name="transporte")
@NamedQuery(name="Transporte.findAll", query="SELECT t FROM Transporte t")
public class Transporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_transporte")
	private long idTransporte;

	private String descripcion;
	
	private String codigo;
	
	
	@OneToMany(mappedBy="transporte")
    private List<Pesaje> pesaje;

	public Transporte() {
	}

	public long getIdTransporte() {
		return idTransporte;
	}

	public void setIdTransporte(long idTransporte) {
		this.idTransporte = idTransporte;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



}