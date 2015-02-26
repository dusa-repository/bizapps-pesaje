package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import servicio.SModelo;
import servicio.maestros.SAlmacen;
import servicio.maestros.SBalanza;
import servicio.maestros.SConductor;
import servicio.maestros.SProducto;
import servicio.maestros.STransporte;
import servicio.maestros.SVehiculo;
import servicio.transacciones.SPesaje;

public abstract class CGenerico implements ActionListener {

	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"/META-INF/ConfiguracionAplicacion.xml");

	public static SProducto getSProducto() {
		return applicationContext.getBean(SProducto.class);
	}
	public static STransporte getSTransporte() {
		return applicationContext.getBean(STransporte.class);
	}
	public static SAlmacen getSAlmacen() {
		return applicationContext.getBean(SAlmacen.class);
	}
	public static SBalanza getSBalanza() {
		return applicationContext.getBean(SBalanza.class);
	}
	public static SConductor getSConductor() {
		return applicationContext.getBean(SConductor.class);
	}
	public static SVehiculo getSVehiculo() {
		return applicationContext.getBean(SVehiculo.class);
	}
	public static SPesaje getSPesaje() {
		return applicationContext.getBean(SPesaje.class);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		cargarListener(arg0);
	}
	
	public abstract void cargarListener(ActionEvent arg0);
}
