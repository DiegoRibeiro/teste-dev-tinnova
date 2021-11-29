package br.com.testedevtinnova.questao05.mapper;

import org.springframework.stereotype.Component;

import br.com.testedevtinnova.questao05.dto.SalvarVeiculoDTO;
import br.com.testedevtinnova.questao05.entity.VeiculoEntity;

@Component
public class Mapper {

	public VeiculoEntity toVeiculo(SalvarVeiculoDTO dto) {
		return new VeiculoEntity(dto.getNome(), dto.getMarca(), dto.getAno(), dto.getDescricao(), dto.isVendido());
	}
}
