package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

//Usamos lombook para acortar el codigo
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass

//Se crea la clase Super
public class Persona  implements Serializable {

    //Indica que este es la llave primaria
    @Id

    // Column ayuda a definir anotaciones en los atributos. Length le da tamaño al codigo
    @Column(length = 10)

    //Identificacion de Codigo (unica)
    private String codigo;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacio y Length le da tamaño al codigo
    @Column(nullable = false, length = 100)
    private String nombre;

    //Column ayuda a definir anotaciones en los atributos. No puede ir vacio, el correo debe ser unico y Length le da tamaño al codigo
    @Column(nullable = false, unique = true, length = 120)
    private String email;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacio
    @Column(nullable = false)
    private String password;

}







