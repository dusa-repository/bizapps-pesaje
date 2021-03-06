package servicio.maestros;

import java.util.List;

import interfacedao.maestros.IAlmacenDAO;
import interfacedao.maestros.IBalanzaDAO;


import modelo.maestros.Almacen;
import modelo.maestros.Balanza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SAlmacen")
public class SAlmacen {
	
	@Autowired
	private IAlmacenDAO almacenDAO;

	public void guardar(Almacen almacen) {
		almacenDAO.save(almacen);
		
	}

	public List<Almacen> buscarTodos() {
		return almacenDAO.findAll();
	}

	public void eliminarUno(long id) {
		almacenDAO.delete(id);
	}

	public void eliminarVarios(List<Almacen> eliminarLista) {
		almacenDAO.delete(eliminarLista);
	}

	public Almacen buscar(long idAlmacen) {
		// TODO Auto-generated method stub
		return almacenDAO.findOne(idAlmacen);
	}

}