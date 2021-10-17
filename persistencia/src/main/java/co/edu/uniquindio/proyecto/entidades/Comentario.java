package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor

public class Comentario implements Serializable {

    @Id
    @Column(length = 50)
    private String codigo;

    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false)
    private String respuesta;

    @Column(nullable = false)
    private LocalDateTime fecha_comentario;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Producto producto;

    @Positive
    @Max(5)
    @Column(nullable = false)
    private Integer calificacion;


}

