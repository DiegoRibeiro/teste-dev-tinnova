package br.com.testedevtinnova.questao05.dto;

import br.com.testedevtinnova.questao05.interfaces.CadastrarVeiculo;
import lombok.Getter;

public class SalvarVeiculoDTO implements CadastrarVeiculo {
	private String nome;
	private String marca;
	private int ano;
	private String descricao;
	private boolean vendido;
	
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}
	@Override
	public String getMarca() {
		// TODO Auto-generated method stub
		return this.marca;
	}
	@Override
	public int getAno() {
		// TODO Auto-generated method stub
		return this.ano;
	}
	@Override
	public String getDescricao() {
		// TODO Auto-generated method stub
		return this.descricao;
	}
	@Override
	public boolean isVendido() {
		// TODO Auto-generated method stub
		return this.vendido;
	}
}
