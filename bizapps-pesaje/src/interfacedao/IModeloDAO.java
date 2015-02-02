package interfacedao;

import modelo.Modelo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IModeloDAO extends JpaRepository<Modelo, String> {

}
