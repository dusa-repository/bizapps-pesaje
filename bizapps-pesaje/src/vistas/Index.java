package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Index extends JFrame {

	JPanel contentPane;
	JTextField txtNombre;
	JPasswordField txtPassword;
	JButton btnLoggin;
	JLabel lblLogin;
	private JLabel lblNewLabel_2;
	private JPanel panel;


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
		setBounds(400, 100,567,439);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Usuario: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setBounds(111, 234, 102, 20);
		contentPane.add(lblNewLabel);

		txtNombre = new JTextField();
		txtNombre.setBounds(223, 234, 200, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1.setBounds(111, 274, 102, 20);
		contentPane.add(lblNewLabel_1);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(223, 274, 200, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblInicioDeSesion = new JLabel("INICIO DE SESION");
		lblInicioDeSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioDeSesion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInicioDeSesion.setBounds(180, 168, 183, 35);
		contentPane.add(lblInicioDeSesion);
		
		lblLogin = new JLabel("");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogin.setForeground(new Color(255, 0, 0));
		lblLogin.setBounds(130, 203, 297, 20);
		contentPane.add(lblLogin);
		
		JLabel lblSistemaDePesaje = new JLabel("Sistema de Pesaje");
		lblSistemaDePesaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemaDePesaje.setForeground(new Color(139, 0, 0));
		lblSistemaDePesaje.setFont(new Font("Arial", Font.BOLD, 30));
		lblSistemaDePesaje.setBounds(24, 82, 378, 35);
		contentPane.add(lblSistemaDePesaje);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Index.class.getResource("/imagenes/LogoIndex.jpg")));
		lblNewLabel_2.setBounds(304, 13, 223, 58);
		contentPane.add(lblNewLabel_2);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(121, 168, 324, 184);
		contentPane.add(panel);
		panel.setLayout(null);
		
				btnLoggin = new JButton("Entrar");
				btnLoggin.setBounds(104, 147, 115, 26);
				panel.add(btnLoggin);
				btnLoggin.setIcon(new ImageIcon(Index.class.getResource("/imagenes/entrar.png")));
				btnLoggin.setForeground(Color.WHITE);
				btnLoggin.setBackground(new Color(139, 0, 0));
				btnLoggin.setFont(new Font("Tahoma", Font.BOLD, 15));
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

	public void setTxtPassword(JPasswordField txtPassword) {
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
