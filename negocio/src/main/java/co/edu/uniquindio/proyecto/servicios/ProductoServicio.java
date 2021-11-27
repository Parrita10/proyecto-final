package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;

import java.util.List;

public interface ProductoServicio {

    Producto publicarProducto(Producto p) throws Exception;

    void actualizarProducto(Producto producto)throws Exception;

    void eliminarProducto(String codigo) throws Exception;

    Producto obtenerProducto(String codigo) throws Exception;

    List<Producto> listarProductos(Categoria categoria);

    void comentarProducto(String mensaje, Integer calificacion, Usuario usuario, Producto producto) throws Exception;

    void guadarProductoEnFavoritos(Producto producto, Usuario usuario) throws Exception;

    void eliminarProductoEnFavoritos(Producto producto, Usuario usuario) throws Exception;

    void comprarProductos(Compra compra) throws Exception;

    List<Producto> buscarProductos(String nombreProducto, String[] filtros);

    List<Producto> listarProductos(String codigoUsuario) throws Exception;
}
