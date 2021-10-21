package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

//sirve únicamente para indicarle a JPA que esa clase es una Entity
@Entity

//Usamos lombook para acortar el codigo
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor

//Se crea la clase Mensaje y se le agrega implements Serializable
public class Mensaje implements Serializable {

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
    private String emisor;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacia
    @Column(nullable = false)
    private LocalDateTime fecha;

    //Aplicamos la relacion muchos a uno entre Mensaje y Chat
    @ManyToOne
    private Chat chat;

}
