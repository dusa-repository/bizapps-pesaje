package servicio;

import java.util.List;

import javax.swing.ListModel;

import interfacedao.IModeloDAO;
import modelo.Modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SModelo")
public class SModelo {

	@Autowired
	private IModeloDAO modelo;

	public void guardar(Modelo modelo2) {
		modelo.save(modelo2);
	}

	public List<Modelo> buscarTodos() {
		return modelo.findAll();
	}
}
