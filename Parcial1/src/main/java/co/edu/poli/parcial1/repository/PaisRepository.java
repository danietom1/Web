package co.edu.poli.parcial1.repository;

import co.edu.poli.parcial1.model.Capital;
import co.edu.poli.parcial1.model.Continente;
import co.edu.poli.parcial1.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaisRepository extends JpaRepository<Pais, String> {

    @Query("FROM Pais WHERE continente.Nombre LIKE %?1% AND area BETWEEN ?2 and ?3")
    List<Pais> filterPais1 (String Continente, int Valor1, int Valor2);

    @Query(value = "select distinct density,name,population from capital left join pais on capital.id = pais.capital_id where pais.nombre_id like %?1%",nativeQuery = true)
    List<String> filterPais2 (String Pais);
}
