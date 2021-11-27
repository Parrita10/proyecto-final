package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

//sirve únicamente para indicarle a JPA que esa clase es una Entity
@Entity

//Usamos lombook para acortar el codigo
@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString

//Se crea la clase categoria y se le agrega implements Serializable
public class Categoria implements Serializable {

    //Indica que este es la llave primaria
    @Id

    // Column ayuda a definir anotaciones en los atributos. Length le da tamaño al codigo
    @Column(length = 50)

    //Identificacion de Categoria (unica)
    private String codigo;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacio y Length le da tamaño al codigo
    @Column(nullable = false, length = 100)
    //Nombre de la Categoria
    private String nombre;

    //Aplicamos la relacion muchos a muchos entre categoria y productos
    @ManyToMany(mappedBy = "categorias")
    @ToString.Exclude
    private List<Producto> productos;

}




