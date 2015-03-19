package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.maestros.Almacen;
import modelo.maestros.Balanza;
import modelo.maestros.Conductor;
import modelo.maestros.Producto;
import modelo.maestros.Transporte;
import modelo.maestros.Vehiculo;
import modelo.transacciones.Pesaje;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vistas.Inicio;

import componente.CatalogoAlmacen;
import componente.CatalogoBalanza;
import componente.CatalogoConductor;
import componente.CatalogoPesaje;
import componente.CatalogoProducto;
import componente.CatalogoTransporte;
import componente.CatalogoVehiculo;

public class CInicio extends CGenerico {

	private Inicio vista;
	String valor = "";
	String valor2 = "";
	String valor3 = "";
	CatalogoPesaje catalogoPesaje;
	CatalogoProducto catalogoProducto;
	CatalogoAlmacen catalogoAlmacen;
	CatalogoBalanza catalogoBalanza;
	CatalogoConductor catalogoConductor;
	CatalogoTransporte catalogoTransporte;
	CatalogoVehiculo catalogoVehiculo;
	String idConductor = "";
	long idAlmacen = 0;
	long idPesaje = 0;
	long idBalanza = 0;
	String idProducto = "";
	long idTransporte = 0;
	String idVehiculo = "";
	SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");// dd/MM/yyyy
	Date now = new Date();
	public Calendar calendario = Calendar.getInstance();
	public String horaAuditoria = String.valueOf(calendario
			.get(Calendar.HOUR_OF_DAY))
			+ String.valueOf(calendario.get(Calendar.MINUTE))
			+ String.valueOf(calendario.get(Calendar.SECOND));
	public java.util.Date fecha = new Date();
	public Timestamp fechaHora = new Timestamp(fecha.getTime());
	boolean boton = false;

	public CInicio(boolean mira) {
		super();
		vista = new Inicio();
		vista.setVisible(true);
		vista.agregarListener(this);
		vista.setDtbEntrada(now);
		boton = mira;
		if (mira)
			vista.getBtnPendiente().setEnabled(true);
		else
			vista.getBtnPendiente().setEnabled(false);
	}

	@Override
	public void cargarListener(ActionEvent arg0) {
		String nombre = arg0.getActionCommand();
		switch (nombre) {
		case "btnBuscarProducto":
			mostrarProductos();
			break;
		case "btnBuscarVehiculo":
			mostrarVehiculos();
			break;
		case "btnBuscarTransporte":
			mostrarTransporte();
			break;
		case "btnBuscarConductor":
			mostrarConductor();
			break;
		case "btnBuscarAlmacen":
			mostrarAlmacen();
			break;
		case "btnBuscarBalanza":
			mostrarBalanza();
			break;
		case "btnBuscar":
			mostrarPesajes();
			break;
		case "btnSalir":
			vista.dispose();
			CIndex cIndex = new CIndex();
			break;
		case "btnLimpiar":
			limpiar();
			break;
		case "btnReporte":
			reporte();
			break;
		case "btnGuardar":
			guardar();
			break;
		case "btnAutomatico":
			automatico();
			break;
		case "btnPendiente":
			pendiente();
			break;
		case "btnCerrados":
			cerrados();
		case "txtEntrada":
			System.out.println("aaaaaaa");
			break;
		default:
			break;
		}
	}

	private void reporte() {
		if (idPesaje == 0)
			JOptionPane.showMessageDialog(null,
					"Debe Seleccionar un Pesaje Realizado", "Error",
					JOptionPane.ERROR_MESSAGE);
		else {
			Pesaje pesa = getSPesaje().buscar(idPesaje);
			if (pesa != null)
				mostrarReporte(pesa);
		}

	}

