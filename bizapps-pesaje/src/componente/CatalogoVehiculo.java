package componente;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.maestros.Vehiculo;




@SuppressWarnings("serial")
public class CatalogoVehiculo extends AbstractTableModel  {
	String[] titulo;
	List<Vehiculo> listaModelo;

	public CatalogoVehiculo(List<Vehiculo> lista, String... titulo) {
		super();
		this.listaModelo = lista;
		this.titulo = titulo;
	}

	@Override
	public int getColumnCount() {
		return titulo.length;
	}

	@Override
	public int getRowCount() {
		return listaModelo.size();
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		Vehiculo modelo = listaModelo.get(fila);
		switch (columna) {
		case 0:
			return modelo.getPlaca();
		case 1:
			return modelo.getDescripcion();
		case 2:
			if(modelo.getPeso()!=null)
			return modelo.getPeso();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return titulo[column];
	}
	
}