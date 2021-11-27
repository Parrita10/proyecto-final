package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

//sirve únicamente para indicarle a JPA que esa clase es una Entity
@Entity

//Usamos lombook para acortar el codigo
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString

//Se crea la clase Comentario y se le agrega implements Serializable
public class Comentario implements Serializable {

    //Indica que este es la llave primaria
    @Id

    // Column ayuda a definir anotaciones en los atributos. Length le da tamaño al codigo
    @Column(length = 50)

    //Identificacion de Codigo (unica)
    private String codigo;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacia
    @Column(nullable = false)
    private String mensaje;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacia
    @Column(nullable = false)
    private String respuesta;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacia
    @Column(nullable = false)
    private LocalDate fecha_comentario;

    //Aplicamos la relacion muchos a uno entre Comentario y Usuario
    @ManyToOne
    private Usuario usuario;

    //Aplicamos la relacion muchos a uno entre Comentario y Producto
    @ManyToOne
    private Producto producto;

    //El numero debe ser positivo
    @Positive

    //La calificacion maxima debe ser 5
    @Max(5)

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacia
    @Column(nullable = false)
    private Integer calificacion;

}

