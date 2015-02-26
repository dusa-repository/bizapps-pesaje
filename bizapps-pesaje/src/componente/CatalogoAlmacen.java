package componente;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.maestros.Almacen;


@SuppressWarnings("serial")
public class CatalogoAlmacen extends AbstractTableModel  {
	String[] titulo;
	List<Almacen> listaModelo;

	public CatalogoAlmacen(List<Almacen> lista, String... titulo) {
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
		Almacen modelo = listaModelo.get(fila);
		switch (columna) {
		case 0:
			return modelo.getIdAlmacen();
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