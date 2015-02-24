package componente;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import modelo.Modelo;
import modelo.maestros.Producto;

@SuppressWarnings("serial")
public class CatalogoProducto extends AbstractTableModel  {
	String[] titulo;
	List<Producto> listaModelo;

	public CatalogoProducto(List<Producto> lista, String... titulo) {
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
		Producto modelo = listaModelo.get(fila);
		switch (columna) {
		case 0:
			return modelo.getId();
		case 1:
			return modelo.getDescripcion();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return titulo[column];
	}
	
}