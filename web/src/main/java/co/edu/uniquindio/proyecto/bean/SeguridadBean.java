package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.dto.ProductoCarrito;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.servicios.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;

@Component
@Scope("session")
public class SeguridadBean implements Serializable {

    @Getter @Setter
    private boolean autenticado;

    @Getter @Setter
    private String email,password;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Getter @Setter
    private Usuario usuarioSesion;

    @Autowired
    private ProductoServicio productoServicio;

    @Getter @Setter
    private ArrayList<ProductoCarrito> productosCarrito;

    @Getter @Setter
    private Double subtotal;



    @PostConstruct
    public void inicializar(){
        this.subtotal = 0.0;
        this.productosCarrito = new ArrayList<>();
    }

    public String iniciarSesion(){
        if(!email.isEmpty() && !password.isEmpty()){
            try {

                usuarioSesion=usuarioServicio.login(email,password);
                autenticado=true;
                return "/index?faces-redirect=true";
            } catch (Exception e) {
                FacesMessage fm=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
                FacesContext.getCurrentInstance().addMessage("login-bean",fm);
            }
        }
        return null;

    }

    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }

    public void agregarAlCarrito(Integer id, Double precio, String nombre, String imagen){
        ProductoCarrito pc = new ProductoCarrito(id, nombre,imagen,precio,1);
        if(!productosCarrito.contains(pc)){
            productosCarrito.add(pc);
            subtotal+=precio;
            FacesMessage fm=new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta","Producto agregado al carrito");
            FacesContext.getCurrentInstance().addMessage("add-cart",fm);

        }

    }

    public void eliminarDelCarrito(int indice){
        subtotal-=productosCarrito.get(indice).getPrecio();
        productosCarrito.remove(indice);
    }

    public void actualizarSubtotal(){
        subtotal=0.0;
        for(ProductoCarrito p : productosCarrito){
            subtotal+= p.getPrecio()*p.getUnidades();
        }
    }

    public void comprar(){
        if(usuarioSesion!=null && !productosCarrito.isEmpty()) {
            try {
                productoServicio.comprarProductos(usuarioSesion, productosCarrito,"PSE");
                productosCarrito.clear();
                subtotal=0.0;
                FacesMessage fm=new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta","La compra se realizo correctamente");
                FacesContext.getCurrentInstance().addMessage("compra-msj",fm);
            } catch (Exception e) {
                FacesMessage fm=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
                FacesContext.getCurrentInstance().addMessage("compra-msj",fm);
            }
        }
    }

}
