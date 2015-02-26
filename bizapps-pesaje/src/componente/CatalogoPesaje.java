package componente;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.maestros.Vehiculo;
import modelo.transacciones.Pesaje;

@SuppressWarnings("serial")
public class CatalogoPesaje extends AbstractTableModel {
	String[] titulo;
	List<Pesaje> listaModelo;

	public CatalogoPesaje(List<Pesaje> lista, String... titulo) {
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
		Pesaje modelo = listaModelo.get(fila);
		switch (columna) {
		case 0:
			return modelo.getBoleto();
		case 1:
			return modelo.getFechaPesaje();
		case 2:
			return modelo.getConductor().getNombres() + "  "+ modelo.getConductor().getApellidos();
		case 3:
			return modelo.getVehiculo().getPlaca();
		case 4:
			return modelo.getEntrada();
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return titulo[column];
	}

}