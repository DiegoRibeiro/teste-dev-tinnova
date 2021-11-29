package br.com.testedevtinnova.questao05.endpoints;

import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.testedevtinnova.questao05.dto.SalvarVeiculoDTO;
import br.com.testedevtinnova.questao05.entity.VeiculoEntity;
import br.com.testedevtinnova.questao05.exceptions.EntidadeNaoEncontradaException;
import br.com.testedevtinnova.questao05.exceptions.TermoNaoSuportadoException;
import br.com.testedevtinnova.questao05.mapper.Mapper;
import br.com.testedevtinnova.questao05.polimorfismo.ResultadoPesquisa;
import br.com.testedevtinnova.questao05.service.VeiculoService;
import br.com.testedevtinnova.questao05.util.ResponseUtil;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin(origins = "http://localhost:3000")
public class VeiculoController {
	@Autowired
	private VeiculoService service;
	
	@Autowired
	private Mapper mapper;

	@PostMapping
	public ResponseEntity<Object> salvarVeiculo(@RequestBody SalvarVeiculoDTO formVeiculo) {
		this.service.cadastrarVeiculo(mapper.toVeiculo(formVeiculo));
		
		return ResponseUtil.generate(HttpStatus.OK, "Cadastro realizado com sucesso!", false);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizaVeiculo(@RequestBody VeiculoEntity veiculo, @PathVariable Long id) {
		try {
			this.service.atualizarVeiculo(veiculo, id);
			return ResponseUtil.generate(HttpStatus.OK, "Veículo Atualizado com sucesso!", false);
		} catch (EntidadeNaoEncontradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseUtil.generate(HttpStatus.NOT_FOUND, "Nenhum veículo encontrado com este ID!", false);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> apagaVeiculo(@PathVariable Long id) {
		try {
			this.service.deletarVeiculo(id);
			return ResponseUtil.generate(HttpStatus.OK, "Veículo Deletado com sucesso!", false);
		} catch (EntidadeNaoEncontradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseUtil.generate(HttpStatus.NOT_FOUND, "Nenhum veículo encontrado com este ID!", false);
		}
	}
	
	@GetMapping
	public Iterable<VeiculoEntity> getAll() {
		return this.service.retornaTodosVeiculos();
	}
	
	@GetMapping("/{id}")
	public VeiculoEntity getById(@PathVariable Long id) throws EntidadeNaoEncontradaException {
		return this.service.find(id);
	}
	
	@GetMapping("/find")
	public List<? extends ResultadoPesquisa> pesquisa(@RequestParam("q") String query) {
		try {
			List<? extends ResultadoPesquisa> resultados = this.service.pesquisa(query);
			System.out.println(resultados);
			return resultados;
		} catch (TermoNaoSuportadoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Object> patchVeiculo(@PathVariable Long id, @RequestBody Map<Object, Object> body) {
		try {
			this.service.atualizarVeiculo(body, id);
			return ResponseUtil.generate(HttpStatus.OK, "Veículo Atualizado com sucesso!", false);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseUtil.generate(HttpStatus.BAD_REQUEST, "Parâmetros incorretos!", true);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseUtil.generate(HttpStatus.BAD_REQUEST, "Erro inesperado!", true);
		} catch (EntidadeNaoEncontradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseUtil.generate(HttpStatus.NOT_FOUND, "Nenhum veículo encontrado com este ID!", false);
		}
	}
}
