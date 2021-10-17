package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Mensaje implements Serializable {

    @Id
    @Column(length = 50)
    private String codigo;

    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private String emisor;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @ManyToOne
    private Chat chat;

}
