package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

//Este permite llamar los datos del archivo .sql
@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, String> {

    //Busca una lista de nombres, y nos devuelve un listado de los que contengan ese nombre
    List<Usuario> findAllByNombreContains(String nombre);


    //Busca un usuario por el email y este nos devuelve un usuario debido a que el email es Unico
    Optional<Usuario> findByEmail(String email);


    @Query("Select u from Usuario u where u.email = :email and u.password = :clave")
    Optional<Usuario> verificarAutenticacion(String email, String clave);


    //Loguearse
    Optional<Usuario> findByEmailAndPassword(String email, String clave);
    Page<Usuario> findAll(Pageable paginador);


    //REVISAR
    @Query("select p from Usuario u, IN (u.productosFavoritos) p where u.email = :email ")
    List<Producto> obtenerProductosFavoritos(String email);

    Optional<Usuario> finByEmailAndPassword(String email, String clave);

    Optional<Usuario> findByUsername(String username);


//    FALTA PONER productosVenta (video 7 min 39:25)
//    Traer el usuario (se trrae el email)  y los productos en venta por cada usuario
//    @Query("select u.email, p from Usuario u join u.productosVenta p")
//    List<Object[]> listarUsuariosYProductos();

}
