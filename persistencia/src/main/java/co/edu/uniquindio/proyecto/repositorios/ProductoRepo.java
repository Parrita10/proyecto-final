package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.dto.ProductoValido;
import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.Comentario;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


//Este permite llamar los datos del archivo .sql
@Repository
public interface ProductoRepo extends JpaRepository <Producto, String> {

    Page<Producto> findAll(Pageable paginador);

    @Query("select p.usuario.nombre from Producto p where p.codigo = :id")
    String obtenerNombreVendedor(String id);


//    Falta hacerle el test
//    Traer todos los comentarios de un producto dado su ID
//    @Query("select c from Producto p join p.comentarios c where p.codigo = :id")
//    List<Comentario> obtenerComentarios1(String id);
//
//    @Query("select c from Comentario c where c.producto.codigo = :id")
//    List<Comentario> obtenerComentarios2(String id);


    //REVISAR
    //@Query("select p.nombre, c from Producto p left join p.comentarios c")
    //List<Object[]> listarProductosYComentarios();


    //Con el distinct se evita que se repitan los registros
    //@Query("select distinct c.usuario from Producto p join p.comentarios c where p.codigo = :id")
    //List<Usuario> listarUsuariosComentarios(String id);


    @Query("select new co.edu.uniquindio.proyecto.dto.ProductoValido(p.nombre,p.descripcion,p.precio,p.ciudad) from Producto p where :fechaActual < p.fechaLimite")
    List<ProductoValido> listarProductosValidos(LocalDateTime fechaActual);

}
