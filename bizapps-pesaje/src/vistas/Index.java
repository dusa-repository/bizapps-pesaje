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
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

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
		setBounds(400, 280,358,262);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Usuario: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setBounds(10, 94, 102, 20);
		contentPane.add(lblNewLabel);

		txtNombre = new JTextField();
		txtNombre.setBounds(122, 94, 200, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		btnLoggin = new JButton("Entrar");
		btnLoggin.setIcon(new ImageIcon(Index.class.getResource("/imagenes/entrar.png")));
		btnLoggin.setForeground(Color.WHITE);
		btnLoggin.setBackground(new Color(139, 0, 0));
		btnLoggin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLoggin.setBounds(113, 175, 115, 26);
		contentPane.add(btnLoggin);

		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1.setBounds(10, 134, 102, 20);
		contentPane.add(lblNewLabel_1);

		txtPassword = new JTextField();
		txtPassword.setBounds(122, 134, 200, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblInicioDeSesion = new JLabel("INICIO DE SESION");
		lblInicioDeSesion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInicioDeSesion.setBounds(74, 30, 183, 35);
		contentPane.add(lblInicioDeSesion);
		
		lblLogin = new JLabel("");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogin.setForeground(new Color(255, 0, 0));
		lblLogin.setBounds(28, 61, 294, 22);
		contentPane.add(lblLogin);
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
