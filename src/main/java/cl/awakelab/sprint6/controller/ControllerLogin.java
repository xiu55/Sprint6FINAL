package cl.awakelab.sprint6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login") //quizas esto no vaya, analizar
public class ControllerLogin {

    @GetMapping
    public String login(){
        return "login";
    }



}
