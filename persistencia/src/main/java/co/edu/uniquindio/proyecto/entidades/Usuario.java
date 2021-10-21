package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//sirve únicamente para indicarle a JPA que esa clase es una Entity
@Entity

//Usamos lombook para acortar el codigo
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@AllArgsConstructor

//La clase Usuario es herencia de persona
public class Usuario extends Persona implements Serializable {

    //Sirve para el tipo de dato Map<>
    @ElementCollection

    // Column ayuda a definir anotaciones en los atributos. No puede ir vacio
    @Column(nullable = false)
    private Map<String,String> numTelefono;

    //Aplicamos la relacion muchos a uno entre Usuario y Ciudad
    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;

    //Aplicamos la relacion uno a muchos entre Usuario y Compra
    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Compra> compras;

    //Aplicamos la relacion uno a muchos entre Usuario y Comentario
    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Comentario> comentarios;

    //Aplicamos la relacion uno a muchos entre Usuario y SubastaUsuario
    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<SubastaUsuario> subastaUsuarios;

    //Aplicamos la relacion muchos a muchos entre Producto y Usuario
    @ManyToMany(mappedBy = "usuarios")
    private List<Producto> productosFavoritos;

    //Aplicamos la relacion uno a muchos entre Usuario y Producto
    @OneToMany(mappedBy = "usuario")
    private List<Producto> productos;

    //Aplicamos la relacion uno a muchos entre Usuario y Chat
    @OneToMany(mappedBy = "usuario")
    private List<Chat> chats;

    //Creamos el constructor con argumentos de la super clase
    public Usuario(String codigo, String nombre, String email,String password, Map<String, String> numTelefono, Ciudad ciudad) {
        super(codigo, nombre, email, password);

        this.numTelefono = numTelefono;
        this.ciudad = ciudad;
    }



}
