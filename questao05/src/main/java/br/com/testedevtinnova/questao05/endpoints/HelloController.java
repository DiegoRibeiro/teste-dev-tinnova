package br.com.testedevtinnova.questao05.endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String index() {
		return "Bem vindo a API teste dev da Tinnova!";
	}
}
