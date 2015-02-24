package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import servicio.SModelo;
import servicio.maestros.SProducto;

public abstract class CGenerico implements ActionListener {

	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"/META-INF/ConfiguracionAplicacion.xml");

	public static SModelo getServicio() {
		return applicationContext.getBean(SModelo.class);
	}
	public static SProducto getProducto() {
		return applicationContext.getBean(SProducto.class);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		cargarListener(arg0);
	}
	
	public abstract void cargarListener(ActionEvent arg0);
}
