package cl.awakelab.sprint6.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class InicioController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
