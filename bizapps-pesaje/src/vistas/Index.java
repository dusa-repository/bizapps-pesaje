package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Index extends JFrame {

	JPanel contentPane;
	JTextField txtNombre;
	JTextField txtPassword;
	JButton btnLoggin;
	JLabel lblLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(82, 129, 46, 14);
		contentPane.add(lblNewLabel);

		lblLogin = new JLabel("");
		lblLogin.setForeground(Color.RED);
		lblLogin.setBounds(275, 129, 206, 45);
		contentPane.add(lblLogin);

		txtNombre = new JTextField();
		txtNombre.setBounds(138, 126, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		btnLoggin = new JButton("Entrar");
		btnLoggin.setBounds(135, 231, 89, 23);
		contentPane.add(btnLoggin);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(82, 175, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtPassword = new JTextField();
		txtPassword.setBounds(138, 172, 86, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
	}

	public void agregarListener(ActionListener cIndex) {
		btnLoggin.addActionListener(cIndex);
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JTextField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JButton getBtnLoggin() {
		return btnLoggin;
	}

	public void setBtnLoggin(JButton btnLoggin) {
		this.btnLoggin = btnLoggin;
	}

	public JLabel getLblLogin() {
		return lblLogin;
	}

	public void setLblLogin(JLabel lblLogin) {
		this.lblLogin = lblLogin;
	}
}
