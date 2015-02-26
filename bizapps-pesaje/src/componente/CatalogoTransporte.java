package componente;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import modelo.maestros.Producto;
import modelo.maestros.Transporte;

@SuppressWarnings("serial")
public class CatalogoTransporte extends AbstractTableModel  {
	String[] titulo;
	List<Transporte> listaModelo;

	public CatalogoTransporte(List<Transporte> lista, String... titulo) {
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
		Transporte modelo = listaModelo.get(fila);
		switch (columna) {
		case 0:
			return modelo.getIdTransporte();
		case 1:
			return modelo.getCodigo();
		case 2:
			return modelo.getDescripcion();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		return titulo[column];
	}
	
}