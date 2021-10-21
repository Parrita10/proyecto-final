package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ProductoTest {

    @Autowired
    private CiudadRepo ciudadRepo;

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private DetalleCompraRepo detalleCompraRepo;

    @Autowired
    private ComentarioRepo comentarioRepo;

    @Autowired
    private SubastaRepo subastaRepo;

    @Autowired
    private CategoriaRepo categoriaRepo;

    @Test
    @Sql("classpath:Archivos.sql")
    public void registrarTest(){

        Ciudad ciudad = ciudadRepo.findById(1).orElse(null);

        Usuario usuario = usuarioRepo.findById("123").orElse(null);

        Map<String, String> imagen = new HashMap<>();
        imagen.put("casa", "12345678");
        imagen.put("celular", "98765432");

        List<DetalleCompra> detalleCompras = new ArrayList<>();

        detalleCompras.add(detalleCompraRepo.findById("1").orElse(null));
        detalleCompras.add(detalleCompraRepo.findById("2").orElse(null));
        detalleCompras.add(detalleCompraRepo.findById("3").orElse(null));


        List<Comentario> comentarios = new ArrayList<>();

        comentarios.add(comentarioRepo.findById("1").orElse(null));
        comentarios.add(comentarioRepo.findById("2").orElse(null));
        comentarios.add(comentarioRepo.findById("3").orElse(null));

        List<Subasta> subastas = new ArrayList<>();

        subastas.add(subastaRepo.findById("1").orElse(null));
        subastas.add(subastaRepo.findById("2").orElse(null));
        subastas.add(subastaRepo.findById("3").orElse(null));

        List<Usuario> listaUsuarios = new ArrayList<>();

        listaUsuarios.add(usuarioRepo.findById("123").orElse(null));
        listaUsuarios.add(usuarioRepo.findById("124").orElse(null));
        listaUsuarios.add(usuarioRepo.findById("125").orElse(null));

        List<Categoria> listaCategoria = new ArrayList<>();

        listaCategoria.add(categoriaRepo.findById("1").orElse(null));
        listaCategoria.add(categoriaRepo.findById("2").orElse(null));
        listaCategoria.add(categoriaRepo.findById("3").orElse(null));


        LocalDate localDate = LocalDate.now();
        Producto producto = new Producto("8","Locion", 5,"Mal olor", 4500.00, localDate, 7500.00, imagen, ciudad,usuario, detalleCompras, comentarios, subastas, listaUsuarios, listaCategoria  );


        Producto productoGuardado = productoRepo.save(producto);
        Assertions.assertNotNull(productoGuardado);
    }

    @Test
    @Sql("classpath:Archivos.sql")
    public void eliminarTest(){

        productoRepo.deleteById("1");

        Producto productoBuscado = productoRepo.findById("1").orElse(null);

        Assertions.assertNull(productoBuscado);
    }

    @Test
    @Sql("classpath:Archivos.sql")
    public void actualizarTest(){

        Producto guardado = productoRepo.findById("1").orElse(null);

        guardado.setNombre("Celular");
        //guardar el usuario
        productoRepo.save(guardado);

        Producto productoBuscado = productoRepo.findById("1").orElse(null);

        Assertions.assertEquals("Celular", productoBuscado.getNombre());
    }

    @Test
    @Sql("classpath:Archivos.sql")
    public void listarTest(){

        List<Producto> productos = productoRepo.findAll();
        productos.forEach(producto -> System.out.println(producto));
    }


}