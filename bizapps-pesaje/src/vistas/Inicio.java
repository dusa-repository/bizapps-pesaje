package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import controlador.CInicio;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 4452902349238947961L;
	JPanel panel;
	JTextField textField;
	JButton btnNewButton_1;
	JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblProducto;
	private JTextField txtProducto;
	JButton btnBuscarProducto;

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 300);
		getContentPane().setLayout(null);
		panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 572, 261);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(22, 36, 79, 14);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(111, 33, 86, 20);
		panel.add(textField);
		textField.setColumns(10);

		btnNewButton = new JButton("Boton buscar");
		btnNewButton.setBounds(218, 227, 190, 23);
		panel.add(btnNewButton);
		btnNewButton_1 = new JButton("Boton registro");
		btnNewButton_1.setBounds(220, 32, 147, 23);
		panel.add(btnNewButton_1);

		lblNewLabel_1 = new JLabel("Producto");
		lblNewLabel_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1.setBounds(29, 117, 59, 32);
		panel.add(lblNewLabel_1);

		txtProducto = new JTextField();
		txtProducto.setBounds(86, 123, 94, 20);
		panel.add(txtProducto);
		txtProducto.setColumns(10);

		btnBuscarProducto = new JButton("Buscar");
		btnBuscarProducto.setForeground(new Color(255, 255, 255));
		btnBuscarProducto.setBackground(new Color(139, 0, 0));
		btnBuscarProducto.setBounds(190, 122, 89, 23);
		panel.add(btnBuscarProducto);

		lblProducto = new JLabel("");
		lblProducto.setBounds(289, 122, 224, 23);
		panel.add(lblProducto);
	}

	public String getTextField() {
		return textField.getText();
	}

	public void setTextField(String textField) {
		this.textField.setText(textField);
	}

	public void agregarListener(ActionListener accion) {
		btnNewButton.addActionListener(accion);
		btnNewButton_1.addActionListener(accion);
		btnBuscarProducto.addActionListener(accion);
	}

	public String getLblProducto() {
		return lblProducto.getText();
	}

	public void setLblProducto(String lblProducto) {
		this.lblProducto.setText(lblProducto); 
	}

	public String getTxtProducto() {
		return txtProducto.getText();
	}

	public void setTxtProducto(String txtProducto) {
		this.txtProducto.setText(txtProducto);
	}

	public JButton getBtnBuscarProducto() {
		return btnBuscarProducto;
	}

	public void setBtnBuscarProducto(JButton btnBuscarProducto) {
		this.btnBuscarProducto = btnBuscarProducto;
	}
}
