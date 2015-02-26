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
			if (user.isSoloVer() != null) {
				if (user.isSoloVer()) {
					CInicio cInicio;
					if (user.isVerPesajeYEditar() != null) {
						if (user.isVerPesajeYEditar())
							cInicio = new CInicio(true);
						else
							cInicio = new CInicio(false);
					} else
						cInicio = new CInicio(false);
					index.dispose();
				} else
					index.getLblLogin().setText(
							"No posee permisos para ver el Pesaje");
			} else
				index.getLblLogin().setText(
						"No posee permisos para ver el Pesaje");

		} else
			index.getLblLogin().setText("Usuario o Password Incorrectos");
	}
	
	public static void main(String args[]) {
		CIndex generico = new CIndex();
	}
}
