package br.com.ifpe.vendas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdicionarProdutoVendaController {
@RequestMapping("/exibirIncluirProdutoVenda")
	
	public String inserirProdutoVenda(){
		return("incluirProdutoVenda");
	}
	
}
		