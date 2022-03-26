package co.edu.poli.parcial1.repository;

import co.edu.poli.parcial1.model.Name;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NombrePaisRepository extends JpaRepository<Name, String> {
}
