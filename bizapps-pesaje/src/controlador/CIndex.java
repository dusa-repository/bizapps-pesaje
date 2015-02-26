package controlador;

import java.awt.event.ActionEvent;

import modelo.seguridad.Usuario;
import vistas.Index;

public class CIndex extends CGenerico {

	private Index index;

	public CIndex() {
		super();
		index = new Index();
		index.setVisible(true);
		index.agregarListener(this);
	}

	@Override
	public void cargarListener(ActionEvent arg0) {
		validarSession();
	}

	private void validarSession() {
		String nombre = index.getTxtNombre().getText();
		String password = index.getTxtPassword().getText();
		Usuario user = getSUsuario()
				.buscarPorLoginAndPassword(nombre, password);
		if (user != null) {
			if (!user.isSoloVer() && !user.isVerPesajeYEditar())
				index.getLblLogin().setText(
						"No posee permisos para ver Pesaje");
			else {
				if (user.isSoloVer()) {
					CInicio cInicio;
					cInicio = new CInicio(false);
				} else {
					CInicio cInicio;
					cInicio = new CInicio(true);
				}
				index.dispose();
			}
		} else
			index.getLblLogin().setText("Usuario o Contraseña Incorrecta");
	}

	public static void main(String args[]) {
		CIndex generico = new CIndex();
	}
}
