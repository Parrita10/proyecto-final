package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor

public class Producto implements Serializable {

    @Id
    @Column(length = 50)
    private String codigo;

    @Column(nullable = false, length = 80)
    private String nombre;

    @Column(nullable = false)
    private Integer unidades;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private LocalDate fechaLimite;

    @Column(nullable = false)
    private Double descuento;

    @ElementCollection
    @Column(nullable = false)
    private Map<String,String> imagen;

    @ManyToOne
    private Ciudad ciudad;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "producto")
    private List<DetalleCompra> detalleCompras;

    @OneToMany(mappedBy = "producto")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "producto")
    private List<Subasta> subastas;

    @ManyToMany
    private List<Usuario> usuarios;

    @ManyToMany
    private List<Categoria> categorias;

}


