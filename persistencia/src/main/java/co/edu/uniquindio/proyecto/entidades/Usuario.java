package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)

public class Usuario extends Persona implements Serializable {

    @ElementCollection
    @Column(nullable = false)
    private Map<String,String> numTelefono;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Compra> compras;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<SubastaUsuario> subastaUsuarios;

    @ManyToMany(mappedBy = "usuarios")
    private List<Producto> productosFavoritos;

    @OneToMany(mappedBy = "usuario")
    private List<Producto> productos;

    @OneToMany(mappedBy = "usuario")
    private List<Chat> chats;

    public Usuario(String codigo, String nombre, String email,String password, Map<String, String> numTelefono, Ciudad ciudad) {
        super(codigo, nombre, email, password);

        this.numTelefono = numTelefono;
        this.ciudad = ciudad;
    }



}
