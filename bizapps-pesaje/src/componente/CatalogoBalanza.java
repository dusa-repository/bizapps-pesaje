package componente;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.maestros.Balanza;

@SuppressWarnings("serial")
public class CatalogoBalanza extends AbstractTableModel  {
	String[] titulo;
	List<Balanza> listaModelo;

	public CatalogoBalanza(List<Balanza> lista, String... titulo) {
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
		Balanza modelo = listaModelo.get(fila);
		switch (columna) {
		case 0:
			return modelo.getIdBalanza();
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