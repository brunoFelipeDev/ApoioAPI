package br.com.apoio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApoioController {

	@GetMapping
	@RequestMapping(value = "/cursos")
	public String listar() {
		return "deu certo..";
	}
}
