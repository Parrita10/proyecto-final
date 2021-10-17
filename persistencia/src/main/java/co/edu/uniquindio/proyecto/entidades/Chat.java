package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString

public class Chat implements Serializable {

    @Id
    @Column(length = 50)
    private String codigo;

    @OneToMany(mappedBy = "chat")
    @ToString.Exclude
    private List<Mensaje> mensajes;

    @ManyToOne
    private Usuario usuario;

}
