package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.*;
import co.edu.uniquindio.proyecto.repositorios.CategoriaRepo;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoriaTest {

    @Autowired
    private CategoriaRepo categoriaRepo;

    @Autowired
    private ProductoRepo productoRepo;

    @Test
    @Sql("classpath:Archivos.sql")
    public void registrarTest(){

        List<Producto> listaProducto = new ArrayList<>();

        listaProducto.add(productoRepo.findById("1").orElse(null));
        listaProducto.add(productoRepo.findById("2").orElse(null));
        listaProducto.add(productoRepo.findById("3").orElse(null));

        Categoria categoria = new Categoria("1", "AUTOS", listaProducto);
        Categoria categoriaGuardado = categoriaRepo.save(categoria);

        Assertions.assertNotNull(categoriaGuardado);
    }

    @Test
    @Sql("classpath:Archivos.sql")
    public  void eliminarTest (){
        categoriaRepo.deleteById("1");
        Categoria categoriaBuscada = categoriaRepo.findById("1").orElse(null);

        Assertions.assertNull(categoriaBuscada);
    }

    @Test
    @Sql("classpath:Archivos.sql")
    public void actualizarTest(){
        Categoria categoria = categoriaRepo.findById("1").orElse(null);

        categoria.setNombre("casas");

        categoriaRepo.save(categoria);

        Categoria categoriaBuscada = categoriaRepo.findById("1").orElse(null);

        Assertions.assertEquals("casas", categoriaBuscada.getNombre());


    }

    @Test
    @Sql("classpath:Archivos.sql")
    public void listarTest(){


        List<Categoria> categorias = categoriaRepo.findAll();
        categorias.forEach(categoria-> System.out.println(categoria));



    }
}