	private void guardar() {
		if (validar()) {
			Pesaje pesaje = new Pesaje();
			pesaje.setBoleto(idPesaje);
			if (idPesaje == 0) {
				Transporte transporte = getSTransporte().buscar(idTransporte);
				Vehiculo vehiculo = getSVehiculo().buscar(idVehiculo);
				Producto producto = getSProducto().buscar(idProducto);
				Conductor conductor = getSConductor().buscar(idConductor);
				String observacion = vista.getTxtObservacion().getText();
				String peso = vista.getTxtPesoEntrada().getText();
				Double pesoEntrada = (double) 0;
				if (!peso.equals(""))
					pesoEntrada = Double.parseDouble(peso);

				pesaje.setConductor(conductor);
				pesaje.setEntrada(pesoEntrada);
				pesaje.setTransporte(transporte);
				pesaje.setVehiculo(vehiculo);
				pesaje.setProducto(producto);
				pesaje.setObservacion(observacion);
				Balanza balanza;
				Almacen almacen;
				if (idBalanza != 0) {
					balanza = getSBalanza().buscar(idBalanza);
					pesaje.setBalanza(balanza);
				}
				if (idAlmacen != 0) {
					almacen = getSAlmacen().buscar(idAlmacen);
					pesaje.setAlmacen(almacen);
				}
				Timestamp fechaPesaje;
				fechaPesaje = new Timestamp(vista.getDateDtbEntrada().getTime());
				pesaje.setFechaPesaje(fechaPesaje);
				pesaje.setEstatus("Activo");
			} else {
				pesaje = getSPesaje().buscar(idPesaje);
				Timestamp fechaPesaje;
				fechaPesaje = new Timestamp(vista.getDateDtbSalida().getTime());
				pesaje.setFechaPesajeSalida(fechaPesaje);
				String peso = vista.getTxtPesoSalida().getText();
				Double pesoSalida = (double) 0;
				if (!peso.equals(""))
					pesoSalida = Double.parseDouble(peso);
				pesaje.setSalida(pesoSalida);
				pesaje.setEstatus("Cerrado");
				mostrarReporte(pesaje);
			}
			pesaje.setHoraAuditoria(horaAuditoria);
			pesaje.setFechaAuditoria(fechaHora);
			getSPesaje().guardar(pesaje);
			if (idPesaje == 0) {
				Pesaje pesaje2 = getSPesaje().buscarUltimo();
				mostrarReporte(pesaje2);
			}
			limpiar();
			JOptionPane.showMessageDialog(null,
					"Pesaje Realizado Exitosamente ", "Informacion",
					JOptionPane.INFORMATION_MESSAGE);

		}
	}

