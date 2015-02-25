package servicio.transacciones;

import interfacedao.transacciones.IPesajeDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SPesaje")
public class SPesaje {

	@Autowired
	private IPesajeDAO pesajeDAO;
}
