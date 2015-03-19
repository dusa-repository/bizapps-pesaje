package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 4452902349238947961L;
	JPanel panel;
	JButton btnBuscarProducto;
	JButton btnBuscarAlmacen;
	JButton btnBuscarTransporte;
	JButton btnBuscarBalanza;
	JButton btnBuscarConductor;
	JButton btnBuscarVehiculo;
	JButton btnGuardar;
	JButton btnLimpiar;
	JButton btnReporte;
	JButton btnSalir;
	JButton btnCerrados;
	JButton btnBuscar;
	private JTextField txtFechaHora;
	private JTextField txtV;
	private JTextField txtTotal;
	private JTextField txtNetoVehiculo;
	private JTextField txtNetoTotal;
	private JTextField txtPesoEntrada;
	private JTextField txtTotalEntrada;
	private JTextField txtPesoSalida;
	private JTextField txtTotalSalida;
	private JTextField txtObservacion;
	private JTextField txtPesajeAutomatico;
	private JTextField txtBoleto;
	private JTextField txtVehiculo;
	private JTextField txtTransporte;
	private JTextField txtConductor;
	private JTextField txtProducto;
	private JTextField txtAlmacen;
	private JTextField txtBalanza;
	private JDateChooser dtbEntrada;
	private JDateChooser dtbSalida;
	private JButton btnAutomatico;
	private JButton btnPendiente;

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 75, 615, 643);
		getContentPane().setLayout(null);
		panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 599, 606);
		getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(20, 479, 113, 20);
		panel.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblComplementario = new JLabel(" Complementario");
		lblComplementario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblComplementario.setBounds(0, 0, 113, 14);
		panel_6.add(lblComplementario);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(20, 325, 59, 20);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblLectura = new JLabel(" Lectura");
		lblLectura.setBounds(0, 0, 59, 15);
		lblLectura.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_4.add(lblLectura);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(10, 335, 566, 133);
		panel.add(panel_5);
		panel_5.setLayout(null);

		dtbEntrada = new JDateChooser();
		dtbEntrada.setDateFormatString("yyyy-MM-dd HH:mm:ss.SSS");
		dtbEntrada.setBounds(87, 39, 183, 20);
		panel_5.add(dtbEntrada);
		dtbEntrada.setEnabled(false);

		txtFechaHora = new JTextField();
		txtFechaHora.setEditable(false);
		txtFechaHora.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtFechaHora.setBackground(Color.LIGHT_GRAY);
		txtFechaHora.setForeground(Color.BLACK);
		txtFechaHora.setText("Fecha / Hora");
		txtFechaHora.setBounds(87, 11, 183, 20);
		panel_5.add(txtFechaHora);
		txtFechaHora.setColumns(10);

		txtV = new JTextField();
		txtV.setHorizontalAlignment(SwingConstants.RIGHT);
		txtV.setEditable(false);
		txtV.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtV.setForeground(Color.BLACK);
		txtV.setBackground(Color.LIGHT_GRAY);
		txtV.setText("Vehiculo");
		txtV.setBounds(280, 11, 126, 20);
		panel_5.add(txtV);
		txtV.setColumns(10);

		txtTotal = new JTextField();
		txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotal.setEditable(false);
		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTotal.setForeground(Color.BLACK);
		txtTotal.setBackground(Color.LIGHT_GRAY);
		txtTotal.setText("Total");
		txtTotal.setBounds(416, 11, 126, 20);
		panel_5.add(txtTotal);
		txtTotal.setColumns(10);

		JLabel lblEntrada = new JLabel("Entrada: * ");
		lblEntrada.setForeground(new Color(139, 0, 0));
		lblEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntrada.setFont(new Font("Dialog", Font.BOLD, 13));
		lblEntrada.setBounds(10, 39, 78, 16);
		panel_5.add(lblEntrada);

		JLabel lblSalida = new JLabel("Salida: ");
		lblSalida.setForeground(new Color(139, 0, 0));
		lblSalida.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalida.setFont(new Font("Dialog", Font.BOLD, 13));
		lblSalida.setBounds(10, 66, 67, 16);
		panel_5.add(lblSalida);

		txtNetoVehiculo = new JTextField();
		txtNetoVehiculo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNetoVehiculo.setEditable(false);
		txtNetoVehiculo.setBackground(Color.LIGHT_GRAY);
		txtNetoVehiculo.setBounds(280, 92, 126, 20);
		panel_5.add(txtNetoVehiculo);
		txtNetoVehiculo.setColumns(10);

		txtNetoTotal = new JTextField();
		txtNetoTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNetoTotal.setEditable(false);
		txtNetoTotal.setBackground(Color.LIGHT_GRAY);
		txtNetoTotal.setBounds(416, 92, 126, 20);
		panel_5.add(txtNetoTotal);
		txtNetoTotal.setColumns(10);

		txtPesoEntrada = new JTextField();
		txtPesoEntrada.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				txtTotalEntrada.setText(txtPesoEntrada.getText());
				txtNetoTotal.setText(txtPesoEntrada.getText());
				txtNetoVehiculo.setText(txtPesoEntrada.getText());
			}

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		txtPesoEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPesoEntrada.setEditable(false);
		txtPesoEntrada.setBounds(280, 39, 126, 20);
		panel_5.add(txtPesoEntrada);
		txtPesoEntrada.setColumns(10);

		txtTotalEntrada = new JTextField();
		txtTotalEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalEntrada.setEditable(false);
		txtTotalEntrada.setBounds(416, 39, 126, 20);
		panel_5.add(txtTotalEntrada);
		txtTotalEntrada.setColumns(10);

		txtPesoSalida = new JTextField();
		txtPesoSalida.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				txtTotalSalida.setText(txtPesoSalida.getText());
				if (!txtPesoEntrada.getText().equals("")) {
					if (validarDouble(txtPesoEntrada.getText())
							&& validarDouble(txtPesoSalida.getText())) {
						Double entrada = Double.valueOf(txtPesoEntrada
								.getText());
						Double peso = Double.valueOf(txtPesoSalida.getText());
						if (entrada > peso)
						{
							txtNetoTotal.setText(String.valueOf(entrada
									- peso));
							txtNetoVehiculo.setText(String.valueOf(entrada
									- peso));
						}
						else
						{
							txtNetoVehiculo.setText(String.valueOf(peso
									- entrada));
							txtNetoTotal.setText(String.valueOf(peso
									- entrada));
						}
					}
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		txtPesoSalida.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPesoSalida.setEditable(false);
		txtPesoSalida.setBounds(280, 65, 126, 20);
		panel_5.add(txtPesoSalida);
		txtPesoSalida.setColumns(10);

		txtTotalSalida = new JTextField();
		txtTotalSalida.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalSalida.setEditable(false);
		txtTotalSalida.setBounds(416, 65, 126, 20);
		panel_5.add(txtTotalSalida);
		txtTotalSalida.setColumns(10);

		dtbSalida = new JDateChooser();
		dtbSalida.setDateFormatString("yyyy-MM-dd HH:mm:ss.SSS");
		dtbSalida.setBounds(87, 65, 183, 20);
		panel_5.add(dtbSalida);
		dtbSalida.setEnabled(false);

		JLabel lblNeto = new JLabel("Netos Totales: ");
		lblNeto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNeto.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNeto.setForeground(new Color(139, 0, 0));
		lblNeto.setBounds(154, 101, 116, 14);
		panel_5.add(lblNeto);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(20, 69, 59, 20);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblVehiculoPanel = new JLabel(" Vehiculo");
		lblVehiculoPanel.setBounds(0, 0, 57, 20);
		panel_2.add(lblVehiculoPanel);
		lblVehiculoPanel.setFont(new Font("Tahoma", Font.BOLD, 12));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 28, 566, 38);
		panel.add(panel_1);
		panel_1.setLayout(null);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setActionCommand("btnBuscar");
		btnBuscar.setIcon(new ImageIcon(Inicio.class
				.getResource("/imagenes/buscar.png")));
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setBackground(new Color(139, 0, 0));
		btnBuscar.setBounds(120, 8, 105, 25);
		panel_1.add(btnBuscar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setActionCommand("btnLimpiar");
		btnLimpiar.setIcon(new ImageIcon(Inicio.class
				.getResource("/imagenes/limpiar.png")));
		btnLimpiar.setForeground(new Color(255, 255, 255));
		btnLimpiar.setBackground(new Color(139, 0, 0));
		btnLimpiar.setBounds(229, 8, 105, 25);
		panel_1.add(btnLimpiar);

		btnSalir = new JButton("Salir");
		btnSalir.setActionCommand("btnSalir");
		btnSalir.setIcon(new ImageIcon(Inicio.class
				.getResource("/imagenes/salir.png")));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(139, 0, 0));
		btnSalir.setBounds(456, 8, 105, 25);
		panel_1.add(btnSalir);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setActionCommand("btnGuardar");
		btnGuardar.setBackground(new Color(139, 0, 0));
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setIcon(new ImageIcon(Inicio.class
				.getResource("/imagenes/guardar.png")));
		btnGuardar.setBounds(10, 8, 108, 25);
		panel_1.add(btnGuardar);

		btnReporte = new JButton("Reporte");
		btnReporte.setActionCommand("btnReporte");
		btnReporte.setIcon(new ImageIcon(Inicio.class
				.getResource("/imagenes/generar.png")));
		btnReporte.setForeground(Color.WHITE);
		btnReporte.setBackground(new Color(139, 0, 0));
		btnReporte.setBounds(337, 8, 115, 25);
		panel_1.add(btnReporte);

		JPanel panelVehiculo = new JPanel();
		panelVehiculo.setForeground(new Color(139, 0, 0));
		panelVehiculo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelVehiculo.setBackground(Color.WHITE);
		panelVehiculo.setBounds(10, 79, 566, 235);
		panel.add(panelVehiculo);
		panelVehiculo.setLayout(null);

		JLabel lblP = new JLabel("Producto: *");
		lblP.setBackground(new Color(139, 0, 0));
		lblP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblP.setBounds(10, 142, 71, 18);
		panelVehiculo.add(lblP);
		lblP.setForeground(new Color(139, 0, 0));

		JLabel lblB = new JLabel("Boleto:");
		lblB.setForeground(new Color(139, 0, 0));
		lblB.setBackground(new Color(139, 0, 0));
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblB.setBounds(10, 26, 71, 18);
		panelVehiculo.add(lblB);

		JLabel lblC = new JLabel("Conductor: *");
		lblC.setForeground(new Color(139, 0, 0));
		lblC.setBackground(new Color(139, 0, 0));
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblC.setBounds(10, 114, 79, 18);
		panelVehiculo.add(lblC);

		JLabel lblV = new JLabel("Vehiculo:  *");
		lblV.setForeground(new Color(139, 0, 0));
		lblV.setBackground(new Color(139, 0, 0));
		lblV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblV.setBounds(10, 58, 71, 18);
		panelVehiculo.add(lblV);

		JLabel lblT = new JLabel("Transporte: *");
		lblT.setForeground(new Color(139, 0, 0));
		lblT.setBackground(new Color(139, 0, 0));
		lblT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblT.setBounds(10, 85, 79, 18);
		panelVehiculo.add(lblT);

		btnBuscarProducto = new JButton("Buscar");
		btnBuscarProducto.setActionCommand("btnBuscarProducto");
		btnBuscarProducto.setIcon(new ImageIcon(Inicio.class
				.getResource("/imagenes/buscar.png")));
		btnBuscarProducto.setBounds(440, 139, 105, 25);
		panelVehiculo.add(btnBuscarProducto);
		btnBuscarProducto.setForeground(new Color(255, 255, 255));
		btnBuscarProducto.setBackground(new Color(139, 0, 0));

		btnBuscarConductor = new JButton("Buscar");
		btnBuscarConductor.setActionCommand("btnBuscarConductor");
		btnBuscarConductor.setIcon(new ImageIcon(Inicio.class
				.getResource("/imagenes/buscar.png")));
		btnBuscarConductor.setBackground(new Color(139, 0, 0));
		btnBuscarConductor.setForeground(new Color(255, 255, 255));
		btnBuscarConductor.setBounds(440, 111, 105, 25);
		panelVehiculo.add(btnBuscarConductor);

		btnBuscarTransporte = new JButton("Buscar");
		btnBuscarTransporte.setActionCommand("btnBuscarTransporte");
		btnBuscarTransporte.setIcon(new ImageIcon(Inicio.class
				.getResource("/imagenes/buscar.png")));
		btnBuscarTransporte.setBackground(new Color(139, 0, 0));
		btnBuscarTransporte.setForeground(new Color(255, 255, 255));
		btnBuscarTransporte.setBounds(440, 83, 105, 25);
		panelVehiculo.add(btnBuscarTransporte);

		btnBuscarVehiculo = new JButton("Buscar");
		btnBuscarVehiculo.setActionCommand("btnBuscarVehiculo");
		btnBuscarVehiculo.setIcon(new ImageIcon(Inicio.class
				.getResource("/imagenes/buscar.png")));
		btnBuscarVehiculo.setBackground(new Color(139, 0, 0));
		btnBuscarVehiculo.setForeground(new Color(255, 255, 255));
		btnBuscarVehiculo.setBounds(440, 54, 105, 25);
		panelVehiculo.add(btnBuscarVehiculo);

		JLabel lblA = new JLabel("Almacen:");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblA.setForeground(new Color(139, 0, 0));
		lblA.setBounds(10, 172, 71, 18);
		panelVehiculo.add(lblA);

		JLabel lblBa = new JLabel("Balanza:");
		lblBa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBa.setForeground(new Color(139, 0, 0));
		lblBa.setBounds(10, 201, 71, 18);
		panelVehiculo.add(lblBa);

		btnBuscarAlmacen = new JButton("Buscar");
		btnBuscarAlmacen.setActionCommand("btnBuscarAlmacen");
		btnBuscarAlmacen.setBackground(new Color(139, 0, 0));
		btnBuscarAlmacen.setForeground(Color.WHITE);
		btnBuscarAlmacen.setIcon(new ImageIcon(Inicio.class
				.getResource("/imagenes/buscar.png")));
		btnBuscarAlmacen.setBounds(440, 168, 105, 25);
		panelVehiculo.add(btnBuscarAlmacen);

		btnBuscarBalanza = new JButton("Buscar");
		btnBuscarBalanza.setActionCommand("btnBuscarBalanza");
		btnBuscarBalanza.setBackground(new Color(139, 0, 0));
		btnBuscarBalanza.setForeground(Color.WHITE);
		btnBuscarBalanza.setIcon(new ImageIcon(Inicio.class
				.getResource("/imagenes/buscar.png")));
		btnBuscarBalanza.setBounds(440, 196, 105, 25);
		panelVehiculo.add(btnBuscarBalanza);

		txtBoleto = new JTextField();
		txtBoleto.setEditable(false);
		txtBoleto.setBackground(new Color(255, 255, 153));
		txtBoleto.setBounds(91, 26, 97, 20);
		panelVehiculo.add(txtBoleto);
		txtBoleto.setColumns(10);

		txtVehiculo = new JTextField();
		txtVehiculo.setEditable(false);
		txtVehiculo.setBounds(90, 58, 340, 20);
		panelVehiculo.add(txtVehiculo);
		txtVehiculo.setColumns(10);

		txtTransporte = new JTextField();
		txtTransporte.setEditable(false);
		txtTransporte.setBounds(90, 85, 340, 20);
		panelVehiculo.add(txtTransporte);
		txtTransporte.setColumns(10);

		txtConductor = new JTextField();
		txtConductor.setEditable(false);
		txtConductor.setBounds(90, 114, 340, 20);
		panelVehiculo.add(txtConductor);
		txtConductor.setColumns(10);

		txtProducto = new JTextField();
		txtProducto.setEditable(false);
		txtProducto.setBounds(90, 142, 340, 20);
		panelVehiculo.add(txtProducto);
		txtProducto.setColumns(10);

		txtAlmacen = new JTextField();
		txtAlmacen.setEditable(false);
		txtAlmacen.setBounds(90, 171, 340, 20);
		panelVehiculo.add(txtAlmacen);
		txtAlmacen.setColumns(10);

		txtBalanza = new JTextField();
		txtBalanza.setEditable(false);
		txtBalanza.setBounds(90, 201, 340, 20);
		panelVehiculo.add(txtBalanza);
		txtBalanza.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 487, 566, 69);
		panel.add(panel_3);
		panel_3.setLayout(null);

		txtObservacion = new JTextField();
		txtObservacion.setBounds(111, 22, 431, 39);
		txtObservacion.setColumns(3);
		panel_3.add(txtObservacion);
		txtObservacion.setColumns(10);
		txtObservacion.setAutoscrolls(true);

		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblObservaciones.setForeground(new Color(139, 0, 0));
		lblObservaciones.setBounds(10, 22, 91, 24);
		panel_3.add(lblObservaciones);

		txtPesajeAutomatico = new JTextField();
		txtPesajeAutomatico.setForeground(Color.WHITE);
		txtPesajeAutomatico.setBackground(new Color(220, 20, 60));
		txtPesajeAutomatico.setText("Pesaje Automatico");
		txtPesajeAutomatico.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPesajeAutomatico.setEditable(false);
		txtPesajeAutomatico.setBounds(10, 4, 566, 20);
		panel.add(txtPesajeAutomatico);
		txtPesajeAutomatico.setColumns(10);

		btnAutomatico = new JButton("Automatico");
		btnAutomatico.setActionCommand("btnAutomatico");
		btnAutomatico.setBorder(new LineBorder(new Color(0, 153, 0)));
		btnAutomatico.setBackground(Color.WHITE);
		btnAutomatico.setForeground(new Color(0, 153, 51));
		btnAutomatico.setIcon(new ImageIcon(Inicio.class
				.getResource("/imagenes/procesar.png")));
		btnAutomatico.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAutomatico.setBounds(288, 567, 146, 27);
		panel.add(btnAutomatico);

		btnPendiente = new JButton("Manual");
		btnPendiente.setActionCommand("btnPendiente");
		btnPendiente.setBorder(new LineBorder(new Color(255, 51, 51)));
		btnPendiente.setBackground(Color.WHITE);
		btnPendiente.setForeground(new Color(255, 0, 0));
		btnPendiente.setIcon(new ImageIcon(Inicio.class
				.getResource("/imagenes/pendiente.png")));
		btnPendiente.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPendiente.setBounds(444, 567, 132, 27);
		panel.add(btnPendiente);

		btnCerrados = new JButton("Pesajes Cerrados");
		btnCerrados.setForeground(Color.BLUE);
		btnCerrados.setActionCommand("btnCerrados");
		btnCerrados.setBorder(new LineBorder(Color.BLUE));
		btnCerrados.setBackground(Color.WHITE);
		btnCerrados.setIcon(new ImageIcon(Inicio.class
				.getResource("/imagenes/buscar.png")));
		btnCerrados.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCerrados.setBounds(10, 567, 175, 25);
		panel.add(btnCerrados);

	}

	public void agregarListener(ActionListener accion) {
		btnBuscarProducto.addActionListener(accion);
		btnBuscarAlmacen.addActionListener(accion);
		btnBuscarBalanza.addActionListener(accion);
		btnBuscarConductor.addActionListener(accion);
		btnBuscarTransporte.addActionListener(accion);
		btnBuscarVehiculo.addActionListener(accion);
		btnGuardar.addActionListener(accion);
		btnSalir.addActionListener(accion);
		btnLimpiar.addActionListener(accion);
		btnReporte.addActionListener(accion);
		btnBuscar.addActionListener(accion);
		btnAutomatico.addActionListener(accion);
		btnPendiente.addActionListener(accion);
		btnCerrados.addActionListener(accion);
	}

	public JButton getBtnBuscarProducto() {
		return btnBuscarProducto;
	}

	public void setBtnBuscarProducto(JButton btnBuscarProducto) {
		this.btnBuscarProducto = btnBuscarProducto;
	}

	public JButton getBtnBuscarAlmacen() {
		return btnBuscarAlmacen;
	}

	public void setBtnBuscarAlmacen(JButton btnBuscarAlmacen) {
		this.btnBuscarAlmacen = btnBuscarAlmacen;
	}

	public JButton getBtnBuscarTransporte() {
		return btnBuscarTransporte;
	}

	public void setBtnBuscarTransporte(JButton btnBuscarTransporte) {
		this.btnBuscarTransporte = btnBuscarTransporte;
	}

	public JButton getBtnBuscarBalanza() {
		return btnBuscarBalanza;
	}

	public void setBtnBuscarBalanza(JButton btnBuscarBalanza) {
		this.btnBuscarBalanza = btnBuscarBalanza;
	}

	public JButton getBtnBuscarConductor() {
		return btnBuscarConductor;
	}

	public void setBtnBuscarConductor(JButton btnBuscarConductor) {
		this.btnBuscarConductor = btnBuscarConductor;
	}

	public JButton getBtnBuscarVehiculo() {
		return btnBuscarVehiculo;
	}

	public void setBtnBuscarVehiculo(JButton btnBuscarVehiculo) {
		this.btnBuscarVehiculo = btnBuscarVehiculo;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(JButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}

	public JButton getBtnReporte() {
		return btnReporte;
	}

	public void setBtnReporte(JButton btnReporte) {
		this.btnReporte = btnReporte;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public void setTxtObservacion(String txtObservacion) {
		this.txtObservacion.setText(txtObservacion);
	}

	public String getTxtBoleto() {
		return txtBoleto.getText();
	}

	public void setTxtBoleto(String txtBoleto) {
		this.txtBoleto.setText(txtBoleto);
	}

	public String getTxtVehiculo() {
		return txtVehiculo.getText();
	}

	public void setTxtVehiculo(String txtVehiculo) {
		this.txtVehiculo.setText(txtVehiculo);
	}

	public String getTxtTransporte() {
		return txtTransporte.getText();
	}

	public void setTxtTransporte(String txtTransporte) {
		this.txtTransporte.setText(txtTransporte);
	}

	public String getTxtConductor() {
		return txtConductor.getText();
	}

	public void setTxtConductor(String txtConductor) {
		this.txtConductor.setText(txtConductor);
	}

	public String getTxtProducto() {
		return txtProducto.getText();
	}

	public void setTxtProducto(String txtProducto) {
		this.txtProducto.setText(txtProducto);
	}

	public String getTxtAlmacen() {
		return txtAlmacen.getText();
	}

	public void setTxtAlmacen(String txtAlmacen) {
		this.txtAlmacen.setText(txtAlmacen);
	}

	public String getTxtBalanza() {
		return txtBalanza.getText();
	}

	public void setTxtBalanza(String txtBalanza) {
		this.txtBalanza.setText(txtBalanza);
	}

	public Date getDateDtbEntrada() {
		return dtbEntrada.getDate();
	}

	public Date getDateDtbSalida() {
		return dtbSalida.getDate();
	}

	public void setDtbEntrada(Date strDate) {
		this.dtbEntrada.setDate(strDate);
	}

	public JDateChooser getDtbEntrada() {
		return dtbEntrada;
	}

	public void setDtbEntrada(JDateChooser dtbEntrada) {
		this.dtbEntrada = dtbEntrada;
	}

	public JDateChooser getDtbSalida() {
		return dtbSalida;
	}

	public void setDtbSalida(JDateChooser dtbSalida) {
		this.dtbSalida = dtbSalida;
	}

	public void setDtbSalida(Date dtbSalida) {
		this.dtbSalida.setDate(dtbSalida);
	}

	public JTextField getTxtNetoVehiculo() {
		return txtNetoVehiculo;
	}

	public void setTxtNetoVehiculo(JTextField txtNetoVehiculo) {
		this.txtNetoVehiculo = txtNetoVehiculo;
	}

	public JTextField getTxtNetoTotal() {
		return txtNetoTotal;
	}

	public void setTxtNetoTotal(JTextField txtNetoTotal) {
		this.txtNetoTotal = txtNetoTotal;
	}

	public JTextField getTxtPesoEntrada() {
		return txtPesoEntrada;
	}

	public void setTxtPesoEntrada(JTextField txtPesoEntrada) {
		this.txtPesoEntrada = txtPesoEntrada;
	}

	public JTextField getTxtTotalEntrada() {
		return txtTotalEntrada;
	}

	public void setTxtTotalEntrada(JTextField txtTotalEntrada) {
		this.txtTotalEntrada = txtTotalEntrada;
	}

	public JTextField getTxtPesoSalida() {
		return txtPesoSalida;
	}

	public void setTxtPesoSalida(JTextField txtPesoSalida) {
		this.txtPesoSalida = txtPesoSalida;
	}

	public JTextField getTxtTotalSalida() {
		return txtTotalSalida;
	}

	public void setTxtTotalSalida(JTextField txtTotalSalida) {
		this.txtTotalSalida = txtTotalSalida;
	}

	public JTextField getTxtObservacion() {
		return txtObservacion;
	}

	public void setTxtObservacion(JTextField txtObservacion) {
		this.txtObservacion = txtObservacion;
	}

	public JButton getBtnAutomatico() {
		return btnAutomatico;
	}

	public void setBtnAutomatico(JButton btnAutomatico) {
		this.btnAutomatico = btnAutomatico;
	}

	public JButton getBtnPendiente() {
		return btnPendiente;
	}

	public void setBtnPendiente(JButton btnPendiente) {
		this.btnPendiente = btnPendiente;
	}

	public boolean validarDouble(String numero) {
		String PATTERN = "\\d+\\.\\d+";
		Pattern pattern = Pattern.compile(PATTERN);
		Matcher matcher = pattern.matcher(numero);
		return matcher.matches();
	}
}
