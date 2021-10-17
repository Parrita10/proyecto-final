package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor

public class SubastaUsuario implements Serializable {

    @Id
    @Column(length = 50)
    private String codigo;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private LocalDate fechaSubasta;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Subasta subasta;
}
