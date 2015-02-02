package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Modelo;
import vistas.Inicio;

import componente.CatalogoModelo;

public class CInicio extends CGenerico {

	private Inicio vista;
	String valor = "";
	CatalogoModelo catalogo;

	public CInicio() {
		super();
		vista = new Inicio();
		vista.setVisible(true);
		vista.agregarListener(this);
	}

	public void metodo() {
		String texto = vista.getTextField();
		Modelo modelo = new Modelo(texto);
		getServicio().guardar(modelo);
		System.out.println("aqui" + texto);
	}

	public void abrir() {
		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
//		lista = new Lista();
//		lista.setVisible(true);
		final JTable tabla = new JTable();
		tabla.setCellSelectionEnabled(true);
		List<Modelo> modelos = getServicio().buscarTodos();
		String[] titulo = { "Nombre", "Correo" };
		catalogo = new CatalogoModelo(modelos, titulo);
		tabla.setModel(catalogo);
		ListSelectionModel cellSelectionModel = tabla.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel
				.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						int selectedRow = tabla.getSelectedRow();
						valor = (String) tabla.getValueAt(selectedRow, 0);
						System.out.println("valores" + valor);
						frame.dispose();
						vista.setTextField(valor);
					}

				});
		frame.add(tabla);

	}

	@Override
	public void cargarListener(ActionEvent arg0) {
		String nombre = arg0.getActionCommand();
		switch (nombre) {
		case "Boton registro":
			metodo();
			break;
		case "Boton buscar":
			abrir();
			break;

		default:
			break;
		}
	}

	public static void main(String args[]) {
		CInicio generico = new CInicio();
	}

}