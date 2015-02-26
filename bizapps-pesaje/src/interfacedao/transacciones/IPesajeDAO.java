package interfacedao.transacciones;

import java.util.List;

import modelo.transacciones.Pesaje;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPesajeDAO extends JpaRepository<Pesaje, Long>{

	List<Pesaje> findByEstatus(String estatus);

}