	private void mostrarReporte(Pesaje pesaje) {
		JasperReport reporte = null;
		try {
			reporte = (JasperReport) JRLoader.loadObject(getClass()
					.getResource("/reporte/RPesaje.jasper"));
		} catch (JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Map<String, Object> p = new HashMap<String, Object>();
		p.put("boleto", pesaje.getBoleto());
		p.put("status", pesaje.getEstatus());
		p.put("vehiculo", pesaje.getVehiculo().getPlaca());
		p.put("transporte", pesaje.getTransporte().getDescripcion());
		p.put("producto", pesaje.getProducto().getIdProducto() + " , "
				+ pesaje.getProducto().getDescripcion());
		p.put("conductor", pesaje.getConductor().getCedula() + " , "
				+ pesaje.getConductor().getNombres() + " "
				+ pesaje.getConductor().getApellidos());
		p.put("status", pesaje.getEstatus());
		p.put("observacion", pesaje.getObservacion());

		URL url = getClass().getResource("/reporte/LogoDusa.png");
		BufferedImage image = null;
		try {
			image = ImageIO.read(url);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "png", baos);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			baos.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		byte[] imageBytes = baos.toByteArray();

		p.put("imagen", imageBytes);

		p.put("fechaEntrada", pesaje.getFechaPesaje().toString());
		if (pesaje.getFechaPesajeSalida() != null)
			p.put("fechaSalida", pesaje.getFechaPesajeSalida().toString());

		p.put("pesoEntrada", pesaje.getEntrada());
		if (pesaje.getSalida() != null)
			p.put("pesoSalida", pesaje.getSalida());

		if (pesaje.getSalida() == null)
			p.put("total", pesaje.getEntrada());
		else {
			Double diferencia = (double) 0;
			double entrada = pesaje.getEntrada();
			double salida = pesaje.getSalida();
			if (entrada > salida)
				diferencia = entrada - salida;
			else
				diferencia = salida - entrada;
			p.put("total", diferencia);
		}

		JasperPrint jasperPrint = null;
		try {
			jasperPrint = JasperFillManager.fillReport(reporte, p,
					new JRBeanCollectionDataSource(null));
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JasperViewer.viewReport(jasperPrint, false);
	}

	private boolean validar() {
		if (idPesaje == 0) {
			if (vista.getDtbEntrada().getDate() == null
					|| vista.getTxtPesoEntrada().getText().equals("")
					|| idConductor.equals("") || idProducto.equals("")
					|| idTransporte == 0 || idVehiculo.equals("")) {
				JOptionPane.showMessageDialog(null,
						"Debe Llenar Todos los Campos", "Error",
						JOptionPane.ERROR_MESSAGE);
				return false;
			} else {
				if (!vista.getTxtPesoEntrada().getText().equals("")
						&& !buenNumero(vista.getTxtPesoEntrada().getText()))
				{
					JOptionPane.showMessageDialog(null,
							"El Peso de Entrada no tiene el formato correcto (xxxxxx.xx)", "Error",
							JOptionPane.ERROR_MESSAGE);
					return false;

				} else
					return true;
			}

		} else {
			if (vista.getDtbSalida().getDate() == null
					|| vista.getTxtPesoSalida().getText().equals("")) {
				JOptionPane.showMessageDialog(null,
						"Debe Llenar Todos los Campos", "Error",
						JOptionPane.ERROR_MESSAGE);
				return false;
			} else
			 {
				if (!vista.getTxtPesoSalida().getText().equals("")
						&& !buenNumero(vista.getTxtPesoSalida().getText()))
				{
					JOptionPane.showMessageDialog(null,
							"El Peso de Salida no tiene el formato correcto (xxxxxx.xx)", "Error",
							JOptionPane.ERROR_MESSAGE);
					return false;

				} else
					return true;
			}

		}

	}

	private boolean buenNumero(String string) {
		if (validarDouble(string))
			return true;
		else
			return false;
	}

	public boolean validarDouble(String numero) {
		String PATTERN = "\\d+\\.\\d+";
		Pattern pattern = Pattern.compile(PATTERN);
		Matcher matcher = pattern.matcher(numero);
		return matcher.matches();
	}

	private void limpiar() {
		idConductor = "";
		idAlmacen = 0;
		idBalanza = 0;
		idProducto = "";
		idTransporte = 0;
		idVehiculo = "";
		idPesaje = 0;
		editable(false);
		vista.getTxtTotalEntrada().setText("");
		vista.getTxtTotalSalida().setText("");
		vista.getTxtPesoEntrada().setText("");
		vista.getTxtPesoSalida().setText("");
		vista.getTxtNetoTotal().setText("");
		vista.getTxtNetoVehiculo().setText("");
		vista.setTxtBoleto("");
		vista.setTxtAlmacen("");
		vista.setTxtBalanza("");
		vista.setTxtConductor("");
		vista.setTxtObservacion("");
		vista.setTxtProducto("");
		vista.setTxtTransporte("");
		vista.setTxtVehiculo("");
		vista.setDtbEntrada(now);
		vista.getDtbSalida().setCalendar(null);
		inhabilitar(true);
		vista.getBtnGuardar().setEnabled(true);
		vista.getBtnAutomatico().setEnabled(true);
		if (boton)
			vista.getBtnPendiente().setEnabled(true);
		else
			vista.getBtnPendiente().setEnabled(false);
	}

	private void pendiente() {
		vista.setDtbEntrada(now);
		if (idPesaje == 0)
			editable(true);
		else {
			vista.getTxtTotalSalida().setEditable(false);
			vista.getTxtPesoSalida().setEditable(true);
			vista.getDtbSalida().setEnabled(true);
		}
	}

	private void automatico() {
		editable(false);
		if (idPesaje == 0) {
			vista.setDtbEntrada(now);
			Double peso = obtenerPeso();
			vista.getTxtTotalEntrada().setText(String.valueOf(peso));
			vista.getTxtPesoEntrada().setText(String.valueOf(peso));
			vista.getTxtNetoTotal().setText(String.valueOf(peso));
			vista.getTxtNetoVehiculo().setText(String.valueOf(peso));
		} else {

			Double peso = obtenerPeso();
			vista.setDtbSalida(now);
			vista.getTxtTotalSalida().setText(String.valueOf(peso));
			vista.getTxtPesoSalida().setText(String.valueOf(peso));
			Double diferencia = (double) 0;
			double entrada = getSPesaje().buscar(idPesaje).getEntrada();
			if (entrada > peso)
				diferencia = entrada - peso;
			else
				diferencia = peso - entrada;

			vista.getTxtNetoTotal().setText(String.valueOf(diferencia));
			vista.getTxtNetoVehiculo().setText(String.valueOf(diferencia));
		}
	}

	private void editable(boolean a) {
		vista.getTxtTotalEntrada().setEditable(false);
		vista.getTxtTotalSalida().setEditable(false);
		vista.getTxtPesoEntrada().setEditable(a);
		vista.getTxtPesoSalida().setEditable(a);
		vista.getTxtNetoTotal().setEditable(a);
		vista.getTxtNetoVehiculo().setEditable(a);
		vista.getDtbEntrada().setEnabled(a);
		vista.getDtbSalida().setEnabled(a);
	}

	private Double obtenerPeso() {
		double start = 1;
		double end = 10000;
		double random = new Random().nextDouble();
		double result = start + (random * (end - start));
		double resultado = Math.round(result * 100) / 100;
		return resultado;
	}

	private void cerrados() {
		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(350, 90);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		final JTable tabla = new JTable();
		tabla.setCellSelectionEnabled(true);
		tabla.setAutoscrolls(true);
		List<Pesaje> modelos = getSPesaje().buscarPorEstatus("Cerrado");
		String[] titulo = { "Boleto", "Fecha", "Conductor", "Placa Vehiculo",
				"Peso Entrada" };
		catalogoPesaje = new CatalogoPesaje(modelos, titulo);
		tabla.setModel(catalogoPesaje);
		ListSelectionModel cellSelectionModel = tabla.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel
				.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						int selectedRow = tabla.getSelectedRow();
						long boleto;
						boleto = (long) tabla.getValueAt(selectedRow, 0);
						idPesaje = (long) tabla.getValueAt(selectedRow, 0);
						Pesaje pesaje = getSPesaje().buscar(boleto);
						if (pesaje != null) {
							llenarCampos(pesaje);
							vista.getBtnGuardar().setEnabled(false);
							vista.getBtnAutomatico().setEnabled(false);

							vista.getBtnPendiente().setEnabled(false);
							vista.getDtbSalida().setEnabled(false);
							try {
								vista.setDtbSalida(sdfDate.parse(pesaje
										.getFechaPesajeSalida().toString()));
							} catch (ParseException u) {
								u.printStackTrace();
							}
							vista.getTxtPesoSalida().setText(
									String.valueOf(pesaje.getSalida()));
							vista.getTxtTotalSalida().setText(
									String.valueOf(pesaje.getSalida()));
							editable(false);
						}
						frame.dispose();

					}
				});
		JScrollPane scrollPane = new JScrollPane(tabla);
		frame.add(scrollPane);
		frame.pack();
		frame.setVisible(true);

	}

	private void mostrarPesajes() {
		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(350, 90);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		final JTable tabla = new JTable();
		tabla.setCellSelectionEnabled(true);
		tabla.setAutoscrolls(true);
		List<Pesaje> modelos = getSPesaje().buscarPorEstatus("Activo");
		String[] titulo = { "Boleto", "Fecha", "Conductor", "Placa Vehiculo",
				"Peso Entrada" };
		catalogoPesaje = new CatalogoPesaje(modelos, titulo);
		tabla.setModel(catalogoPesaje);
		ListSelectionModel cellSelectionModel = tabla.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel
				.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						int selectedRow = tabla.getSelectedRow();
						long boleto;
						boleto = (long) tabla.getValueAt(selectedRow, 0);
						idPesaje = (long) tabla.getValueAt(selectedRow, 0);
						Pesaje pesaje = getSPesaje().buscar(boleto);
						if (pesaje != null)
							llenarCampos(pesaje);
						frame.dispose();

					}
				});
		JScrollPane scrollPane = new JScrollPane(tabla);
		frame.add(scrollPane);
		frame.pack();
		frame.setVisible(true);

	}

	private void llenarCampos(Pesaje pesaje) {
		limpiar();
		idPesaje = pesaje.getBoleto();
		idConductor = pesaje.getConductor().getCedula();
		idProducto = pesaje.getProducto().getIdProducto();
		idTransporte = pesaje.getTransporte().getIdTransporte();
		idVehiculo = pesaje.getVehiculo().getPlaca();
		vista.setTxtBoleto(String.valueOf(pesaje.getBoleto()));
		vista.setTxtConductor(pesaje.getConductor().getCedula() + " , "
				+ pesaje.getConductor().getNombres() + " "
				+ pesaje.getConductor().getApellidos());
		vista.setTxtProducto(pesaje.getProducto().getIdProducto() + " , "
				+ pesaje.getProducto().getDescripcion());
		vista.setTxtTransporte(pesaje.getTransporte().getCodigo() + " , "
				+ pesaje.getTransporte().getDescripcion());
		vista.setTxtVehiculo(pesaje.getVehiculo().getPlaca() + " , "
				+ pesaje.getVehiculo().getDescripcion());
		vista.setTxtObservacion(pesaje.getObservacion());
		if (pesaje.getBalanza() != null) {
			vista.setTxtBalanza(pesaje.getBalanza().getDescripcion());
			idBalanza = pesaje.getBalanza().getIdBalanza();
		}
		if (pesaje.getAlmacen() != null) {
			vista.setTxtAlmacen(pesaje.getAlmacen().getDescripcion());
			idAlmacen = pesaje.getAlmacen().getIdAlmacen();
		}
		vista.getTxtPesoEntrada().setText(String.valueOf(pesaje.getEntrada()));
		vista.getTxtTotalEntrada().setText(String.valueOf(pesaje.getEntrada()));
		Double diferencia = (double) 0;
		double entrada = pesaje.getEntrada();
		if (pesaje.getSalida() != null) {
			double peso = pesaje.getSalida();
			if (entrada > peso)
				diferencia = entrada - peso;
			else
				diferencia = peso - entrada;

			vista.getTxtNetoTotal().setText(String.valueOf(diferencia));
			vista.getTxtNetoVehiculo().setText(String.valueOf(diferencia));
		} else {

			vista.getTxtNetoTotal()
					.setText(String.valueOf(pesaje.getEntrada()));
			vista.getTxtNetoVehiculo().setText(
					String.valueOf(pesaje.getEntrada()));
		}
		try {

			vista.setDtbEntrada(sdfDate.parse(pesaje.getFechaPesaje()
					.toString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		inhabilitar(false);
		editable(false);
	}

	private void inhabilitar(boolean a) {
		vista.getBtnBuscarAlmacen().setEnabled(a);
		vista.getBtnBuscarBalanza().setEnabled(a);
		vista.getBtnBuscarConductor().setEnabled(a);
		vista.getBtnBuscarProducto().setEnabled(a);
		vista.getBtnBuscarTransporte().setEnabled(a);
		vista.getBtnBuscarVehiculo().setEnabled(a);

	}

	private void mostrarConductor() {
		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(350, 90);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		final JTable tabla = new JTable();
		tabla.setCellSelectionEnabled(true);
		tabla.setAutoscrolls(true);
		List<Conductor> modelos = getSConductor().buscarTodos();
		String[] titulo = { "Cedula", "Nombres", "Apellidos" };
		catalogoConductor = new CatalogoConductor(modelos, titulo);
		tabla.setModel(catalogoConductor);
		ListSelectionModel cellSelectionModel = tabla.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel
				.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						int selectedRow = tabla.getSelectedRow();
						valor = (String) tabla.getValueAt(selectedRow, 0);
						valor2 = (String) tabla.getValueAt(selectedRow, 1);
						valor3 = (String) tabla.getValueAt(selectedRow, 2);
						String a = valor + " , " + valor2 + "  " + valor3;
						idConductor = (String) tabla.getValueAt(selectedRow, 0);
						frame.dispose();
						vista.setTxtConductor(a);
					}

				});
		JScrollPane scrollPane = new JScrollPane(tabla);
		frame.add(scrollPane);
		frame.pack();
		frame.setVisible(true);

	}

	private void mostrarVehiculos() {
		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(350, 90);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		final JTable tabla = new JTable();
		tabla.setCellSelectionEnabled(true);
		tabla.setAutoscrolls(true);
		List<Vehiculo> modelos = getSVehiculo().buscarTodos();
		String[] titulo = { "Placa", "Descripcion", "Peso" };
		catalogoVehiculo = new CatalogoVehiculo(modelos, titulo);
		tabla.setModel(catalogoVehiculo);
		ListSelectionModel cellSelectionModel = tabla.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel
				.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						int selectedRow = tabla.getSelectedRow();
						valor = (String) tabla.getValueAt(selectedRow, 0);
						valor2 = (String) tabla.getValueAt(selectedRow, 1);
						String a = valor + " , " + valor2;
						idVehiculo = (String) tabla.getValueAt(selectedRow, 0);
						frame.dispose();
						vista.setTxtVehiculo(a);
					}

				});
		JScrollPane scrollPane = new JScrollPane(tabla);
		frame.add(scrollPane);
		frame.pack();
		frame.setVisible(true);

	}

	private void mostrarBalanza() {

		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(350, 90);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		final JTable tabla = new JTable();
		tabla.setCellSelectionEnabled(true);
		tabla.setAutoscrolls(true);
		List<Balanza> modelos = getSBalanza().buscarTodos();
		String[] titulo = { "ID", "Descripcion" };
		catalogoBalanza = new CatalogoBalanza(modelos, titulo);
		tabla.setModel(catalogoBalanza);
		ListSelectionModel cellSelectionModel = tabla.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel
				.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						int selectedRow = tabla.getSelectedRow();

						valor2 = (String) tabla.getValueAt(selectedRow, 1);
						String a = valor2;
						idBalanza = (long) tabla.getValueAt(selectedRow, 0);
						frame.dispose();
						vista.setTxtBalanza(a);
					}

				});
		JScrollPane scrollPane = new JScrollPane(tabla);
		frame.add(scrollPane);
		frame.pack();
		frame.setVisible(true);
	}

	private void mostrarAlmacen() {

		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(350, 90);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		final JTable tabla = new JTable();
		tabla.setCellSelectionEnabled(true);
		tabla.setAutoscrolls(true);
		List<Almacen> modelos = getSAlmacen().buscarTodos();
		String[] titulo = { "ID", "Descripcion" };
		catalogoAlmacen = new CatalogoAlmacen(modelos, titulo);
		tabla.setModel(catalogoAlmacen);
		ListSelectionModel cellSelectionModel = tabla.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel
				.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						int selectedRow = tabla.getSelectedRow();

						valor2 = (String) tabla.getValueAt(selectedRow, 1);
						String a = valor2;
						idAlmacen = (long) tabla.getValueAt(selectedRow, 0);
						frame.dispose();
						vista.setTxtAlmacen(a);
					}

				});
		JScrollPane scrollPane = new JScrollPane(tabla);
		frame.add(scrollPane);
		frame.pack();
		frame.setVisible(true);
	}

	private void mostrarTransporte() {

		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(350, 90);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		final JTable tabla = new JTable();
		tabla.setCellSelectionEnabled(true);
		tabla.setAutoscrolls(true);
		List<Transporte> modelos = getSTransporte().buscarTodos();
		String[] titulo = { "ID", "Codigo", "Descripcion" };
		catalogoTransporte = new CatalogoTransporte(modelos, titulo);
		tabla.setModel(catalogoTransporte);
		ListSelectionModel cellSelectionModel = tabla.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel
				.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						int selectedRow = tabla.getSelectedRow();
						valor = (String) tabla.getValueAt(selectedRow, 1);
						valor2 = (String) tabla.getValueAt(selectedRow, 2);
						String a = valor + " , " + valor2;
						idTransporte = (long) tabla.getValueAt(selectedRow, 0);
						frame.dispose();
						vista.setTxtTransporte(a);
					}

				});
		JScrollPane scrollPane = new JScrollPane(tabla);
		frame.add(scrollPane);
		frame.pack();
		frame.setVisible(true);
	}

	public void mostrarProductos() {

		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(350, 90);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		final JTable tabla = new JTable();
		tabla.setCellSelectionEnabled(true);
		tabla.setAutoscrolls(true);
		List<Producto> modelos = getSProducto().buscarTodos();
		String[] titulo = { "Codigo", "Descripcion" };
		catalogoProducto = new CatalogoProducto(modelos, titulo);
		tabla.setModel(catalogoProducto);
		ListSelectionModel cellSelectionModel = tabla.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cellSelectionModel
				.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						int selectedRow = tabla.getSelectedRow();
						valor = (String) tabla.getValueAt(selectedRow, 0);
						valor2 = (String) tabla.getValueAt(selectedRow, 1);
						idProducto = (String) tabla.getValueAt(selectedRow, 0);
						frame.dispose();
						vista.setTxtProducto(valor + " , " + valor2);
					}

				});
		JScrollPane scrollPane = new JScrollPane(tabla);
		frame.add(scrollPane);
		frame.pack();
		frame.setVisible(true);
	}
}
