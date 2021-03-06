package br.com.ifpe.vendas.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import br.com.ifpe.vendas.model.Cliente;
import br.com.ifpe.vendas.model.Endereco;
import br.com.ifpe.vendas.model.ItemVenda;
import br.com.ifpe.vendas.model.Produto;
import br.com.ifpe.vendas.model.SituacaoVenda;
import br.com.ifpe.vendas.model.TipoPagamento;
import br.com.ifpe.vendas.model.Venda;

public class ControleVendas {
	
	private double DESCONTO_DEBITO = 0.1;
	private double DESCONTO_BOLETO = 0.12;
	private double JUROS_CREDITO = 0.02;

	public Venda iniciarVenda(Cliente cliente){
		Venda venda = new Venda();
		venda.setCliente(cliente);
		venda.setSituacao(SituacaoVenda.EM_PROCESSAMENTO);
		return venda;
	}
	
	public void adicionarProduto(Venda venda, Produto produto, int quantidade) 
		throws Exception{
		if (venda.getSituacao() != SituacaoVenda.EM_PROCESSAMENTO) {
			throw new Exception("Venda finalizada! N�o � poss�vel adicionar novos produtos!");
		}
		if (venda.getItensVendidos() == null){
			venda.setItensVendidos(new ArrayList<>());
		}
		ItemVenda iv = new ItemVenda(1, venda, produto, quantidade);
		venda.getItensVendidos().add(iv);
	}
	
	public int obterQuantidadeItensVendidos(Venda venda){
		int quantidade = 0;
		if (venda.getItensVendidos() == null) {
			quantidade = 0;
		} else {
			quantidade = venda.getItensVendidos().size();
		}
		return quantidade;
	}
	
	public void finalizarVenda(Venda venda, Endereco entrega, TipoPagamento tipo){
		venda.setDataPedido(LocalDate.now());
		double valorVenda = 0;
		for (ItemVenda iv : venda.getItensVendidos()) {
			valorVenda += iv.getProduto().getPreco() * iv.getQuantidade();
		}
		if (tipo == TipoPagamento.BOLETO){
			valorVenda *= (1 - DESCONTO_BOLETO);
		} else if (tipo == TipoPagamento.DEBITO) {
			valorVenda *= (1 - DESCONTO_DEBITO);
		} else {
			valorVenda *= (1 + JUROS_CREDITO);
		}
		venda.setTotalVenda(valorVenda);
		venda.setSituacao(SituacaoVenda.FINALIZADA);
		venda.setEnderecoEntrega(entrega);
		venda.setTipoPagamento(tipo);
	}
}