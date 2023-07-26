package cl.awakelab.sprint6.service;

import cl.awakelab.sprint6.entity.Usuario;

import java.util.List;

//Definir metodos que va a llevar nouestro implemten

public interface IUsuarioService {
    List<Usuario> listarUsuarios();
    Usuario crearUsuario(Usuario usuario);
    Usuario buscarUsuarioPorId(int idUsuario);
    Usuario actualizarUsuario(int idUsuario,Usuario usuario);
    void eliminarUsuarioPorId(int idUsuario);
}
