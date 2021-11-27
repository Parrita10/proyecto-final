package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Categoria;
import co.edu.uniquindio.proyecto.entidades.Compra;
import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductoServicioImpl implements ProductoServicio {

    @Autowired
    private ProductoRepo productoRepo;

    @Override
    public Producto publicarProducto(Producto p) throws Exception {
        try {
            return productoRepo.save(p);
        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
    }

    @Override
    public void actualizarProducto(Producto producto) throws Exception {

    }

    @Override
    public void eliminarProducto(String codigo) throws Exception {

        Optional<Producto> producto = productoRepo.findById(codigo);

        if(producto.isEmpty()){
            throw new Exception("El codigo del producto no existe");
        }

        productoRepo.deleteById(codigo);

    }

    @Override
    public Producto obtenerProducto(String codigo) throws Exception {

        return productoRepo.findById(codigo).orElseThrow( ()-> new Exception("El producto no existe"));
    }

    @Override
    public List<Producto> listarProductos(Categoria categoria) {
        return null;
    }

    @Override
    public void comentarProducto(String mensaje, Integer calificacion, Usuario usuario, Producto producto) throws Exception {

    }

    @Override
    public void guadarProductoEnFavoritos(Producto producto, Usuario usuario) throws Exception {

    }

    @Override
    public void eliminarProductoEnFavoritos(Producto producto, Usuario usuario) throws Exception {

    }

    @Override
    public void comprarProductos(Compra compra) throws Exception {

    }

    @Override
    public List<Producto> buscarProductos(String nombreProducto, String[] filtros) {
        return null;
    }

    @Override
    public List<Producto> listarProductos(String codigoUsuario) throws Exception {
        return null;
    }
}
