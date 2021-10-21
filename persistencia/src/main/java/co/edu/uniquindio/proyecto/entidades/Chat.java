package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//sirve únicamente para indicarle a JPA que esa clase es una Entity
@Entity

//Usamos lombook para acortar el codigo
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString

//Se crea la clase Chat y se le agrega implements Serializable
public class Chat implements Serializable {

    //Indica que este es la llave primaria
    @Id

    // Column ayuda a definir anotaciones en los atributos. Length le da tamaño al codigo
    @Column(length = 50)

    //Identificacion de Chat (unica)
    private String codigo;

    //Aplicamos la relacion uno a muchos entre chat y mensajes
    @OneToMany(mappedBy = "chat")

    //Lo exluye del metodo toString
    @ToString.Exclude
    private List<Mensaje> mensajes;

    //Aplicamos la relacion muchos a uno entre chat y usuario
    @ManyToOne

    //Lo excluimos porque nos estaba generando un error de StackOverflowError
    //Lo exluye del metodo toString
    @ToString.Exclude
    private Usuario usuario;


}
