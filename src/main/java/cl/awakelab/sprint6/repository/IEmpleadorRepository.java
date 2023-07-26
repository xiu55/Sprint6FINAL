package cl.awakelab.sprint6.repository;

import cl.awakelab.sprint6.entity.Empleador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadorRepository extends JpaRepository<Empleador, Integer> {
}
