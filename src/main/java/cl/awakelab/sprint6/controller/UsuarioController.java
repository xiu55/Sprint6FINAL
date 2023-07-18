package cl.awakelab.sprint6.controller;

import cl.awakelab.sprint6.entity.Usuario;
import cl.awakelab.sprint6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller //Solo anotacion para indicar que es controlador
@RequestMapping("/usuario") //redirecciona a usuario ?
public class UsuarioController {
    //TODO: Consultar por que es service y no "UsuarioImpl"

    @Autowired
    IUsuarioService objUsuarioService; //CREAR Clse

    @GetMapping //si queda solo redirecciona a /usuario
    public String listarUsuario(Model model) { //comunicar datos entre el propio controlador y la vista
        List<Usuario> listaUsuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("usuarios", listaUsuarios);
        return "listarUsuarios";
    }

    @GetMapping("/crearUsuario")
    public String mostrarFormularioCrearUsuario(){
        return "crearUsuario";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario) {
          //("yyyy-MM-dd HH:mm:ss");
        usuario.setFechaCreacion(LocalDateTime.now());
        objUsuarioService.crearUsuario(usuario);
        return "redirect:/usuario";
    }


    @GetMapping("/buscar/{idUsuario}")
    public String buscarUsuarioPorId(@PathVariable int idUsuario, Model model) {
        Usuario usuario = objUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("usuario",usuario);
        return "redirect:/usuario"; // en caso de volver a "listarusuario"
    }


    @PostMapping("/editar/{idUsuario}")
    public String mostrarFormularioEditarUsuario(@PathVariable int idUsuario, Model model){
        model.addAttribute("usuario",objUsuarioService.buscarUsuarioPorId(idUsuario));
        return "editarUsuario";
    }

    @PostMapping("/actualizar/{idUsuario}")
    public String actualizarUsuario(@ModelAttribute Usuario usuario, @PathVariable int idUsuario) {

        usuario.setFechaCreacion(LocalDateTime.now());
        objUsuarioService.actualizarUsuario(idUsuario,usuario);
        return "redirect:/usuario";
    }

    @PostMapping("/eliminar/{idUsuario}")
    public String eliminarUsuarioPorId(@PathVariable int idUsuario) {
        objUsuarioService.eliminarUsuarioPorId(idUsuario);
        return "redirect:/usuario";
    }
}
