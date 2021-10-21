package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

//sirve únicamente para indicarle a JPA que esa clase es una Entity
@Entity

//Usamos lombook para acortar el codigo
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor

//Se crea la clase DetalleCompra y se le agrega implements Serializable
public class DetalleCompra implements Serializable {

    //Indica que este es la llave primaria
    @Id

    // Column ayuda a definir anotaciones en los atributos. Length le da tamaño al codigo
    @Column(length = 100)

    //Identificacion de Codigo (unica)
    private String codigo;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacia
    @Column(nullable = false)
    private Integer unidades;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacia
    @Column(nullable = false)
    private Double precioProducto;

    //Aplicamos la relacion muchos a uno entre DetalleCompra y Compra
    @ManyToOne
    private Compra compra;

    //Aplicamos la relacion muchos a uno entre DetalleCompra y Producto
    @ManyToOne
    private Producto producto;

}
