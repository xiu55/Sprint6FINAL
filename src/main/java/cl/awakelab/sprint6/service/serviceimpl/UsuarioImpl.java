package cl.awakelab.sprint6.service.serviceimpl;

import cl.awakelab.sprint6.entity.Usuario;
import cl.awakelab.sprint6.repository.IUsuarioRepository;
//import com.marvic.springm6.service.IUsuarioService;
import cl.awakelab.sprint6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("usuarioImpl")
public class UsuarioImpl implements IUsuarioService {
    @Autowired
    IUsuarioRepository objUsuarioRepo;
    /**Listar usuarios
     * @return List object usuarios
     */
    @Override
    public List<Usuario> listarUsuarios() {
        return objUsuarioRepo.findAll();
    }

    /**
     * Crear usuarios
     * @param usuario
     * @return Object Usuario
     */
    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return objUsuarioRepo.save(usuario);
    }

    /** Buscar usuario por id
     * @param idUsuario
     * @return Object Usuario
     */
    @Override
    public Usuario buscarUsuarioPorId(int idUsuario) {
        return objUsuarioRepo.findById(idUsuario).orElseThrow(()->new NoSuchElementException("Usuario no encontrado"));
    }

    /** Actualizar usuarios por id
     * @param usuario
     * @return Object Usuario
     */
    @Override
    public Usuario actualizarUsuario(int idUsuario, Usuario usuario) {
        Usuario usuario1 = this.buscarUsuarioPorId(idUsuario);
        usuario1.setNombre(usuario.getNombre());
        usuario1.setApellido1(usuario.getApellido1());
        usuario1.setApellido2(usuario.getApellido2());
        usuario1.setEmail(usuario.getEmail());
        usuario1.setClave(usuario.getClave());
        usuario1.setPerfil(usuario.getPerfil());
        usuario1.setFechaCreacion(usuario.getFechaCreacion());
        usuario1.setTelefono(usuario.getTelefono());
        return objUsuarioRepo.save(usuario1);
    }




    /**Eliminar usuario por id
     * @param idUsuario
     */
    @Override
    public void eliminarUsuarioPorId(int idUsuario) {

    objUsuarioRepo.deleteById(idUsuario);
    }
}
