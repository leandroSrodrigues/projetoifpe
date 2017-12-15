package br.com.ifpe.vendas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifpe.vendas.model.Venda;
import br.com.ifpe.vendas.model.VendaDAO;


@Controller
public class FinalizarVendaController {
	@RequestMapping("/finalizarVenda")
	public String finalizarVenda(Venda venda) {
		VendaDAO dao = new VendaDAO();
		dao.Inserir(venda);
		return "finalizarVenda";
	}
}
