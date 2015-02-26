package componente;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.maestros.Conductor;





@SuppressWarnings("serial")
public class CatalogoConductor extends AbstractTableModel  {
	String[] titulo;
	List<Conductor> listaModelo;

	public CatalogoConductor(List<Conductor> lista, String... titulo) {
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
		Conductor modelo = listaModelo.get(fila);
		switch (columna) {
		case 0:
			return modelo.getCedula();
		case 1:
			return modelo.getNombres();
		case 2:
			return modelo.getApellidos();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return titulo[column];
	}
	
}