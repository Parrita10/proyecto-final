package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

//sirve únicamente para indicarle a JPA que esa clase es una Entity
@Entity

//Usamos lombook para acortar el codigo
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor

//Se crea la clase SubastaUsuario y se le agrega implements Serializable
public class SubastaUsuario implements Serializable {

    //Indica que este es la llave primaria
    @Id

    // Column ayuda a definir anotaciones en los atributos. Length le da tamaño al codigo
    @Column(length = 50)

    //Identificacion de Codigo (unica)
    private String codigo;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacio
    @Column(nullable = false)
    private Double valor;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacio
    @Column(nullable = false)
    private LocalDate fechaSubasta;

    //Aplicamos la relacion muchos a uno entre SubastaUsuario y Usuario
    @ManyToOne
    private Usuario usuario;

    //Aplicamos la relacion muchos a uno entre SubastaUsuario y Subasta
    @ManyToOne
    private Subasta subasta;
}
