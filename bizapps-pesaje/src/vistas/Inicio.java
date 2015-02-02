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

public class Inicio extends JFrame {

	private static final long serialVersionUID = 4452902349238947961L;
	JPanel panel;
	private JTextField textField;
	JButton btnNewButton_1;
	JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
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
		btnNewButton.setBounds(33, 191, 89, 23);
		panel.add(btnNewButton);
		btnNewButton_1 = new JButton("Boton registro");
		btnNewButton_1.setBounds(220, 32, 89, 23);
		panel.add(btnNewButton_1);
	}

	public String getTextField() {
		return textField.getText();
	}

	public void setTextField(String textField) {
		this.textField.setText(textField);
	}
	
	public void agregarListener(ActionListener accion){
		btnNewButton.addActionListener(accion);
		btnNewButton_1.addActionListener(accion);
	}
}
