package br.com.testedevtinnova.questao05.service;

import java.lang.reflect.Field;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testedevtinnova.questao05.dto.PesquisaPorFabricanteDTO;
import br.com.testedevtinnova.questao05.dto.PesquisarVeiculoPorDecadaDTO;
import br.com.testedevtinnova.questao05.entity.VeiculoEntity;
import br.com.testedevtinnova.questao05.exceptions.EntidadeNaoEncontradaException;
import br.com.testedevtinnova.questao05.exceptions.TermoNaoSuportadoException;
import br.com.testedevtinnova.questao05.interfaces.PesquisaVeiculoPorFabricante;
import br.com.testedevtinnova.questao05.interfaces.PesquisarVeiculoPorDecada;
import br.com.testedevtinnova.questao05.polimorfismo.ResultadoPesquisa;
import br.com.testedevtinnova.questao05.repository.VeiculoRepository;
import org.springframework.util.ReflectionUtils;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository repository;
	
	public void cadastrarVeiculo(VeiculoEntity veiculo) {
		this.repository.save(veiculo);
	}
	
	public void atualizarVeiculo(VeiculoEntity veiculoAtualizado, Long id) throws EntidadeNaoEncontradaException {
		Optional<VeiculoEntity> data = this.repository.findById(id);
		
		if(data.isEmpty()) {
			throw new EntidadeNaoEncontradaException();
		}
		
		VeiculoEntity veiculoDesatualizado = this.repository.findById(id).get();
		veiculoDesatualizado.setAno(veiculoAtualizado.getAno());
		veiculoDesatualizado.setDescricao(veiculoAtualizado.getDescricao());
		veiculoDesatualizado.setMarca(veiculoAtualizado.getMarca());
		veiculoDesatualizado.setNome(veiculoAtualizado.getNome());
		veiculoDesatualizado.setVendido(veiculoAtualizado.isVendido());
		this.repository.save(veiculoDesatualizado);
	}
	
	public void atualizarVeiculo(Map<Object, Object> body, Long id) throws EntidadeNaoEncontradaException, NoSuchFieldException, SecurityException {
		Optional<VeiculoEntity> data = this.repository.findById(id);
		
		if(data.isEmpty()) {
			throw new EntidadeNaoEncontradaException();
		}
		
		VeiculoEntity veiculoParaAtualizar = data.get();
		
		for (Map.Entry<Object, Object> entry : body.entrySet()) {
			Object key = entry.getKey();
			Object val = entry.getValue();
			
			Field field = ReflectionUtils.findField(VeiculoEntity.class, (String)key);
			boolean canAccess = field.canAccess(veiculoParaAtualizar);
			System.out.println(canAccess);
			field.setAccessible(true);
			ReflectionUtils.setField(field, veiculoParaAtualizar, val);
			field.setAccessible(canAccess);		
		}
		
		this.repository.save(veiculoParaAtualizar);
	}
	
	public void deletarVeiculo(Long id) throws EntidadeNaoEncontradaException {
		Optional<VeiculoEntity> data = this.repository.findById(id);
		
		if(data.isEmpty()) {
			throw new EntidadeNaoEncontradaException();
		}
		
		VeiculoEntity veiculo = data.get();
		this.repository.delete(veiculo);
	}
	
	public Iterable<VeiculoEntity> retornaTodosVeiculos() {
		return this.repository.findAll();
	}
	
	public VeiculoEntity find(Long id) throws EntidadeNaoEncontradaException {
		Optional<VeiculoEntity> data = this.repository.findById(id);
		
		if(data.isEmpty()) {
			throw new EntidadeNaoEncontradaException();
		} else {
			return data.get();
		}
	}
	
	public List<? extends ResultadoPesquisa> pesquisa(String q) throws TermoNaoSuportadoException {
		switch(q) {
			case "naovendidos":
				return this.repository.findAllStatusVendido(false);
			case "decadafabricacao":
				List<PesquisarVeiculoPorDecada> resultadosDecada = this.repository.countVeiculosByDecada();
				List<ResultadoPesquisa> retornoDecada = new ArrayList<ResultadoPesquisa>();
				
				
				for(PesquisarVeiculoPorDecada p: resultadosDecada) {
					retornoDecada.add(new PesquisarVeiculoPorDecadaDTO(p.getAnoDecada(), p.getQuantidade()));
				}
				
				return retornoDecada;
			case "fabricante":
				List<PesquisaVeiculoPorFabricante> resultadosFabricante = this.repository.countFabricanteByMarca();
				List<ResultadoPesquisa> retornoFabricante = new ArrayList<ResultadoPesquisa>();
				
				for(PesquisaVeiculoPorFabricante p: resultadosFabricante) {
					retornoFabricante.add(new PesquisaPorFabricanteDTO(p.getMarca(), p.getQuantidade()));
				}
				
				return retornoFabricante;
			case "ultimasemana":
				LocalDate ultimoSabado = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.SATURDAY));
				LocalDate ultimoDomingo = ultimoSabado.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));

				return this.repository.findAllVeiculosRegistradosUltimaSemana(ultimoDomingo, ultimoSabado);
			default:
				throw new TermoNaoSuportadoException();				
		}
	}
}
