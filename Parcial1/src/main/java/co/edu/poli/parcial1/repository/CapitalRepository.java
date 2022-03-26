package co.edu.poli.parcial1.repository;

import co.edu.poli.parcial1.model.Capital;
import co.edu.poli.parcial1.model.Continente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapitalRepository extends JpaRepository<Capital, String> {
}
