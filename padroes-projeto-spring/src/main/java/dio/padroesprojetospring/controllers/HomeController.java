package dio.padroesprojetospring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(path = "/")
	public String saudacao() {		
		return "Bem vindo ao nosso Site!";
	}
    
}
