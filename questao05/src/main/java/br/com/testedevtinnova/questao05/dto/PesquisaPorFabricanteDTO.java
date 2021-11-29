package br.com.testedevtinnova.questao05.dto;

import br.com.testedevtinnova.questao05.interfaces.PesquisaVeiculoPorFabricante;
import br.com.testedevtinnova.questao05.polimorfismo.ResultadoPesquisa;

public class PesquisaPorFabricanteDTO extends ResultadoPesquisa implements PesquisaVeiculoPorFabricante {
	private String marca;
	private int quantidade;
	
	public PesquisaPorFabricanteDTO(String marca, int quantidade) {
		super();
		this.marca = marca;
		this.quantidade = quantidade;
	}
	@Override
	public String getMarca() {
		return this.marca;
	}
	@Override
	public int getQuantidade() {
		return this.quantidade;
	}
}
