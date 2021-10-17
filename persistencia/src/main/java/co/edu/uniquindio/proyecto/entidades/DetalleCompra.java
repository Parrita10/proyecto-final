package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor

public class DetalleCompra {

    @Id
    @Column(length = 100)
    private String codigo;

    @Column(nullable = false)
    private Integer unidades;

    @Column(nullable = false)
    private Integer precioProducto;

    @ManyToOne
    private Compra compra;

    @ManyToOne
    private Producto producto;

}
