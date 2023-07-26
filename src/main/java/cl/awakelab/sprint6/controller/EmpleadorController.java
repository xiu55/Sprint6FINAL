package cl.awakelab.sprint6.controller;

import cl.awakelab.sprint6.entity.Empleador;
import cl.awakelab.sprint6.service.IEmpleadorService;
import cl.awakelab.sprint6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {
     @Autowired
     IEmpleadorService objIEmpleadorService;

     @Autowired
     IUsuarioService objIUsuarioService;

     @GetMapping("/crearEmpleador")
     public String mostrarFormularioCrearEmpleador(Model model){
          model.addAttribute("usuarios",objIUsuarioService.listarUsuarios());
          return "crearEmpleador";
     }
     @PostMapping("/crearEmpleador")
     public String crearEmpleador(@ModelAttribute Empleador empleador){
          objIEmpleadorService.crearEmpleador(empleador);
          return "redirect:/empleador";
     }

     @GetMapping
     public String listarEmpleador(Model model) {
          List<Empleador> listarEmpleadores = objIEmpleadorService.listarEmpleador();
          model.addAttribute("empleadores",listarEmpleadores);
          return "listarEmpleadores";
     }

     @PostMapping("/editar/{idEmpleador}")
     public String mostrarFormularioEditarEmpleador(@PathVariable int idEmpleador, Model model){
          model.addAttribute("empleador", objIEmpleadorService.buscarEmpleadorPorId(idEmpleador));
          model.addAttribute("usuarios", objIUsuarioService.listarUsuarios());
          return "editarEmpleador";
     }

     @GetMapping("/{idEmpleador}")
     public String buscarEmpleadorPorId(@PathVariable int idEmpleador, Model model){
          Empleador empleador = objIEmpleadorService.buscarEmpleadorPorId(idEmpleador);
          model.addAttribute("empleador",empleador);
          return "redirect:/empleador";
     }

     @PostMapping("/actualizar/{idEmpleador}")
     public String actualizarEmpleador(@ModelAttribute Empleador empleador, @PathVariable int idEmpleador){
          objIEmpleadorService.actualizarEmpleador(idEmpleador,empleador);
          return "redirect:/empleador";
     }

     @PostMapping("/eliminar/{idEmpleador}")
     public String eliminarEmpleadorPorId(@PathVariable int idEmpleador){
          objIEmpleadorService.eliminarEmpleadorPorId(idEmpleador);
          return "redirect:/empleador";
     }



}
