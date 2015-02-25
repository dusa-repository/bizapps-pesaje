package interfacedao.transacciones;

import modelo.transacciones.Pesaje;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPesajeDAO extends JpaRepository<Pesaje, Long>{

}
