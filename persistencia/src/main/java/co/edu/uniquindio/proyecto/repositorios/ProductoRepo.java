package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import java.util.List;


//Este permite llamar los datos del archivo .sql
@Repository
public interface ProductoRepo extends JpaRepository <Producto, String> {



    Page<Producto> findAll(Pageable paginador);


   // @Query("select p.vendedor.nombre from Producto p where p.codigo = :id")
    //String obtenerNombreVendedor(Integer id);
}
