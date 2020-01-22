package com.desafio.desafio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/** Classe responsável pelo controle da página index **/

@Controller
public class IndexController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
