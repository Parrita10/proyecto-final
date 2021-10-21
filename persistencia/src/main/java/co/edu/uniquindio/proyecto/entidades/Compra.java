package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//sirve únicamente para indicarle a JPA que esa clase es una Entity
@Entity

//Usamos lombook para acortar el codigo
@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor

//Se crea la clase Compra y se le agrega implements Serializable
public class Compra implements Serializable {

    //Indica que este es la llave primaria
    @Id

    // Column ayuda a definir anotaciones en los atributos. Length le da tamaño al codigo
    @Column(length = 50)
    private String codigo;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacia
    @Column(nullable = false)
    private LocalDate fechaCompra;

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacia
    @Column(nullable = false)
    private String medioPago;

    //Aplicamos la relacion muchos a uno entre Compra y Usuario
    @ManyToOne
    private Usuario usuario;

    //Aplicamos la relacion uno a muchos entre Comentario y DetalleCompra
    @OneToMany(mappedBy = "compra")
    private List<DetalleCompra> detallesCompras;


}
