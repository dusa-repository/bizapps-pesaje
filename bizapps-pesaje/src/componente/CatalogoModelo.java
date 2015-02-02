package componente;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import modelo.Modelo;

@SuppressWarnings("serial")
public class CatalogoModelo extends AbstractTableModel  {
	String[] titulo;
	List<Modelo> listaModelo;

	public CatalogoModelo(List<Modelo> lista, String... titulo) {
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
		Modelo modelo = listaModelo.get(fila);
		switch (columna) {
		case 0:
			return modelo.getNombre();
		case 1:
			return modelo.getNombre();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return titulo[column];
	}
	
}
