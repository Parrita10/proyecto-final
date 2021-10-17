package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.security.PrivateKey;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor

public class Subasta implements Serializable {

    @Id
    @Column(length = 50)
    private String codigo;

    @Column(nullable = false)
    private LocalDate fechaLimite;

    @ManyToOne
    private Producto producto;

    @OneToMany(mappedBy = "subasta")
    private List<SubastaUsuario> subastaUsuarios;
}


