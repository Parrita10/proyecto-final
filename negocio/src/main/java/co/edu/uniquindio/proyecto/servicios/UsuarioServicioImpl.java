package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Producto;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class UsuarioServicioImpl implements UsuarioServicio{
    private final UsuarioRepo usuarioRepo;


    public UsuarioServicioImpl(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;

    }


    @Override
    public Usuario registrarUsuario(Usuario u) throws Exception {

        return getUsuario(u);
    }

    @Override
    public Usuario actualizarUsuario(Usuario u) throws Exception {
        return getUsuario(u);
    }

    private Usuario getUsuario(Usuario u) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(u.getCodigo());
        if(buscado.isPresent()){
            throw new Exception("El codigo del usuario ya existe");
        }
        buscado = buscarPorEmail(u.getEmail());
        if(buscado.isPresent()){
            throw new Exception("El email del usuario ya existe");
        }

        buscado = usuarioRepo.findByUsername(u.getUsername());
        if(buscado.isPresent()){
            throw new Exception("El username del usuario ya existe");
        }
        return usuarioRepo.save(u);
    }

    private Optional<Usuario> buscarPorEmail(String email){
        return usuarioRepo.findByEmail(email);
    }

    @Override
    public void eliminarUsuario(String codigo) throws Exception {

        Optional<Usuario> buscado = usuarioRepo.findById(codigo);
        if(buscado.isEmpty()){
            throw new Exception("El codigo del usuario no existe");
        }

        usuarioRepo.deleteById(codigo);

    }

    @Override
    public List<Usuario> listarUsuario() {

        return usuarioRepo.findAll();
    }

    @Override
    public List<Producto> listarFavoritos(String email) throws Exception{

        Optional<Usuario> buscado = buscarPorEmail(email);
        if(buscado.isEmpty()){
            throw new Exception("El email del usuario no existe");
        }

        return usuarioRepo.obtenerProductosFavoritos(email);
    }

    @Override
    public Usuario obtenerUsuario(String codigo) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findById(codigo);
        if(buscado.isEmpty()){
            throw new Exception("El usuario no existe");
        }
        return buscado.get();
    }

    @Override
    public Usuario login(String email, String password) throws Exception {

       return usuarioRepo.findByEmailAndPassword(email,password).orElseThrow( ()-> new Exception("Los datos de autenticacion son incorrectos"));


    }



}
