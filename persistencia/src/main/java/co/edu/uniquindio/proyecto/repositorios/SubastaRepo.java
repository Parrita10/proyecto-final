package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Subasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Este permite llamar los datos del archivo .sql
@Repository
public interface SubastaRepo extends JpaRepository<Subasta, Integer> {
}
