package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

//sirve únicamente para indicarle a JPA que esa clase es una Entity
@Entity

//Usamos lombook para acortar el codigo
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString

//Se crea la clase Producto y se le agrega implements Serializable
public class Producto implements Serializable {

    //Indica que este es la llave primaria
    @Id
    // Column ayuda a definir anotaciones en los atributos. Length le da tamaño al codigo
    @Column(length = 50)
    //Identificacion de Codigo (unica)
    private String codigo;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacio y Length le da tamaño al codigo
    @Column(nullable = false, length = 80)
    private String nombre;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacio
    @Column(nullable = false)
    private Integer unidades;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacio
    @Column(nullable = false)
    private String descripcion;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacio
    @Column(nullable = false)
    private Double precio;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacio
    @Column(nullable = false)
    private LocalDate fechaLimite;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacio
    @Column(nullable = false)
    private Double descuento;


    //Sirve para el tipo de dato Map<>
    @ElementCollection
    // Column ayuda a definir anotaciones en los atributos. No puede ir vacio
    @Column(nullable = false)
    private Map<String,String> imagen;


    //Aplicamos la relacion muchos a uno entre Producto y Ciudad
    @ManyToOne
    private Ciudad ciudad;

    //Aplicamos la relacion muchos a uno entre Producto y Usuario
    @ManyToOne
    private Usuario usuario;

    //Aplicamos la relacion uno a muchos entre Producto y DetalleCompra
    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<DetalleCompra> detalleCompras;

    //Aplicamos la relacion uno a muchos entre Comentario y Producto
    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<Comentario> comentarios;

    //Aplicamos la relacion uno a muchos entre Producto y Subasta
    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<Subasta> subastas;

    //Aplicamos la relacion muchos a muchos entre Producto y Usuario
    @ManyToMany(mappedBy = "productosFavoritos")
    @ToString.Exclude
    private List<Usuario> usuarios;

    //Aplicamos la relacion muchos a muchos entre Producto y Categoria
    @ManyToMany
    @ToString.Exclude
    private List<Categoria> categorias;
}