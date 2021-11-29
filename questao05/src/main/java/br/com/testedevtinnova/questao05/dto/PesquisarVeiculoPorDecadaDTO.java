package br.com.testedevtinnova.questao05.dto;

import br.com.testedevtinnova.questao05.interfaces.PesquisarVeiculoPorDecada;
import br.com.testedevtinnova.questao05.polimorfismo.ResultadoPesquisa;

public class PesquisarVeiculoPorDecadaDTO extends ResultadoPesquisa implements PesquisarVeiculoPorDecada {
	private int anoDecada;
	private int quantidade;

	public PesquisarVeiculoPorDecadaDTO(int anoDecada, int quantidade) {
		super();
		this.anoDecada = anoDecada;
		this.quantidade = quantidade;
	}

	@Override
	public int getAnoDecada() {
		return this.anoDecada;
	}

	@Override
	public int getQuantidade() {
		// TODO Auto-generated method stub
		return this.quantidade;
	}
}
